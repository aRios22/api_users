package co.edu.unicauca.distribuidos.services.Usuario;

import java.util.ArrayList;

import co.edu.unicauca.distribuidos.models.Usuario;
import co.edu.unicauca.distribuidos.services.DTO.CredencialesDTO;
import co.edu.unicauca.distribuidos.services.DTO.UsuarioDTO;

public interface IUsuarioServicio {
    
    public ArrayList<Usuario> findAll();
    public UsuarioDTO save(UsuarioDTO Admin);
    public Boolean validarCredenciales(CredencialesDTO credenciales);

}
