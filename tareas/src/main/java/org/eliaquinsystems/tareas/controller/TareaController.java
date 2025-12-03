package org.eliaquinsystems.tareas.controller;

import org.eliaquinsystems.tareas.entity.Tarea;
import org.eliaquinsystems.tareas.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaRepository tareaRepository;

    // Obtener todas las tareas
    @GetMapping
    public List<Tarea> getAllTareas() {
        return tareaRepository.findAll();
    }

    // Crear una tarea
    @PostMapping
    public Tarea createTarea(@RequestBody Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    // Obtener una tarea por ID
    @GetMapping("/{id}")
    public Tarea getTareaById(@PathVariable String id) {
        return tareaRepository.findById(id).orElse(null);
    }

    // Actualizar una tarea
    @PutMapping("/{id}")
    public Tarea updateTarea(@PathVariable String id, @RequestBody Tarea detalles) {
        Tarea tarea = tareaRepository.findById(id).orElse(null);

        if (tarea != null) {
            tarea.setTitulo(detalles.getTitulo());
            tarea.setDescripcion(detalles.getDescripcion());
            tarea.setCompletada(detalles.isCompletada());
            return tareaRepository.save(tarea);
        }
        return null;
    }

    // Eliminar una tarea
    @DeleteMapping("/{id}")
    public String deleteTarea(@PathVariable String id) {
        tareaRepository.deleteById(id);
        return "Tarea eliminada con éxito";
    }
}
