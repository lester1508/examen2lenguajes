package hn.unah.lenguajes._0.creditos.creditos.servicios;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes._0.creditos.creditos.modelos.cliente;
import hn.unah.lenguajes._0.creditos.creditos.modelos.cuotas;
import hn.unah.lenguajes._0.creditos.creditos.modelos.prestamos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class clienteServicio {

    @Autowired
    private clienteServicio clienteRepositorio;

    @Autowired
    private prestamoServicio prestamoRepositorio;

    public Optional<cliente> encontrarClientePorDni(long dni) {
        return clienteRepositorio.findById(dni);
    }

    private Optional<cliente> findById(long dni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Transactional
    public cliente crearClienteConPrestamo(cliente cliente, prestamos prestamo) {
        if (clienteRepositorio.existsById(cliente.getDni())) {
            return null;
        }

        clienteRepositorio.save(cliente);
        if (prestamo != null) {
            prestamo.setCliente(cliente);
            prestamoRepositorio.save(prestamo);
            List<cuotas> cuotas = generarTablaPagos(prestamo);
            prestamo.setCuotas(cuotas);
        }

        return cliente;
    }

    

    private void save(cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    private boolean existsById(long dni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    private List<cuotas> generarTablaPagos(prestamos prestamo) {
        double saldo = prestamo.getMonto();
        double i = prestamo.getTasaInteres() / 12;
        int n = prestamo.getPlazo() * 12;
        double cuota = calcularCuota(prestamo.getMonto(), i, n);
        List<cuotas> cuotas = new ArrayList<>();

        for (int mes = 0; mes <= n; mes++) {
            cuotas cuotaMensual = new cuotas();
            cuotaMensual.setMes(mes);
            cuotaMensual.setPrestamo(prestamo);
            if (mes == 0) {
                cuotaMensual.setInteres(0);
                cuotaMensual.setCapital(0);
                cuotaMensual.setSaldo(saldo);
            } else {
                double interes = saldo * i;
                double capital = cuota - interes;
                saldo -= capital;
                cuotaMensual.setInteres(interes);
                cuotaMensual.setCapital(capital);
                cuotaMensual.setSaldo(saldo);
            }
            cuotas.add(cuotaMensual);
        }
        return cuotas;
    }

    private double calcularCuota(double monto, double i, int n) {
        return monto * i / (1 - Math.pow(1 + i, -n));
    }

    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }
}