package biblioteca.biblioteca.sptech.school.mapper;

import biblioteca.biblioteca.sptech.school.dto.escritor.EscritorLivroDTO;
import biblioteca.biblioteca.sptech.school.dto.livro.LivroEscritorDTO;
import biblioteca.biblioteca.sptech.school.entity.Escritor;
import biblioteca.biblioteca.sptech.school.entity.Livro;

import java.util.List;

public class EscritorMapper {
    public static EscritorLivroDTO toEscritorLivroDTO(Escritor escritor) {
        if (escritor == null) {
            return null;
        }

        EscritorLivroDTO escritorDTO = new EscritorLivroDTO();

        escritorDTO.setNome(escritor.getNome());
        escritorDTO.setNacionalidade(escritor.getNacionalidade());
        escritorDTO.setQuantidadePublicacoes(escritor.getQuantidadePublicacoes());
        escritorDTO.setIdade(escritor.getIdade());

        if (!escritor.getLivros().isEmpty()) {
            List<Livro> livros = escritor.getLivros();

            List<LivroEscritorDTO> livrosDTO = livros.stream()
                    .map(EscritorMapper::toLivroEscritorDTO)
                    .toList();

            escritorDTO.setLivros(livrosDTO);
        }

        return escritorDTO;
    }

    public static LivroEscritorDTO toLivroEscritorDTO(Livro livro) {
        if (livro == null) {
            return null;
        }

        LivroEscritorDTO livroEscritorDTO = new LivroEscritorDTO();

        livroEscritorDTO.setNome(livro.getNome());
        livroEscritorDTO.setAnoPublicacao(String.valueOf(livro.getAnoPublicacao()));
        livroEscritorDTO.setAutor(livro.getAutor());
        livroEscritorDTO.setEditora(livro.getEditora());
        livroEscritorDTO.setGenero(livro.getGenero());
        livroEscritorDTO.setQuantidadePaginas(livro.getQuantidadePaginas());
        livroEscritorDTO.setPreco(livro.getPreco());

        return livroEscritorDTO;
    }

    // para fazer POST
    public static Escritor toEntity(EscritorLivroDTO escritorDTO) {
        if (escritorDTO == null) {
            return null;
        }

        Escritor escritor = new Escritor();

        escritor.setNome(escritorDTO.getNome());
        escritor.setNacionalidade(escritorDTO.getNacionalidade());
        escritor.setQuantidadePublicacoes(escritorDTO.getQuantidadePublicacoes());
        escritor.setIdade(escritorDTO.getIdade());

        return escritor;
    }
}
