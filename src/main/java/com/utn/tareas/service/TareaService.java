package com.utn.tareas.service;

import com.utn.tareas.model.Tarea;
import com.utn.tareas.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    @Value("${app.nombre:Sistema de Tareas}")
    private String nombreApp;

    @Value("${app.max-tareas:5}")
    private int maxTareas;

    @Value("${app.mostrar-estadisticas:true}")
    private boolean mostrarEstadisticas;

    @Autowired
    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public void agregarTarea(String descripcion, Tarea.Prioridad prioridad) {
        if (tareaRepository.contarTareas() >= maxTareas) {
            throw new IllegalStateException(
                    String.format("No se pueden agregar más de %d tareas. Límite alcanzado.", maxTareas)
            );
        }

        Tarea nuevaTarea = new Tarea(descripcion, prioridad);
        tareaRepository.guardar(nuevaTarea);
        System.out.println("Tarea agregada: " + descripcion);
    }

    public List<Tarea> listarTodas() {
        return tareaRepository.obtenerTodas();
    }

    public List<Tarea> listarPendientes() {
        return tareaRepository.obtenerTodas().stream()
                .filter(tarea -> !tarea.isCompletada())
                .collect(Collectors.toList());
    }

    public List<Tarea> listarCompletadas() {
        return tareaRepository.obtenerTodas().stream()
                .filter(Tarea::isCompletada)
                .collect(Collectors.toList());
    }

    public void marcarComoCompletada(Long id) {
        Tarea tarea = tareaRepository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarea no encontrada con ID: " + id));

        tarea.setCompletada(true);
        tareaRepository.guardar(tarea);
        System.out.println("Tarea marcada como completada: " + tarea.getDescripcion());
    }

    public String obtenerEstadisticas() {
        List<Tarea> todas = tareaRepository.obtenerTodas();
        long total = todas.size();
        long completadas = todas.stream().filter(Tarea::isCompletada).count();
        long pendientes = total - completadas;
        double porcentaje = total > 0 ? (completadas * 100.0) / total : 0;

        return String.format(
                "ESTADÍSTICAS:\n" +
                        "   • Total de tareas: %d\n" +
                        "   • Completadas: %d (%.1f%%)\n" +
                        "   • Pendientes: %d\n" +
                        "   • Límite máximo: %d tareas",
                total, completadas, porcentaje, pendientes, maxTareas
        );
    }

    public void mostrarConfiguracion() {
        System.out.println("\n⚙️  CONFIGURACIÓN ACTUAL:");
        System.out.println("   • Aplicación: " + nombreApp);
        System.out.println("   • Límite de tareas: " + maxTareas);
        System.out.println("   • Mostrar estadísticas: " + (mostrarEstadisticas ? "SÍ" : "NO"));
        System.out.println("   • Tareas actuales: " + tareaRepository.contarTareas() + "/" + maxTareas);
    }
}