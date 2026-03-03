# Artemis Financial — Secure Software Refactor

A security refactoring project for a fictional financial services client (Artemis Financial), focused on implementing industry-standard encryption, secure communication, and vulnerability mitigation in a Java Spring Boot application.

## 🛠️ Tech Stack

- **Java / Spring Boot** — core application framework
- **AES** — symmetric encryption for financial data protection
- **SHA-256** — cryptographic hashing for data integrity verification
- **Java Keytool** — SSL certificate generation
- **HTTPS** — secure client-server communication
- **OWASP Dependency-Check** — static analysis for third-party vulnerability scanning

## 🔒 What Was Implemented

### 1. Algorithm Cipher
- Implemented **AES encryption** to protect sensitive financial data in transit
- Applied **SHA-256 checksum verification** to ensure data integrity
- Used secure random number generation for cryptographic key creation

### 2. Certificate Generation
- Generated a **self-signed SSL certificate** using Java Keytool
- Configured the Spring Boot application to serve over **HTTPS**

### 3. Vulnerability Assessment
- Ran **OWASP Dependency-Check** to identify vulnerabilities in third-party libraries
- Refactored code to eliminate flagged dependencies and ensure no new vulnerabilities were introduced
- Conducted functional testing to verify application stability post-refactor

## 🏗️ Security Practices Applied

| Practice | Implementation |
|----------|---------------|
| Encryption | AES (symmetric) for data protection |
| Data Integrity | SHA-256 hashing for checksum verification |
| Secure Transport | HTTPS via self-signed SSL certificate |
| Static Analysis | OWASP Dependency-Check for vulnerability scanning |
| Functional Testing | Post-refactor testing to confirm no regressions |

## 📋 Key Takeaways

- Secure coding is not an afterthought — integrating encryption and HTTPS from the start reduces attack surface significantly
- OWASP Dependency-Check is an effective tool for identifying supply chain vulnerabilities in Java projects
- AES + SHA-256 together provide both **confidentiality** (encryption) and **integrity** (hashing) for sensitive data

## 📁 Project Structure

```
├── src/
│   └── main/java/         # Spring Boot application source
├── CS305_Project_Two.docx # Secure software practices report
└── README.md
```

> **Note:** This project was completed as part of CS-305 (Software Security) at Southern New Hampshire University.
