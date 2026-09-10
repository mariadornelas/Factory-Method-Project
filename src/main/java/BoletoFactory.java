public class BoletoFactory extends PagamentoFactory {

    @Override
    protected ProcessadorPagamento criarProcessador() {
        return new ProcessadorBoleto();
    }
}
