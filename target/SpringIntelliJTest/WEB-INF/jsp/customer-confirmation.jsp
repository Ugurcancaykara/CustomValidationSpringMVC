<%--
  Created by IntelliJ IDEA.
  User: ugurc
  Date: 25.01.2021
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Customer Confirmation</title>
</head>
<body>

The customer is confirmed : ${customer.firstName} ${customer.lastName} <br>
Free passes: ${customer.freePasses}<br>
Postal Code: ${customer.postalCode}<br>
Course Code: ${customer.courseCode}<br>

</body>
</html>
