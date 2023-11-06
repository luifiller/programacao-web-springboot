package biblioteca.biblioteca.sptech.school.mapper;

import biblioteca.biblioteca.sptech.school.dto.livro.EscLivroResponseDTO;
import biblioteca.biblioteca.sptech.school.dto.livro.LivroEscResponseDTO;
import biblioteca.biblioteca.sptech.school.entity.Escritor;
import biblioteca.biblioteca.sptech.school.entity.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {
    public static LivroEscResponseDTO toLivroEscritorDTO(Livro livro) {
        if (livro == null) {
            return null;
        }

        LivroEscResponseDTO livroEscResponseDTO = new LivroEscResponseDTO();

        livroEscResponseDTO.setNome(livro.getNome());
        livroEscResponseDTO.setAnoPublicacao(String.valueOf(livro.getAnoPublicacao()));
        livroEscResponseDTO.setAutor(livro.getAutor());
        livroEscResponseDTO.setEditora(livro.getEditora());
        livroEscResponseDTO.setGenero(livro.getGenero());
        livroEscResponseDTO.setQuantidadePaginas(livro.getQuantidadePaginas());
        livroEscResponseDTO.setPreco(livro.getPreco());

        livroEscResponseDTO.setEscLivroResponseDTO(toEscritorLivroResponseDTO(livro.getEscritor()));

        return livroEscResponseDTO;
    }

    public static EscLivroResponseDTO toEscritorLivroResponseDTO(Escritor escritor) {
        EscLivroResponseDTO escritor1 = new EscLivroResponseDTO();

        escritor1.setIdade(escritor.getIdade());
        escritor1.setNacionalidade(escritor.getNacionalidade());
        escritor1.setNome(escritor.getNome());
        escritor1.setQuantidadePublicacoes(escritor.getQuantidadePublicacoes());

        return escritor1;
    }
}
