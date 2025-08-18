# Quiz Application (Monolithic - Spring Boot)

This is a **Quiz Application** built using **Spring Boot (Monolithic architecture)**.  
It allows managing questions and quizzes with features like quiz creation, quiz submission, and retrieving results.  

---

## 🚀 Tech Stack
- Java 21
- Spring Boot
- Spring Data JPA
- REST APIs
- PostgreSQL
- Maven

---

## 📂 Project Structure
- **Controller Layer**
  - `QuestionController`
  - `QuizController`

- **DAO Layer**
  - `QuestionDao`
  - `QuizDao`

- **Model Layer**
  - `Question`
  - `QuestionWrapper`
  - `Quiz`
  - `Response`

- **Service Layer**
  - `QuestionService`
  - `QuizService`

---

## 🎯 Features
- Manage Questions
  - Get all questions
  - Get questions by category
  - Add new question
  - Update question
  - Delete question

- Manage Quiz
  - Create a new quiz
  - Get quiz by ID
  - Submit quiz and calculate score

---

## 🔗 API Endpoints

### Question APIs
- `GET /question/allQuestions` → Get all questions
- `GET /question/category/{category}` → Get questions by category
- `POST /question/add` → Add a new question
- `PUT /question/update{id}` → Update a question
- `DELETE /question/delete/{id}` → Delete a question

### Quiz APIs
- `POST /quiz/create` → Create a quiz
- `GET /quiz/get/{id}` → Get quiz by ID
- `POST /quiz/submit/{id}` → Submit quiz and get score

