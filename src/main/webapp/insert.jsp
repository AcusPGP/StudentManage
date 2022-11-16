<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Insert</title>
</head>
<body>
    <h2>Insert a new student to database</h2>
    <form>
        <p style="font-style: oblique">Enter the student information</p>
        ID <input id="id" type="text">
        <br>
        <br>
        NAME <input id="name" type="text">
        <br>
        <br>
        CLASS ID <input id="class_id" type="text">
        <br>
        <br>
        GENDER <input id="gender" type="text">
        <br>
        <br>
        BIRTH <input id="birth" type="text">
        <br>
        <br>
        ADDRESS <input id="address" type="text">
        <br>
    </form>
    <br><button id="insert_button">Insert</button>
    <jsp:include page="student-insert"></jsp:include>
</body>
</html>
