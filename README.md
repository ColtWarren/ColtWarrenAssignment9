Recipe Filtering Application
A Spring Boot web application that loads recipe data from a CSV file and provides RESTful API endpoints to filter recipes based on dietary preferences.

Features
RESTful API: Provides multiple endpoints to access filtered recipe data

CSV Data Loading: Automatically loads recipe data from recipes.txt file

Dietary Filtering: Filter recipes by various dietary preferences:

Gluten-free

Vegan

Vegan and gluten-free

Vegetarian

All recipes

API Endpoints
Endpoint	Method	Description
/api/recipes/all-recipes	GET	Returns all recipes
/api/recipes/gluten-free	GET	Returns gluten-free recipes
/api/recipes/vegan	GET	Returns vegan recipes
/api/recipes/vegan-and-gluten-free	GET	Returns recipes that are both vegan and gluten-free
/api/recipes/vegetarian	GET	Returns vegetarian recipes
Technology Stack
Java 17+

Spring Boot 3.x

Apache Commons CSV - For parsing CSV files

Maven - Dependency management

Project Structure
text
src/main/java/com/coderscampus/assignment9/
├── RecipeFilteringApplication.java    # Main application class
├── controller/
│   └── RecipeController.java          # REST controller with endpoints
├── domain/
│   └── Recipe.java                    # Recipe entity class
├── repository/
│   └── RecipeRepository.java          # Data access layer
└── service/
├── RecipeFileService.java         # CSV file parsing service
└── RecipeService.java             # Business logic service
Setup and Installation
Clone the repository

bash
git clone <your-repository-url>
cd recipe-filtering-application
Build the project

bash
mvn clean install
Run the application

bash
mvn spring-boot:run
Access the API
The application will start on http://localhost:8080

Data Format
The application expects a CSV file named recipes.txt in the project root directory with the following columns:

Cooking Minutes

Dairy Free

Gluten Free

Instructions

Preparation Minutes

Price Per Serving

Ready In Minutes

Servings

Spoonacular Score

Title

Vegan

Vegetarian

Example Usage
bash
# Get all recipes
curl http://localhost:8080/api/recipes/all-recipes

# Get gluten-free recipes
curl http://localhost:8080/api/recipes/gluten-free

# Get vegan recipes
curl http://localhost:8080/api/recipes/vegan
Response Format
The API returns JSON arrays of Recipe objects with the following structure:

json
[
{
"cookingMinutes": 45,
"dairyFree": false,
"glutenFree": true,
"instructions": "Recipe instructions...",
"preparationMinutes": 15.0,
"pricePerServing": 50.25,
"readyInMinutes": 60,
"servings": 4,
"spoonacularScore": 85.5,
"title": "Delicious Recipe",
"vegan": false,
"vegetarian": true
}
]
Error Handling
The application includes basic error handling:

Returns appropriate HTTP status codes

Provides descriptive error messages for file parsing issues

Handles missing or malformed data gracefully

Dependencies
Spring Boot Starter Web

Apache Commons CSV

Spring Boot DevTools (for development)

Spring Boot Starter Test (for testing)

Contributing
Fork the repository

Create a feature branch

Make your changes

Add tests if applicable

Submit a pull request