package co.edu.unicauca.distribuidos.services.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class AdministradorDTO {
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

    public AdministradorDTO()
	{
		
	}
}
