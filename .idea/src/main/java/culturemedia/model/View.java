package culturemedia.model;

import java.time.LocalDateTime;

record View(String userFullName, LocalDateTime starPlayingTime, int age, Video video) {
}
