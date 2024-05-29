package demo.exceptions.handlers;

import demo.controllers.BotAPI_VKController;
import demo.exceptions.IncorrectSecretException;
import demo.exceptions.SendResponseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice(assignableTypes = BotAPI_VKController.class)
public class ExceptionsHandler {

    @ExceptionHandler(IncorrectSecretException.class)
    public void handleIncorrectSecretException(IncorrectSecretException ex) {
        log.error("error: {}", ex.getMessage());
    }

    @ExceptionHandler(SendResponseException.class)
    public void handleSendResponseException(SendResponseException ex) {
        log.error("error: {}", ex.getMessage());
        ex.printStackTrace();
    }
}