package enzosdev.desafio_junior.exceptions;

public class CategoryListEmptyException extends RuntimeException {
    public CategoryListEmptyException(String message) {
        super(message);
    }
}
