import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * Escolha Personal ou Fisioterapeuta e complete 2 testes.
 * Um deles deve obrigatoriamente verificar o pagamento (registrarPagamento).
 */
public class ProfissionalTest {

    @Test 
    public void adicionaMaisQueOMaximoDeAulasAvulsas() {
        // Arrange
        Personal personal = new Personal("Ana", "P001");
        // Act — troque/complete conforme a classe escolhida
        double aulas = personal.addAulaAvulsa(40.0);
        // Assert
        assertEquals("verifica se as aulas avulsas são adicionadas corretamente se adicionadas mais de 30", 30, aulas, 0.001);
    }

    @Test
    public void testaPagamentoRecebidoComSucesso() {
        // Arrange
        Personal ana = new Personal("Ana", "P001");
        // Act — troque/complete conforme a classe escolhida
        ana.addAulaAvulsa(23);
        double total = ana.registrarPagamento();
        // Assert
        assertEquals("verifica se o pagamento é registrado corretamente", 5017.35, total, 0.001);
    }

    // TODO: criar 2 testes unitários (AAA + mensagem na asserção)
    // DONE: um deles deve testar registrarPagamento
}
