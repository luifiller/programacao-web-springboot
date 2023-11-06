package biblioteca.biblioteca.sptech.school.mapper;

import biblioteca.biblioteca.sptech.school.dto.escritor.EscritorLivroResponseDTO;
import biblioteca.biblioteca.sptech.school.dto.escritor.EscritorRequestDTO;
import biblioteca.biblioteca.sptech.school.dto.escritor.LivroEscritorResponseDTO;
import biblioteca.biblioteca.sptech.school.entity.Escritor;
import biblioteca.biblioteca.sptech.school.entity.Livro;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
public class EscritorMapper {
    public static EscritorLivroResponseDTO toEscritorLivroDTO(Escritor escritor) {
        if (escritor == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Escritor estava nulo.");
        }

        EscritorLivroResponseDTO escritorDTO = new EscritorLivroResponseDTO();

        escritorDTO.setNome(escritor.getNome());
        escritorDTO.setNacionalidade(escritor.getNacionalidade());
        escritorDTO.setQuantidadePublicacoes(escritor.getQuantidadePublicacoes());
        escritorDTO.setIdade(escritor.getIdade());

        if (!escritor.getLivros().isEmpty()) {
            List<Livro> livros = escritor.getLivros();

            List<LivroEscritorResponseDTO> livrosDTO = livros.stream()
                    .map(EscritorMapper::toLivroEscritorDTO)
                    .toList();

            escritorDTO.setLivros(livrosDTO);
        } else {
            escritorDTO.setLivros(null);
        }

        return escritorDTO;
    }

    public static LivroEscritorResponseDTO toLivroEscritorDTO(Livro livro) {
        if (livro == null) {
            return null;
        }

        LivroEscritorResponseDTO livroEscritorResponseDTO = new LivroEscritorResponseDTO();

        livroEscritorResponseDTO.setNome(livro.getNome());
        livroEscritorResponseDTO.setAnoPublicacao(String.valueOf(livro.getAnoPublicacao()));
        livroEscritorResponseDTO.setAutor(livro.getAutor());
        livroEscritorResponseDTO.setEditora(livro.getEditora());
        livroEscritorResponseDTO.setGenero(livro.getGenero());
        livroEscritorResponseDTO.setQuantidadePaginas(livro.getQuantidadePaginas());
        livroEscritorResponseDTO.setPreco(livro.getPreco());

        return livroEscritorResponseDTO;
    }

    // para fazer POST
    public Escritor toEntity(EscritorRequestDTO escritorDTO) {
        Escritor escritor = new Escritor();

        escritor.setNome(escritorDTO.getNome());
        escritor.setNacionalidade(escritorDTO.getNacionalidade());
        escritor.setQuantidadePublicacoes(escritorDTO.getQuantidadePublicacoes());
        escritor.setIdade(escritorDTO.getIdade());
        escritor.setLivros(null);

        return escritor;
    }
}
