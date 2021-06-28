package ua.com.alevel.exeption;

public class NotFoundToDataException extends AccessToDataException {
    public NotFoundToDataException(String data, Class<?> resourceClass) {
        super("The" + resourceClass.getSimpleName() + " with " + data + " not found");
    }

    public NotFoundToDataException(String course) {
        super(course);
    }
}
