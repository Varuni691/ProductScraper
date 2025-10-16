# ProductScraper

A Java-based web scraper that extracts product details from e-commerce sites using the Jsoup library.  
It saves data like product names, prices, and links into a CSV file.

---

## 🛠 Features
- Scrapes product data automatically
- Saves output to `products.csv`
- Uses `Jsoup` library for HTML parsing
- Simple command-line interface

---

## 💻 Files
- `ProductScraper.java` — main Java code  
- `jsoup-1.21.2.jar` — Jsoup library dependency  
- `products.csv` — sample extracted product data

---

## ⚡ Usage
1. Make sure `jsoup-1.21.2.jar` is in the same folder as `ProductScraper.java`.  
2. Compile the Java program:
   ```bash
   javac -cp jsoup-1.21.2.jar ProductScraper.java



## RUN
java -cp .;jsoup-1.21.2.jar ProductScraper

## Directory Structure
ProductScraper/
├── ProductScraper.java
├── jsoup-1.21.2.jar
├── products.csv
└── README.md

