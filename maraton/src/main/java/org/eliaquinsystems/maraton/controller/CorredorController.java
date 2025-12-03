package org.eliaquinsystems.maraton.controller;

import org.eliaquinsystems.maraton.entity.Corredor;
import org.eliaquinsystems.maraton.repository.CorredorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/corredores")
public class CorredorController {

    @Autowired
    private CorredorRepository corredorRepository;

    @GetMapping
    public List<Corredor> getAllCorredores() {
        return corredorRepository.findAll();
    }

    @PostMapping
    public Corredor createCorredor(@RequestBody Corredor corredor) {
        return corredorRepository.save(corredor);
    }

    @GetMapping("/{id}")
    public Corredor getCorredorById(@PathVariable Long id) {
        return corredorRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Corredor updateCorredor(@PathVariable Long id, @RequestBody Corredor detalles) {
        Corredor corredor = corredorRepository.findById(id).orElse(null);
        if (corredor != null) {
            corredor.setNombre(detalles.getNombre());
            corredor.setEdad(detalles.getEdad());
            corredor.setCategoria(detalles.getCategoria());
            corredor.setTiempo(detalles.getTiempo());
            return corredorRepository.save(corredor);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteCorredor(@PathVariable Long id) {
        corredorRepository.deleteById(id);
        return "Corredor eliminado con éxito";
    }
}
