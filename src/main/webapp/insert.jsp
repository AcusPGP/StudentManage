<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insert the students</title>
    <link rel="stylesheet" type="text/css" href="css/function.css">
</head>
<body>
<div>
    <a href="index.jsp" class="link_style">Back</a><br>
    <p style="background-color: transparent; height: 25px"></p>
</div>
<div class="header" align="center">
    <h3>Insert a student to database</h3>
</div>
<div align="center">
    <form action="student-insert" style="font-family: Arial, serif ; font-size: 18px">
        ID <input name="id" type="text" placeholder="Input the ID"/>
        <p style="background-color: transparent; height: 15px"></p>
        NAME <input name="name" type="text" placeholder="Input the NAME"/>
        <p style="background-color: transparent; height: 15px"></p>
        CLASS ID <input name="class_id" type="text" placeholder="Input the CLASS ID"/>
        <p style="background-color: transparent; height: 15px"></p>
        GENDER <input name="gender" type="text" placeholder="Input the GENDER"/>
        <p style="background-color: transparent; height: 15px"></p>
        BIRTH <input name="birth" type="text" placeholder="Input the BIRTH"/>
        <p style="background-color: transparent; height: 15px"></p>
        ADDRESS <input name="address" type="text" placeholder="Input the ADDRESS"/>
        <p style="background-color: transparent; height: 15px"></p>
        <input type="submit" name="insert" value="Insert">
    </form>
</div>
<jsp:include page="student-insert"/>
</body>
</html>
