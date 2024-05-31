<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31/05/2024
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.example.h691_lab6_20210795.beans.Peliculas" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 30/05/2024
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.example.h691_lab6_20210795.beans.Actor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listaActores" scope="request" type="ArrayList<org.example.h691_lab6_20210795.beans.Actor>" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Actores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <style>
        body {
            margin: 20px auto; /* Añade espacio alrededor de la página y centra horizontalmente */
            max-width: 80%; /* Ancho máximo para el contenido */
        }
        .tabla-container {
            margin: 0 auto; /* Centra el contenedor horizontalmente */
            max-width: 70%; /* Ancho máximo para el contenedor */
        }
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px 0; /* Espacio arriba y abajo de 20px */
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
            width: auto;
        }
    </style>
</head>
<body>
<div class="tabla-container">
    <h1 style="text-align: center;"><%= listaActores != null ? listaActores.get(0).getTitulo_pelicula() : "No hay información disponible" %></h1>
    <div style="display: flex; justify-content: center; align-items: center;">
        <table>
            <tr>
                <th>idActor</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Ano Nacimiento</th>
                <th>Ganador Premio Oscar</th>
            </tr>
            <% for (Actor actor : listaActores) { %>
            <tr>
                <td><%=actor.getIdActor() %></td>
                <td><%=actor.getNombre() %></td>
                <td><%=actor.getApellido() %></td>
                <td><%=actor.getAnoNacimiento() %></td>
                <td><%=actor.isganoOscar() %></td>
            </tr>
            <% } %>
        </table>
    </div>
</div>
</body>
</html>
