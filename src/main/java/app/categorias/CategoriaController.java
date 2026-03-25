package app.categorias;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public Iterable<CategoriaDTO> list() {
        System.out.println("----GET----");
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public CategoriaDTO getOne(@PathVariable long id) {
        return categoriaService.findOne(id);
    }

    @PostMapping
    public CategoriaDTO insert(@RequestBody CategoriaInsertDTO novacategoria) {
        return categoriaService.insert(novacategoria);
    }

    @PutMapping("/{id}")
    public CategoriaDTO update(@PathVariable long id, @RequestBody CategoriaInsertDTO modif){
        return categoriaService.update(id, modif);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        categoriaService.delete(id);
    }
}