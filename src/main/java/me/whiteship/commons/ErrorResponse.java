package me.whiteship.commons;

import lombok.Data;

import java.util.List;

/**
 * @author Keesun Baik
 */
@Data
public class ErrorResponse {

    private String message;

    private String code;

    private List<FieldError> errors;

    // TODO
    public static class FieldError {
        private String field;
        private String value;
        private String reason;
    }

}
