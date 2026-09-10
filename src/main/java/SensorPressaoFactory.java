public class SensorPressaoFactory extends SensorFactory {

    @Override
    protected LeituraSensor criarSensor() {
        return new SensorPressao();
    }
}