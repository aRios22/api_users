package co.edu.unicauca.distribuidos.repositories;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.distribuidos.models.Administrador;


@Repository
public class AdministradorRepository {

    private ArrayList<Administrador> listaAdministradores;

    public AdministradorRepository() {
        
        this.listaAdministradores=new ArrayList<Administrador>();
        cargarAdmins();

    }

    public ArrayList<Administrador> findAll() {
        return this.listaAdministradores;
    }

    public Administrador save(Administrador Admin){
        Administrador objAdmin=null;
        
        for (Administrador savedAdmin : this.listaAdministradores) {
            if(savedAdmin.getLogin().compareTo(Admin.getLogin())==0){
                return objAdmin;
            }
        }

        if(this.listaAdministradores.add(Admin)){
            objAdmin=Admin;
        }
        return objAdmin;
    }

    public Boolean validarCredenciales(String usuario, String clave){
        for (Administrador administrador : listaAdministradores) {
            if(administrador.getLogin().compareTo(usuario) == 0 && administrador.getContraseña().compareTo(clave)==0){
                return true;
            }
        }
        return false;
    }

    private void cargarAdmins(){
        Administrador objAdmin=new Administrador(1,"Andres", "Medina", "adminbase","adminbase");
        this.listaAdministradores.add(objAdmin);
    }




    
    
}
