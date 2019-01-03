/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplosweb.controlador;

import com.ejemplosweb.controlador.ControladorGenerico;
import com.ejemplosweb.controlador.excepciones.EjemploMovilesException;
import com.ejemplosweb.modelo.conexion.ConexionBD;
import com.ejemplosweb.modelo.vo.UsuarioVO;
import com.ejemplosweb.modelo.dao.UsuarioDAO;
import com.ejemplosweb.utilidades.EMensajesError;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabian
 */
public class UsuarioControlador extends ControladorGenerico<UsuarioDAO, UsuarioVO> {

    public UsuarioControlador() throws EjemploMovilesException {
        try {
            this.setCnn(ConexionBD.obtenerConexionBD());
            this.setDao(new UsuarioDAO(this.getCnn()));
        } catch (ClassNotFoundException ex) {
            throw new EjemploMovilesException(EMensajesError.ERROR_DRIVER_NO_ENCONTRADO, ex);
        } catch (SQLException ex) {
            throw new EjemploMovilesException(EMensajesError.ERROR_BASE_DATOS, ex);
        }
    }
    
    public UsuarioControlador(Connection cnn) throws EjemploMovilesException {
        try {
            this.setCnn(cnn);
            this.setDao(new UsuarioDAO(this.getCnn()));
        }catch (Exception ex) {
            throw new EjemploMovilesException(EMensajesError.ERROR_BASE_DATOS, ex);
        }
    }

    
    
}
