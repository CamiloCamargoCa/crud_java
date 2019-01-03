/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplosweb;

import com.ejemplosweb.controlador.EventoControlador;
import com.ejemplosweb.modelo.conexion.ConexionBD;
import com.ejemplosweb.modelo.dao.UsuarioDAO;
import com.ejemplosweb.controlador.UsuarioControlador;
import com.ejemplosweb.modelo.vo.AmigoVO;
import com.ejemplosweb.modelo.vo.EventoVO;
import com.ejemplosweb.modelo.vo.IGenericoVO;
import com.ejemplosweb.modelo.vo.UsuarioVO;
import com.sun.xml.rpc.encoding.GenericObjectSerializer;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabian
 */
public class pp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //new ConexionBD();

            System.out.println("Iniciarndo Prueba");
            
            UsuarioControlador controlUsu = new UsuarioControlador();
            UsuarioVO vo = new UsuarioVO();
            vo.setNombreUsuario("Pedro123");
            vo.setApellidoUsuario("Pablo123");
            vo.setCorreoUsuario("correo@ssdf123123");
            vo.setClaveUsuario("Clave1234123123");
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            vo.setFechaNacimientoUsuario(formato.parse("25/10/1999"));
            controlUsu.insertar(vo);
            controlUsu.terminarTransaccion();
//            UsuarioDAO dao = new UsuarioDAO(cnn);
//            dao.insertar(vo);
            
            
            EventoControlador controlEvento = new EventoControlador();
            
            
           
            System.out.println("Fin Prueba");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
