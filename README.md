# AutoCare Application (Frontend)

Android frontend for a vehicle service management system, built in Java as part of a university group project. This repository contains the UI layer: screens, navigation and input validation. The data layer was built separately by teammates and is not included here.

## Scope

**This repo covers:**
- Splash and login flow with role-based routing
- Admin, Mechanic and Customer dashboards
- Forms for adding customers, vehicles and mechanics, creating bookings and updating service status
- A bookings list screen using RecyclerView

**This repo does not include:**
- Database persistence (SQLite integration was handled by teammates)
- Real authentication (login uses hardcoded demo credentials)

Screens that save data currently validate input and show a confirmation toast only. Each one has a `TEAM MATE HANDOFF POINT` comment marking where the database logic plugs in.

## Features by role

| Role | Screens |
|---|---|
| Admin | Add Customer, Add Vehicle, Add Mechanic |
| Mechanic | Create Booking, Update Service Status, View Bookings |
| Customer | View Bookings (My Vehicles and My Profile are placeholders) |

## Demo credentials

| Role | Username | Password |
|---|---|---|
| Admin | `admin` | `1234` |
| Mechanic | `mechanic` | `1234` |
| Customer | `customer` | `1234` |

These are placeholders for development only and are meant to be replaced with database-backed login.

## Tech stack

- Java 11
- Android SDK (min API 30, target API 36)
- Material Components, AppCompat, ConstraintLayout, RecyclerView
- Gradle with Kotlin DSL and a version catalog

## Project structure

```
app/src/main/
├── java/com/example/autocareapplication/
│   ├── SplashActivity.java            # 2.5s splash, routes to login
│   ├── LoginActivity.java             # Role-based routing
│   ├── AdminDashboardActivity.java
│   ├── MechanicDashboardActivity.java
│   ├── CustomerDashboardActivity.java
│   ├── AddCustomerActivity.java
│   ├── AddVehicleActivity.java
│   ├── AddMechanicActivity.java
│   ├── CreateBookingActivity.java
│   ├── UpdateServiceStatusActivity.java
│   ├── ViewBookingsActivity.java      # RecyclerView with sample data
│   ├── Booking.java                   # Booking model
│   └── BookingAdapter.java            # RecyclerView adapter
└── res/layout/                        # One XML layout per screen, plus item_booking.xml
```

## Getting started

1. Clone the repository:
   ```bash
   git clone https://github.com/Moleboheng-Mahahle/AutoCareApplication.git
   ```
2. Open the project in Android Studio.
3. Let Gradle sync, then run the app on an emulator or device running Android 11 (API 30) or higher.
4. Log in with one of the demo credentials above.

## Integrating the data layer

Replace the following stubs with database calls:

| File | Stub |
|---|---|
| `LoginActivity` | Hardcoded credential check |
| `AddCustomerActivity`, `AddVehicleActivity`, `AddMechanicActivity` | Insert logic |
| `CreateBookingActivity` | Booking insert |
| `UpdateServiceStatusActivity` | Status update query |
| `ViewBookingsActivity` | Dummy `Booking` list, replace with a database cursor |

## Known limitations

- No persistence: nothing entered in the forms is saved
- Status and IDs are entered as free text rather than chosen from fixed options or existing records
- Customer "My Vehicles" and "My Profile" screens are not yet implemented



## Author

Moleboheng Mahahle: frontend (UI, navigation and validation)

