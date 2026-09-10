# Sistema de Monitoramento de Sensores Industriais — Factory Method

---

## Testes implementados

- **Produtos concretos** (`SensorTemperaturaTest`, `SensorPressaoTest`):
  validam os três limiares de classificação (normal, alerta, crítico)
  de cada tipo de sensor.
- **Fábricas concretas** (`SensorTemperaturaFactoryTest`,
  `SensorPressaoFactoryTest`): garantem que cada *Concrete Creator*
  produz a instância correta do produto e que a validação de valor
  negativo é respeitada.
- **`SensorFactoryTest`**: o teste mais importante do ponto de vista do
  padrão — usa um `LeituraSensor` "fake" (subclasse anônima) para
  provar que `SensorFactory.realizarLeitura()` depende **apenas da
  abstração**, sem nenhum acoplamento a uma classe concreta. Isso
  evidencia o polimorfismo obtido com o Factory Method.

---