package hn.unah.lenguajes._0.creditos.creditos.modelos;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "prestamo")
@Data
public class prestamos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double monto;

    private double tasaInteres;

    private int plazo;

    @ManyToOne
    @JoinColumn(name = "cliente_dni")
    private cliente cliente;

    @OneToMany(mappedBy = "prestamo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<cuotas> cuotas;
}
