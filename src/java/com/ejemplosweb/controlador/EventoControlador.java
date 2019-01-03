/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplosweb.controlador;

import com.ejemplosweb.controlador.excepciones.EjemploMovilesException;
import com.ejemplosweb.modelo.conexion.ConexionBD;
import com.ejemplosweb.modelo.dao.EventoDAO;
import com.ejemplosweb.modelo.vo.EventoVO;
import com.ejemplosweb.modelo.vo.IGenericoVO;
import com.ejemplosweb.utilidades.EMensajesError;
import java.sql.SQLException;

/**
 *
 * @author Fabian
 */
public class EventoControlador extends ControladorGenerico<EventoDAO, EventoVO>{

    public EventoControlador() throws EjemploMovilesException {
        try {
            this.setCnn(ConexionBD.obtenerConexionBD());
            this.setDao(new EventoDAO(this.getCnn()));
        } catch (ClassNotFoundException ex) {
            throw new EjemploMovilesException(EMensajesError.ERROR_DRIVER_NO_ENCONTRADO, ex);
        } catch (SQLException ex) {
            throw new EjemploMovilesException(EMensajesError.ERROR_BASE_DATOS, ex);
        }

    }
    
}
