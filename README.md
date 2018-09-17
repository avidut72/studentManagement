# studentManagement
project in java




Step1: Backend Project Setup
Create spring-boot-intializer project with dependencies: a. spring-security b. spring-boot-devtools c. thymeleaf d. spring-data-jpa e. mysql-connector
Create Entity called 'Department' with attributes departmentId and name.
Create DepartmentRepository interface and extend JPARepository interface.
Create DepartmentController and write different methods for CRUD operations.
Configure database in application.yml or in application.properties file.
Run and see result using postman
Step2: FrontEnd Setup.
You are done in back-end, now lets do following steps for front-end.

Create different html files like home.html, about.html, department.html, login.html etc file in templates folder under src/main/resources, and modify it as per your need.

Create Default Controller and write following code:
public class DefaultController {
@GetMapping("/")
public String home1(){
return "home";

}
this will open your home.html page.

Now, lets create template for our project. for this we are going to create header for navigation bar. 
So create header.html file under templates/fragments.

Write following code <!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Bootstrap 4 Example</title>
<meta charset="utf-8" />
<div th:fragment="header-css">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous" />

</div>
</head>
<body>
<div th:fragment="header">
<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
<!-- Brand/logo --> <a class="navbar-brand" href="#">Logo</a>

     <!-- Links -->
     <ul class="navbar-nav">
         <li class="nav-item">
             <a class="nav-link" href="/home">Home</a>
         </li>

         <li class="nav-item">
             <a class="nav-link" href="/admin">Admin</a>
         </li>
         <li class="nav-item">
             <a class="nav-link" href="/user">User</a>
         </li>
         <li class="nav-item">
             <a class="nav-link" href="/department">Department</a>
         </li>

     </ul>

        </nav>

Now in home.html write following code:
<div th:replace="fragments/header :: header-css" /> inside header section 
<div th:replace="fragments/header :: header" /> inside body section 
and don't forget to include xmlns for thymeleaf in html tag.
Similarly write same code for every page.
