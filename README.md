# What-should-I-wear: Weather-Based Outfit Recommendation API

## 📌 Project Overview
"What-should-I-wear" is a robust Backend API built using **Java and Spring Boot**. The application provides intelligent clothing recommendations by mapping real-time weather conditions to specific outfit tiers. 

This project demonstrates the implementation of complex business logic and a "quality-first" approach through rigorous unit testing.

## 🚀 Features
* **Real-time Condition Mapping:** Dynamically processes weather data to provide accurate suggestions.
* **Tier-based Logic:** Implements sophisticated decision-making based on temperature ranges and atmospheric conditions (e.g., Rain, Snow, Sun).
* **RESTful API Design:** Clean endpoints built with Spring Boot to serve recommendation data.
* **Reliability:** Built with a focus on API response stability and logic accuracy.

## 🛠 Tech Stack
* **Language:** Java
* **Framework:** Spring Boot
* **Testing:** JUnit
* **Build Tool:** Maven / Gradle

## 🧪 Testing & Quality Assurance
Following a strong foundation in **Software Testing**, I have prioritized the reliability of this service:
* **JUnit Validation:** Developed and executed test cases to ensure the recommendation logic handles all edge cases (e.g., extreme temperatures or conflicting conditions).
* **Logic Accuracy:** Validated that the "condition mapping" aligns perfectly with defined business rules.

## 📂 Project Structure
* `src/main/java`: Contains the Spring Boot controllers and recommendation services.
* `src/test/java`: Contains the JUnit test suites used for validating business logic.

## ⚙️ How to Run
1. **Clone the repository:**
   ```bash
   git clone [https://github.com/Mitsuha-24/What-should-I-wear.git](https://github.com/Mitsuha-24/What-should-I-wear.git)
   ```
2.**Run the application:**
```bash
./mvnw spring-boot:run
```
3.**Run Tests:**
```bash
./mvnw test
```
**The Application is accesible at http://localhost:8080/recommend?city=city_name**
