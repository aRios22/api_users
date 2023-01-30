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

        for (Usuario savedUser : this.listaUsuarios) {
            if(savedUser.getLogin().compareTo(User.getLogin())==0){
                return objUsuario;
            }
        }

        if(this.listaUsuarios.add(User)){
            objUsuario=User;
        }
        return objUsuario;
    }

    public Usuario validarCredenciales(String usuario, String clave){
        for (Usuario user : this.listaUsuarios) {
            if(user.getLogin().compareTo(usuario) == 0 && user.getContraseña().compareTo(clave)==0){
                return user;
            }
        }
        return null;
    }

    private void cargarUsuarios(){
        Usuario objUsuario=new Usuario(1,"Andres", "Medina","correo@mail.com","5523456789" ,"usuariobase","usuariobase");
        this.listaUsuarios.add(objUsuario);
    }
}
