package biblioteca.biblioteca.sptech.school.mapper;

import biblioteca.biblioteca.sptech.school.dto.LivroEscritorDTO;
import biblioteca.biblioteca.sptech.school.entity.Livro;

public class LivroMapper {
    public static LivroEscritorDTO toLivroEscritorDTO(Livro livro) {
        if (livro == null) {
            return null;
        }

        LivroEscritorDTO livroEscritorDTO = new LivroEscritorDTO();

        livroEscritorDTO.setId(livro.getId());
        livroEscritorDTO.setNome(livro.getNome());
        livroEscritorDTO.setAnoPublicacao(String.valueOf(livro.getAnoPublicacao()));
        livroEscritorDTO.setAutor(livro.getAutor());
        livroEscritorDTO.setEditora(livro.getEditora());
        livroEscritorDTO.setGenero(livro.getGenero());
        livroEscritorDTO.setQuantidadePaginas(livro.getQuantidadePaginas());
        livroEscritorDTO.setPreco(livro.getPreco());

        /* if (livro.getEscritor() != null) {
            EscritoLivroResponseDTO escritor = LivroMapper.EscritorToEscritoLivroResponseDTO(livro.getEscritor());
            // CONTINUAR DAQUI...
        }*/

        return livroEscritorDTO;
    }
/*
    public static EscritoLivroResponseDTO EscritorToEscritoLivroResponseDTO(Escritor escritor) {
    }*/
}
