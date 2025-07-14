package cl.gallardo_molina.tiendacelulares.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Venta venta;

    @ManyToOne
    private Celular celular;

    @ManyToOne
    private Cliente cliente;

    private LocalDate fecha;

    //private int cantidad;
    //private double precioUnitario;
    private double total;

    //@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<DetalleVenta> detalles;
}
