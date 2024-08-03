package hn.unah.lenguajes._0.creditos.creditos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import hn.unah.lenguajes._0.creditos.creditos.modelos.cuotas;

@Repository
public interface coutasRepositorio extends JpaRepository<cuotas, Long >{
    
}
 