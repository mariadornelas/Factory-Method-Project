import java.time.LocalDateTime;
import java.util.Objects;

public final class ResultadoPagamento {

    private final boolean sucesso;
    private final String tipoPagamento;
    private final String idTransacao;
    private final double valor;
    private final String mensagem;
    private final LocalDateTime dataProcessamento;

    public ResultadoPagamento(boolean sucesso, String tipoPagamento, String idTransacao,
                              double valor, String mensagem) {
        this.sucesso = sucesso;
        this.tipoPagamento = Objects.requireNonNull(tipoPagamento, "tipoPagamento não pode ser nulo");
        this.idTransacao = Objects.requireNonNull(idTransacao, "idTransacao não pode ser nulo");
        this.valor = valor;
        this.mensagem = Objects.requireNonNull(mensagem, "mensagem não pode ser nula");
        this.dataProcessamento = LocalDateTime.now();
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public double getValor() {
        return valor;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataProcessamento() {
        return dataProcessamento;
    }

    @Override
    public String toString() {
        return String.format(
                "ResultadoPagamento{sucesso=%s, tipo='%s', id='%s', valor=R$%.2f, mensagem='%s'}",
                sucesso, tipoPagamento, idTransacao, valor, mensagem);
    }
}

