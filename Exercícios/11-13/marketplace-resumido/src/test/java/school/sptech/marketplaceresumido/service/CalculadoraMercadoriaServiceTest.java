package school.sptech.marketplaceresumido.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraMercadoriaServiceTest {
    @Test
    @DisplayName("Deve retornar valor correto ao calcular")
    void deveRetornarValorCorretoAoCalcular() {
        CalculadoraMercadoriaService calculadoraMercadoriaService = new CalculadoraMercadoriaService();

        Double icms = calculadoraMercadoriaService.calculaICMS(100.0);
        assertEquals(18.0, icms);
    }

    @Test
    @DisplayName("Deve retornar IllegalArgumentException ao calcular com valor nulo")
    void deveRetornarIllegalArgumentExceptionAoCalcularComValorNulo() {
        CalculadoraMercadoriaService calculadoraMercadoriaService = new CalculadoraMercadoriaService();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadoraMercadoriaService.calculaICMS(null);
        });

        assertEquals("Valor não pode ser nulo", exception.getMessage());

/*        assertThrows(IllegalArgumentException.class, () -> {
            calculadoraMercadoriaService.calculaICMS(null);
        });*/
    }

    @Test
    @DisplayName("Deve retornar IllegalArgumentException ao calcular com valor zero")
    void deveRetornarIllegalArgumentExceptionAoCalcularComValorZero() {
        CalculadoraMercadoriaService calculadoraMercadoriaService = new CalculadoraMercadoriaService();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadoraMercadoriaService.calculaICMS(0.0);
        });

        assertEquals("Valor não pode ser zero", exception.getMessage());

/*        assertThrows(IllegalArgumentException.class, () -> {
            calculadoraMercadoriaService.calculaICMS(0.0);
        });*/
    }

    @Test
    @DisplayName("Deve retornar IllegalArgumentException ao calcular com valor negativo")
    void deveRetornarIllegalArgumentExceptionAoCalcularComValorNegativo() {
        CalculadoraMercadoriaService calculadoraMercadoriaService = new CalculadoraMercadoriaService();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadoraMercadoriaService.calculaICMS(-1.0);
        });

        assertEquals("Valor não pode ser negativo", exception.getMessage());
    }

    // Falha -> quando o teste não passa, por erro de lógica/except/assert
    // Erro -> quando o teste não executa, por erro do desenvolvedor
}