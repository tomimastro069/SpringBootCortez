package com.utn.tareas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {
    private Long id;
    private String descripcion;
    private boolean completada;
    private Prioridad prioridad;

    public enum Prioridad {
        ALTA, MEDIA, BAJA
    }

    public Tarea(String descripcion, Prioridad prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = false;
    }

    @Override
    public String toString() {
        return String.format("Tarea {id=%d, descripcion='%s', completada=%s, prioridad=%s}",
                id, descripcion, completada ? "SÍ" : "NO", prioridad);
    }
}