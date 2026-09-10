import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SensorPressaoFactoryTest {

    private final SensorFactory fabrica = new SensorPressaoFactory();

    @Test
    void factoryMethodDeveCriarUmSensorDePressao() {
        LeituraSensor sensor = fabrica.criarSensor();

        assertInstanceOf(SensorPressao.class, sensor);
        assertEquals("PRESSAO", sensor.getTipo());
    }

    @Test
    void deveRealizarLeituraAtravesDaFabrica() {
        ResultadoLeitura resultado = fabrica.realizarLeitura(6.0);

        assertEquals("NORMAL", resultado.getStatus());
        assertEquals("PRESSAO", resultado.getTipoSensor());
    }

    @Test
    void deveLancarExcecaoParaValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> fabrica.realizarLeitura(-1.0));
    }
}