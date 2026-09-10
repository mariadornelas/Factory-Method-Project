public class PixFactory extends PagamentoFactory {

    @Override
    protected ProcessadorPagamento criarProcessador() {
        return new ProcessadorPix();
    }
}
