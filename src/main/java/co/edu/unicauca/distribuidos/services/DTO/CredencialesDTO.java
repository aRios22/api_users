package co.edu.unicauca.distribuidos.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class CredencialesDTO {

    private String login;
    private String contraseña;

    public CredencialesDTO()
	{
		
	}
    
}
