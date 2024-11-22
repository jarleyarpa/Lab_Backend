package culturemedia.service;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;
import java.util.List;

public interface culturemediaService {
    List<Video> getAllVideos() throws VideoNotFoundException;
    Video addVideo(Video video);
    View addView(View view);
    List<Video> findByDuration(Double duration, double v) throws VideoNotFoundException;
    List<Video> findByTitle(String title) throws VideoNotFoundException;
}
