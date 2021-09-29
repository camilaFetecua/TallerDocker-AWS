# TAREA DE DE MODULARIZACIÓN CON VIRTUALIZACIÓN E INTRODUCCIÓN A DOCKER Y A AWS
## AREP 2021-2 / 30 de Septiembre del 2021

Se debe construir una aplicación con la arquitectura propuesta y desplegarla en AWS 
usando EC2 y Docker.

# Prerrequisitos 
  Para este laboratorio se requiere tener instalado los siguientes programas: 
  + Git: Sistema de control de versiones que almacena cambios sobre un archivo o un 
  conjunto de archivos, permite recuperar versiones previas de esos archivos.
  
  + Maven: Maven es una herramienta open-source, que se creó con el objetivo 
  de simplificar los procesos de build (compilar y generar ejecutables a partir del código
  fuente).
  
  + Docker:Programa encargado de crear contenedores ligeros y portables para las aplicaciones 
  software que puedan ejecutarse en cualquier máquina con Docker instalado, independientemente 
  del sistema operativo que la máquina tenga por debajo, facilitando así también los despliegues.
  
  Para verificar que esten instalados los programas puede usar los suguientes comandos
    + mvn --version
    + git version
    + java --version
    + docker version
    
  ## Instalacion 
   Para descargar el proyecto de GitHub, primero debemos clonar el  repositorio con el siguiente comando
    
    git clone 
    
  Para ejecutar el rpoyecto con la herramienta Maven debemos ejecutar el siguiente comando.
     
     mvn package
     
  ## Bitacora
  
  1.Se crea el proyecto Maven y se crea la clase principal. 
  
 IMAGEN 1 
 
 2. Se crean las imagenes para docker y con Docker compose se deine la estrategia de despliegue sobre Docker y el Docker file que permite definir los archivos como vemos en la siguiente imagen. 

Imagen 2 

3. Usamos el comando docker build --tag dockersparkprimer para crear una referencia a la imagen con el nombre del repositorio donde se quiere subir. Y verificamos que las imagenes esten creadas correctamente.

Imagen 3

4. Creamos contenedores con el siguiente comando 

  docker run -d -p 42000:6000 --name firstdockerimageaws camilaFetecua/firstsprkwebapprepo
  
5. Verificamos que se creen correctamente 

  Imagen 4 
  
6. Creamos una referencia de la imagen y la subimos al repositorio en DockerHub y podemos visualizar el contenedor en DockerHub 

Imagen 5 

7. Creamos una instancia en AWS e instalamos Docker en la maquina.
Imagen 6 
Imagen 7 


8.Instalamos Docker en la maquina aws 
Imagen 13 
9. Configuramos los puertos en el grupo de seguridad 
Evidencia Puertos 
10. A partir de la imagen creada en Dockerhub cree una instancia de un contenedor docker independiente de la consola (opción “-d”) y con el puerto 6000 enlazado a un puerto físico de su máquina (opción -p)
Imagen 14 
11.  Verificamos que las imagenes esten creadas 
Imagen 15 
12. Verificamos el funcionamiento

Imagen 16








  
  
     
     
    
    
  
  
  
  
  
  
