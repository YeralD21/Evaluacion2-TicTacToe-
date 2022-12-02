/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.dao;

import java.util.List;
import pe.edu.upeu.modelo.ResultadoTO;

/**
 *
 * @author ACER ASPIRE
 */
public interface ResultadoDaoI {
    public List listarResultados();
    public int crearResultado(ResultadoTO re); 
}
