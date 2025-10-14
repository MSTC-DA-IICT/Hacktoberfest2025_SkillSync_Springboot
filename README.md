# 🧠 SkillSync — Peer-to-Peer Learning & Mentorship Platform


<img src="https://res.cloudinary.com/dbvyvfe61/image/upload/v1619799241/Cicada%203301:%20Reinvented/MSTC_ffmo9v.png" width="10%">


A Spring Boot–based open-source project for **Hacktoberfest 2025** focused on real-world backend development and contribution.  
SkillSync is a **peer-to-peer learning network** where learners and mentors connect based on shared skills and interests.  

This project is created to **encourage open-source collaboration** among students and developers who want to gain practical Spring Boot experience.  
Every contribution matters — from fixing bugs to building new APIs or improving documentation. 🚀

---

## 🧩 Project Overview

**SkillSync** is designed to create a space where:
- Learners can find mentors in specific topics (e.g., Java, Spring Boot, Cloud, etc.).
- Mentors can share knowledge or guide learners in their area of expertise.
- Both can chat, collaborate, and grow together.

This project focuses on **real-world backend architecture**, including:
- Entity relationships (User ↔ Skills)
- RESTful APIs
- Service-layer logic
- Data persistence using MySQL and JPA
- Scalable design for future modules (matching algorithm, chat, mentorship scheduling, etc.)

---

## 🏗️ Tech Stack

| Layer | Technology |
|-------|-------------|
| **Backend** | Spring Boot (3.x) |
| **ORM / DB** | Spring Data JPA + MySQL |
| **Build Tool** | Maven |
| **Language** | Java 17+ |
| **Version Control** | Git + GitHub |
| **Open Source Event** | Hacktoberfest 2025 |

---

## ⚙️ Prerequisites

To run and contribute to this project, ensure you have:

- **Java 17 or higher**  
- **Maven 3.9+**  
- **MySQL 8.0+**  
- **An IDE** (IntelliJ IDEA / Eclipse / VS Code recommended)
- **Git** for version control

---

## 🧾 Project Setup

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/<your-username>/SkillSync.git
cd SkillSync


---
# DATABASE CONFIGURATION
# ----------------------------------------
spring.datasource.url=jdbc:mysql://localhost:3306/skillsync_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=yourpassword

# ----------------------------------------
# JPA / HIBERNATE SETTINGS
# ----------------------------------------
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

