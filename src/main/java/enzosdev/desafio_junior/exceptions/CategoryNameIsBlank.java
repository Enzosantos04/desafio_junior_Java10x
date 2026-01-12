package enzosdev.desafio_junior.exceptions;

public class CategoryNameIsBlank extends RuntimeException {
    public CategoryNameIsBlank(String message) {
        super(message);
    }
}
