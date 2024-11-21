# 🌟 **Category and Product Management API** 🌟

This API provides CRUD operations for managing **Categories** and **Products**. Below are the details of the endpoints:

---

## 🗂️ **Category CRUD Operations**

### 1. 📄 **GET all categories**  
**Endpoint:** `GET /api/categories?page={pageNumber}`  
**Description:** Retrieves a paginated list of all categories.  
**Request Parameters:**  
- `page` (Query Parameter): The page number (0-based indexing). Default is 0 if not specified.

**📝 Example Request:**  
```
GET http://localhost:8080/api/categories?page=1
```

**📦 Example Response:**  
```json
{
    "content": [
        {
            "id": 1,
            "name": "Electronics"
        },
        {
            "id": 2,
            "name": "Accessories"
        }
    ],
    "pageable": {
        "pageNumber": 1,
        "pageSize": 10
    },
    "totalElements": 20,
    "totalPages": 2
}
```

---

### 2. ➕ **POST - Create a new category**  
**Endpoint:** `POST /api/categories`  
**Description:** Creates a new category.  
**📤 Request Body:**  
```json
{
    "name": "New Category"
}
```

**📦 Example Response:**  
```json
{
    "id": 3,
    "name": "New Category"
}
```

---

### 3. 🔍 **GET category by ID**  
**Endpoint:** `GET /api/categories/{id}`  
**Description:** Retrieves a specific category by its ID.  

**📝 Example Request:**  
```
GET http://localhost:8080/api/categories/1
```

**📦 Example Response:**  
```json
{
    "id": 1,
    "name": "Electronics"
}
```

---

### 4. 🛠️ **PUT - Update category by ID**  
**Endpoint:** `PUT /api/categories/{id}`  
**Description:** Updates a specific category by its ID.  
**📤 Request Body:**  
```json
{
    "name": "Updated Category"
}
```

**📦 Example Response:**  
```json
{
    "id": 1,
    "name": "Updated Category"
}
```

---

### 5. ❌ **DELETE - Delete category by ID**  
**Endpoint:** `DELETE /api/categories/{id}`  
**Description:** Deletes a specific category by its ID.  

**📝 Example Request:**  
```
DELETE http://localhost:8080/api/categories/1
```

**📦 Example Response:**  
```
Status: 204 No Content
```

---

## 🛒 **Product CRUD Operations**

### 1. 📄 **GET all products**  
**Endpoint:** `GET /api/products?page={pageNumber}`  
**Description:** Retrieves a paginated list of all products.  
**Request Parameters:**  
- `page` (Query Parameter): The page number (0-based indexing). Default is 0 if not specified.

**📝 Example Request:**  
```
GET http://localhost:8080/api/products?page=2
```

**📦 Example Response:**  
```json
{
    "content": [
        {
            "id": 1,
            "name": "Laptop",
            "price": 75000.0,
            "category": {
                "id": 1,
                "name": "Electronics"
            }
        },
        {
            "id": 2,
            "name": "Charger",
            "price": 150.0,
            "category": {
                "id": 1,
                "name": "Electronics"
            }
        }
    ],
    "pageable": {
        "pageNumber": 2,
        "pageSize": 10
    },
    "totalElements": 50,
    "totalPages": 5
}
```

---

### 2. ➕ **POST - Create a new product**  
**Endpoint:** `POST /api/products`  
**Description:** Creates a new product and associates it with a category.  
**📤 Request Body:**  
```json
{
    "name": "New Product",
    "price": 500.0,
    "category": {
        "id": 1
    }
}
```

**📦 Example Response:**  
```json
{
    "id": 3,
    "name": "New Product",
    "price": 500.0,
    "category": {
        "id": 1,
        "name": "Electronics"
    }
}
```

---

### 3. 🔍 **GET product by ID**  
**Endpoint:** `GET /api/products/{id}`  
**Description:** Retrieves a specific product by its ID.  

**📝 Example Request:**  
```
GET http://localhost:8080/api/products/1
```

**📦 Example Response:**  
```json
{
    "id": 1,
    "name": "Laptop",
    "price": 75000.0,
    "category": {
        "id": 1,
        "name": "Electronics"
    }
}
```

---

### 4. 🛠️ **PUT - Update product by ID**  
**Endpoint:** `PUT /api/products/{id}`  
**Description:** Updates a specific product by its ID and can also update the associated category.  
**📤 Request Body:**  
```json
{
    "name": "Updated Product",
    "price": 800.0,
    "category": {
        "id": 2
    }
}
```

**📦 Example Response:**  
```json
{
    "id": 1,
    "name": "Updated Product",
    "price": 800.0,
    "category": {
        "id": 2,
        "name": "Accessories"
    }
}
```

---

### 5. ❌ **DELETE - Delete product by ID**  
**Endpoint:** `DELETE /api/products/{id}`  
**Description:** Deletes a specific product by its ID.  

**📝 Example Request:**  
```
DELETE http://localhost:8080/api/products/1
```

**📦 Example Response:**  
```
Status: 204 No Content
```

---

### 🛠️ **Additional Notes:**
- 🛑 **Error Handling:**  
  - If an ID does not exist, the API will throw a `ResourceNotFoundException` with an appropriate error message.
- 📖 **Pagination:**  
  - Use `page` and `size` query parameters for pagination. Default `size` is 10 if not specified.
