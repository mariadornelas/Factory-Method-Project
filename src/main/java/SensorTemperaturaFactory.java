public class SensorTemperaturaFactory extends SensorFactory {

    @Override
    protected LeituraSensor criarSensor() {
        return new SensorTemperatura();
    }
}