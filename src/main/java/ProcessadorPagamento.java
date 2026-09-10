public interface ProcessadorPagamento {

    ResultadoPagamento processar(double valor);

    String getTipo();
}
