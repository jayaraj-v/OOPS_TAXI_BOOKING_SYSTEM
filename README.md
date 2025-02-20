Call Taxi Booking System 🚖
A Java-based taxi booking system built using Object-Oriented Programming (OOP) principles. This system efficiently handles taxi bookings, assigns the best available taxi, and maintains trip records with fare calculations.

📌 Features
✅ Taxi Management – Supports multiple taxis with real-time availability tracking.
✅ Efficient Taxi Allocation – Selects the nearest taxi with the least earnings to ensure fair distribution.
✅ Automated Fare Calculation – Uses distance-based fare calculation with a base charge.
✅ Booking History Tracking – Maintains a record of all bookings for each taxi.
✅ User-friendly Interface – Simple menu-driven input system for seamless booking and data visualization.

🛠️ System Design Overview
The system follows an OOP-based layered architecture, with three main classes:
1️⃣ Main – Handles user interaction and business logic.
2️⃣ Taxi – Represents a taxi and manages its bookings.
3️⃣ Booking – Stores individual booking details.

📂 Class Breakdown
1️⃣ Main.java (Entry Point & Controller)
Initializes the taxis and manages user interactions.
Provides a menu-driven interface for taxi booking and taxi details.
Implements input validation to handle incorrect values.
Calls helper functions to allocate taxis efficiently.
🔹 Methods:
🔸 initializeTaxis(int count) – Creates and stores taxi instances.
🔸 bookTaxi() – Handles booking requests and assigns taxis.
🔸 displayTaxis() – Displays taxi details with booking history.
🔸 findBestTaxi(char pickupLocation, int requestTime) – Finds the nearest available taxi.
🔸 getValidLocation(String message) – Ensures valid A-F locations for bookings.

2️⃣ Taxi.java (Core Taxi Management)
Manages taxi attributes like ID, current location, earnings, and booking history.
Ensures a taxi is available before assigning it to a booking.
Uses distance-based fare calculation for each trip.
🔹 Methods:
🔸 isAvailable(int requestTime) – Checks taxi availability based on last trip.
🔸 calculateFare(char from, char to) – Computes fare based on trip distance.
🔸 addBooking(Booking booking) – Stores new bookings and updates taxi earnings.
🔸 getNextBookingId() – Generates a new unique booking ID.
🔸 toString() – Provides a formatted string representation of taxi details.

3️⃣ Booking.java (Booking Data Model)
Encapsulates booking details such as pickup/drop locations, time, fare, and customer ID.
Provides getter methods for data retrieval.
🔹 Attributes:
✔ bookingId – Unique booking reference.
✔ customerId – ID of the customer.
✔ pickUpTime – Time of taxi pickup.
✔ dropTime – Time taxi reaches the drop location.
✔ amount – Total fare for the trip.
✔ from & to – Pickup and drop points (A-F).

🛠️ Functional Flow (How It Works)
1️⃣ System Initialization:

User enters the number of taxis available.
All taxis start at location 'A' with ₹0 earnings.
2️⃣ Taxi Booking Process:

User inputs pickup & drop locations (A-F) and pickup time.
System finds the best available taxi (nearest with the least earnings).
If a taxi is found, it is assigned to the booking and updated.
If no taxis are available, the booking is rejected.
3️⃣ Taxi Details Display:

Shows all taxis with their total earnings and trip history.
4️⃣ Exit System:

Stops the program execution.
📊 Fare Calculation Formula
💰 Base Fare: ₹100 (for up to 5 km).
🚗 Distance Rate: ₹10 per km after 5 km.
📏 1 unit distance (A → B) = 15 km.

🔹 Example Calculation:
If a trip covers 30 km, fare = ₹100 + ((30-5) * 10) = ₹350.

🔹 OOP Principles Used
✔ Encapsulation – Used private attributes with getter methods.
✔ Abstraction – Taxi and Booking hide unnecessary implementation details.
✔ Inheritance (Minimal) – The system avoids unnecessary complexity.
✔ Polymorphism (Method Overriding) – toString() provides meaningful output.

🚀 Improvements in this Version
✅ Refactored Code: Cleaner, more readable, and optimized logic.
✅ Used Constants: No magic numbers, better maintainability.
✅ Handled Input Validation: Prevents invalid locations & incorrect inputs.
✅ Efficient Taxi Selection: Prioritizes the nearest taxi with lower earnings.
✅ Improved Object Representation: Overridden toString() for better output.

📌 How to Run the Project?
1️⃣ Clone the repository:

sh
Copy
Edit
git clone https://github.com/your-username/CallTaxiBookingSystem.git
cd CallTaxiBookingSystem
2️⃣ Compile & Run:

sh
Copy
Edit
javac -d . Main.java Taxi.java Booking.java
java CallTaxiBookingSystem.Main
3️⃣ Follow the on-screen instructions to book taxis.

🌟 Future Enhancements (To-Do List)
🔹 Improve Taxi Selection Algorithm – Consider real-time traffic & dynamic pricing.
🔹 Implement GUI – Create a JavaFX or Swing-based UI for better usability.
🔹 Store Data in Database – Replace in-memory lists with MySQL/PostgreSQL.
🔹 Add Customer Profiles – Maintain a record of customers & their booking history.
🔹 Introduce Peak-Time Pricing – Adjust fares based on demand.

📜 License
This project is open-source under the MIT License.

📩 Have suggestions or improvements? Feel free to contribute!

🔗 GitHub Repository Link
👉 Call Taxi Booking System 🚖 => https://github.com/jayaraj-v/OOPS_TAXI_BOOKING_SYSTEM

