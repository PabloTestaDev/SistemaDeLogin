
package com.mycompany.login.logica;

import com.mycompany.login.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis;

    public Controladora() {
        controlPersis = new ControladoraPersistencia();
    }
    
    
    
       public Usuario validarUsuario(String usuario, String contrasenia) {
           
        Usuario usuar = null;
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();
        for (Usuario usua: listaUsuarios) {
           if (usua.getNombreUsuario().equals(usuario)) {
               if (usua.getContrasenia().equals(contrasenia)) {
                   usuar = usua;
                   return usuar;
               } else {
                   usuar = null;
                   return usuar;
               }
           } else {
           usuar = null;
           
           
           }
       }
       return usuar ;
    }

    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }

    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    public void crearUsuario(String usuario, String contra, String rolRecibido) {
        
        Usuario usu = new Usuario();
        usu.setNombreUsuario(usuario);
        usu.setContrasenia(contra);
        
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        if (rolEncontrado != null) {
            usu.setUnRol(rolEncontrado);
        }
        controlPersis.crearUsuario(usu);
    }

    private Rol traerRol(String rolRecibido) {
        List<Rol> listaRoles = controlPersis.traerRoles();
        for (Rol rol: listaRoles) {
            if (rol.getNombreRol().equals(rolRecibido)) {
            return rol;
            }
        }
        return null;
    }

    public void borrarUsuario(int id_usuarios) {
        controlPersis.borrarUsuario(id_usuarios);
    }

    public Usuario traerUsuario(int id_usuarios) {
       return controlPersis.traerUsuario(id_usuarios);
    }

    public void editarUsuario(Usuario usu, String usuario, String contra, String rolRecibido) {
        usu.setNombreUsuario(usuario);
        usu.setContrasenia(contra);
        
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        if (rolEncontrado != null) {
            usu.setUnRol(rolEncontrado);
        }
        controlPersis.editarUsuario(usu);
    }

    
}
