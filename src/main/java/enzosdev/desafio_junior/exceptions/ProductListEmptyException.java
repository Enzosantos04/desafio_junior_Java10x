package enzosdev.desafio_junior.exceptions;

public class ProductListEmptyException extends RuntimeException {
  public ProductListEmptyException(String message) {
    super(message);
  }
}
