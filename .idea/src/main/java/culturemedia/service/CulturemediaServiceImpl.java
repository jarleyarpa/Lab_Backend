package culturemedia.service;

import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import java.util.List;

public class CulturemediaServiceImpl implements CulturemediaService {
    private final VideoRepository videoRepository;
    private final ViewsRepository viewsRepository;

    public CulturemediaServiceImpl(VideoRepository videoRepository, ViewsRepository viewsRepository) {
        this.videoRepository = videoRepository;
        this.viewsRepository = viewsRepository;
    }
    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    @Override
    public Video addVideo(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public View addView(View view) {
        return viewsRepository.save(view);
    }

    @Override
    public List<View> getViewsByVideo(String code) {
        return viewsRepository.findByVideo(code);
    }
}

