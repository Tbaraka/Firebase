# Mama Fua Pro - Laundry Service App

Mama Fua Pro is an Android application designed to bridge the gap between laundry service providers ("Mama Fua") and customers. It allows users to easily book laundry services, provide specific instructions, and manage their bookings through a simple, user-friendly interface powered by Firebase.

## 🚀 Features

- **User Authentication**: Secure sign-up and login system using Firebase Authentication.
- **Service Booking**: A detailed booking form where users can provide:
  - Full Name
  - Phone Number
  - Pickup Location
  - Preferred Pickup Time
  - Special Instructions (e.g., "Hand wash only", "No bleach")
- **Booking Management**:
  - Customers can schedule new washes from the home dashboard.
  - Admins can view all incoming wash requests in a real-time list.
- **Status Tracking**: Bookings are initialized with a "pending_wash" status.
- **Dynamic Menu**: A reusable options menu for quick access to "Contact Us", "Admin Login", and "Logout".

## 🛠️ Technologies Used

- **Language**: Java
- **UI Framework**: Android XML with Material Design & AppCompat
- **Database**: Google Firebase Firestore (NoSQL)
- **Authentication**: Firebase Auth
- **Components**: RecyclerView, CardView, Toolbar, and custom Adapters.

## 📂 Project Structure

- `signup.java` / `login.java`: Handles user onboarding.
- `HomeActivity.java`: The main landing page for customers.
- `dashboard.java`: The booking interface for scheduling laundry.
- `WashBooking.java`: The data model representing a laundry request.
- `viewwashes.java`: The admin dashboard to view all bookings.
- `washadapter.java`: Custom adapter to display bookings in a list format.
- `newUserOption.java`: A base class to handle shared menu logic across activities.

## ⚙️ Installation & Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/MamaFuaPro.git
   ```
2. **Open in Android Studio**:
   Open the project folder and let Gradle sync.
3. **Connect to Firebase**:
   - Create a new project in the [Firebase Console](https://console.firebase.google.com/).
   - Add your Android app package name (`com.example.firebase`).
   - Download the `google-services.json` file and place it in the `app/` directory.
   - Enable **Email/Password** Authentication.
   - Create a **Cloud Firestore** database in test mode.
4. **Build and Run**:
   Click the "Run" button in Android Studio to install the app on your emulator or physical device.

## 📋 Future Enhancements

- [ ] Push notifications for booking status updates.
- [ ] In-app payment integration (M-Pesa/Card).
- [ ] User profile editing.
- [ ] Location services (GPS) for automated pickup addresses.

## 📄 License

Distributed under the MIT License. See `LICENSE` for more information.
