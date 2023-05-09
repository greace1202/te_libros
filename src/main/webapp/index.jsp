<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import = "java.util.List" %>
<%@page import="com.emergentes.modelo.libro"%>
<%
    List<libro> lista = (List<libro>) request.getAttribute("lista");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>listado de libros</h1>
        <p><a href="MainController?op=nuevo">Nuevo</a></p>
        <table>
            <tr>
                <th>ID</th><!-- comment -->
                <th>ISBN</th>
                <th>TITULO</th>
                <th>CATEGORIA</th>
                <th> </th>
            </tr>
            <c:forEach var= "item" items="${lista}">
            <tr>
                <th>${item.id}</th><!-- comment -->
                <th>${item.isbn}</th>
                <th>${item.titulo}</th>
                <th>${item.categoria}</th>
                <th><a href="MainController?op=eliminar&id=${item.id}"
                       onclick="return(confirm('Esta seguro ???'))">Eliminar</a> </th>
            </tr>    
            <c:forEach>            
        </table>
    </body>
</html>
