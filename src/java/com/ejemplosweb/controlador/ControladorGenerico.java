package com.ejemplosweb.controlador;
import com.ejemplosweb.controlador.excepciones.EjemploMovilesException;
import com.ejemplosweb.modelo.conexion.ConexionBD;
import com.ejemplosweb.modelo.dao.IGenericoDAO;
import com.ejemplosweb.modelo.vo.IGenericoVO;
import com.ejemplosweb.utilidades.EMensajesError;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorGenerico <I extends IGenericoDAO, J extends IGenericoVO>{
    
    private I dao;
    private Connection cnn;

    
    public void insertar(J vo) throws EjemploMovilesException{
        try {
            dao.insertar(vo);
        } catch (SQLException ex) {
            throw new EjemploMovilesException(EMensajesError.ERROR_INSERTAR, ex);
        }
    }
    
    public void modificar(J vo) throws EjemploMovilesException{
        try {
            dao.modificar(vo);
        } catch (SQLException ex) {
            throw new EjemploMovilesException(EMensajesError.ERROR_MODIFICAR, ex);
        }
    }

    
    public void borrar(J vo) throws EjemploMovilesException{
        try {
            dao.borrar(vo);
        } catch (SQLException ex) {
            throw new EjemploMovilesException(EMensajesError.ERROR_MODIFICAR, ex);
        }
    }
    
    public List<J> consultar() throws EjemploMovilesException{
        try {
            return dao.consultar();
        } catch (SQLException ex) {
            throw new EjemploMovilesException(EMensajesError.ERROR_MODIFICAR, ex);
        }
    }
    
    public void terminarTransaccion() throws EjemploMovilesException{
        try {
            ConexionBD.cerrarConexion(this.cnn);
        } catch (SQLException ex) {
            throw new EjemploMovilesException(EMensajesError.ERROR_DESCONECTANDO_BASE_DATOS, ex);
        }
    }
    
    protected I getDao() {
        return dao;
    }

    protected Connection getCnn() {
        return cnn;
    }

    protected void setDao(I dao) {
        this.dao = dao;
    }

    protected  void setCnn(Connection cnn) {
        this.cnn = cnn;
    }


    
    
    
}
