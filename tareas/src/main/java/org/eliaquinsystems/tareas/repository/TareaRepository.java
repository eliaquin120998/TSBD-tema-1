package org.eliaquinsystems.tareas.repository;

import org.eliaquinsystems.tareas.entity.Tarea;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends MongoRepository<Tarea, String> {
}
