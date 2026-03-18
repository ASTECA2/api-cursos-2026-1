package app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import app.record.categoriaDTO;
import app.record.categoriaInsertDTO;
import app.services.categoriaService;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/categorias")
public class categoriaController {
    @Autowired
    private categoriaService categoriaService;

    @GetMapping
    public Iterable<categoriaDTO> list() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public categoriaDTO getOne(@PathVariable long id) {
        return categoriaService.findOne(id);
    }

    @PostMapping
    public categoriaDTO insert(@RequestBody categoriaInsertDTO novacategoria) {
        return categoriaService.insert(novacategoria);
    }

    @PutMapping("/{id}")
    public categoriaDTO update(@PathVariable long id, @RequestBody categoriaInsertDTO modif){
        return categoriaService.update(id, modif);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        categoriaService.delete(id);
    }
}