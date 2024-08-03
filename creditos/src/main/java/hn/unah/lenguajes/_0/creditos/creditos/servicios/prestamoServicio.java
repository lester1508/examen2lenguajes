package hn.unah.lenguajes._0.creditos.creditos.servicios;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes._0.creditos.creditos.modelos.prestamos;

@Service
public class prestamoServicio {

    @Autowired
    private clienteServicio clienteRepositorio;

    @Autowired
    private prestamoServicio prestamoRepositorio;

    private prestamos findById;

    public prestamos buscarPrestamoPorCodigo(long codigoPrestamo) {
        return prestamoRepositorio.findById;
    }

    @Transactional
    public prestamos crearPrestamo(long dni, prestamos prestamo) {
        clienteServicio clienteOpt = clienteRepositorio;
        if (clienteOpt.isEmpty());
        return prestamo;
        
        }

        


    public void save(prestamos prestamo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }}