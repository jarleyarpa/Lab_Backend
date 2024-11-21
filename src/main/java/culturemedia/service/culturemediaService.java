package culturemedia.service;

import culturemedia.model.Video;
import culturemedia.model.View;
import java.util.List;
import culturemedia.exception.VideoNotFoundException;

public interface culturemediaService {
    List<Video> getAllVideos() throws VideoNotFoundException;
    Video addVideo(Video video);
    View addView(View view);
    List<View> getViewsByVideo(String code);
}

