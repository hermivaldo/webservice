package br.com.hermivaldo.webservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNaoEncontrado extends RuntimeException {

    private String classe;
    private String parametro;
    private String valor;

    public RecursoNaoEncontrado(String classe, String parametro, String valor){
        super(String.format("A classe %s não conseguiu encontrar um %s com valor %s", classe, parametro, valor));
    }
}
