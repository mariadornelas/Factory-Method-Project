public abstract class PagamentoFactory {
    protected abstract ProcessadorPagamento criarProcessador();

    public final ResultadoPagamento processarPagamento(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do pagamento deve ser maior que zero.");
        }

        ProcessadorPagamento processador = criarProcessador();
        return processador.processar(valor);
    }

    public final String getTipoPagamento() {
        return criarProcessador().getTipo();
    }
}
