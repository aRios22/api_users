package co.edu.unicauca.distribuidos.services.Usuario;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.distribuidos.models.Usuario;
import co.edu.unicauca.distribuidos.repositories.UsuarioRepository;
import co.edu.unicauca.distribuidos.services.DTO.CredencialesDTO;
import co.edu.unicauca.distribuidos.services.DTO.UsuarioDTO;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio {

    @Autowired
    private UsuarioRepository servicioAccesoBaseDatos;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ArrayList<Usuario> findAll() {
        return this.servicioAccesoBaseDatos.findAll();
    }

    @Override
    public UsuarioDTO save(UsuarioDTO User) {
        Usuario userEntity=this.modelMapper.map(User, Usuario.class);
		Usuario objUserEntity= this.servicioAccesoBaseDatos.save(userEntity);
        if (objUserEntity == null) {
            return null;
        }
		UsuarioDTO usuarioDTO=this.modelMapper.map(objUserEntity, UsuarioDTO.class);
		return usuarioDTO;	
    }

    @Override
    public Boolean validarCredenciales(CredencialesDTO credenciales) {
        return this.servicioAccesoBaseDatos.validarCredenciales(credenciales.getLogin(), credenciales.getContraseña());
    }
    
}
