package com.eoi.ejemplospringboot.errorcontrol;

import com.eoi.ejemplospringboot.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.eoi.ejemplospringboot.errorcontrol.exceptions.ParametrosIncorrectosException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.Nested;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    private static final  String errorMessageFieldName="mensaje";
    private static final  String errorErrorDescriptionFieldName="error";



    @ExceptionHandler(EntityNotFoundException.class)
    public String handleEntityNotFoundException(EntityNotFoundException ex, Model model) {
        model.addAttribute(errorErrorDescriptionFieldName, "Entidad no localizada");
        model.addAttribute(errorMessageFieldName, ex.getLocalizedMessage());
        return "error";
    }



    @ExceptionHandler(MiEntidadNoEncontradaException.class)
    public String handleMiEntidadNoEncontradaException(MiEntidadNoEncontradaException ex, Model model) {
        model.addAttribute(errorErrorDescriptionFieldName, "Entidad DETERMINADA no localizada");
        model.addAttribute(errorMessageFieldName, ex.getLocalizedMessage());
        return "error";
    }


    @ExceptionHandler(ParametrosIncorrectosException.class)
    public String handleMiOtraExcepcion(ParametrosIncorrectosException ex, Model model) {
        model.addAttribute(errorErrorDescriptionFieldName, "Los parámetros son incorrectos");
        model.addAttribute(errorMessageFieldName, ex.getLocalizedMessage());
        return "error";
    }


    @ExceptionHandler(Exception.class)
    public String handleMiOtraExcepcion(Exception ex, Model model) {
        model.addAttribute(errorErrorDescriptionFieldName, "Excepción no controlada");
        model.addAttribute(errorMessageFieldName, ex.getLocalizedMessage());
        return "error";
    }


    // Clase ErrorResponse para representar la respuesta de error
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class ErrorResponse {
        // Atributos para el mensaje de error, código de estado, detalles, etc.
        private String error;
        private String mensaje;
    }

}

