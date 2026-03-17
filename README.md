# Quantity Measurement App

🧾 Project Overview

The Quantity Measurement App is a Test-Driven Development (TDD) based project designed to demonstrate how to build scalable, maintainable software by starting simple and progressively adding complexity.

The application focuses on comparing and converting length measurements across different units while strictly following:

Test Driven Development (TDD)

Incremental Development

Clean Code Principles

DRY (Don't Repeat Yourself)

Proper Git Workflow (feature branches + PR)

The project is built step-by-step through Use Cases (UCs).
Each UC introduces a small feature and refactors the design to keep the code maintainable and extensible.

🧪 Development Methodology

This project follows the TDD Cycle:

🔴 Write failing test

🟢 Write minimal code to pass

🔵 Refactor without breaking tests

This ensures:

Safety

Maintainability

Scalability

🌳 Git Workflow Used

We followed a professional branching strategy:

main → stable production code

dev → integration branch

feature/UCx-* → individual feature branches

Each UC was:

Developed in feature branch

Tested locally

Pushed & PR created

Merged into dev

📚 USE CASE IMPLEMENTATION
## 🟢 UC1 — Feet Equality
🎯 Goal

Compare two Feet measurements for equality.

🧪 Tests Written

We validated the equals contract:

Same value → equal

Different value → not equal

Null comparison → false

Different object type → false

Same reference → true

💻 Implementation

Created Feet class with:

value field

equals() method

🧠 Learning Outcome

Understanding equality contract

First step of TDD

## 🟢 UC2 — Inches Equality
🎯 Goal

Support Inches unit in addition to Feet.

🧪 Tests Written

Repeated same equality tests for:

Inches = Inches

💻 Implementation

Created Inches class similar to Feet.

⚠️ Problem Observed

Huge code duplication:

Feet and Inches had identical logic.

🧠 Learning Outcome

Recognized need for refactoring (DRY violation).

## 🔵 UC3 — Refactor to Generic Length Class
🎯 Goal

Remove duplication by introducing a generic measurement model.

🛠 Refactoring Done

Removed:

❌ Feet class

❌ Inches class

Introduced:

✅ Length class

✅ LengthUnit enum

🧠 Core Design Change

Instead of multiple classes:

Feet
Inches

We created one generic model:

Length(value, LengthUnit)
📐 Base Unit Concept

All units converted internally to INCHES (base unit).

FEET  → 12 inches
INCHES → 1 inch

Added method:

convertToBaseUnit()
🧪 Tests Covered

✔ Feet = Feet
✔ Inches = Inches
✔ 1 Foot = 12 Inches
✔ Symmetry
✔ Transitive equality
✔ equals contract validation

🧠 Learning Outcome

Refactoring safely using tests

Generic design

Domain modeling

DRY principle

## 🟣 UC4 — Add New Units (Extensibility Proof)
🎯 Goal

Prove that the design is scalable by adding new units without modifying core logic.

➕ New Units Added

YARDS

CENTIMETERS

Updated enum only — no logic changes.

📐 Conversion Factors
Unit	Inches
1 Foot	12
1 Yard	36
1 Inch	1
1 cm	0.393701
🧪 Tests Added

✔ Yard = Yard
✔ Yard = Feet
✔ Yard = Inches
✔ Feet = Yard (symmetry)
✔ Inches = Yard (symmetry)
✔ Centimeter = Inches
✔ Centimeter ≠ Feet
✔ Transitive property

🧠 Learning Outcome

Extensible architecture

Open/Closed Principle

Adding features without modifying logic

## 🔵 UC5 — Unit Conversion
🎯 Goal

Add the ability to convert length from one unit to another.

Until UC4, the app could only compare units.
UC5 introduces an explicit conversion API.

⚙️ Features Added

Static conversion method

convert(value, fromUnit, toUnit)

Instance conversion method in Length class

length.convertTo(targetUnit)

Overloaded helper methods for easy usage.

🧪 Test Coverage

Feet ↔ Inches conversion

Yards ↔ Inches conversion

Centimeters ↔ Inches conversion

Zero & negative values

Round-trip conversion

Null & NaN validation

🧠 Learning Outcome

UC5 demonstrates:

Reusable design from previous UCs

Clean API design

Validation & edge-case handling

## UC6 – Addition of Two Length Units
Overview

UC6 extends the Quantity Measurement App by adding addition operations between two length measurements.
Users can now add values with same or different units and get the result in the unit of the first operand.

Example:

1 Foot + 12 Inches = 2 Feet

What was implemented

Added add() method in Length class

Supports addition across units:

Feet, Inches, Yards, Centimeters

Uses base unit normalization (inches) before addition

Returns a new immutable Length object

Maintains floating-point precision using rounding

Ensures input validation and error handling

Key Features

Same-unit addition (Feet + Feet)

Cross-unit addition (Feet + Inches, Yards + Feet, etc.)

Result returned in unit of first operand

Supports zero, negative, large and small values

Null and invalid inputs throw exceptions

Addition follows commutative property

Example Usage
Length l1 = new Length(1, Length.LengthUnit.FEET);
Length l2 = new Length(12, Length.LengthUnit.INCHES);

Length result = l1.add(l2);
System.out.println(result); // 2.00 FEET

## UC7 – Addition with Target Unit Specification
Overview

UC7 extends the length addition feature by allowing the caller to explicitly choose the unit of the result.
Instead of always returning the result in the unit of the first operand (UC6), the result can now be returned in any supported length unit.

What was implemented

Added overloaded add method to support target unit:

add(Length length1, Length length2, LengthUnit targetUnit)

Both lengths are:

Converted to base unit (inches)

Added together

Converted to the specified target unit

Returned as a new immutable Length object

Supported Units

FEET

INCHES

YARDS

CENTIMETERS

Key Features

Explicit control over result unit

Maintains immutability of objects

Reuses conversion logic from UC5

Maintains backward compatibility with UC6

Validates null units and invalid inputs

Example
Input	Target Unit	Result
1 ft + 12 in	FEET	2 ft
1 ft + 12 in	INCHES	24 in
1 ft + 12 in	YARDS	0.667 yd
Concepts Covered

Method Overloading

DRY Principle (shared conversion logic)

Explicit parameter design

Floating-point precision handling

Robust validation & exception handling

##  📘 UC8 – Refactoring Unit Enum to Standalone Class
🔹 Overview

UC8 refactors the architecture by extracting LengthUnit enum from the Length class into a standalone top-level enum.
This follows the Single Responsibility Principle (SRP) and makes the design scalable for future measurement types (Weight, Volume, Temperature).

🔹 What Changed in UC8

LengthUnit moved to its own class.

All conversion logic is now handled inside LengthUnit.

Length class now focuses only on:

equality

conversion delegation

addition operations

Circular dependency risk removed.

All UC1 → UC7 functionality works without any change.

🔹 New Capabilities

Units now handle:

convertToBaseUnit()

convertFromBaseUnit()

Cleaner architecture & better separation of concerns.

Easy to add new measurement categories in future.

🔹 Result

No breaking changes.

All previous tests pass.

Archite

## UC9- Addition of Weight Measurement
📌 Feature Added

UC9 extends the Quantity Measurement App by introducing a new measurement category: Weight.

The system now supports multiple independent measurement categories:

Length (existing UC1–UC8)

Weight (new in UC9)

⚖️ Supported Weight Units
Unit	Base Conversion
Kilogram (kg)	Base unit
Gram (g)	1 kg = 1000 g
Pound (lb)	1 lb = 0.453592 kg
🚀 Capabilities Implemented
1️⃣ Equality Comparison

Weight objects can be compared across units.
Example:

1 kg == 1000 g

2.20462 lb == 1 kg

2️⃣ Unit Conversion

Weights can be converted between all units.
Examples:

kg → g

g → lb

lb → kg

3️⃣ Addition Operations

Two weights can be added:

Result in first operand unit

Result in explicit target unit

Examples:

1 kg + 1000 g = 2 kg

1 kg + 1000 g (GRAM) = 2000 g

4️⃣ Category Type Safety

Weight and Length cannot be compared.
Example:

1 kg != 1 foot

5️⃣ Immutability & Precision

All operations return new objects

Round-trip conversions maintain accuracy

Works with zero, negative & large values

🧠 Key Learning

Multiple measurement categories design

Reusable enum-based conversion architecture

Type safety across domains

Arithmetic on Value Objects


## 🔹 UC10 — Generic Quantity Measurement using Interface & Generics

In this UC, the application was refactored to a generic architecture to support multiple measurement types using a common design.

🎯 What was implemented
1️⃣ Introduced a common interface

Created IMeasurable interface to standardize unit behavior:

Conversion to base unit

Conversion from base unit

Unit name access

This allows any future unit type (Temperature, Volume, etc.) to plug into the system easily.

2️⃣ Refactored Unit Enums

Both enums now implement IMeasurable:

LengthUnit

WeightUnit

Each unit now defines:

Conversion factor to base unit

Conversion logic

3️⃣ Created Generic Quantity Class

Introduced reusable generic class:

Quantity<U extends IMeasurable>

Capabilities:

Compare quantities across units

Convert between units

Add quantities

Add quantities with target unit

Validation & immutability

This removed duplication and made the design scalable and extensible.

4️⃣ Multi-Domain Support

Application now supports:

Length conversions & arithmetic

Weight conversions & arithmetic

5️⃣ Extensive Test Coverage

Added 30+ unit tests covering:

Enum conversion logic

Equality checks

Conversions

Addition

Null & invalid inputs

HashCode & immutability

Backward compatibility


## UC11 — Volume Measurement Support

This use case demonstrates the scalability of the generic Quantity architecture by introducing a new measurement category Volume without modifying existing classes.

What was added

Introduced new enum VolumeUnit implementing IMeasurable

Supported units:

LITRE (base unit)

MILLILITRE

GALLON

Key Achievements

No changes required in Quantity, LengthUnit, or WeightUnit

Generic design automatically supports new unit categories

Added 50 comprehensive test cases for volume:

Equality

Conversion

Addition

Cross-category safety

Precision & immutability

This UC proves the system is open for extension and closed for modification (OCP).

## UC12 – Subtraction & Division Support

In this use case, we enhanced the generic Quantity system by adding arithmetic operations beyond addition.

Features Added

subtract(Quantity<U> other)

subtract(Quantity<U> other, U targetUnit)

divide(Quantity<U> other)

Key Improvements

Supports subtraction across compatible units

Supports subtraction with explicit target unit

Supports division (returns ratio as double)

Cross-category safety maintained (Length ≠ Weight ≠ Volume)

Division by zero handled using ArithmeticException

Improved output readability using overridden toString()

Design Impact

No architectural change required

Generic design remains scalable

Fully backward compatible with UC1–UC11


## 📄 UC13 – Centralized Arithmetic Logic (DRY Refactor)
🎯 Objective

Refactor arithmetic operations in Quantity class to remove code duplication and enforce the DRY (Don’t Repeat Yourself) principle while keeping behaviour unchanged.

✨ Enhancements

Introduced ArithmeticOperation enum to centralize arithmetic logic.

Added validateArithmeticOperands() to unify validation across operations.

Added performBaseArithmetic() helper to execute arithmetic in base units.

All public APIs remain unchanged (backward compatible with UC12).

➕ Refactored Operations

Addition

Subtraction

Division

All now delegate to centralized helper methods.

🧪 Testing

New tests added to verify:

Helper delegation

Enum-based arithmetic dispatch

Validation consistency across operations

Backward compatibility with UC12 behaviour

All tests passing ✅

🏁 Outcome

Code duplication removed

Improved maintainability & scalability

Ready for future arithmetic operations (multiply, modulo, etc.)


## UC14 – Temperature Measurement (Non-Arithmetic Quantity)

Overview:
In this UC we extended the Quantity Measurement App to support Temperature units while enforcing that temperature does NOT support arithmetic operations (add, subtract, divide).
This demonstrates how to safely introduce new measurement categories with different behavior using interfaces and functional programming.

Key Enhancements:

Added new measurement category Temperature

Supported units:

Celsius

Fahrenheit

Kelvin

Implemented temperature conversion formulas:

°C ↔ °F

°C ↔ K

°F ↔ K

Introduced SupportsArithmetic functional interface

Arithmetic operations now:

✅ Allowed → Length, Weight, Volume

❌ Blocked → Temperature (throws UnsupportedOperationException)

Added 40+ unit tests validating:

Equality across temperature units

Conversion accuracy

Round-trip conversion

Extreme values & precision

Unsupported arithmetic validation


# UC15 – N-Tier Architecture Refactoring (Quantity Measurement Application)

## Overview
UC15 refactors the **Quantity Measurement Application** from a monolithic design into a professional **N-Tier architecture**.  
The application is organized into multiple layers to improve **separation of concerns, maintainability, scalability, and testability.**

---

## Architecture

The application follows a **layered architecture**:

```
Application Layer
        |
        v
Controller Layer
        |
        v
Service Layer
        |
        v
Repository Layer
        |
        v
Entity / Model Layer
```

---

## Layers Description

### 1. Application Layer
Entry point of the application.

**Class**
- `QuantityMeasurementApp`

**Responsibilities**
- Initialize components
- Start the application
- Call controller methods

---

### 2. Controller Layer
Handles user requests and delegates operations to the service layer.

**Class**
- `QuantityMeasurementController`

**Responsibilities**
- Accept user input
- Call service methods
- Display results

---

### 3. Service Layer
Contains the core **business logic** for quantity operations.

**Interface**
- `IQuantityMeasurementService`

**Implementation**
- `QuantityMeasurementServiceImpl`

**Supported Operations**
- Compare quantities
- Add quantities
- Subtract quantities
- Divide quantities

---

### 4. Repository Layer
Responsible for storing **measurement history**.

**Interface**
- `IQuantityMeasurementRepository`

**Implementation**
- `QuantityMeasurementCacheRepository`

**Special Implementation**
- Uses **Singleton Pattern** to maintain a single repository instance.

---

### 5. Entity / Model Layer
Classes used for **data representation**:

- `QuantityDTO`
- `QuantityModel`
- `QuantityMeasurementEntity`

**Purpose**

| Class | Description |
|------|-------------|
| DTO | Used for transferring data between layers |
| Model | Internal service representation |
| Entity | Stores measurement records |

---

## Design Principles Used

- Separation of Concerns
- SOLID Principles
- Dependency Injection

---

## Design Patterns Used

- Singleton Pattern
- Factory Pattern
- Facade Pattern

---

## Testing

JUnit test cases are implemented to verify:

- Service operations
- Controller flow
- Repository behavior
- Edge cases

## UC16 – Database Integration with JDBC for Quantity Measurement Persistence

### Overview

UC16 enhances the **Quantity Measurement Application** by introducing **persistent storage using JDBC**.
In the previous use case (UC15), the application followed an **N-Tier Architecture** with an in-memory cache repository.
UC16 extends this design by implementing a **database repository layer** that stores measurement operations in a relational database.

The system now supports **long-term persistence**, enabling storage, retrieval, and analysis of measurement operations.

---

### Architecture

The application continues to follow the **layered N-Tier architecture** introduced in UC15.

```
Application Layer
        |
        v
Controller Layer
        |
        v
Service Layer
        |
        v
Repository Layer
        |
        v
Database (H2)
```

---

### Layers Description

#### Application Layer

Entry point of the application.

Class:

```
QuantityMeasurementApp
```

Responsibilities:

* Initialize repository implementation
* Configure database settings
* Start application execution
* Display measurement history

---

#### Controller Layer

Handles user requests and delegates them to the service layer.

Class:

```
QuantityMeasurementController
```

Responsibilities:

* Accept input quantities
* Call service methods
* Display results
* Handle user interaction logic

---

#### Service Layer

Contains the core business logic for quantity operations.

Interface:

```
IQuantityMeasurementService
```

Implementation:

```
QuantityMeasurementServiceImpl
```

Supported operations:

* Compare quantities
* Convert units
* Add quantities
* Subtract quantities
* Divide quantities

Responsibilities:

* Perform business logic
* Validate measurement categories
* Convert units before operations
* Persist results through repository layer

---

#### Repository Layer

Responsible for storing and retrieving measurement data.

Interface:

```
IQuantityMeasurementRepository
```

Implementations:

```
QuantityMeasurementCacheRepository
QuantityMeasurementDatabaseRepository
```

Repository Types:

| Repository          | Description                      |
| ------------------- | -------------------------------- |
| Cache Repository    | In-memory storage used in UC15   |
| Database Repository | JDBC implementation used in UC16 |

Responsibilities:

* Store measurement operations
* Retrieve measurement history
* Query operations
* Delete stored records

---

### Database Integration

UC16 introduces **JDBC-based persistence** using the **H2 database**.

Database Configuration:

```
jdbc:h2:./quantitydb
```

Database Table:

```
QUANTITY_MEASUREMENT_ENTITY
```

Table Structure:

| Column        | Description                          |
| ------------- | ------------------------------------ |
| id            | Primary key                          |
| operation     | Operation type (ADD, SUBTRACT, etc.) |
| operand1      | First quantity                       |
| operand2      | Second quantity                      |
| result        | Operation result                     |
| error_message | Error information                    |
| created_at    | Timestamp of operation               |

---

### Database Utilities

#### ApplicationConfig

Loads configuration from `application.properties`.

Responsibilities:

* Load database URL
* Load username and password
* Load repository configuration

---

#### ConnectionPool

Manages database connections.

Responsibilities:

* Maintain connection pool
* Reuse database connections
* Improve performance
* Prevent connection overhead

---

### Exception Handling

New exception introduced:

```
DatabaseException
```

Purpose:

* Handle JDBC errors
* Provide meaningful error messages
* Prevent application crashes

---

### Persistence Flow

Example Flow for Addition Operation:

```
Controller receives request
        |
        v
Service performs validation and conversion
        |
        v
Repository saves operation in database
        |
        v
Database stores measurement record
```

---

### Technologies Used

| Technology      | Purpose                         |
| --------------- | ------------------------------- |
| Java            | Core application logic          |
| Maven           | Build and dependency management |
| JDBC            | Database connectivity           |
| H2 Database     | Lightweight embedded database   |
| JUnit 5         | Unit testing                    |
| Mockito         | Mocking for tests               |
| SLF4J + Logback | Logging framework               |

---

### Key Features Introduced in UC16

* JDBC-based database persistence
* H2 embedded database integration
* Connection pooling for database performance
* Configurable repository implementation
* SQL-based data storage
* Secure parameterized queries
* Improved logging using SLF4J
* Extended unit and integration testing
* Maven dependency management

---

### Advantages of UC16 Implementation

| Improvement        | Benefit                            |
| ------------------ | ---------------------------------- |
| Persistent Storage | Data survives application restarts |
| JDBC Integration   | Standard database connectivity     |
| Connection Pooling | Efficient resource usage           |
| Query Support      | Retrieve measurement history       |
| Database Schema    | Structured data storage            |
| Scalability        | Supports larger datasets           |

---

### Testing

JUnit test cases verify:

* Database connection creation
* Repository CRUD operations
* SQL query execution
* Connection pool functionality
* Data persistence
* Service layer integration
* Controller functionality

All **UC1–UC15 test cases continue to pass**, ensuring backward compatibility.

---

### Postconditions

After implementing UC16:

* The application supports **database persistence**
* Measurement operations are stored in a **relational database**
* The repository layer supports **both cache and database storage**
* Database queries can retrieve stored measurements
* Connection pooling improves performance
* The system is ready for **future REST API integration**
* The project follows a **professional Maven project structure**

---

### Summary

UC16 transforms the Quantity Measurement Application from an **in-memory system** into a **database-backed application** using JDBC.

This enhancement improves:

* Persistence
* Scalability
* Maintainability
* Data analysis capabilities

The system now supports long-term storage of measurement operations and prepares the application for **future enterprise-level features such as REST APIs and distributed deployment**.