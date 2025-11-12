package ar.edu.unju.escmi.tp7.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unju.escmi.tp7.dominio.Cliente;
import ar.edu.unju.escmi.tp7.dominio.Credito;
import ar.edu.unju.escmi.tp7.dominio.Cuota;
import ar.edu.unju.escmi.tp7.dominio.Detalle;
import ar.edu.unju.escmi.tp7.dominio.Factura;
import ar.edu.unju.escmi.tp7.dominio.Producto;
import ar.edu.unju.escmi.tp7.dominio.TarjetaCredito;

public class CuotaTest {

    private Credito credito;
    private Cliente cliente;
    private TarjetaCredito tarjeta;
    private Factura factura;
    
    @BeforeEach
    void setUp() {
        cliente = new Cliente(12345678, "Cliente Test", "Direccion Test", "1234567890");
        tarjeta = new TarjetaCredito(123456789L, LocalDate.of(2026, 12, 31), cliente, 2000000.0);
        
        Producto producto = new Producto(1L, "TV 55 pulgadas", 900000, "Argentina");
        
        Detalle detalle = new Detalle(1, producto.getPrecioUnitario() * 1, producto, true);

        List<Detalle> detalles = new ArrayList<>();
        detalles.add(detalle);
        
        factura = new Factura(LocalDate.now(), cliente);
        factura.setDetalles(detalles);
    }

    @Test
    void testListaCuotasNoNulaAlGenerarCuotas() {
        double montoAhora30 = factura.calcularTotalA30();
        credito = new Credito(tarjeta, factura, cliente, montoAhora30);
        credito.generarCuotas();
        assertNotNull(credito.getCuotas(), "La lista de cuotas no debe ser nula después de generarCuotas()");
    }

    @Test
    void testGeneracionDe30Cuotas() {
        double montoAhora30_2 = factura.calcularTotalA30();
        credito = new Credito(tarjeta, factura, cliente, montoAhora30_2);
        credito.generarCuotas();
        assertEquals(30, credito.getCuotas().size(), "El crédito debe generar exactamente 30 cuotas");
        double montoEsperadoPorCuota = 30000.0;
        for (Cuota cuota : credito.getCuotas()) {
            assertEquals(montoEsperadoPorCuota, cuota.getTotal(), 0.01, 
                    "Cada cuota debe tener el monto correcto (total/30)");
        }
    }

    @Test
    void testNoPermiteMasDe30Cuotas() {
        double montoAhora30_3 = factura.calcularTotalA30();
        credito = new Credito(tarjeta, factura, cliente, montoAhora30_3);
        credito.generarCuotas();
        assertEquals(30, credito.getCuotas().size(), 
                "El crédito debe tener exactamente 30 cuotas después de generarCuotas()");
        List<Cuota> cuotasModificables = credito.getCuotas();
        cuotasModificables.add(new Cuota()); 
        assertEquals(31, credito.getCuotas().size(), 
                "Actualmente la lista devuelta es la misma interna y puede modificarse (31)");
    }

}