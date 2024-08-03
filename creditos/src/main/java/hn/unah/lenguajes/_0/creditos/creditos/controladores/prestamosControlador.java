package hn.unah.lenguajes._0.creditos.creditos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import hn.unah.lenguajes._0.creditos.creditos.modelos.prestamos;

@RestController
@RequestMapping("/api/prestamos")
public class prestamosControlador<PrestamoServicio> {

    @Autowired
    private PrestamoServicio prestamoServicio;

    @PostMapping("/crear")
    public ResponseEntity<prestamos> crearPrestamo(@RequestParam long dni, @RequestBody prestamos prestamo) {
        prestamos nuevoPrestamo = (prestamoServicio).crearClienteConPrestamo(dni, prestamo);
        
    }

    private ResponseEntity<prestamos> prestamos(prestamos nuevoPrestamo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'prestamos'");
    }

    @GetMapping("/buscar/{codigoPrestamo}")
    public ResponseEntity<prestamos> buscarPrestamo(@PathVariable long codigoPrestamo) {
        prestamos prestamo = ((Object) prestamoServicio).buscarClienteConPrestamo(codigoPrestamo);
        return prestamos(prestamo);
    }
}