<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Insert</title>
</head>
<body>
    <h2>Insert a new student to database</h2>
    <form action="student-insert">
        <p style="font-style: oblique">Enter the student information</p>
        ID <input name="id" type="text">
        <br>
        <br>
        NAME <input name="name" type="text">
        <br>
        <br>
        CLASS ID <input name="class_id" type="text">
        <br>
        <br>
        GENDER <input name="gender" type="text">
        <br>
        <br>
        BIRTH <input name="birth" type="text">
        <br>
        <br>
        ADDRESS <input name="address" type="text">
        <br>
        <br>
        <input type="submit" name="event" value="confirm">
    </form>
    <br><button type="submit" id="insert_button">Insert</button>
    <jsp:include page="student-insert"></jsp:include>
</body>
</html>
