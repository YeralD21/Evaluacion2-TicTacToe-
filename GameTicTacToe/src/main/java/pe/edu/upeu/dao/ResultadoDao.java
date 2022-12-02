/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.coon.ConnS;
import pe.edu.upeu.modelo.ResultadoTO;

/**
 *
 * @author ACER ASPIRE
 */
public class ResultadoDao implements ResultadoDaoI{
    ConnS instance=ConnS.getInstance();
    Connection conexion=instance.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    

    @Override
    public List listarResultados() {
        List<ResultadoTO> lista=new ArrayList();
        String sql="select * from resultados";
        try {
            ps=conexion.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                ResultadoTO to=new ResultadoTO();
                to.setId_resultado(rs.getInt("id_resultado"));
                to.setNombre_partida(rs.getString("nombre_partida"));
                to.setNombre_jugador1(rs.getString("nombre_jugador1"));
                to.setNombre_jugador2(rs.getString("nombre_jugador2"));
                to.setGanador(rs.getString("ganador"));
                to.setPunto(rs.getInt("punto"));
                to.setEstado(rs.getString("estado"));
               
                
            }
            
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int crearResultado(ResultadoTO re) {
        int exec=0;
        int i=0;
        String sql="insert into resultados(nombre_partida, nombre_jugador1, nombre_jugador2, ganador, punto, estado "
                + "values(?,?,?,?,?,?)";
        try {
            ps=conexion.prepareStatement(sql);
            ps.setString(++i, re.getNombre_partida());
            ps.setString(++i, re.getNombre_jugador1());
            ps.setString(++i, re.getNombre_jugador2());
            ps.setString(++i, re.getGanador());
            ps.setInt(++i, re.getPunto());
            ps.setString(++i, re.getEstado());
            exec=ps.executeUpdate();/*Esto va a ejecutar y va actualizar*/
            
        } catch (Exception e) {
        }
        return exec;
    }
}
