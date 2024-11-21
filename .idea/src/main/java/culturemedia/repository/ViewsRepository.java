package culturemedia.repository;

import culturemedia.model.View;
import java.time.LocalDateTime;
import java.util.List;

public interface ViewsRepository {

    List<View> findAll();
    View save(View view);
    List<View> findByUserFullName(String userFullName);
    List<View> findByStartPlayingTime(LocalDateTime startPlayingTime);
    List<View> findByAgeRange(int minAge, int maxAge);
    List<View> findByVideo(String videoId);
}
