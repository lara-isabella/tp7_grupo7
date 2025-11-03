package ar.edu.unju.escmi.tp7.tests;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import ar.edu.unju.escmi.tp7.dominio.*;

public class CreditoTest {

    @Test
    public void testMontoTotalNoSuperaLimiteGeneral() {
        Producto producto = new Producto(1L, "Heladera", 1400000, "Argentina");
        Cliente cliente = new Cliente(12345678L, "Lautaro", "San Salvador", "3884000000");
        

        Credito credito = new Credito(cliente, producto);

        assertTrue(credito.validarMonto(), "El monto total no debería superar el límite general de $1.500.000");
    }

    @Test
    public void testMontoTotalSuperaLimiteGeneral() {
        Producto producto = new Producto(2L, "Lavarropas", 1600000, "Argentina");
        Cliente cliente = new Cliente(87654321, "Valentina", "Palpalá", "3884111111");
        TarjetaCredito tarjeta = new TarjetaCredito(123456, LocalDate.now(), 500000, 500000);
        cliente.setTarjeta(tarjeta);

        Credito credito = new Credito(cliente, producto);

        assertFalse(credito.validarMonto(), "El monto total supera el límite permitido de $1.500.000");
    }

    @Test
    public void testMontoNoSuperaLimiteTarjeta() {
        Producto producto = new Producto(3L, "Celular", 700000, "Argentina");
        Cliente cliente = new Cliente(11223344, "Camila", "Perico", "3884222222");
        TarjetaCredito tarjeta = new TarjetaCredito(223456, LocalDate.now(), 500000, 900000);

        cliente.setTarjeta(tarjeta);

        Credito credito = new Credito(cliente, producto);

        assertTrue(credito.validarTarjeta(), "El cliente tiene límite suficiente en su tarjeta");
    }

    @Test
    public void testMontoSuperaLimiteTarjeta() {
        Producto producto = new Producto(4L, "Celular", 850000, "Argentina");
        Cliente cliente = new Cliente(55667788L, "Mateo", "Tilcara", "3884333333");
        TarjetaCredito tarjeta = new TarjetaCredito(334456, LocalDate.now(), 500000, 500000);

        cliente.setTarjeta(tarjeta);

        Credito credito = new Credito(cliente, producto);

        assertFalse(credito.validarTarjeta(), "El monto supera el límite disponible en la tarjeta del cliente");
    }
}
