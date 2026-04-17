# Mama Fua Pro - Laundry Service App

Mama Fua Pro is a modern Android application designed to bridge the gap between laundry service providers "Mama Fua" and customers. powered by Firebase.

## 🚀 Key Features

### For Customers
- **User Authentication**: Secure sign-up and login using Firebase Authentication.
- **Service Booking**: Detailed forms to schedule laundry with pickup location, preferred time, and special instructions.
- **Mamafua Registration**: A dedicated portal for service providers to join the team.
- **Booking History**: View and track your scheduled washes.

### For Admins
- **Manage Appointments**: View all incoming laundry requests in real-time.
- **Mamafua Onboarding**: Review, filter (Pending/Approved), and approve new Mamafua registrations directly from the Admin Dashboard.
- **Status Tracking**: Manage the lifecycle of requests from "pending" to "approved".

## 🎨 Design & Theme
- **Fresh & Clean Aesthetic**: A professional palette of **Deep Blue** (trustworthy) and **Fresh Teal** (cleanliness) using Material 3 components.
- **Responsive UI**: Card-based navigation on the home screen with high-quality visual cues.
- **Consistent Forms**: Uniform input fields and button styles across the entire application for a seamless user experience.

## 🛠️ Technologies Used
- **Language**: Java
- **UI Framework**: Android XML with Material 3 Design
- **Database**: Google Firebase Firestore (NoSQL)
- **Authentication**: Firebase Auth
- **Components**: RecyclerView, CardView, MaterialToolbar, and custom PopupMenus.

## 📂 Project Structure
- `HomeActivity.java`: Main customer landing page with service cards.
- `AdminDashboardActivity.java`: Central hub for administrative tasks.
- `RegisterMamafuaActivity.java`: Form for service providers to apply.
- `ViewMamafuaRegistrationsActivity.java`: Admin view to filter and approve applicants.
- `dashboard.java`: Customer booking interface.
- `viewwashes.java`: Real-time list of all laundry appointments.
- `newUserOption.java`: Base class for shared menu logic (Contact, Admin Login, Logout).

## ⚙️ Installation & Setup
1. **Clone the repository**:
   ```bash
   git clone https://github.com/Tbaraka/MamaFuaPro.git
   ```
2. **Open in Android Studio**:
   Open the project folder and let Gradle sync.
3. **Connect to Firebase**:
   - Create a project in the [Firebase Console](https://console.firebase.google.com/).
   - Add your Android app package name (`com.example.firebase`).
   - Place `google-services.json` in the `app/` directory.
   - Enable **Email/Password** Authentication and **Cloud Firestore**.
4. **Build and Run**:
   Install the app on your emulator or physical device via Android Studio.

## 📋 Future Enhancements
- [ ] Push notifications for booking status updates.
- [ ] M-Pesa/Card payment integration.
- [ ] GPS-based location services for automated pickup addresses.
- [ ] Rating and review system for Mamafuas.

