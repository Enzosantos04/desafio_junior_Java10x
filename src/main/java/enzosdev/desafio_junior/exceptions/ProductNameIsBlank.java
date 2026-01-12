package enzosdev.desafio_junior.exceptions;

public class ProductNameIsBlank extends RuntimeException {
    public ProductNameIsBlank(String message) {
        super(message);
    }
}
