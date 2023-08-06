# Prueba Tecnica Sofka 

### Introducción
Automatización para la api publicada de Current weather data -- OpenWeather, realizada por Sara Victoria Padilla
Pruebas al consumo Get, para la consulta del clima actual discriminado por:
Ciudad
Latitud y longitud

La automatizacion esta desarrollada bajo el patron de diseño Scremplay con Bdd.
Archivo de pruebas: weather_information.feature

### Pre requisitos 📋
Java 1.8, update 11 o mayor y JDK (variables de entorno configuradas). Eclipse IDE o IntelliJ IDEA (automatizacion relaizada en versión 2023 de IOntellij). Gradle versión 5.5.1 o mayor (Variables de entono configuradas). Gherkin Plugin (versión actualizada).

### Instalación ⚙️
Para clonar este repositorio localmente, se debe ejecutar el siguiente comando: git clone https://github.com/sara236824/PruebaTecnica.git 
Importar el proyecto desde Eclipse o IntelliJ IDE bajo la estructura de un proyecto Gradle existente. 
Configurar la librería del sistema JRE con JavaSE-1.8. Configurar la codificación a UTF-8 al proyecto una vez importado. 
Compilar el proyecto y generar Wrapper 🔧 
Para construir el proyecto se debe ejecutar el comando: gradle clean build -x test.
Comando de ejecución ▶️ El proyecto se puede ejecutar desde la consola, estando en la carpeta del proyecto con el siguiente comando: gradle clean test --tests=* aggregate --info. 

### Reportes 🎨
El informe Serenity se generará en la carpeta /target/site/serenity/ situada en la carpeta raíz del proyecto.
index.html

### Automatizacion 🛠
La automatización se desarrollo con:
BDD (Behavior-Driven Development) - Patrón de diseño Scremplay - Aplicando principios SOLID Gradle - Libreria  Gherkin

### Convención de programación 🎨
En los automatismos se utilizan los siguientes estilos de escritura:

Variables y funciones: CamelCase minúscula. Ejemplo: nomenclaturaEjemplo. Nombres de clases: PascalCase o UpperCamel Case. Ejemplo: NomenclaturaEjemplo. Nombres de funciones: Snake Case. Ejemplo: nomenclatura_ejemplo. Control de versiones 🔀 Se utiliza Git para el control de versiones.

### Estructura del proyecto Sofka 🚧
La estructura completa del proyecto de automatización es la siguiente:

src/main/java/co/com/sofka/certification/challenge

interactions - Este proyecto en especifico no usa interactions

models Clases con las que se construyen los modelos de datos.

questions Clases con las que se obtienen valores de la aplicación para ser verificados (asserts).

tasks Clases que realizan acciones de alto nivel.

userinterfaces - Al ser proyecto back no se usa esta carpeta

utils Clases que se usan de manera transversal en todo el proyecto.

src/main/resources

log4j2.xml - Este archivo me permite guardar un registro y ver en consola en tiempo real la ejecucion de la prueba y sus resultados.
weathersCode.txt - Este archivo contiene los codigos de los climas, tomasdo de la pagina web https://openweathermap.org/current

src/test/java/co/com/sofka/certification/challenge

runners Clases para ejecutar las automatizaciones con los escenarios indicados en los features.

stepdefinitions Clases que permiten la traducción del lenguaje Gherkin utilizado en los Features a lenguaje máquina, de esta forma posibilitan la ejecución de automatizaciones. Existe una clase Step Definitions general que contiene la configuración y los pasos que se repiten en las otras Step Definitions, por lo tanto la General hereda a las otras. 

src/test/resources/features

features Aquí se encuentran las características del proyecto.

#### QA ✒
Sara Victoria Padilla
