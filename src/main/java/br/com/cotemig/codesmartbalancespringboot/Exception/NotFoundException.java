package br.com.cotemig.codesmartbalancespringboot.Exception;

public class NotFoundException extends RuntimeException {
  public NotFoundException(String message) {
    super(message);
  }
}
