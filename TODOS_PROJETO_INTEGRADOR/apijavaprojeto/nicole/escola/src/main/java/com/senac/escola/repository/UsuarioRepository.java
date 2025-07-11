package com.senac.escola.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.escola.model.Usuario;

@Repository                                            
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}