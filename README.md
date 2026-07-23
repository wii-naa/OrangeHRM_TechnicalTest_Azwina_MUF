# OrangeHRM QA Automation Technical Test

## Overview

This project contains an automated test suite for the OrangeHRM web application developed as part of a QA Automation Technical Test.

The automation is implemented using **Katalon Studio** with a data-driven approach utilizing Excel files for test data management.

---

## Project Structure

```
OrangeHRM_TechnicalTest_Azwina_MUF/
│
├── Data/
│   └── OpenHRM_Test Data.xlsx
│
├── Data Files/
│
├── Object Repository/
│
├── Test Cases/
│   ├── TC-01_Login
│   ├── TC-02_Navigate to Admin Module
│   ├── TC-03_Verify System Users UI Elements
│   ├── TC-04_Add User
│   ├── TC-05_Search User by Username
│   ├── TC-06_Search User by Multiple Parameter
│   ├── TC-07_Update User
│   ├── TC-08_Delete User
│   ├── TC-09_Negative Case Validation
│   └── TC-10_End-to-End CRUD
│
├── Test Suites/
│
├── Reports/
│
└── README.md
```

---

## Test Scenarios

The project covers the following scenarios:

- Login
- Navigate to Admin Module
- Verify System Users UI Elements
- Add New System User
- Search Existing User by Username
- Search Existing User by multiple filter parameter
- Update User
- Delete User
- Add User-Negative Test
- End-to-End CRUD (Create → Read → Update → Delete)

---

## Prerequisites

Before running the project, ensure the following software is installed:

- Katalon Studio
- Google Chrome
- ChromeDriver (managed by Katalon)
- Internet Connection

---

## Tool & Version

| Tool | Version |
|-------|---------|
| Katalon Studio | 10.4.3 |
| Groovy | Built-in |
| Selenium | Built-in |
| Browser | Google Chrome |
| Test Data | Microsoft Excel (.xlsx) |

---

## How to Run

### Run From Test Suite

1. Open **Test Suites**.
2. Select the Test Suite.
3. Click **Run**.

---

## Test Data

All test data is stored in Excel files under:

```
Data/
```

and imported into Katalon via:

```
Data Files/
```

The project uses parameterized test cases to support data-driven testing.

---

## Notes

- Employee Name must already exist in OrangeHRM before creating a System User.
- Screenshots are captured during important test steps.
- Test execution will stop immediately if a critical step fails (`STOP_ON_FAILURE`).

---

## Author

**Azwina**

QA Automation Technical Test