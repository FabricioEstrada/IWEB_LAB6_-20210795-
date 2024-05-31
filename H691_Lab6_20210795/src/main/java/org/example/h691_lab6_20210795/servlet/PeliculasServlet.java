package org.example.h691_lab6_20210795.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.h691_lab6_20210795.beans.Peliculas;
import org.example.h691_lab6_20210795.daos.PeliculaDaos;

import java.io.IOException;

@WebServlet(name = "PeliculasServlet", value = "/PeliculasServlet")
public class PeliculasServlet extends HttpServlet {
    PeliculaDaos peliculaDao = new PeliculaDaos();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idPelicula = request.getParameter("idPelicula");

        if (idPelicula != null && !idPelicula.isEmpty()) {
            Peliculas pelicula = peliculaDao.BuscarPorId(Integer.parseInt(idPelicula));
            if (pelicula != null) {
                request.setAttribute("pelicula", pelicula);
                RequestDispatcher view = request.getRequestDispatcher("viewPelicula.jsp");
                view.forward(request, response);
                return;
            }
        }
        response.sendRedirect("ListaPeliculaServlet");
    }
}
