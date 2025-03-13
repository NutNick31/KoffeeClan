# KoffeeClan ☕  

KoffeeClan is a web application designed to [describe your project's purpose briefly].  

---

## 🚀 Features  
- Perform CRUD operations on the blog posts 
- This application is dockerized, and is hosted on an EC2 instance
- Summarizes any blog using openai gpt-4.0 model

---

## 📌 Prerequisites  

Ensure you have the following installed:  
- **Git**: [Download & Install](https://git-scm.com/downloads)  
- **Java (JDK 17 or later)**: [Download Here](https://adoptopenjdk.net/)  
- **Maven**: [Download Here](https://maven.apache.org/download.cgi)  
- **Docker (Optional, if using containers)**: [Get Docker](https://www.docker.com/)  

---

## 🛠️ Installation & Setup  

### 🔹 1️ Clone the Repository  
```bash
git clone https://github.com/NutNick31/KoffeeClan.git
cd KoffeeClan
```

### 🔹 2 Setup Environment Variable
```
OPENAI_API_KEY=your-api-key-here
DATABASE_URL=your-database-url
```

### 🔹 3 Build and Run the Project
#### Option - 1
```
mvn clean install
mvn spring-boot:run
```

#### Option - 2
```
docker-compose up --build
```

### EC2 Public IP Address to access the API endpoints : 16.170.158.7

## 📌 API Endpoints

| Method   | Endpoint           | Description                 | Request Body (if applicable) |
|----------|-------------------|-----------------------------|------------------------------|
| `GET`    | `/api/blogs`      | Fetch all blogs            | N/A                          |
| `POST`   | `/api/blogs`      | Create a new blog          | `{ "title": "...", "content": "..." }` |
| `GET`    | `/api/blogs/{id}` | Get a specific blog        | N/A                          |
| `PUT`    | `/api/blogs/{id}` | Update a blog              | `{ "title": "...", "content": "..." }` |
| `DELETE` | `/api/blogs/{id}` | Delete a blog              | N/A                          |
| `GET`    | `/ai/summarize/{id}`|Get Summary of the specified blog| `{summary}`             |


