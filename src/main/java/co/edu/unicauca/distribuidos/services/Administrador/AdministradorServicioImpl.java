package co.edu.unicauca.distribuidos.services.Administrador;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.distribuidos.models.Administrador;
import co.edu.unicauca.distribuidos.repositories.AdministradorRepository;
import co.edu.unicauca.distribuidos.services.DTO.AdministradorDTO;
import co.edu.unicauca.distribuidos.services.DTO.CredencialesDTO;

@Service
public class AdministradorServicioImpl implements IAdministradorServicio{

    @Autowired
    private AdministradorRepository servicioAccesoBaseDatos;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ArrayList<Administrador> findAll() {
        return this.servicioAccesoBaseDatos.findAll();
    }

    @Override
    public AdministradorDTO save(AdministradorDTO Admin) {
        Administrador adminEntity=this.modelMapper.map(Admin, Administrador.class);
		Administrador objAdminEntity= this.servicioAccesoBaseDatos.save(adminEntity);
		AdministradorDTO adminDTO=this.modelMapper.map(objAdminEntity, AdministradorDTO.class);
		return adminDTO;	
    }

    @Override
    public Boolean validarCredenciales(CredencialesDTO credenciales) {
        return this.servicioAccesoBaseDatos.validarCredenciales(credenciales.getLogin(), credenciales.getContraseña());
    }
    
}
