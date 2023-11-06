package biblioteca.biblioteca.sptech.school.service;

import biblioteca.biblioteca.sptech.school.entity.Escritor;
import biblioteca.biblioteca.sptech.school.entity.Livro;
import biblioteca.biblioteca.sptech.school.repository.EscritorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EscritorService {
    private final EscritorRepository escritorRepository;
    private final GeralService geralService;

    public List<Escritor> listarEscritores() {
        return escritorRepository.findAll();
    }

    public void cadastrarEscritor(Escritor escritor2) {
        escritorRepository.save(escritor2);
    }

    public Livro inserirLivro(int idLivro, int idEscritor) {
        Livro livro = geralService.findLivro(idLivro);
        Escritor escritor = geralService.findEscritor(idEscritor);
        livro.setEscritor(escritor);

        List<Livro> livros = escritor.getLivros();
        livros.add(livro);

        escritor.setLivros(livros);
        escritorRepository.save(escritor);

        return geralService.findLivro(livro.getId());
    }

    public Escritor encontrarMaisVelho() {
        return escritorRepository.findFirstByOrderByIdadeDesc()
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Não existe escritor velho."
                        )
                );
    }

    public List<Escritor> encontrarEscritoresComMaisPublicacoes() {
        return escritorRepository.findTop3ByOrderByQuantidadePublicacoesDesc();
    }

    public List<Escritor> encontrarPorNacionalidade(String nacionalidade) {
        return escritorRepository.findEscritorsByNacionalidadeEqualsIgnoreCase(nacionalidade);
    }
}
