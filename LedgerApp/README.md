# 📒 Ledger Tracking Application

A simple Java console application for managing and displaying financial ledger entries, including deposits and payments. The application reads from a CSV file and provides a menu-driven interface for user interaction.

## 📁 Project Structure

```
src/
└── com/pluralsight/
    ├── LedgerEntry.java
    ├── LedgerMenu.java
    └── Main.java
resources/
└── transactions.csv
```

## 📦 Classes Overview

### `LedgerEntry.java`
Represents a single ledger transaction with the following fields:
- `date` (String)
- `time` (String)
- `vendor` (String)
- `description` (String)
- `amount` (double)

### `LedgerMenu.java`
Handles the display and filtering of ledger entries. Features include:
- Display all entries
- Filter by deposits or payments
- Generate reports:
    - Month-to-date
    - Previous month
    - Year-to-date
    - Previous year
    - Search by vendor (incomplete)

### `Main.java`
The entry point of the application. It:
- Loads ledger entries from a CSV file
- Displays a home screen with options:
    - Add Deposit
    - Make Payment
    - Display Ledger
    - Exit Application

## 🛠️ How to Run

1. Ensure you have Java installed (JDK 8 or higher).
2. Place your `transactions.csv` file in `src/main/resources/`.
3. Compile and run the `Main.java` file.

```bash
javac com/pluralsight/*.java
java com.pluralsight.Main
```

## 📌 Notes

- Some report features in `LedgerMenu` are marked as TODO or partially implemented.
- The CSV file should contain entries in the format:
  ```
  date,time,description,vendor,amount
  ```

## 🚧 Future Improvements

- Fix and complete the report generation methods.
- Implement `searchByVendor`.
- Improve error handling and input validation.
- Add support for writing new entries back to the CSV file.
