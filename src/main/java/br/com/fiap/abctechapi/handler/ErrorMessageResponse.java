package br.com.fiap.abctechapi.handler;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessageResponse {
    private Integer statusCode;
    private Date date;
    private String message;
    private String description;
}
