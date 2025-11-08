#  Sistema de Gestión de Tareas - Spring Boot

##  Descripción del Proyecto
Este proyecto es una aplicación desarrollada con **Spring Boot** que simula un **Sistema de Gestión de Tareas**.  
El sistema permite administrar una lista de tareas, agregarlas, marcarlas como completadas y visualizar estadísticas generales.  
Además, la aplicación está configurada con **diferentes perfiles de ejecución (`dev` y `prod`)**, lo que permite adaptar su comportamiento y nivel de detalle según el entorno.

El objetivo principal del proyecto es **demostrar el uso de perfiles en Spring Boot**, la configuración mediante archivos `application.yml` y la ejecución controlada según el entorno de desarrollo o producción.

---

## Tecnologías Utilizadas
- **Java 17**
- **Spring Boot 3.x**
- **Maven** como herramienta de construcción
- **Lombok** (opcional, para simplificar código)
- **YAML** para configuración (`application.yml`)
- **Consola / Terminal** para la ejecución

---

##  Instrucciones para Clonar y Ejecutar

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/usuario/sistema-tareas-springboot.git
   cd sistema-tareas-springboot
Verificar instalación de Maven y Java


mvn -v
java -version
Ejecutar el proyecto con perfil dev


mvn spring-boot:run -Dspring-boot.run.profiles=dev
Ejecutar el proyecto con perfil prod

mvn spring-boot:run -Dspring-boot.run.profiles=prodSi el comando mvn no se reconoce, asegurate de tener Apache Maven agregado a las variables de entorno (PATH).

Cómo cambiar entre Profiles
Spring Boot permite manejar distintos profiles para ajustar la configuración de la aplicación sin cambiar el código.
Los perfiles usados son:

Profile	Archivo de Configuración	Descripción
dev	application-dev.yml	Entorno de desarrollo, muestra logs extendidos, mensajes detallados y estadísticas.
prod	application-prod.yml	Entorno de producción, muestra mensajes resumidos, sin estadísticas ni logs detallados.

El cambio de perfil se realiza directamente desde la línea de comandos con el parámetro:


-Dspring-boot.run.profiles=<nombre_del_profile>

Capturas de Pantalla:
<img width="1365" height="513" alt="image" src="https://github.com/user-attachments/assets/6fe829b2-8dd6-4cb8-8825-dbe4b27c44fe" />
<img width="1363" height="430" alt="image" src="https://github.com/user-attachments/assets/0a92bfe6-c6ec-4c19-8341-4e18a6a1cdff" />
<img width="1356" height="315" alt="image" src="https://github.com/user-attachments/assets/c093ac5f-bcbd-4741-9eab-0ec78f6c2cf6" />


Conclusiones Personales
Este proyecto me permitió comprender en profundidad cómo Spring Boot gestiona los diferentes perfiles de configuración y cómo adaptar la aplicación según el entorno de ejecución,
reforcé conceptos sobre inyección de dependencias, configuración modular con YAML, y la importancia de mantener una arquitectura clara y escalable
El uso de perfiles (dev y prod) es muy importante en proyectos reales, ya que facilita la separación entre el entorno de desarrollo y el de producción, reduciendo errores y mejorando la mantenibilidad del sistema.

Autor

Nombre: Tomás Mastropietro

Legajo: (52695)

Materia: Programación III - Alberto Cortez

Año: 2025




