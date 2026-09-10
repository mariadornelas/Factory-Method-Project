public class CartaoCreditoFactory extends PagamentoFactory {

    @Override
    protected ProcessadorPagamento criarProcessador() {
        return new ProcessadorCartaoCredito();
    }
}