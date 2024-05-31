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
import java.util.ArrayList;

@WebServlet(name = "ListaPeliculaServlet", value = "/ListaPeliculaServlet")
public class ListaPeliculaServlet extends HttpServlet {
    PeliculaDaos listapeliculasDao = new PeliculaDaos();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String searchQuery = request.getParameter("search");
        ArrayList<Peliculas> listaPeliculas = new ArrayList<>();

        if (searchQuery != null && !searchQuery.isEmpty()) {
            listaPeliculas = listapeliculasDao.BuscarPorNombre(searchQuery);
        } else {
            listaPeliculas = listapeliculasDao.listarPeliculas();
        }

        request.setAttribute("listarPeliculas", listaPeliculas);
        request.setAttribute("searchQuery", searchQuery);
        RequestDispatcher view = request.getRequestDispatcher("listaPeliculas.jsp");
        view.forward(request,response);
    }
}

