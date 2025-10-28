🧩 OOS Praktikum 1–2

Author: Arjeet Gongboir
Course: Object-Oriented Software Development (OOS)
University: Fachhochschule Aachen
Language: Java

⸻

📘 Overview

This repository contains the practical exercises for Praktikum 1 and Praktikum 2 of the Object-Oriented Software Development course.
The goal of these assignments is to gradually build a simple, object-oriented banking system in Java — starting with basic classes and then evolving the design to include inheritance, interfaces, and abstraction.

⸻

🧱 Praktikum 1 — Basic Classes and Constructors

📂 Package: bank

In Praktikum 1, two foundational classes are created to model simple financial transactions:
•	Payment – Represents a deposit or withdrawal.
•	Transfer – Represents a transfer between two accounts.

Each class includes:
•	Three constructors:
1.	Minimal constructor (basic attributes)
2.	Full constructor (all attributes)
3.	Copy constructor
•	Getter and setter methods for encapsulation
•	Validation and console error messages (System.out)

🧪 Testing

A separate Main class (outside the bank package) tests all constructors and methods:
•	Object creation with various constructors
•	Copy constructor behavior
•	Validation of incorrect input (e.g., invalid interest or negative transfer amount)
•	Console output using a printObject() method

🎯 Learning Focus
•	Encapsulation and data hiding
•	Constructor overloading and reusability
•	Working with packages and access modifiers
•	Testing and debugging class behavior

⸻

🧩 Praktikum 2 — Inheritance, Interfaces & Abstraction

📂 Extended Package: bank

In Praktikum 2, the existing code is refactored to introduce proper object-oriented hierarchy:
•	Transaction (abstract class)
•	Common superclass for all transactions.
•	Contains shared attributes (date, amount, description).
•	Declares abstract method calculate() to be implemented by subclasses.
•	CalculateBill (interface)
•	Defines a single method calculate() returning a double.
•	Implemented by both Payment and Transfer.
•	Payment (extends Transaction, implements CalculateBill)
•	Adds incomingInterest and outgoingInterest.
•	Implements calculate() with interest adjustments.
•	Transfer (extends Transaction, implements CalculateBill)
•	Adds sender and recipient.
•	Overrides setAmount() to ensure positive values only.
•	calculate() returns the raw amount (no interest).

⚙️ Key Features
•	Extracted common attributes into an abstract superclass.
•	Replaced printObject() with overridden toString() methods.
•	Implemented equals(Object) in all classes for logical comparison.
•	Introduced polymorphism through the CalculateBill interface.

🧪 Testing

The Main class tests:
•	All constructors (including copy constructors)
•	Correct behavior of calculate() for both deposits and withdrawals
•	equals() and toString() methods
•	Validation rules for interest rates and transfer amounts

🎯 Learning Focus
•	Inheritance and abstraction
•	Interface implementation
•	Method overriding (toString(), equals())
•	Clean, reusable architecture
•	Javadoc documentation and UML diagram creation

⸻

🧰 Tools & Technologies
•	Language: Java (JDK 17+)
•	IDE: IntelliJ IDEA
•	Documentation: Javadoc
•	Diagrams: UML