package biblioteca.biblioteca.sptech.school.service;

import biblioteca.biblioteca.sptech.school.entity.Escritor;
import biblioteca.biblioteca.sptech.school.repository.EscritorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EscritorService {
    private final EscritorRepository escritorRepository;

    public List<Escritor> listarEscritores() {
        return escritorRepository.findAll();
    }

}
