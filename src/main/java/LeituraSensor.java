public interface LeituraSensor {
    ResultadoLeitura ler(double valorMedido);

    String getTipo();
}
