<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Show the students</title>
    <link rel="stylesheet" type="text/css" href="css/show.css">
</head>
<body>
<div>
    <a href="index.jsp" class="link_style">Back</a><br>
    <p style="background-color: transparent; height: 25px"></p>
</div>
<div class="header" align="center">
    <h3>The student list</h3>
</div>
<jsp:include page="student-show"/>
</body>
</html>