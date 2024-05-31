<%@ page import="org.example.h691_lab6_20210795.beans.Peliculas" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 30/05/2024
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listarPeliculas" scope="request" type="ArrayList<org.example.h691_lab6_20210795.beans.Peliculas>" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Películas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <style>
        body {
            margin: 20px; /* Añade espacio alrededor de la página */
        }
        .tabla-container {
            margin: 0 auto; /* Centra el contenedor horizontalmente */
            max-width: 80%; /* Ancho máximo para el contenedor */
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 10px 0; /* Espacio arriba y abajo de 10px */
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<div class="tabla-container">
    <h1>Lista de Películas</h1>
    <form action="ListaPeliculaServlet" method="get" class="mb-3">
        <input type="text" name="search" placeholder="Buscar película..." value="<%= request.getAttribute("searchQuery") != null ? request.getAttribute("searchQuery") : "" %>" class="form-control" style="display: inline-block; width: auto;">
        <button type="submit" class="btn btn-primary">Buscar</button>
    </form>
    <table>
        <tr>
            <th>Titulo</th>
            <th>Director</th>
            <th>Año Publicacion</th>
            <th>Rating</th>
            <th>BoxOffice</th>
            <th>Genero</th>
            <th>Actores</th>
        </tr>
        <% for (Peliculas pelicula : listarPeliculas) { %>
        <tr>
            <td><a href="PeliculasServlet?idPelicula=<%= pelicula.getIdPelicula() %>"><%= pelicula.getTitulo() %></a></td>
            <td><%=pelicula.getDirector() %></td>
            <td><%=pelicula.getAnoPublicacion() %></td>
            <td><%=pelicula.getRating() %>/10</td>
            <td>$<%=pelicula.getBoxOffice() %></td>
            <td><%=pelicula.getGenero() %></td>
            <td><a href="ActorServlet?idPelicula=<%= pelicula.getIdPelicula() %>">Ver Actores</a></td>
        </tr>
        <% } %>
    </table>
</div>
</body>
</html>
