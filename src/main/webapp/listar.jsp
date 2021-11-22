<%-- 
    Document   : listar.jsp
    Created on : 15-nov-2021, 17:36:18
    Author     : DAW2
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Productos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <h1>Listado de productos por Nombre</h1>
        <%
            List<Productos> listaProductos = ( List<Productos> )request.getAttribute("listado");
         %>
         <table class="table">
         <% for ( Productos p: listaProductos ) { %>
         <tr>
             <td><%=p.getNombre() %></td>
             <td><%=p.getPrecio() %></td>
             <td><%=p.getId() %> </td>
             <td><a href="Servlet?op=borrar&id=<%=p.getId() %>">Borrar</a>
         </tr>
         <%}%>
         </table>

    </body>
</html>
