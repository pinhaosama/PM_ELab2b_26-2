import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Tratamento acompanhado por um fisioterapeuta.
 */
public class Tratamento {
    private final LocalDate iniciadoEm;
    private LocalDate finalizadoEm;
    private final String nome;

    public Tratamento(String nome, LocalDate dataInicio) {
        this.nome = nome;
        this.iniciadoEm = dataInicio;
        this.finalizadoEm = null;
    }

    /**
     * Finaliza o tratamento na data de hoje (LocalDate.now()).
     * @return dias entre início e finalização
     */
    public int finalizar() {
        this.finalizadoEm = LocalDate.now();
        return (int) ChronoUnit.DAYS.between(iniciadoEm, finalizadoEm);
    }

    /**
     * Dias desde a finalização até hoje.
     * @return -1 se o tratamento ainda não foi finalizado
     */
    public int diasAposFinalizacao() {

        if(this.finalizadoEm == null) return -1;

        int dias = finalizadoEm.getDayOfYear() - iniciadoEm.getDayOfYear();

        return dias;

        // DONE: se finalizadoEm == null, devolver -1; senão, dias entre finalizadoEm e LocalDate.now()
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome + " | inicio=" + iniciadoEm + " | fim=" + finalizadoEm;
    }
}
