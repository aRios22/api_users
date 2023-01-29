package co.edu.unicauca.distribuidos.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Administrador {
    //nombres, apellidos, login y contraseña.
    @NotNull
    private Integer id;

	@NotNull
    @Size(min = 5, max = 50)
    private String nombre;

    @NotNull
    @Size(min = 5, max = 50)
    private String apellido;

    @NotNull
    @Size(min = 10, max = 20)
    private String login;

    @NotNull
    @Size(min = 10, max = 20)
    private String contraseña;
    
    
    
    public Administrador() {
    }

    public Administrador(Integer id, String nombre, String apellido, String login, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.login = login;
        this.contraseña = contraseña;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
   
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


    
}
