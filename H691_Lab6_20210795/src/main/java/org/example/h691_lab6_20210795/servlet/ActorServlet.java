package org.example.h691_lab6_20210795.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.h691_lab6_20210795.beans.Actor;
import org.example.h691_lab6_20210795.daos.PeliculaDaos;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ActorServlet", value = "/ActorServlet")
public class ActorServlet extends HttpServlet {
    PeliculaDaos listapeliculasDao = new PeliculaDaos();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idPelicula = request.getParameter("idPelicula");

        if (idPelicula != null && !idPelicula.isEmpty()) {
            try {
                int id = Integer.parseInt(idPelicula);
                ArrayList<Actor> listaActores = listapeliculasDao.BuscarActores(id);

                request.setAttribute("listaActores", listaActores);
                RequestDispatcher view = request.getRequestDispatcher("listaActores.jsp");
                view.forward(request, response);
            } catch (NumberFormatException e) {
                // Manejo de error si el parámetro idPelicula no es un número válido
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de película inválido");
            }
        } else {
            // Manejo de error si no se proporciona el parámetro idPelicula
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de película no proporcionado");
        }
    }
}