<%@ page import="com.example.examjpa.entity.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.examjpa.dao.EmployeeDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>List User</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<h1>Danh sách người dùng:</h1>
<br>
<h3><a href="/createOrUpdate">create</a></h3>

<table class="table">
  <thead>
  <tr>
    <th scope="col">STT</th>
    <th scope="col">Full Name</th>
    <th scope="col">Birthday</th>
    <th scope="col">Address</th>
    <th scope="col">Position</th>
    <th scope="col">Department</th>
  </tr>
  </thead>
  <tbody>
  <%--<c:choose>
      <c:when test="${listUser.size() > 0}">

      </c:when>
      <c:otherwise>
          <td colspan="md-4">chưa có user nào trong hệ thống</td>
      </c:otherwise>
  </c:choose>--%>


  <c:forEach items="${listUser}" var="employee" varStatus="loop">
    <tr>
      <th scope="row">${loop.index + 1}</th>
      <td>${employee.fullName}</td>
      <td><c:out value="${employee.birthday}"/></td>
      <td>${employee.address}</td>
      <td>${employee.position}</td>
      <td>${employee.department}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>