public abstract class SensorFactory {

    protected abstract LeituraSensor criarSensor();

    public final ResultadoLeitura realizarLeitura(double valorMedido) {
        if (valorMedido < 0) {
            throw new IllegalArgumentException("O valor medido não pode ser negativo.");
        }

        LeituraSensor sensor = criarSensor();
        return sensor.ler(valorMedido);
    }

    public final String getTipoSensor() {
        return criarSensor().getTipo();
    }
}
