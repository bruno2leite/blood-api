# 🧪🩸 Blood Exam API - Java Spring Boot

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)


This REST API allows users to upload blood test reports in PDF format. It extracts key data from the file, identifies (or creates) the patient by CPF, and saves the exam in memory.

---

## 🚀 Technologies Used

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (in-memory)
- Apache PDFBox (PDF parser)
- Maven

---

## 📦 Features

- ✅ Upload PDF containing exam data
- ✅ Extracts information such as: name, CPF, date, hemoglobin, leukocytes, and platelets
- ✅ Checks if the patient exists by CPF
- ✅ Creates the patient automatically if not registered
- ✅ Saves the exam linked to the patient
- ✅ H2 Console enabled for query testing

---

## ⚙️ How to Run

```bash
git clone https://github.com/bruno2leite/blood-api.git
cd blood-api
mvn spring-boot:run
```

API available at:  
📍 `http://localhost:8080`

---

## 📄 Expected PDF format

The PDF must contain the data in the following format:

```
Name: Your Name
CPF: 12345678900
Date: 2025-05-19
Hemoglobin: 13.4
Leukocytes: 7000
Platelets: 250000
```

---

## 📮 API Endpoints

### 🔹 POST `/exams/upload`

Uploads a PDF with exam data.

**Request:**
- Content-Type: `multipart/form-data`
- Form key: `file` (select a `.pdf` file)

**Response:**

```json
"Exam saved successfully. Exam ID: 1"
```

---

## 🧪 How to Test with Postman

1. Method: `POST`  
2. URL: `http://localhost:8080/exams/upload`  
3. Body → form-data:
   - Key: `file`
   - Type: `File`
   - Upload a sample PDF with valid structure

---

## 🗃️ H2 In-Memory Database

**Access the H2 Console:**

- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:examdb`
- Username: `sa`
- Password: *(leave empty)*

---


## 🧠 What you’ll learn from this project

- File upload with Spring Boot
- Reading structured data from PDFs using PDFBox
- Using DTOs and separating data responsibilities
- Mapping entity relationships (One-to-Many, Many-to-One)
- Basic in-memory persistence with H2

---

## 👨‍💻 Author

Developed by **Bruno Leite**  
🔗 [www.linkedin.com/in/brunoprestesleite]
---
