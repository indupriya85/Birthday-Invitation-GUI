# Birthday Invitation Generator

A Java Swing GUI application that generates a personalized and decorated birthday greeting based on the user's name and date of birth.

The application provides a simple input window where the user enters their name and date of birth. After clicking the **Generate** button, a separate decorated birthday card is displayed with the person's name and automatically calculated age.

## Features

* User-friendly Java Swing graphical interface
* Accepts the birthday person's name
* Accepts date of birth in `dd/MM/yyyy` format
* Automatically calculates the person's current age
* Generates the correct birthday ordinal such as `18th`, `20th`, `21st`, `22nd`, or `23rd`
* Displays a separate decorated birthday greeting window
* Includes birthday-themed decorations and emojis
* Validates empty fields
* Validates the date format
* Prevents future dates of birth
* Uses a clean and colorful GUI design

## Technologies Used

* Java
* Java Swing
* Java AWT
* Java Time API

## Java Concepts Used

* Classes and objects
* Inheritance using `JFrame`
* Encapsulation
* Methods
* Event handling
* Lambda expressions
* Exception handling
* String handling
* Conditional statements
* `LocalDate`
* `Period`
* `DateTimeFormatter`
* GUI components and layouts

## How the Application Works

### 1. Enter Details

The application opens a **Birthday Invitation** window where the user enters:

* Name
* Date of Birth

The date should be entered in the following format:

```text
dd/MM/yyyy
```

Example:

```text
05/08/2006
```

### 2. Click Generate

After entering the details, click the **Generate** button.

The application validates the entered information and calculates the person's current age using the date of birth.

### 3. Birthday Card

A separate birthday card window is displayed containing:

```text
HAPPY
BIRTHDAY
INDUPRIYA!

Wishing you a very happy and
wonderful 20th Birthday!
```

The card also includes birthday decorations such as balloons, cake, stars, hearts, and celebration symbols.

## Age Calculation

The application uses Java's `LocalDate` and `Period` classes to calculate the current age.

```java
int age = Period.between(
        birthDate,
        today
).getYears();
```

The birthday ordinal is generated automatically using the `getOrdinal()` method.

Examples:

```text
1st
2nd
3rd
4th
11th
12th
13th
21st
22nd
23rd
```

## Input Validation

The application checks whether:

* The name is entered.
* The date of birth is entered.
* The date follows the `dd/MM/yyyy` format.
* The date of birth is not a future date.

If invalid information is entered, an appropriate error message is displayed.

## Project Structure

```text
Birthday-Invitation-GUI/
│
├── BirthdayInvitation.java
└── README.md
```

## How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/indupriya85/Birthday-Invitation-GUI.git
```

### 2. Open the Project

Open the project folder in an IDE such as:

* Visual Studio Code
* IntelliJ IDEA
* Eclipse

### 3. Compile the Program

Open the terminal inside the project folder and run:

```bash
javac BirthdayInvitation.java
```

### 4. Run the Program

```bash
java BirthdayInvitation
```

The Birthday Invitation GUI will open.

## Sample Input

```text
Name: Indupriya
Date of Birth: 05/08/2006
```

## Sample Output

The application generates a decorated birthday card displaying:

```text
HAPPY
BIRTHDAY
INDUPRIYA!

Wishing you a very happy and
wonderful 20th Birthday!
```

The age is calculated automatically based on the entered date of birth and the current date.

## Project Highlights

This project demonstrates how Java Swing can be used to create an interactive desktop application instead of a command-line program.

It combines GUI design, event handling, date processing, input validation, and object-oriented programming concepts in a single application.

## Author

**P. Indupriya**

B.Tech – Computer Science and Engineering (Data Science)

CVR College of Engineering, Hyderabad
