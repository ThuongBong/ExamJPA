<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<h1 style="text-align: center">Create Employee</h1>
<form method="post" action="/employeeServlet">
    <div class="col-12">
        <input type="hidden" id="empId" name="empId" class="form-control">
    </div>
    <div class="col-12">
        <label for="fullName" class="form-label">Full Name:</label>
        <input class="form-control" type="text" id="fullName" name="fullName" required>
    </div>
    <div class="col-12">
        <label for="birthday" class="form-label">Birthday:</label>
        <input type="date" id="birthday" name="birthday" class="form-control" required>
    </div>
    <div class="col-12">
        <label for="address" class="form-label">Address:</label>
        <input type="text" id="address" name="address" class="form-control" required>
    </div>
    <div class="col-12">
        <label for="position" class="form-label">Position:</label>
        <input type="text" id="position" name="position" class="form-control" required>
    </div>
    <div class="col-12">
        <label for="department" class="form-label">Department:</label>
        <input type="text" id="department" name="department" class="form-control" required>
    </div>
    <div class="col-12">
        <button type="submit" class="btn btn-primary" style="float: left">Submit</button>
        <button type="reset" class="btn btn-danger" style="float: right">Reset</button>
    </div>
</form>

</body>
</html>