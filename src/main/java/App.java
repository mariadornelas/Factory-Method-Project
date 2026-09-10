import java.util.List;

public class App {

    public static void main(String[] args) {
        System.out.println("=== Sistema de Processamento de Pagamentos ===\n");

        List<PagamentoFactory> fabricas = List.of(
                new CartaoCreditoFactory(),
                new BoletoFactory(),
                new PixFactory()
        );

        double[] valores = {150.00, 2_500.75, 99_999.00};

        for (PagamentoFactory fabrica : fabricas) {
            System.out.println("--- " + fabrica.getTipoPagamento() + " ---");
            for (double valor : valores) {
                ResultadoPagamento resultado = fabrica.processarPagamento(valor);
                System.out.println(resultado);
            }
            System.out.println();
        }
    }
}
