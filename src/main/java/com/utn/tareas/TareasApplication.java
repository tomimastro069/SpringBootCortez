package com.utn.tareas;

import com.utn.tareas.model.Tarea;
import com.utn.tareas.service.MensajeService;
import com.utn.tareas.service.TareaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TareasApplication implements CommandLineRunner {

	private final TareaService tareaService;
	private final MensajeService mensajeService;

	public TareasApplication(TareaService tareaService, MensajeService mensajeService) {
		this.tareaService = tareaService;
		this.mensajeService = mensajeService;
	}

	public static void main(String[] args) {
		SpringApplication.run(TareasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mensajeService.mostrarBienvenida();

		tareaService.mostrarConfiguracion();

		System.out.println("\nTODAS LAS TAREAS INICIALES:");
		tareaService.listarTodas().forEach(System.out::println);

		System.out.println("\n➕ AGREGANDO NUEVA TAREA...");
		try {
			tareaService.agregarTarea("Revisar documentación de Spring Boot", Tarea.Prioridad.ALTA);
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nTAREAS PENDIENTES:");
		tareaService.listarPendientes().forEach(System.out::println);

		System.out.println("\nMARCANDO TAREA COMO COMPLETADA...");
		try {
			tareaService.marcarComoCompletada(1L);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n" + tareaService.obtenerEstadisticas());

		System.out.println("\nTAREAS COMPLETADAS:");
		tareaService.listarCompletadas().forEach(System.out::println);

		mensajeService.mostrarDespedida();
	}
}