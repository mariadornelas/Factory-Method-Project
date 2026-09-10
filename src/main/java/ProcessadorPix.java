import java.util.UUID;

public class ProcessadorPix implements ProcessadorPagamento {

    @Override
    public ResultadoPagamento processar(double valor) {
        String idTransacao = gerarIdTransacao();

        return new ResultadoPagamento(
                true,
                getTipo(),
                idTransacao,
                valor,
                "Pagamento via Pix confirmado instantaneamente."
        );
    }

    @Override
    public String getTipo() {
        return "PIX";
    }

    private String gerarIdTransacao() {
        return "PIX-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
