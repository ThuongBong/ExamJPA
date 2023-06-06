<%@ page import="java.util.List" %>
<%@ page import="com.example.examjpa.entity.EmployeeEntity" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>List Employee</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</head>
<body>

<p style="color: green">${message}</p>

  <a href="employee.jsp" class="btn btn-primary">Create Employee</a>


<table class="table" style="width: 80%; margin: 0 auto">
  <thead>
  <tr>
    <th scope="col">STT</th>
    <th scope="col">Name</th>
    <th scope="col">Birthday</th>
    <th scope="col">Address</th>
    <th scope="col">Position</th>
    <th scope="col">Department</th>
  </tr>
  </thead>
  <tbody>
      <c:forEach items="${listEmployee}" var="employee" varStatus="loop">
        <tr>
          <th scope="row">${loop.index + 1}</th>
          <td>${employee.fullName}</td>
          <td>${employee.birthday}</td>
          <td>${employee.address}</td>
          <td>${employee.position}</td>
          <td>${employee.department}</td>
        </tr>
      </c:forEach>

  </tbody>
</table>
</body>
</html>