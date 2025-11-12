package ar.edu.unju.escmi.tp7.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unju.escmi.tp7.dominio.Cliente;
import ar.edu.unju.escmi.tp7.dominio.TarjetaCredito;
import ar.edu.unju.escmi.tp7.dominio.Factura;
import ar.edu.unju.escmi.tp7.dominio.Credito;
import ar.edu.unju.escmi.tp7.dominio.Detalle;
import ar.edu.unju.escmi.tp7.dominio.Producto;

class CreditoTest {
    private Cliente cliente;
    private TarjetaCredito tarjeta;
    private Factura factura;
    private Credito credito;
    private List<Detalle> detalles;

    @BeforeEach
    void setUp() {
        cliente = new Cliente(12345678L, "Cliente Test", "Calle Test", "123456789");

        tarjeta = new TarjetaCredito(11111L, LocalDate.of(2030, 1, 1), cliente, 1600000);

        Producto p1 = new Producto(1L, "TV 55 pulgadas", 500000, "Argentina");
        Producto p2 = new Producto(2L, "Heladera No Frost", 400000, "Argentina");

        detalles = new ArrayList<>();
        
        detalles.add(new Detalle(1, 500000, p1, true));
        detalles.add(new Detalle(1, 400000, p2, true));

        factura = new Factura(LocalDate.now(), cliente);
        factura.setDetalles(detalles);

        double monto = factura.calcularTotalA30();
        credito = new Credito(tarjeta, factura, cliente, monto);
    }

    @Test
    void testMontoCreditoValido() {
        double montoCredito = credito.getTotalCredito();
        
        assertEquals(true, montoCredito <= 1500000,
                "El monto del crédito no debe superar $1.500.000");
    }

    @Test
    void testSumaImportesDetallesA30IgualTotalFacturaA30() {
        double sumaDetallesA30 = 0;
        for (Detalle detalle : detalles) {
            if (detalle.isEstadoA30()) { 
                sumaDetallesA30 += detalle.getImporte();
            }
        }
        
        assertEquals(sumaDetallesA30, factura.calcularTotalA30(),
                "La suma de los importes de los detalles A30 debe ser igual al total A30 de la factura");
        assertEquals(0.0, factura.calcularTotal(),
                "El total normal de la factura debe ser 0 si todo es A30");
    }

    @Test
    void testMontoCompraA30NoSuperaLimiteYSaldoTarjeta() {
        double totalCompraA30 = factura.calcularTotalA30();
        
        assertEquals(true, totalCompraA30 <= 1500000,
                "El total de la compra A30 no debe superar $1.500.000");
        assertEquals(true, tarjeta.tieneSaldoSuficiente(totalCompraA30),
                "El total de la compra A30 no debe superar el saldo disponible en la tarjeta");
    }
}