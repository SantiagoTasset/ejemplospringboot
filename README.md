# Proyecto de ejemplo Springboot EOI

## Introducción

El Proyecto de Ejemplo Spring Boot EOI es una aplicación guía diseñada para facilitar el aprendizaje de Spring Boot, un poderoso framework de desarrollo de aplicaciones Java. Spring Boot simplifica la creación de aplicaciones empresariales, proporcionando una configuración predefinida y una estructura de proyecto fácil de seguir.

Este proyecto de ejemplo utiliza Spring Boot 3.0.7, una versión estable y confiable de Spring Boot en el momento de su desarrollo. Además, se emplean tecnologías y herramientas adicionales como Maven para la gestión de dependencias y el empaquetado en formato JAR, y Java 20 como el lenguaje de programación principal.

Para el desarrollo de esta aplicación, se recomienda el uso del entorno de desarrollo IntelliJ IDEA, conocido por su amplio conjunto de características y facilidades para el desarrollo de aplicaciones Java. También se sugiere la instalación de algunos plugins, como Docker para la gestión de contenedores, JPA Buddy para mejorar la experiencia de desarrollo con JPA y Database Navigator para explorar y administrar bases de datos directamente desde el IDE.


## Software utilizado

En este proyecto, se utilizan las siguientes tecnologías:

