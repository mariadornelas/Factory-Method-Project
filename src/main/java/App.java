import java.util.List;

public class App {

    public static void main(String[] args) {
        System.out.println("=== Central de Monitoramento Industrial ===\n");

        List<SensorFactory> fabricas = List.of(
                new SensorTemperaturaFactory(),
                new SensorPressaoFactory()
        );

        double[] leiturasTemperatura = {45.0, 75.0, 95.0};
        double[] leiturasPressao = {5.0, 9.0, 13.0};

        for (SensorFactory fabrica : fabricas) {
            double[] leituras = fabrica.getTipoSensor().equals("TEMPERATURA")
                    ? leiturasTemperatura
                    : leiturasPressao;

            System.out.println("--- Sensor: " + fabrica.getTipoSensor() + " ---");
            for (double valor : leituras) {
                ResultadoLeitura resultado = fabrica.realizarLeitura(valor);
                System.out.println(resultado);
            }
            System.out.println();
        }
    }
}
