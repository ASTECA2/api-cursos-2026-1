package app.categorias;

import org.springframework.stereotype.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepo;

    public Iterable<CategoriaDTO> findAll(){
        return categoriaRepo.findAll().stream().map(CategoriaDTO::new).toList();
    }

    public CategoriaDTO findOne(long id) {
        Optional<Categoria> resultado = categoriaRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Categoria não encontrada"
            );
        }

        return new CategoriaDTO(resultado.get());
    }

    public CategoriaDTO insert(CategoriaInsertDTO dados) {
        Categoria Categoria = new Categoria();
        Categoria.setNome(dados.nome());
        return new CategoriaDTO(categoriaRepo.save(Categoria));
    }

    public CategoriaDTO update(long id, CategoriaInsertDTO dados) {
        Optional<Categoria> resultado = categoriaRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Categoria não encontrada"
            );
        }

        resultado.get().setNome(dados.nome());
        return new CategoriaDTO(categoriaRepo.save(resultado.get()));
    }

    public void delete(long id) {
        if(!categoriaRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Categoria não encontrada"
            );
        }
        categoriaRepo.deleteById(id);
    }
}