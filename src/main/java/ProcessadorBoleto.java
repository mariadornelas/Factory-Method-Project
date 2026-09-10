import java.time.LocalDate;
import java.util.UUID;

public class ProcessadorBoleto implements ProcessadorPagamento {

    private static final int DIAS_PARA_VENCIMENTO = 3;

    @Override
    public ResultadoPagamento processar(double valor) {
        String idTransacao = gerarIdTransacao();
        LocalDate vencimento = LocalDate.now().plusDays(DIAS_PARA_VENCIMENTO);

        return new ResultadoPagamento(
                true,
                getTipo(),
                idTransacao,
                valor,
                "Boleto emitido com sucesso. Vencimento em " + vencimento
        );
    }

    @Override
    public String getTipo() {
        return "BOLETO";
    }

    private String gerarIdTransacao() {
        return "BOL-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
