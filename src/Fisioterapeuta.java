import java.util.ArrayList;
import java.util.List;

/**
 * Fisioterapeuta (PJ): salário base + bônus por tratamentos finalizados recentemente.
 */
public class Fisioterapeuta extends Profissional {
    private static final double SALARIO_FISIO = 6045.0;
    private static final double BONUS_TRATAMENTO = 10.0 / 100.0;
    private static final int TEMPO_BONUS = 60;

    private final List<Tratamento> tratamentos;

    public Fisioterapeuta(String nome, String registro) {
        super(nome, registro);
        this.tratamentos = new ArrayList<>();
    }

    /**
     * Soma SALARIO_FISIO × BONUS_TRATAMENTO para cada tratamento finalizado
     * há no máximo TEMPO_BONUS dias (diasAposFinalizacao entre 0 e TEMPO_BONUS, inclusive).
     */
    private double valorBonus() {

        double valor = 0d;

        for(Tratamento trat : tratamentos) {
            if(trat.diasAposFinalizacao() <= TEMPO_BONUS && trat.diasAposFinalizacao() >= 0) {
                valor += BONUS_TRATAMENTO * SALARIO_FISIO;
            }
        }

        // DONE: percorrer tratamentos e acumular o bônus dos elegíveis
        return valor;
    }

    /**
     * Aloca um tratamento se não houver nenhum tratamento não finalizado.
     * @return a quantidade de tratamentos após a alocação, ou -1 se não foi possível alocar
     */
    public int alocarTratamento(Tratamento tratamento) {
        for (Tratamento t : tratamentos) {
            if (t.diasAposFinalizacao() == -1) {
                return -1;
            }
        }
        tratamentos.add(tratamento);
        return tratamentos.size();
    }

    /**
     * Pagamento = salário base + valorBonus().
     * O valor total deve ser guardado em ultimoPagamento.
     */
    @Override
    public double registrarPagamento() {

        double total = 0d;
        total += SALARIO_FISIO;
        total += valorBonus();

        this.ultimoPagamento = total;

        // DONE: calcular total, armazenar em ultimoPagamento e devolver
        return total;
    }

    @Override
    public String toString() {
        return "Fisioterapeuta " + super.toString() + " | tratamentos=" + tratamentos.size();
    }
}
