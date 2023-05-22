package com.eoi.ejemplospringboot.errorcontrol;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.exceptions.TemplateInputException;

/**
 * Controlador para manejar los errores en la aplicación.
 *
 * <p>Esta clase implementa la interfaz ErrorController de Spring Boot para manejar los errores generados
 * durante la ejecución de la aplicación. Se encarga de mostrar una página de error personalizada
 * dependiendo del tipo de excepción ocurrida.</p>
 *
 * <p>Los principios de programación de Spring Boot y Java que se aplican en esta clase incluyen:</p>
 * <ul>
 *     <li>Inversión de Control (IoC): La clase utiliza la anotación @Autowired para inyectar la instancia
 *     del motor de plantillas TemplateEngine necesaria para procesar las plantillas HTML.</li>
 *     <li>Principio de Abstracción: La clase implementa la interfaz ErrorController, que es parte de la
 *     arquitectura de Spring Boot, proporcionando un contrato genérico para manejar los errores.</li>
 * </ul>
 *
 * @see org.springframework.boot.web.servlet.error.ErrorController
 */
@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @Autowired
    private TemplateEngine templateEngine;

    /**
     * Maneja los errores y muestra una página de error personalizada.
     *
     * @param request La solicitud HTTP que generó el error.
     * @param model   El modelo utilizado para pasar datos a la plantilla HTML.
     * @return El nombre de la plantilla HTML que muestra la página de error.
     */
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        // Obtener la excepción relacionada con el error
        Throwable throwable = (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);

        // Verificar si es una ServletException con una causa de TemplateInputException
        if (throwable instanceof ServletException && throwable.getCause() instanceof TemplateInputException) {
            ServletException servletException = (ServletException) throwable;
            TemplateInputException templateInputException = (TemplateInputException) servletException.getCause();

            // Agregar la lógica de manejo de TemplateInputException según tus necesidades
            model.addAttribute("error", "Error en la carga de la plantilla");
            model.addAttribute("mensaje", templateInputException.getMessage());
            model.addAttribute("causa", templateInputException);

            return "error";
        }
        else {
            // Agregar la lógica de manejo de una excepción genérica según tus necesidades
            model.addAttribute("error", "Error Thymeleaf");
            model.addAttribute("mensaje", throwable.getLocalizedMessage());
            model.addAttribute("causa", throwable);

            return "error";
        }
    }
}

