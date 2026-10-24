import java.util.Objects;

/**
 * Profissional da Xulambs Fit. Classe abstrata da hierarquia de remuneração.
 */
public abstract class Profissional {
    private final String nome;
    private final String registro;
    protected double ultimoPagamento;

    protected Profissional(String nome, String registro) {
        this.nome = nome;
        this.registro = registro;
        this.ultimoPagamento = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public String getRegistro() {
        return registro;
    }

    public double getUltimoPagamento() {
        return ultimoPagamento;
    }

    /**
     * Calcula e registra o pagamento do profissional.
     * O valor deve ser armazenado em {@code ultimoPagamento}.
     */
    public abstract double registrarPagamento();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profissional outro)) {
            return false;
        }
        return Objects.equals(registro, outro.registro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registro);
    }

    @Override
    public String toString() {
        return nome + " (" + registro + ") | ultimoPagamento=" + String.format("%.2f", ultimoPagamento);
    }
}
