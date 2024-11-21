package culturemedia.exception;

import java.text.MessageFormat;

public class VideoNotFoundException extends cultureMediaException {
    public VideoNotFoundException() {
        super("Videos not found");
    }
    public VideoNotFoundException(String title) {
        super(MessageFormat.format("Video with title {0} not found", title)
        );
    }
}