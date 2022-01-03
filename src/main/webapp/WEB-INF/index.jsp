<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
                crossorigin="anonymous">
<meta charset="UTF-8">
<title>Survey</title>
</head>
<body>
<jsp:include page="base.jsp"></jsp:include>

<div class="container">
    
    <div class="row">
        <div class="col bg-light m-2 border">
            
            <form action="/result" method="POST" class="m-1">
                
                <div class="form-group m-1">
                    <label for="name">Name:</label>
                    <input type="text" name="name" class="form-control">
                </div>
                <div class="form-group m-1">
                    <label for="location">Dojo Location</label>
                    <select name="location" class="form-control">
                        <c:forEach items="${locations}" var="location">
                        <option value="${location}">${location}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group m-1">
                    <label for="language">Language</label>
                    <select name="language" class="form-control">
                        
                        <c:forEach items="${languages}" var="language">
                        <option value="${language}">${language}</option>
                        </c:forEach>
                        
                    </select>
                </div>
                <div class="form-group m-1">
                    <label for="comment">
                    <textarea  name="comment" rows="4" cols="50">
                    </textarea>
                </div>
                <input type="submit" name="" id="" value="Submit" class="btn btn-success m-2">
            </form>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous"></script>

</body>
</html>