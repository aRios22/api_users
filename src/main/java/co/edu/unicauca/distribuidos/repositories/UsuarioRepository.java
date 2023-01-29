package co.edu.unicauca.distribuidos.repositories;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.distribuidos.models.Usuario;

@Repository
public class UsuarioRepository {

    private ArrayList<Usuario> listaUsuarios;
    
    public UsuarioRepository() {
        
        this.listaUsuarios=new ArrayList<Usuario>();
        cargarUsuarios();

    }

    public ArrayList<Usuario> findAll() {
        return this.listaUsuarios;
    }

    public Usuario save(Usuario User){
        Usuario objUsuario=null;

        if(this.listaUsuarios.add(User)){
            objUsuario=User;
        }
        return objUsuario;
    }

    public Boolean validarCredenciales(String usuario, String clave){
        for (Usuario user : this.listaUsuarios) {
            if(user.getLogin().compareTo(usuario) == 0 && user.getContraseña().compareTo(clave)==0){
                return true;
            }
        }
        return false;
    }

    private void cargarUsuarios(){
        Usuario objUsuario=new Usuario(1,"Andres", "Rios","correo@mail.com",123456789 ,"user","user");
        this.listaUsuarios.add(objUsuario);
    }
}
