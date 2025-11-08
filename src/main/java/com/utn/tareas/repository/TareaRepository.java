package com.utn.tareas.repository;

import com.utn.tareas.model.Tarea;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TareaRepository {
    private final List<Tarea> tareas = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(1);

    public TareaRepository() {
        // Inicializar con tareas de ejemplo
        inicializarTareasEjemplo();
    }

    private void inicializarTareasEjemplo() {
        guardar(new Tarea("Estudiar Spring Boot", Tarea.Prioridad.ALTA));
        guardar(new Tarea("Hacer ejercicio", Tarea.Prioridad.MEDIA));
        guardar(new Tarea("Comprar víveres", Tarea.Prioridad.BAJA));
        guardar(new Tarea("Preparar presentación", Tarea.Prioridad.ALTA));
        guardar(new Tarea("Leer libro", Tarea.Prioridad.MEDIA));
    }

    public Tarea guardar(Tarea tarea) {
        if (tarea.getId() == null) {
            tarea.setId(contadorId.getAndIncrement());
        } else {
            // Si tiene ID, es una actualización - eliminar la existente primero
            eliminarPorId(tarea.getId());
        }
        tareas.add(tarea);
        return tarea;
    }

    public List<Tarea> obtenerTodas() {
        return new ArrayList<>(tareas);
    }

    public Optional<Tarea> buscarPorId(Long id) {
        return tareas.stream()
                .filter(tarea -> tarea.getId().equals(id))
                .findFirst();
    }

    public void eliminarPorId(Long id) {
        tareas.removeIf(tarea -> tarea.getId().equals(id));
    }

    public int contarTareas() {
        return tareas.size();
    }
}