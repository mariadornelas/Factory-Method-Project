import java.util.UUID;

public class ProcessadorCartaoCredito implements ProcessadorPagamento {

    private static final double LIMITE_MAXIMO = 50_000.0;
    private static final double TAXA_INTERMEDIACAO = 0.029; // 2,9%

    @Override
    public ResultadoPagamento processar(double valor) {
        String idTransacao = gerarIdTransacao();

        if (valor > LIMITE_MAXIMO) {
            return new ResultadoPagamento(
                    false,
                    getTipo(),
                    idTransacao,
                    valor,
                    String.format("Pagamento recusado: valor excede o limite do cartão (R$ %.2f)", LIMITE_MAXIMO)
            );
        }

        double taxa = valor * TAXA_INTERMEDIACAO;
        return new ResultadoPagamento(
                true,
                getTipo(),
                idTransacao,
                valor,
                String.format("Pagamento aprovado. Taxa de intermediação: R$ %.2f", taxa)
        );
    }

    @Override
    public String getTipo() {
        return "CARTAO_CREDITO";
    }

    private String gerarIdTransacao() {
        return "CC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
