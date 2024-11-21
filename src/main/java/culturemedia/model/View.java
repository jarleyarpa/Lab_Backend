package culturemedia.model;

import java.time.LocalDateTime;

public record View(String userFullName, LocalDateTime starPlayingTime, int age, Video video) {
}
