    package com.eoi.ejemplospringboot.abstractcomponents;

    import com.eoi.ejemplospringboot.errorcontrol.exceptions.MiEntidadNoEncontradaException;
    import jakarta.persistence.OneToOne;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    /**
     * Controlador genérico para entidades utilizando Spring MVC.
     *
     * <p>Esta clase abstracta proporciona una implementación base para los controladores que trabajan con entidades utilizando Spring MVC.
     * Está parametrizada para que pueda ser utilizada con diferentes tipos de entidades.</p>
     *
     * <p>Los principios de programación de Spring que se aplican con esta clase incluyen:</p>
     * <ul>
     *     <li>Inversión de control (IoC): La clase utiliza la anotación @Autowired para aplicar la inyección de dependencias y obtener una
     *     instancia del servicio genérico {@link GenericServiceWithJPA} necesario para acceder a los datos de la entidad. Esto permite la
     *     separación de responsabilidades y facilita la prueba y la flexibilidad de intercambio de implementaciones.</li>
     *     <li>Inyección de dependencias (DI): El controlador se inyecta con una instancia del servicio genérico {@link GenericServiceWithJPA}
     *     mediante el constructor, lo que permite obtener acceso a los métodos CRUD del servicio y realizar operaciones en la entidad correspondiente.
     *     Esto facilita la reutilización de código y mejora la mantenibilidad y escalabilidad de la aplicación.</li>
     *     <li>Principio de abstracción: La clase proporciona una abstracción común para operaciones CRUD comunes en los controladores que trabajan
     *     con entidades, permitiendo la reutilización de código y la consistencia en la implementación de controladores.</li>
     *     <li>MVC (Modelo-Vista-Controlador): La clase utiliza las anotaciones @Controller y @RequestMapping para gestionar las solicitudes HTTP
     *     y controlar la lógica de negocio correspondiente a las operaciones CRUD en la entidad.</li>
     * </ul>
     *
     *
     * <p>La autocalculación de las URL se realiza de la siguiente manera:</p>
     * <ul>
     *     <li>En el constructor de la clase, se recibe el parámetro "entityName", que representa el nombre de la entidad gestionada por el controlador.</li>
     *     <li>A partir de ese nombre de entidad, se autocalcula la URL base del controlador utilizando la anotación @RequestMapping("/{entityName}"),
     *     lo que permite que todas las rutas definidas en el controlador tengan la forma "/{entityName}/...". Por ejemplo, si el nombre de entidad es "Producto",
     *     la URL base será "/producto".</li>
     *     <li>Además, se autocalcula el prefijo de la entidad utilizando el nombre de entidad en minúsculas. Este prefijo se utiliza para construir las
     *     URLs específicas de cada operación CRUD. Por ejemplo, si el nombre de entidad es "Producto", el prefijo será "/producto/".</li>
     *     <li>En cada método del controlador, se utilizan las anotaciones @GetMapping, @PostMapping, @PutMapping y @DeleteMapping junto con las
     *     variables de ruta para definir las rutas específicas para cada operación CRUD. La URL final se compone concatenando el prefijo de la entidad
     *     con la ruta específica de cada operación. Por ejemplo, la ruta para obtener todas las entidades será "{entityPrefix}all".</li>
     *     <li>Al utilizar variables de ruta en los métodos, como en el caso de @GetMapping("/{id}"), se puede acceder al valor de la variable de ruta
     *     mediante la anotación @PathVariable. Esto permite obtener el identificador de la entidad en las operaciones que lo requieran.</li>
     *     <li>Para redireccionar a otras rutas después de realizar una operación, se utiliza la anotación @PostMapping con la opción "redirect".
     *     Esto permite redirigir a una URL específica, como por ejemplo "redirect:/{entityName}/all", que redirige a la página de listar todas las
     *     entidades después de eliminar una entidad.</li>
     * </ul>
     *
     * @param <T> El tipo de entidad gestionado por el controlador.
     */
    public abstract class MiControladorGenerico<T> {

        protected Class<T> tClass;

        protected String entityName;
        protected String entityPrefix;

        @Autowired
        protected GenericServiceWithJPA<T,?> service;


        /**
         * Maneja la solicitud GET para obtener todas las entidades.
         *
         * @param model El objeto Model para agregar los atributos necesarios.
         * @return El nombre de la plantilla para mostrar todas las entidades.
         */
        @GetMapping("/all")
        public String getAll(Model model) {
            this.entityPrefix = entityName + "/";
            List<T> entities = service.listAll();
            model.addAttribute("entities", entities);
            return entityPrefix+"all-entities"; // Nombre de la plantilla para mostrar todas las entidades
        }

        /**
         * Maneja la solicitud GET para obtener una entidad por su identificador.
         *
         * @param id     El identificador de la entidad.
         * @param model  El objeto Model para agregar los atributos necesarios.
         * @return El nombre de la plantilla para mostrar los detalles de una entidad.
         * @throws MiEntidadNoEncontradaException Si la entidad no se encuentra en la base de datos.
         */
        @GetMapping("/{id}")
        public String getById(@PathVariable Object id,  Model model) throws MiEntidadNoEncontradaException {
                this.entityPrefix = entityName + "/";
                T entity = service.getById(id);
                model.addAttribute("entity", entity);
                return entityPrefix+"entity-details"; // Nombre de la plantilla para mostrar los detalles de una entidad
        }


        /**
         * Maneja la solicitud POST para crear una nueva entidad.
         *
         * @param entity La entidad a crear.
         * @param model  El objeto Model para agregar los atributos necesarios.
         * @return El nombre de la plantilla para mostrar los detalles de la entidad creada.
         */
        @PostMapping("/")
        public String create(@ModelAttribute("entity") T entity, Model model) {
            this.entityPrefix = entityName + "/";
            T createdEntity = service.create((T) entity);
            model.addAttribute("entity", createdEntity);
            return entityPrefix+"entity-details"; // Nombre de la plantilla para mostrar los detalles de la entidad creada
        }

        /**
         * Maneja la solicitud PUT para actualizar una entidad existente.
         *
         * @param id     El identificador de la entidad a actualizar.
         * @param entity La entidad actualizada.
         * @param model  El objeto Model para agregar los atributos necesarios.
         * @return El nombre de la plantilla para mostrar los detalles de la entidad actualizada.
         */
        @PutMapping("/{id}")
        public String update( @ModelAttribute T entity, Model model
                             ) {
            this.entityPrefix = entityName + "/";
            T updatedEntity = service.update((T) entity);
            model.addAttribute("entity", updatedEntity);
            return entityPrefix+"entity-details"; // Nombre de la plantilla para mostrar los detalles de la entidad actualizada

        }


        /**
         * Maneja la solicitud DELETE para eliminar una entidad por su identificador.
         *
         * @param id El identificador de la entidad a eliminar.
         * @return La URL de redirección a la página de listar todas las entidades después de eliminar una entidad.
         */
        @DeleteMapping("/{id}")
        public String delete(@PathVariable Object id) {
            this.entityPrefix = entityName + "/";
            service.delete(id);
            return "redirect:/"+ entityName +"/all"; // Redireccionar a la página de listar todas las entidades después de eliminar una entidad
        }
    }

