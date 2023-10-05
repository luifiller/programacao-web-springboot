package school.sptech.dynamicfinders.service;

/*
 * @Component -> classes singleton | Usada quando não se enquadra em nenhum dos cases abaixos
 * @Controller -> classes que recebem requisições | Pode fazer MVC, retornando templates HTML
 * @RestController -> classes que recebem requisições e retornam JSON
 * @Service -> classes que executam regras de negócio
 * @Repository -> classes que acessam o banco de dados
 * @Configuration -> classes que configuram o projeto
 * @Bean -> métodos que retornam objetos gerenciados pelo Spring
 * */

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.dynamicfinders.entity.Filme;
import school.sptech.dynamicfinders.exception.EntidadeNaoEncontradaException;
import school.sptech.dynamicfinders.repository.FilmeRepository;

import java.util.List;

@Service
public class FilmeService {
    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public Filme salvarFilme(@Valid Filme filme) {
        return this.filmeRepository.save(filme);
    }

    public List<Filme> listar() {
        return this.filmeRepository.findAll();
    }

    public Filme buscarPorId(int id) {
        return this.filmeRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Filme não encontrado")
        );
    }
}
