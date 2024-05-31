<%@ page import="org.example.h691_lab6_20210795.beans.Peliculas" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <%Peliculas pelicula = (Peliculas) request.getAttribute("pelicula");%>
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
            width: 40%; /* Ancho del th reducido */
        }
    </style>
</head>
<body>
<div class="tabla-container">
    <h1 style="text-align: center;"><%= pelicula != null ? pelicula.getTitulo() : "No hay esta película" %></h1>
    <div style="display: flex; justify-content: center; align-items: center;">
        <table>
            <tr>
                <th>ID</th>
                <td><%=pelicula.getIdPelicula()%></td>
            </tr>
            <tr>
                <th>Director</th>
                <td><%=pelicula.getDirector()%></td>
            </tr>
            <tr>
                <th>Año de Publicación</th>
                <td><%=pelicula.getAnoPublicacion()%></td>
            </tr>
            <tr>
                <th>Rating</th>
                <td><%=pelicula.getRating()%></td>
            </tr>
            <tr>
                <th>Box Office</th>
                <td><%=pelicula.getBoxOffice()%></td>
            </tr>
            <tr>
                <th>Género</th>
                <td><%=pelicula.getGenero()%></td>
            </tr>
            <tr>
                <th>Actores</th>
                <td><a href="ActorServlet?idPelicula=<%= pelicula.getIdPelicula() %>">Ver Actores</a></td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>


