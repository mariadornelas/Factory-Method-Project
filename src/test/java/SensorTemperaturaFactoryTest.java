import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SensorTemperaturaFactoryTest {

    private final SensorFactory fabrica = new SensorTemperaturaFactory();

    @Test
    void factoryMethodDeveCriarUmSensorDeTemperatura() {
        // Acesso ao método protegido é possível pois o teste está no mesmo pacote
        LeituraSensor sensor = fabrica.criarSensor();

        assertInstanceOf(SensorTemperatura.class, sensor);
        assertEquals("TEMPERATURA", sensor.getTipo());
    }

    @Test
    void deveRealizarLeituraAtravesDaFabrica() {
        ResultadoLeitura resultado = fabrica.realizarLeitura(50.0);

        assertEquals("NORMAL", resultado.getStatus());
        assertEquals("TEMPERATURA", resultado.getTipoSensor());
    }

    @Test
    void deveLancarExcecaoParaValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> fabrica.realizarLeitura(-5.0));
    }

    @Test
    void getTipoSensorDeveRetornarTemperatura() {
        assertEquals("TEMPERATURA", fabrica.getTipoSensor());
    }
}