# Sistema de Gestión de Jugadores de Videojuegos

Este proyecto es un sistema de gestión para jugadores de videojuegos. Está diseñado para permitir a los usuarios realizar diversas operaciones sobre los jugadores, como añadir, eliminar, modificar y listar información.

## Características

- **Gestión de Jugadores**: Puedes crear, eliminar y modificar la información de los jugadores.
- **Almacenamiento de Datos**: Los datos de los jugadores se pueden guardar en diferentes tipos de archivos, como:
  - Archivos de texto secuenciales
  - Archivos binarios secuenciales
  - Archivos de objetos binarios
  - Archivos de acceso aleatorio binario
  - Archivos en formato XML
- **Interfaz de Consola**: El sistema tiene una interfaz de usuario simple basada en la consola que permite interactuar fácilmente.

## Estructura del Proyecto

El proyecto sigue un patrón de diseño conocido como MVC (Modelo, Vista, Controlador):

- **Modelo**: Representa los datos del jugador. La clase `Jugador` contiene información como ID, nombre, experiencia, nivel de vida y monedas.
- **Vista**: Maneja la interacción con el usuario. La clase `VisConsola` muestra un menú y recoge la entrada del usuario.
- **Controlador**: Actúa como intermediario entre la vista y el modelo. La clase `Controlador` gestiona las operaciones solicitadas por el usuario.

## Cómo Usar

1. **Clona el repositorio** en tu máquina local.
2. **Compila el proyecto** con un IDE compatible con Java.
3. **Ejecuta el programa** y sigue las instrucciones en la consola para gestionar los jugadores.

## Requisitos

- Java 8 o superior
- IDE compatible con Java (como IntelliJ IDEA o Eclipse)

