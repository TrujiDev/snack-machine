# Snack Machine

Snack Machine es una aplicación de consola en Java que simula una máquina expendedora de snacks. Los usuarios pueden comprar snacks, ver el ticket de compra y agregar nuevos snacks al sistema. Los datos de los snacks se almacenan y cargan desde un archivo de texto.

## Tabla de contenidos

- [Características](#características)
- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Uso](#uso)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Contribuciones](#contribuciones)

## Características

- Mostrar una lista de snacks disponibles.
- Comprar snacks por su ID.
- Mostrar el ticket de los snacks comprados con el precio total.
- Agregar nuevos snacks al sistema.
- Guardar y cargar los snacks desde un archivo de texto.

## Requisitos

- Java 11 o superior
- Un entorno de desarrollo como IntelliJ IDEA o Eclipse
- Herramientas básicas de compilación (Maven o Gradle si es necesario)

## Instalación

1. Clona el repositorio:

   ```bash
   git clone https://github.com/TrujiDev/snack-machine.git
   ```

2. Navega al directorio del proyecto:

   ```bash
   cd snack-machine
   ```

3. Compila el proyecto con tu entorno de desarrollo Java o ejecuta los siguientes comandos si usas `javac`:

   ```bash
   javac -d out/ src/ui/SnackMachine.java src/service/SnackService.java src/model/Snack.java src/data/SnackData.java
   ```

4. Ejecuta la aplicación:

   ```bash
   java -cp out ui.SnackMachine
   ```

## Uso

Al ejecutar el programa, aparecerá el siguiente menú interactivo:

```
*** Snack Machine ***
1. Buy snack
2. Show ticket
3. Add new snack
4. Exit
Choose an option: 
```

### Opciones del menú:

1. **Comprar un snack**: Elige un snack por su ID para agregarlo al carrito.
2. **Mostrar ticket**: Muestra los snacks comprados y el total a pagar.
3. **Agregar un nuevo snack**: Permite al usuario agregar un nuevo snack con su nombre y precio.
4. **Salir**: Finaliza el programa.

### Funcionalidad de archivo:

- Los snacks se guardan automáticamente en el archivo `snacks.txt` al agregar un nuevo snack o modificar los existentes.
- Al iniciar la aplicación, los snacks se cargan desde este archivo.

## Estructura del proyecto

```bash
├── src/
│   ├── ui/
│   │   └── SnackMachine.java    # Lógica principal de la máquina de snacks
│   ├── service/
│   │   └── SnackService.java    # Maneja las operaciones sobre los snacks
│   ├── model/
│   │   └── Snack.java           # Modelo de datos para los snacks
│   └── data/
│       └── SnackData.java       # Lectura y escritura de snacks en un archivo
└── snacks.txt                   # Archivo de texto donde se guardan los snacks
```

## Contribuciones

Las contribuciones son bienvenidas. Si deseas colaborar en el proyecto, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza los cambios necesarios y haz commit (`git commit -am 'Agrega nueva funcionalidad'`).
4. Sube los cambios a tu fork (`git push origin feature/nueva-funcionalidad`).
5. Crea un pull request describiendo tus cambios.

---