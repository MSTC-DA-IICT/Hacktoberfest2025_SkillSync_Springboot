# 🧠 SkillSync — Peer-to-Peer Learning & Mentorship Platform


<img src="https://res.cloudinary.com/dbvyvfe61/image/upload/v1619799241/Cicada%203301:%20Reinvented/MSTC_ffmo9v.png" width="10%">


A Spring Boot–based open-source project for **Hacktoberfest 2025** focused on real-world backend development and contribution.  
SkillSync is a **peer-to-peer learning network** where learners and mentors connect based on shared skills and interests.  

This project is created to **encourage open-source collaboration** among students and developers who want to gain practical Spring Boot experience.  
Every contribution matters — from fixing bugs to building new APIs or improving documentation. 🚀

---

### How to Contribute
* Check `contributing.md` for details on how to work with github.
* Go to the `Issues` find an issue for you. 
* If you completely understand the issue then leave a comment to owner to assing that issue.
* Once you are assigned the issue, start working on it and finally make your `PR`.
* If you find a bug or want to add a new feature then you can specify it by adding a new issue. We will look into it and assign it.
* If you have added some new dependancy then make sure that that dependancy is stable and do not forget to mention in to the PR and also update the README file.

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
| **Backend** | Spring Boot  |
| **ORM / DB** | Spring Data JPA + MySQL |
| **Build Tool** | Maven |
| **Language** | Java 21+ |
| **Version Control** | Git + GitHub |
| **Open Source Event** | Hacktoberfest 2025 |

---

## 🧾 Project Setup

```bash
git clone https://github.com/MSTC-DA-IICT/Hacktoberfest2k25_springboot_SkillSync.git

Before running the project, you must create a file named application.properties inside src/main/resources/.

You can use the application.properties.example file as a reference for how to set up your configuration.

Important: The filename must be exactly application.properties.

Example configuration:

---
# DATABASE CONFIGURATION
# ----------------------------------------
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=yourpassword

# ----------------------------------------
# JPA / HIBERNATE SETTINGS
# ----------------------------------------
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

