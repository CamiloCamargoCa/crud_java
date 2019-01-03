package com.ejemplosweb.vista;

import com.ejemplosweb.controlador.UsuarioControlador;
import com.ejemplosweb.controlador.excepciones.EjemploMovilesException;
import com.ejemplosweb.modelo.vo.UsuarioVO;
import com.ejemplosweb.utilidades.EMensajesError;
import com.ejemplosweb.vista.utilidades.RespuestaServlets;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletUsuario", urlPatterns = {"/usuario/insertar", "/usuario/modificar", "/usuario/eliminar", "/usuario/consultar"})
public class ServletUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String accion = request.getServletPath().substring(request.getServletPath().lastIndexOf("/") + 1);

            //out.println("Me llamaron :DD  --> " + request.getServletPath() + " --> Accion : " + accion);
            UsuarioControlador controlUsu = new UsuarioControlador();
            UsuarioVO usuVO = new UsuarioVO();

            switch (accion) {
                case "insertar":
                    out.println("Inserttando ---- - - -- ");
                    String dato=request.getParameter("nombre");
                    String dato2=request.getParameter("apellido");
                    String dato3=request.getParameter("fnacimiento");
                    String dato4=request.getParameter("correo");
                    String dato5=request.getParameter("clave");
                    
                    System.out.println(""+dato);
                    
                    usuVO.setNombreUsuario(dato);
                    usuVO.setApellidoUsuario(dato2);
                    
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    usuVO.setFechaNacimientoUsuario(formato.parse(dato3));
                    usuVO.setCorreoUsuario(dato4);
                    usuVO.setClaveUsuario(dato5);
                    
                    
                    controlUsu.insertar(usuVO);
                    controlUsu.terminarTransaccion();
                    RespuestaServlets respuesta = new RespuestaServlets();
                    respuesta.setCodigo(500);
                    respuesta.setMensaje("Probando Insert---- "+dato+" ---  "+dato2);
                    respuesta.setDatos(null);
                    Gson gson = new Gson();
                    String json = gson.toJson(respuesta);
                    out.println(json);
                    break;
                case "modificar":
                    out.println("modificando * * ** * ** ");
                    break;
                case "eliminar":
                    out.println("eliminando + ++ + + +");
                    break;
                case "consultar":
                    List<UsuarioVO> listado = controlUsu.consultar();
                    RespuestaServlets respuestaConsulta = new RespuestaServlets();
                    respuestaConsulta.setCodigo(1);
                    respuestaConsulta.setMensaje("OK");
                    respuestaConsulta.setDatos(listado);
                    Gson gsonConsulta = new Gson();
                    String jsonConsulta = gsonConsulta.toJson(respuestaConsulta);
                    out.println(jsonConsulta);
                break;

                default:
                    throw new AssertionError();
            }
        }catch (ParseException perror){
        } catch (EjemploMovilesException error) {
            error.printStackTrace();
            RespuestaServlets respuesta = new RespuestaServlets();
            respuesta.setCodigo(500);
            respuesta.setMensaje("Error en Actividad del Servlet");
            respuesta.setDatos(null);

            Gson gson = new Gson();
            String json = gson.toJson(respuesta);
            PrintWriter out;
            out = response.getWriter();
            out.println(json);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
