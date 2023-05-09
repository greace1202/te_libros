<%@taglib prefix  = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.libro"%>
<%
    libro lib = (libro) request.getAttribute("lib");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo Libro</h1>
        <form action="MainController" method="post">
            
            <table>
                <input type="hidden" name="id" value="${lib.id}">
                <tr>
                    <td>ISBN</td>
                    <td><input type="text" name="id" value="${lib.isbn}"></td>
                </tr>
                <tr>
                    <td>Titulo</td>
                    <td><input type="text" name="id" value="${lib.titulo}"></td>
                </tr>
                <tr>
                    <td>Categoria</td>
                    <td><input type="text" name="id" value="${lib.categoria}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value = "Enviar" ></td>
                </tr>

            </table>          
        </form>
    </body>
</html>
