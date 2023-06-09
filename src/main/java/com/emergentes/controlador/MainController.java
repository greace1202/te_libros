package com.emergentes.controlador;

import com.emergentes.modelo.libro;
import com.emergentes.utiles.ConexionDB;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String op;
            op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";
            ArrayList<libro> lista = new ArrayList<libro>();
            ConexionDB canal = new ConexionDB();
            Connection conn = canal.conectar();
            PreparedStatement ps;
            ResultSet rs;
            if (op.equals("list")) {
                String sql = "select * from lbros";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    libro lib = new libro();
                    lib.setId(rs.getInt("id"));
                    lib.setIsbn(rs.getString("isbn"));
                    lib.setTitulo(rs.getString("titulo"));
                    lib.setCategoria(rs.getString("categoria"));
                    lista.add(lib);
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            if (op.equals("nuevo")) {
                libro li = new libro();
                System.out.println(li.toString());
                request.setAttribute("lib", li);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
            }
            if (op.equals("eliminar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String sql = "delete from libros where id  = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                response.sendRedirect("MainConroller");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL Conectar" + ex.getMessage());
        }
    }
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("Valor de ID" + id);
            String isbn = request.getParameter("isbn");
            String titulo = request.getParameter("titulo");
            String categoria = request.getParameter("categoria");

            libro lib = new libro();
            lib.setId(id);            
            lib.setIsbn(isbn);
            lib.setTitulo(titulo);
            lib.setCategoria(categoria);
            
            ConexionDB canal = new ConexionDB();
            Connection conn = canal.conectar();
            PreparedStatement ps;
            ResultSet rs;

            if(id == 0){
            String sql = "insert into libros (isbn,titulo,categoria) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, lib.getIsbn());
            ps.setString(2, lib.getTitulo());
            ps.setString(3, lib.getCategoria());
            ps.executeUpdate();
            }
            else{
            //edicion del registro
            
            }
            response.sendRedirect("MainController");
        }catch(SQLException ex){
            System.out.println("Error en SQL" + ex.getMessage());
        }
    }    
}



