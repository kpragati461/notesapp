# 📝 NotesApp

A full-stack note-taking web application built with **Spring Boot**, **Spring Security**, **MySQL**, and **Thymeleaf**.

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=flat-square&logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=flat-square&logo=mysql)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.x-green?style=flat-square)
![License](https://img.shields.io/badge/license-MIT-purple?style=flat-square)

---

## ✨ Features

- 🔐 User registration and login with **BCrypt** password encryption
- 🛡️ Secured routes with **Spring Security**
- 📒 Full **CRUD** — create, read, update, delete notes
- 👤 **User-specific notes** — users only see their own notes
- 🔍 **Search** notes by title
- 🕐 Notes sorted by **newest first**
- ✅ **Validation** on all forms with error messages
- ⚠️ **Global exception handling** with friendly error pages
- 🎨 Colorful, responsive **Thymeleaf** frontend with masonry layout

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 3.x |
| Security | Spring Security + BCrypt |
| Database | MySQL 8.0 |
| ORM | Spring Data JPA + Hibernate |
| Frontend | Thymeleaf + CSS |
| Build Tool | Maven |
| Version Control | Git + GitHub |

---

## 📁 Project Structure

```
src/
└── main/
    ├── java/com/don/notesapp/
    │   ├── config/
    │   │   └── SecurityConfig.java
    │   ├── controller/
    │   │   ├── AuthController.java
    │   │   ├── NoteController.java
    │   │   └── NoteViewController.java
    │   ├── entity/
    │   │   ├── User.java
    │   │   └── Note.java
    │   ├── exception/
    │   │   ├── NoteNotFoundException.java
    │   │   └── GlobalExceptionHandler.java
    │   ├── repository/
    │   │   ├── UserRepository.java
    │   │   └── NoteRepository.java
    │   └── service/
    │       ├── UserService.java
    │       └── NoteService.java
    └── resources/
        ├── templates/
        │   ├── login.html
        │   ├── register.html
        │   ├── notes.html
        │   ├── create-note.html
        │   ├── edit-note.html
        │   └── error.html
        └── application.properties
```

---

## 🚀 Getting Started

### Prerequisites
- Java 21+
- MySQL 8.0+
- Maven

### Setup

**1. Clone the repository**
```bash
git clone https://github.com/kpragati461/notesapp.git
cd notesapp
```

**2. Create the database**
```sql
CREATE DATABASE notesapp;
```

**3. Configure `application.properties`**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/notesapp
spring.datasource.username=root
spring.datasource.password=Eipw1376?
spring.jpa.hibernate.ddl-auto=update
```

**4. Run the application**
```bash
./mvnw spring-boot:run
```

**5. Open in browser**
```
http://localhost:8080/register
```

---

## 📸 Screenshots

### Login Page
![Login](screenshots/login.png)

### My Notes Dashboard
![Dashboard](screenshots/dashboard.png)

### Create Note
![Create](screenshots/create.png)

---

## 🔒 Security

- Passwords hashed with **BCrypt**
- CSRF protection enabled on all forms
- Routes protected — unauthenticated users redirected to login
- User data fully isolated — users cannot access other users' notes

---

## 📌 API Endpoints (REST)

| Method | Endpoint | Description |
|---|---|---|
| POST | `/notes` | Create a note |
| GET | `/notes` | Get all notes |
| GET | `/notes/{id}` | Get note by ID |
| PUT | `/notes/{id}` | Update a note |
| DELETE | `/notes/{id}` | Delete a note |

---

## 🗺️ UI Routes

| Route | Description |
|---|---|
| `/register` | Registration page |
| `/login` | Login page |
| `/my-notes` | Notes dashboard |
| `/my-notes/create` | Create note form |
| `/my-notes/edit/{id}` | Edit note form |

---

## 👩‍💻 Author

**Pragati Katiyar**
- GitHub: [@kpragati461](https://github.com/kpragati461)
- LinkedIn: [Pragati Katiyar](https://www.linkedin.com/in/pragatikatiyar)

---

## 📄 License

This project is licensed under the MIT License.
