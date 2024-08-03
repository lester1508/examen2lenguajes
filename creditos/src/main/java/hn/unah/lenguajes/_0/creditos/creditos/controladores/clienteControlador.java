package hn.unah.lenguajes._0.creditos.creditos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import hn.unah.lenguajes._0.creditos.creditos.modelos.cliente;
import hn.unah.lenguajes._0.creditos.creditos.modelos.prestamos;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class clienteControlador {

    @Autowired
    private clienteControlador clienteServicio;
    private Object prestamoServicio;

    

    @PostMapping("/crear/nuevo")
    public prestamos crearMaestro(@RequestBody prestamos nvocliPrestamos) {
        return this.clienteServicio.crearNvoprestamos(nvocliPrestamos);
        
    }

    private prestamos crearNvoprestamos(prestamos nvocliPrestamos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearNvoprestamos'");
    }

    private ResponseEntity<cliente> cliente(hn.unah.lenguajes._0.creditos.creditos.modelos.cliente nuevoCliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cliente'");
    }

    @GetMapping("/todos")
    public ResponseEntity<List<cliente>> obtenerTodos() {
        List<cliente> clientes = (List<cliente>) clienteServicio.obtenerTodos();
        return this.clienteServicio.obtenerTodos();
    }
}
