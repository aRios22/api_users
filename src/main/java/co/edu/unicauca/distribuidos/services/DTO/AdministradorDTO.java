package co.edu.unicauca.distribuidos.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class AdministradorDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String login;
    private String contraseña;

    public AdministradorDTO()
	{
		
	}
}
