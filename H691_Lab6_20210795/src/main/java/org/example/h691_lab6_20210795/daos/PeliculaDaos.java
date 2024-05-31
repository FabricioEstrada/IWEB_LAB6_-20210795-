package org.example.h691_lab6_20210795.daos;

import org.example.h691_lab6_20210795.beans.Actor;
import org.example.h691_lab6_20210795.beans.Peliculas;

import java.sql.*;
import java.util.ArrayList;

public class PeliculaDaos {
    public ArrayList<Peliculas> listarPeliculas() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ArrayList<Peliculas> listaPeliculas = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=America/Lima";
        String username = "root";
        String password = "root";

        String sql = "SELECT pel.idPelicula, pel.titulo, pel.director, pel.anoPublicacion, pel.rating, pel.boxOffice, " +
                "gen.nombre AS genero, pel.idGenero " +
                "FROM pelicula pel " +
                "JOIN genero gen ON pel.idGenero = gen.idGenero " +
                "ORDER BY pel.rating DESC, pel.boxOffice DESC";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Peliculas pelicula = new Peliculas();
                pelicula.setIdPelicula(rs.getInt(1));
                pelicula.setTitulo(rs.getString(2));
                pelicula.setDirector(rs.getString(3));
                pelicula.setAnoPublicacion(rs.getInt(4));
                pelicula.setRating(rs.getDouble(5));
                pelicula.setBoxOffice((int) Math.round(rs.getDouble(6)));
                pelicula.setGenero(rs.getString(7));

                listaPeliculas.add(pelicula);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPeliculas;
    }

    public ArrayList<Peliculas> BuscarPorNombre(String LetraInicial) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Peliculas> peliculasFiltradas = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=America/Lima";
        String username = "root";
        String password = "root";

        String sql = "SELECT pel.idPelicula, pel.titulo, pel.director, pel.anoPublicacion, pel.rating, pel.boxOffice, " +
                "gen.nombre AS genero " +
                "FROM pelicula pel " +
                "JOIN genero gen ON pel.idGenero = gen.idGenero " +
                "WHERE pel.titulo LIKE ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, LetraInicial + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Peliculas pelicula = new Peliculas();
                    pelicula.setIdPelicula(rs.getInt(1));
                    pelicula.setTitulo(rs.getString(2));
                    pelicula.setDirector(rs.getString(3));
                    pelicula.setAnoPublicacion(rs.getInt(4));
                    pelicula.setRating(rs.getDouble(5));
                    pelicula.setBoxOffice((int) Math.round(rs.getDouble(6)));
                    pelicula.setGenero(rs.getString(7));
                    peliculasFiltradas.add(pelicula);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peliculasFiltradas;
    }

    public Peliculas BuscarPorId(int idPelicula) {
        Peliculas pelicula = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=America/Lima";
        String username = "root";
        String password = "root";

        String sql = "SELECT pel.idPelicula, pel.titulo, pel.director, pel.anoPublicacion, pel.rating, pel.boxOffice, " +
                "gen.nombre AS genero " +
                "FROM pelicula pel " +
                "JOIN genero gen ON pel.idGenero = gen.idGenero " +
                "WHERE pel.idPelicula = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPelicula);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    pelicula = new Peliculas();
                    pelicula.setIdPelicula(rs.getInt(1));
                    pelicula.setTitulo(rs.getString(2));
                    pelicula.setDirector(rs.getString(3));
                    pelicula.setAnoPublicacion(rs.getInt(4));
                    pelicula.setRating(rs.getDouble(5));
                    pelicula.setBoxOffice((int) Math.round(rs.getDouble(6)));
                    pelicula.setGenero(rs.getString(7));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pelicula;
    }
    public ArrayList<Actor> BuscarActores(int idPelicula) {
        Actor actor = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Actor> listaActores = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=America/Lima";
        String username = "root";
        String password = "root";

        String sql = "SELECT a.*, pel.titulo as titulo_pelicula\n" +
                "FROM Actor a \n" +
                "INNER JOIN Protagonistas p ON a.idActor = p.idActor \n" +
                "INNER JOIN Pelicula pel ON p.idPelicula = pel.idPelicula\n" +
                "WHERE p.idPelicula = ?;";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPelicula);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    actor = new Actor();
                    actor.setIdActor(rs.getInt("idActor"));
                    actor.setNombre(rs.getString("nombre"));
                    actor.setApellido(rs.getString("apellido"));
                    actor.setAnoNacimiento(rs.getInt("anoNacimiento"));
                    actor.setganoOscar(rs.getBoolean("premioOscar"));
                    actor.setTitulo_pelicula(rs.getString("titulo_pelicula"));
                    listaActores.add(actor);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaActores;
    }
}
