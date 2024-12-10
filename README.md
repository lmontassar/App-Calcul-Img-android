# Android BMI Calculator

An Android application that calculates Body Mass Index (IMG) based on user input and provides visual feedback through intuitive smiley faces. The application implements data persistence using serialization to maintain user profiles.

## Features

- Calculate BMI/IMG based on:
  - Weight (Poids)
  - Height (Taille)
  - Age
  - Gender (Homme/Femme)
- Visual feedback with different smiley faces based on the BMI result
- Data persistence using serialization
- Input validation
- Color-coded results (green for normal, red for warnings)

## Project Structure

The project follows the MVC (Model-View-Controller) architecture:

### Model
- `Profil.java`: Handles the BMI calculation logic and result interpretation
  - Implements `Serializable` for data persistence
  - Defines BMI ranges for different genders
  - Calculates IMG and determines result category

### View
- `MainActivity.java`: Main user interface
  - Handles user input
  - Displays results
  - Manages UI state and updates

### Controller
- `Controle.java`: Manages communication between Model and View
  - Implements Singleton pattern
  - Handles profile creation and data retrieval
  - Manages serialization operations

### Utils
- `Serializer.java`: Handles data persistence
  - Provides methods for serializing and deserializing profile data
  - Manages file operations for data storage

## Screenshots


The application features a clean, user-friendly interface with:
- Input fields for weight, height, and age
- Gender selection radio buttons
- A prominent calculate button
- Visual feedback through emojis
- Color-coded results for easy interpretation

## Installation

1. Clone the repository
2. Open the project in Android Studio
3. Build and run the application on your device or emulator

## Usage

1. Enter your weight in kilograms
2. Enter your height in centimeters
3. Enter your age
4. Select your gender
5. Press the "Calculer" button to see your BMI result
6. The result will be displayed with a corresponding smiley face and color indication

