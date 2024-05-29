package demo.exceptions;

public class IncorrectSecretException extends RuntimeException {
   public static final String DEFAULT_MESSAGE = "The transmitted secret is incorrect";

   public IncorrectSecretException() {
       super(DEFAULT_MESSAGE);
   }
   public IncorrectSecretException(String message) {
       super(message);
   }
}