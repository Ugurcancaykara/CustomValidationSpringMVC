<%--
  Created by IntelliJ IDEA.
  User: ugurc
  Date: 24.01.2021
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
  <head>
    <title>Student Registration Form</title>
  </head>
  <body>

  <form:form action="processForm" modelAttribute="student">

      First name: <form:input path="firstName"/>
      <br><br>
      Last  name: <form:input path="lastName"/>
      <br><br>


      <form:select path="country">
          <form:options items="${theCountryOptions}" />
      </form:select>
      <br><br>
      Favorite Language
      <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguages}" />
      <br><br>
      Operating Systems:

      Linux <form:checkbox path="operatingSystems" value="Linux"/>
      MS Windows <form:checkbox path="operatingSystems" value="Windows"/>
      Mac OS <form:checkbox path="operatingSystems" value="MacOS"/>

      <br><br>
      <input type="submit" value="Submit">
  </form:form>

  </body>
</html>
