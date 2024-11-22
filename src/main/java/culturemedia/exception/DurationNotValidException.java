package culturemedia.exception;

public class DurationNotValidException extends cultureMediaException {
    public DurationNotValidException(String title,Double duration) {
        super("The duration of the video:" + title +",it's too short : " + duration);
    }
}