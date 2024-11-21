package culturemedia.service;

import culturemedia.model.Video;
import culturemedia.model.View;
import java.util.List;

public interface CulturemediaService {
    List<Video> getAllVideos();
    Video addVideo(Video video);
    View addView(View view);
    List<View> getViewsByVideo(String code);
}

