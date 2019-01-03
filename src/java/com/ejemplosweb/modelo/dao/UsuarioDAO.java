/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplosweb.modelo.dao;

import com.ejemplosweb.modelo.vo.IGenericoVO;
import com.ejemplosweb.modelo.vo.UsuarioVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabian
 */
public class UsuarioDAO implements IGenericoDAO<UsuarioVO> {

    Connection cnn;

    public UsuarioDAO(Connection cnn) {
        this.cnn = cnn;
    }

    @Override
    public void insertar(UsuarioVO vo) throws SQLException {
        String sql = "INSERT INTO usuario (nombre_usuario,apellido_usuario,fecha_nacimiento_usuario,correo_usuario,clave_usuario)"
                + "VALUES(?,?,?,?,?) ";
        PreparedStatement ejecutorSQL = cnn.prepareStatement(sql);
        ejecutorSQL.setString(1, vo.getNombreUsuario());
        ejecutorSQL.setString(2, vo.getApellidoUsuario());
        ejecutorSQL.setDate(3, new java.sql.Date(vo.getFechaNacimientoUsuario().getTime()));
        ejecutorSQL.setString(4, vo.getCorreoUsuario());
        ejecutorSQL.setString(5, vo.getClaveUsuario());

        ejecutorSQL.executeUpdate();

    }

    @Override
    public void modificar(UsuarioVO vo) throws SQLException {
        String sql = "UPDATE usuario SET nombre_usuario = ?,apellido_usuario=? ,fecha_nacimiento_usuario =? ,correo_usuario =? ,clave_usuario = "
                + "WHERE id_usuario = ?";
        PreparedStatement ejecutorSQL = cnn.prepareStatement(sql);
        ejecutorSQL.setString(1, vo.getNombreUsuario());
        ejecutorSQL.setString(2, vo.getApellidoUsuario());
        ejecutorSQL.setDate(3, new java.sql.Date(vo.getFechaNacimientoUsuario().getTime()));
        ejecutorSQL.setString(4, vo.getCorreoUsuario());
        ejecutorSQL.setString(5, vo.getClaveUsuario());
        ejecutorSQL.setInt(6, vo.getIdUsuario());

        ejecutorSQL.executeUpdate();
    }

    @Override
    public void borrar(UsuarioVO vo) throws SQLException {
        String sql = "DELETE usuario"
                + "WHERE id_usuario = ?";
        PreparedStatement ejecutorSQL = cnn.prepareStatement(sql);
        ejecutorSQL.setInt(1, vo.getIdUsuario());
        ejecutorSQL.executeUpdate();
    }

    @Override
    public List<UsuarioVO> consultar() throws SQLException {
        String sql = "SELECT * FROM usuario";
        PreparedStatement ejecutorSQL = cnn.prepareStatement(sql);
        ResultSet resultado = ejecutorSQL.executeQuery();
        
        ArrayList<UsuarioVO> listaUsuarios = new ArrayList<>();
        
        while (resultado.next()) {
            UsuarioVO voTemporal = new UsuarioVO();
            voTemporal.setIdUsuario(resultado.getInt("id_usuario"));
            voTemporal.setNombreUsuario(resultado.getString("nombre_usuario"));
            voTemporal.setApellidoUsuario(resultado.getString("apellido_usuario"));
            voTemporal.setFechaNacimientoUsuario(resultado.getDate("fecha_nacimiento_usuario"));
            voTemporal.setCorreoUsuario(resultado.getString("correo_usuario"));
            voTemporal.setClaveUsuario(resultado.getString("clave_usuario"));
            
            listaUsuarios.add(voTemporal);
            
        }
        
        if(listaUsuarios.size() == 0){
            return null;
        }
        return listaUsuarios;
        
        
    }
    
    
    public UsuarioVO consultar(int idUsuario) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id_usuario = ? ";
        PreparedStatement ejecutorSQL = cnn.prepareStatement(sql);
        ejecutorSQL.setInt(1, idUsuario);
        
        ResultSet resultado = ejecutorSQL.executeQuery();
        
        
        if (resultado.next()) {
            UsuarioVO voTemporal = new UsuarioVO();
            voTemporal.setIdUsuario(resultado.getInt("id_usuario"));
            voTemporal.setNombreUsuario(resultado.getString("nombre_usuario"));
            voTemporal.setApellidoUsuario(resultado.getString("apellido_usuario"));
            voTemporal.setFechaNacimientoUsuario(resultado.getDate("fecha_nacimiento_usuario"));
            voTemporal.setCorreoUsuario(resultado.getString("correo_usuario"));
            voTemporal.setClaveUsuario(resultado.getString("clave_usuario"));
            
            return voTemporal;
            
            
        }
        return null;
    }

}
