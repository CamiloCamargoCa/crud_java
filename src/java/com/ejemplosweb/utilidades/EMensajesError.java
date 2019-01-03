/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplosweb.utilidades;

/**
 *
 * @author Fabian
 */
public enum EMensajesError {
    ERROR_BASE_DATOS("Error Intentando conectar a la base de datos"),
    ERROR_DESCONECTANDO_BASE_DATOS("Error Intentando desconectar la base de datos"),
    ERROR_INSERTAR("Ocurrio un error al insertar datos en la Base de datos verifique los datos ingresados "),
    ERROR_MODIFICAR("Ocurrio un error al modificar datos en la Base de datos verifique los datos ingresados "),
    ERROR_BORRAR("Ocurrio un error al Borraer datos en la Base de datos verifique los datos ingresados "),
    ERROR_CONSULTAR("Ocurrio un error al Consultar datos en la Base de datos verifique los datos ingresados "), 
    ERROR_DRIVER_NO_ENCONTRADO("Driver de MySQL no encontrado en el proyecto");
    
    String mensaje;

    private EMensajesError(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
    
}
