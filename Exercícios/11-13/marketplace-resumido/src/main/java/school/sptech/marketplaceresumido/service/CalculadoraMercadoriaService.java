package school.sptech.marketplaceresumido.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraMercadoriaService {
    public Double calculaICMS(Double valor) {
        if (valor == null) {
            throw new IllegalArgumentException("Valor não pode ser nulo");
        }

        if (valor == 0) {
            throw new IllegalArgumentException("Valor não pode ser zero");
        }

        if (valor < 0) {
            throw new IllegalArgumentException("Valor não pode ser negativo");
        }

        return valor * 0.18;
    }
}