- [Spring Boot 3.0.7](https://spring.io/projects/spring-boot): Spring Boot es un framework de desarrollo de aplicaciones Java que facilita la creación de aplicaciones empresariales. La versión 3.0.7 es la utilizada en este proyecto.

- [Maven](https://maven.apache.org/): Maven es una herramienta de gestión de dependencias y construcción de proyectos. Se utiliza para gestionar las dependencias del proyecto y para empacar la aplicación en formato JAR.

- JAR Packaging: El empaquetado en formato JAR es una forma común de distribuir aplicaciones Java. En este proyecto, se utiliza JAR Packaging para empaquetar la aplicación y hacerla fácilmente ejecutable.

- [Java 20](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html): Java 20 es la versión de Java utilizada en este proyecto. Java es un lenguaje de programación ampliamente utilizado para el desarrollo de aplicaciones.


## Configurar el entorno de desarrollo local

Sigue estos pasos para configurar tu entorno de desarrollo local:

### 1. Instalar IntelliJ IDEA

- Descarga [IntelliJ IDEA](https://www.jetbrains.com/idea/) desde el sitio web oficial.
- Sigue las instrucciones de instalación para tu sistema operativo.
- Una vez instalado, ábrelo y configura tu entorno de trabajo según tus preferencias.

### 2. Instalar los plugins indicados

Para aprovechar al máximo el desarrollo en este proyecto, se recomienda instalar los siguientes plugins en IntelliJ IDEA:

- **Docker**: Este plugin te permite gestionar y administrar contenedores Docker directamente desde el IDE, lo que facilita la integración de tus aplicaciones con Docker.
- **JPA Buddy**: El plugin JPA Buddy mejora la experiencia de desarrollo al proporcionar características específicas para trabajar con JPA (Java Persistence API) en tu proyecto.
- **Database Navigator**: Este plugin te permite explorar y administrar bases de datos directamente desde el IDE, lo que facilita la interacción con tu base de datos durante el desarrollo.

### 3. Instalar Docker Desktop

- Descarga [Docker Desktop](https://www.docker.com/products/docker-desktop) según tu sistema operativo.
- Sigue las instrucciones de instalación para tu sistema operativo.
- Una vez instalado, asegúrate de que Docker esté en funcionamiento y configurado correctamente en tu entorno.

Asegúrate de seguir estos pasos para configurar tu entorno de desarrollo local antes de comenzar a trabajar en el proyecto. Esto te permitirá aprovechar al máximo las herramientas y los recursos necesarios para el desarrollo exitoso del proyecto.


## Hacer un Fork del Proyecto

Para hacer un fork del repositorio en GitHub, sigue estos pasos:

1. Navega hasta el repositorio original en GitHub: [ateixeiramunoz/ejemplospringboot](https://github.com/ateixeiramunoz/ejemplospringboot).
2. Haz clic en el botón "Fork" en la parte superior derecha del repositorio.
3. Selecciona tu cuenta de GitHub como destino para el fork.

Una vez completado, tendrás un nuevo repositorio en tu cuenta de GitHub que es una copia del repositorio original. Ahora puedes clonar este fork en tu entorno local y realizar modificaciones según tus necesidades.

## Actualizar el Fork desde la Versión Principal

Para mantener tu fork actualizado con la versión principal en GitHub, puedes seguir estos pasos:

1. Clona tu fork en tu entorno local utilizando el comando `git clone` o una herramienta Git de tu elección.
2. Agrega el repositorio original como un control remoto adicional utilizando el comando `git remote add upstream https://github.com/ateixeiramunoz/ejemplospringboot`. Esto establecerá una conexión entre tu fork y el repositorio original.
3. Verifica los remotos configurados en tu repositorio local utilizando el comando `git remote -v`. Deberías ver tu fork (origin) y el repositorio original (upstream).
4. Para actualizar tu fork, primero debes obtener los cambios del repositorio original ejecutando `git fetch upstream`. Esto traerá las últimas actualizaciones al repositorio local.
5. Después de obtener los cambios, puedes combinarlos con tu rama principal utilizando `git merge upstream/main`. Asegúrate de estar en tu rama principal antes de ejecutar este comando.
6. Si hay conflictos durante la fusión, resuélvelos manualmente editando los archivos afectados.
7. Finalmente, empuja los cambios actualizados a tu fork en GitHub utilizando `git push origin <nombre-de-tu-rama>`.

Con estos pasos, tu fork estará actualizado con los cambios más recientes del repositorio original en GitHub. Puedes repetir este proceso siempre que desees sincronizar tu fork con la versión principal.




## Ejecución del proyecto

Por defecto, el proyecto está configurado para lanzar el perfil "local", el cual utiliza una base de datos H2 en memoria. Esto permite ejecutar la aplicación sin necesidad de configurar una base de datos externa.

Sin embargo, si se elige el perfil "dev", se seleccionará un sistema de conexión en el que deberemos informar las variables de entorno de la base de datos o conectar a una base de datos local de MySQL por defecto. Esto proporciona flexibilidad para utilizar una base de datos más robusta y adecuada para entornos de desarrollo.

La ejecución del proyecto se realiza mediante la configuración de ciertas variables de entorno, que permiten adaptar la aplicación a diferentes escenarios. Estas variables incluyen SPRING_PROFILE para definir el perfil de ejecución, DATABASE_TYPE para especificar el tipo de base de datos a utilizar, DATABASE_NAME para el nombre de la base de datos, DATABASE_USERNAME y DATABASE_PASSWORD para las credenciales de acceso, y DATABASE_HOST y DATABASE_PORT para la ubicación y el puerto del servidor de la base de datos. Además, DATABASE_DRIVER se utiliza para indicar el controlador de la base de datos.

Con el Proyecto de Ejemplo Spring Boot EOI, podrás familiarizarte con los conceptos fundamentales de Spring Boot, incluyendo la configuración automática, la gestión de dependencias, el acceso a bases de datos mediante JPA, entre otros. A través de su estructura organizada y su configuración predefinida, este proyecto te servirá como punto de partida para tus propias aplicaciones basadas en Spring Boot.


## Ejecución del Proyecto en IntelliJ

Sigue estos pasos para ejecutar el proyecto `EjemplospringbootApplication` en IntelliJ:

1. Abre IntelliJ IDEA y selecciona "Open" en la pantalla de inicio.
2. Navega hasta la carpeta del proyecto descargado y haz clic en "Open" para abrirlo en IntelliJ.
3. Espera a que IntelliJ importe y configure el proyecto.
4. Una vez que el proyecto se haya cargado correctamente, busca la clase `EjemplospringbootApplication`. Puedes encontrarla en la ruta `src/main/java/com/eoi/ejemplospringboot/EjemplospringbootApplication.java`.
5. Haz clic derecho en la clase `EjemplospringbootApplication` y selecciona Run 'EjemplospringbootApplication'" para ejecutar la aplicación.
6. IntelliJ compilará y construirá el proyecto, y la aplicación se iniciará.

Si estás utilizando el perfil "local", la aplicación se ejecutará con una base de datos H2 en memoria por defecto. Si deseas utilizar el perfil "dev" con una base de datos MySQL, asegúrate de configurar las variables de entorno necesarias con los detalles de la base de datos, como se describe anteriormente.

Una vez que la aplicación se haya iniciado correctamente, puedes acceder a ella a través de un navegador web en la dirección [http://localhost:8080](http://localhost:8080) (o el puerto especificado en la configuración).

¡Disfruta explorando y probando el proyecto en IntelliJ!




## Integración con Docker

El proyecto trabaja con docker como sistema de contendores.

### Generacion de la imagen

Para generar la imagen Docker del proyecto, es necesario ejecutar el goal Maven del plugin spring-boot llamado build-image. Este plugin proporciona una manera conveniente de empacar la aplicación Spring Boot en una imagen Docker.

La sintaxis para ejecutar el goal Maven build-image es la siguiente:

`mvn spring-boot:build-image`


Al ejecutar este comando, Maven generará la imagen Docker del proyecto, incluyendo todas las dependencias y configuraciones necesarias. La imagen resultante se almacenará localmente y podrá ser utilizada para ejecutar contenedores Docker.

Una vez que la imagen Docker esté generada, puedes lanzar un contenedor utilizando la variable de entorno del perfil "local". Para hacerlo, debes ejecutar la siguiente sentencia:

   ```shell
   docker run --name SpringbootLOCAL -e SPRING_PROFILE=local -p 8080:8080 alejandroteixeira/spring-boot:latest
   ```

Esto levantará un contenedor docker que podrás consultar, igual que antes, en http://localhost:8080


### Variables de entorno

Durante la ejecución del proyecto, se utilizan ciertas variables de entorno para adaptar la aplicación a diferentes escenarios. A continuación se enumeran las variables de entorno utilizadas en este proyecto:

- `SPRING_PROFILE`: Esta variable define el perfil de ejecución de la aplicación.
- `DATABASE_TYPE`: Esta variable especifica el tipo de base de datos que se utilizará.
- `DATABASE_NAME`: Esta variable define el nombre de la base de datos.
- `DATABASE_USERNAME`: Esta variable define el nombre de usuario para acceder a la base de datos.
- `DATABASE_PASSWORD`: Esta variable define la contraseña para acceder a la base de datos.
- `DATABASE_HOST`: Esta variable define la ubicación (host) del servidor de la base de datos.
- `DATABASE_PORT`: Esta variable define el puerto del servidor de la base de datos.
- `DATABASE_DRIVER`: Esta variable define el controlador de la base de datos a utilizar.

Asegúrate de configurar correctamente estas variables de entorno según tus necesidades antes de ejecutar el proyecto.


## Crear un modo de ejecución en IntelliJ con variables de entorno

Sigue estos pasos para crear un modo de ejecución en IntelliJ con las variables de entorno proporcionadas:

1. Abre IntelliJ IDEA y carga el proyecto.
2. Haz clic en la configuración de ejecución en la parte superior derecha de la ventana de IntelliJ (generalmente junto al botón de ejecución verde).
3. Selecciona "Edit Configurations" en el menú desplegable.
4. En la ventana de configuraciones, haz clic en el botón "+" en la esquina superior izquierda y selecciona "Spring Boot" en la lista de opciones.
5. En la sección "Environment", agrega las siguientes variables de entorno con los valores correspondientes:

    - Variable: `SPRING_PROFILE`
      Valor: `dev`

    - Variable: `DATABASE_TYPE`
      Valor: `mysql`

    - Variable: `DATABASE_NAME`
      Valor: `springboot`

    - Variable: `DATABASE_USERNAME`
      Valor: `root`

    - Variable: `DATABASE_PASSWORD`
      Valor: `password`

    - Variable: `DATABASE_HOST`
      Valor: `localhost`

    - Variable: `DATABASE_PORT`
      Valor: `3306`

    - Variable: `DATABASE_DRIVER`
      Valor: `com.mysql.cj.jdbc.Driver`

6. En la parte inferior de la ventana de configuraciones, selecciona la clase principal del proyecto (por ejemplo, `EjemplospringbootApplication`) como el punto de entrada.
7. Haz clic en "Apply" y luego en "OK" para guardar la configuración.

Ahora puedes ejecutar el proyecto en IntelliJ utilizando este modo de ejecución con las variables de entorno especificadas. Asegúrate de seleccionar esta configuración antes de ejecutar el proyecto para utilizar los valores proporcionados.

Recuerda que estos valores son solo un ejemplo y puedes ajustarlos según tus necesidades y configuración específica.


## Levantar un contenedor MySQL con el plugin de Docker en IntelliJ

El plugin de Docker en IntelliJ te permite gestionar y administrar contenedores Docker directamente desde el IDE, lo que facilita la integración de tus aplicaciones con Docker.

Para levantar un contenedor MySQL utilizando el plugin de Docker en IntelliJ en la ventana de servicios, puedes seguir estos pasos:

1. Asegúrate de tener el plugin de Docker instalado en IntelliJ. Si no lo tienes instalado, puedes ir a `File > Settings > Plugins` y buscar "Docker" en el Marketplace de IntelliJ para instalarlo.

2. Abre IntelliJ IDEA y carga tu proyecto.

3. Haz clic en la pestaña "Services" en la parte inferior izquierda de la ventana de IntelliJ para abrir la ventana de servicios.

4. En la ventana de servicios, haz clic derecho en la sección "Images" y selecciona la opción "Pull".

5. En el campo "Image name", ingresa `mysql:latest` para descargar la imagen más reciente de MySQL directamente desde Docker Hub.

6. Haz clic en el botón "OK" para iniciar la descarga de la imagen de MySQL.

7. Una vez descargada la imagen, haz click derecho sobre ella y selecciona la opción "Create Container".

8. En la sección "Port bindings", haz clic en el botón "+" para agregar una nueva asignación de puertos. Especifica el puerto 3036 en el campo "Host port" y el puerto 3306 en el campo "Container port".

9. En la sección "Environment variables", haz clic en el botón "+" para agregar una nueva variable de entorno. Ingresa `MYSQL_ROOT_PASSWORD` como nombre y `password` como valor.

10. Haz clic en el botón "OK" para crear el contenedor.

11. Espera a que el contenedor se inicie correctamente. Puedes verificar el estado del contenedor y los registros en la ventana de servicios.

12. Ahora, puedes conectarte al servidor de MySQL utilizando una herramienta de administración de bases de datos o ejecutando comandos SQL desde la línea de comandos.

- Host: `localhost` o `127.0.0.1`
- Puerto: `3036`
- Nombre de usuario: `root`
- Contraseña: `password`

Recuerda que este es solo un ejemplo y puedes ajustar los valores según tus necesidades, como los puertos de publicación y la contraseña de root.

¡Listo! Ahora tienes un contenedor MySQL en ejecución con la contraseña de root "password" y el puerto 3036 publicado en tu sistema utilizando el plugin de Docker en IntelliJ en la ventana de servicios.



## Ejecutar la aplicación y la base de datos en diferentes contenedores de Docker

Si deseas ejecutar la aplicación y la base de datos en diferentes contenedores de Docker en el mismo sistema, es recomendable crear una red personalizada en el plugin de Docker en IntelliJ y unir el contenedor MySQL a esa red. Esto permite una comunicación fácil y segura entre los contenedores.

Puedes seguir estos pasos para crear una red personalizada y unir el contenedor MySQL a esa red utilizando el plugin de Docker en IntelliJ:

1. Abre IntelliJ IDEA y carga tu proyecto.

2. Haz clic en la pestaña "Services" en la parte inferior izquierda de la ventana de IntelliJ para abrir la ventana de servicios.

3. En la ventana de servicios, haz clic derecho en la sección "Networks" y selecciona la opción "Create Network".

4. En la ventana emergente, ingresa un nombre para la red en el campo "Name" y haz clic en el botón "OK" para crear la red personalizada.

5. Una vez creada la red, haz clic derecho en el contenedor MySQL que creaste antes  y selecciona la opción "Edit Container Settings".

6. En la configuración del contenedor, ve a la sección "Networks" y haz clic en el botón "+" para agregar una nueva red.

7. Selecciona la red personalizada que creaste en el paso anterior y haz clic en el botón "OK" para unir el contenedor MySQL a esa red.

8. Guarda los cambios en la configuración del contenedor. Vuelve a crear el contenedor con la nueva configuración pulsando botón derecho sobre él. 

9. Ahora, puedes crear un nuevo contenedor para ejecutar la aplicación y unirlo a la misma red personalizada.

10. Para crear el contenedor de la aplicación, sigue los pasos mencionados anteriormente para crear un contenedor, pero selecciona la imagen de la aplicación y configura los puertos y variables de entorno según sea necesario. 
    
    Puedes tomar estos como ejemplo:
  
    - Variable: `SPRING_PROFILE`
      Valor: `dev`

    - Variable: `DATABASE_TYPE`
      Valor: `mysql`

    - Variable: `DATABASE_NAME`
      Valor: `springboot`

    - Variable: `DATABASE_USERNAME`
      Valor: `root`

    - Variable: `DATABASE_PASSWORD`
      Valor: `password`

    - Variable: `DATABASE_HOST`
      Valor: `localhost`

    - Variable: `DATABASE_PORT`
      Valor: `3306`

    - Variable: `DATABASE_DRIVER`
      Valor: `com.mysql.cj.jdbc.Driver`

11. En la configuración del contenedor de la aplicación, ve a la sección "Networks" y selecciona la misma red personalizada que seleccionaste para el contenedor MySQL.

12. Guarda los cambios en la configuración del contenedor de la aplicación.

13. Ahora, tanto el contenedor de la aplicación como el contenedor MySQL están conectados a la misma red personalizada, lo que les permite comunicarse entre sí.

Recuerda que este es solo un ejemplo y puedes ajustar los valores y configuraciones según tus necesidades, como los nombres de la red, las imágenes de los contenedores y las variables de entorno.

También puedes lanzar ambas directamente con los comandos:

   ```shell
   docker run -p 3306:3306 --env MYSQL_ROOT_PASSWORD=password --name mysql-server-dev --pull missing --network springboot mysql:latest
   ```

   ```shell
   docker run -p 80:8080 --env DATABASE_HOST=mysql-server-dev --env SPRING_PROFILE=dev --name SpringbootAPP-DESARROLLO --pull missing --network springboot alejandroteixeira/spring-boot:latest
   ```

¡Listo! Ahora puedes ejecutar la aplicación y la base de datos en diferentes contenedores de Docker en el mismo sistema utilizando una red personalizada.

Al ser la versión de desarrollo y no la local, en este caso la hemos publicado en el puerto 80 para diferenciarlas, por lo que podrás acceder directamente desde  [http://localhost](http://localhost)







