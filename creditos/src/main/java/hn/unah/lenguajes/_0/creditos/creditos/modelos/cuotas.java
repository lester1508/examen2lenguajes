package hn.unah.lenguajes._0.creditos.creditos.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "cuota")
@Data
public class cuotas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigoCuota;

    private int mes;

    private double interes;

    private double capital;

    private double saldo;

    @ManyToOne
    @JoinColumn(name = "codigoPrestamo")
    private prestamos prestamo;
}