package co.edu.unicauca.distribuidos.services.Administrador;

import java.util.ArrayList;
import co.edu.unicauca.distribuidos.models.Administrador;
import co.edu.unicauca.distribuidos.services.DTO.AdministradorDTO;
import co.edu.unicauca.distribuidos.services.DTO.CredencialesDTO;

public interface IAdministradorServicio {

    public ArrayList<Administrador> findAll();
    public AdministradorDTO save(AdministradorDTO Admin);
    public Boolean validarCredenciales(CredencialesDTO credenciales);
    
}
