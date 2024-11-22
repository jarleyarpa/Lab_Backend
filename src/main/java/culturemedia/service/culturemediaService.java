package culturemedia.service;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;
import java.util.List;

public interface culturemediaService {
    List<Video> getAllVideos() throws VideoNotFoundException;
    Video save(Video video);
    View save(View view);
    List<Video> findByTitle(String title) throws VideoNotFoundException;
    List<Video> findByDuration(Double fromDuration, Double toDuration) throws VideoNotFoundException;
}