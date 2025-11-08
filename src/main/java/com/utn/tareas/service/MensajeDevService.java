package com.utn.tareas.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class MensajeDevService implements MensajeService {

    @Override
    public void mostrarBienvenida() {
        System.out.println("\n ===========================================");
        System.out.println(" BIENVENIDO AL SISTEMA DE GESTIÓN DE TAREAS");
        System.out.println(" ENTORNO: DESARROLLO");
        System.out.println(" Características:");
        System.out.println("   • Límite de tareas: 10");
        System.out.println("   • Logging extendido activado");
        System.out.println("   • Mensajes detallados");
        System.out.println(" ===========================================\n");
    }

    @Override
    public void mostrarDespedida() {
        System.out.println("EJECUCIÓN COMPLETADA");
    }
}