package co.edu.unicauca.distribuidos.services.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class UsuarioDTO {

    @NotNull
    private Integer id;

    @NotNull
    @Size(min = 5, max = 50)
    private String nombre;

    @NotNull
    @Size(min = 5, max = 50)
    private String apellido;    

    @NotNull
    @Email
    private String correo;

    @NotNull
    @Pattern (regexp = "^5.*$")
    @Digits(integer = 10, fraction = 0)
    private String telefono;

    @NotNull
    @Size(min = 10, max = 20)
    private String login;
    @NotNull
    @Size(min = 10, max = 20)
    private String contraseña;
    
    
    public UsuarioDTO() {
    }


}
