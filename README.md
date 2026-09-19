# Scam Message Analyzer

A Java-based application that analyzes messages for common scam indicators and provides a risk score.

## Features

- Detects suspicious keywords
- Detects payment-related requests
- Detects prize and lottery scams
- Detects suspicious website links
- Detects urgency-based language
- Calculates a risk score
- Classifies messages as LOW, MEDIUM, or HIGH risk
- Provides safety recommendations
- Includes a Java Swing graphical user interface

## Technologies Used

- Java
- Java Swing
- Object-Oriented Programming
- ArrayList
- String Processing

## Project Structure

- `ScamMessageAnalyzer.java` – Console-based application
- `MessageAnalyzer.java` – Scam detection and risk analysis
- `ScamAnalyzerGUI.java` – Graphical user interface

## How It Works

1. User enters a message.
2. The application checks for suspicious patterns.
3. Risk points are assigned based on detected indicators.
4. A risk score is calculated.
5. The message is classified as LOW, MEDIUM, or HIGH risk.
6. The application provides safety recommendations.

## Example

```text
Risk Score : 75/100
Risk Level : HIGH

Recommendation:
Do not click links or share OTP, passwords, or payment details.
