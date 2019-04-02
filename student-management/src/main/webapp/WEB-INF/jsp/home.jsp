<%-- 
    Document   : home
    Created on : 30-Mar-2019, 5:35:57 PM
    Author     : Jayshree
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
            ul li 
            {
                display: table-cell;
            }
            body {
                background: white }
            p {
                background: bisque;
                color: black;
                border-radius: 1em;
                padding: 1em;
                font-size: large;
                font-weight: bold;
                width: 20%;
                margin-top: 15%;
                margin-left : 35%;
                text-align: center;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>
            <a href="<c:url value="/studentInfo" />">Click here to add Student Info</a><br/><br/>
            <a href="<c:url value="/courseInfo" />">Click here to add Course Info</a>
        </p>
        
    </body>
</html>
