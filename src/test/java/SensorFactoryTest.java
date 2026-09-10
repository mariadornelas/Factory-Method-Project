import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SensorFactoryTest {

    private static class SensorFake implements LeituraSensor {
        boolean foiChamado = false;
        double valorRecebido;

        @Override
        public ResultadoLeitura ler(double valorMedido) {
            foiChamado = true;
            valorRecebido = valorMedido;
            return new ResultadoLeitura(getTipo(), valorMedido, "NORMAL", "ok");
        }

        @Override
        public String getTipo() {
            return "FAKE";
        }
    }

    @Test
    void deveDelegarLeituraParaOProdutoCriadoPeloFactoryMethod() {
        SensorFake fake = new SensorFake();
        SensorFactory fabrica = new SensorFactory() {
            @Override
            protected LeituraSensor criarSensor() {
                return fake;
            }
        };

        ResultadoLeitura resultado = fabrica.realizarLeitura(42.0);

        assertTrue(fake.foiChamado, "O sensor criado pelo factory method deveria ter sido chamado");
        assertEquals(42.0, fake.valorRecebido);
        assertEquals("NORMAL", resultado.getStatus());
    }

    @Test
    void naoDeveChamarOSensorQuandoOValorForInvalido() {
        SensorFake fake = new SensorFake();
        SensorFactory fabrica = new SensorFactory() {
            @Override
            protected LeituraSensor criarSensor() {
                return fake;
            }
        };

        assertThrows(IllegalArgumentException.class, () -> fabrica.realizarLeitura(-10.0));
        assertFalse(fake.foiChamado, "O sensor não deveria ser chamado quando o valor é inválido");
    }

    @Test
    void getTipoSensorDeveDelegarParaOProdutoCriado() {
        SensorFactory fabrica = new SensorTemperaturaFactory();
        assertEquals("TEMPERATURA", fabrica.getTipoSensor());
    }
}