package client.utils;

public class SpaceMarinesValidators {
    public static void validateName(String name) throws ValidationError {
        if (name == null || name.isEmpty()) {
            throw new ValidationError("Name must be not null or empty.");
        }
    }

    public static void validateHealth(Float health) {
        if (health == null || health <= 0) {
            throw new ValidationError("Health must be positive float number");
        }
    }
    public static void validateHeartCount(Long heartCount) {
        if(heartCount == null || heartCount < 1 || heartCount > 2){
            throw new ValidationError("HeartCount must be positive int number between 1 and 3");
        }
    }


    public static void validateCoordinateX(Float x) {
        if (x == null) {
            throw new ValidationError();
        }
    }

    public static void validateCoordinateY(Integer y) {
        if (y == null) {
            throw new ValidationError();
        }
    }

}
