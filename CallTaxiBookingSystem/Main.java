package CallTaxiBookingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    private static int customerCount = 1;
    private static final List<Taxi> taxis = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.print("Enter the number of Taxis: ");
        int taxiCount = sc.nextInt();
        initializeTaxis(taxiCount);

        boolean isRunning = true;
        while (isRunning)
        {
            System.out.println("\nChoose an option:");
            System.out.println("1. Book Taxi\n2. Display Taxi Details\n3. Exit");
            int option = sc.nextInt();

            switch (option)
            {
                case 1:
                    bookTaxi();
                    break;
                case 2:
                    displayTaxis();
                    break;
                case 3:
                    System.out.println("Exiting... Thank you!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option! Please enter a valid choice.");
            }
        }
    }

    private static void displayTaxis()
    {
        for (Taxi taxi : taxis)
        {
            System.out.println(taxi);
            System.out.printf("%-11s %-12s %-5s %-5s %-12s %-10s %-7s%n","Booking ID", "Customer ID", "From", "To", "Pickup Time", "Drop Time", "Amount");

            for (Booking booking : taxi.getBookingHistory())
            {
                System.out.printf("%-11d %-12d %-5c %-5c %-12d %-10d %-7.2f%n",booking.getBookingId(), booking.getCustomerId(), booking.getFrom(), booking.getTo(),booking.getPickUpTime(), booking.getDropTime(), booking.getAmount());
            }
            System.out.println();
        }
    }

    private static void bookTaxi()
    {
        int customerId = customerCount++;

        char from = getValidLocation("Enter the pickup point (A-F): ");
        char to = getValidLocation("Enter the drop point (A-F): ");

        System.out.print("Enter the pickup time: ");
        int pickupTime = sc.nextInt();

        Taxi selectedTaxi = findBestTaxi(from, pickupTime);
        if (selectedTaxi == null)
        {
            System.out.println("Booking rejected. No taxi is available!");
            return;
        }

        int dropTime = pickupTime + Math.abs(to - from);
        double fare = selectedTaxi.calculateFare(from, to);

        Booking booking = new Booking(selectedTaxi.getNextBookingId(), customerId, pickupTime, dropTime, fare, from, to);
        selectedTaxi.addBooking(booking);

        System.out.println("Taxi-" + selectedTaxi.getId() + " has been booked successfully!");
    }

    private static void initializeTaxis(int taxiCount)
    {
        for (int i = 1; i <= taxiCount; i++)
        {
            taxis.add(new Taxi(i));
        }
    }

    private static char getValidLocation(String message)
    {
        while (true)
        {
            System.out.print(message);
            char location = sc.next().toUpperCase().charAt(0);
            if (location >= 'A' && location <= 'F') return location;
            System.out.println("Invalid input! Please enter a location between A and F.");
        }
    }

    private static Taxi findBestTaxi(char pickupLocation, int requestTime)
    {
        Taxi bestTaxi = null;
        int minDistance = Integer.MAX_VALUE;

        for (Taxi taxi : taxis)
        {
            if (taxi.isAvailable(requestTime))
            {
                int distance = Math.abs(taxi.getCurrentLocation() - pickupLocation);
                if (distance < minDistance || (distance == minDistance && taxi.getTotalEarning() < bestTaxi.getTotalEarning()))
                {
                    bestTaxi = taxi;
                    minDistance = distance;
                }
            }
        }
        return bestTaxi;
    }
}
