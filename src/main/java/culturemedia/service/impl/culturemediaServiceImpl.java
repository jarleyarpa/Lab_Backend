package culturemedia.service.impl;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.service.culturemediaService;

import java.util.List;

public class culturemediaServiceImpl implements culturemediaService {
    private final VideoRepository videoRepository;
    private final ViewsRepository viewsRepository;

    public culturemediaServiceImpl(VideoRepository videoRepository, ViewsRepository viewsRepository) {
        this.videoRepository = videoRepository;
        this.viewsRepository = viewsRepository;
    }

    @Override
    public List<Video> getAllVideos() throws VideoNotFoundException {
        List<Video> videos = videoRepository.findAll();
        if (videos.isEmpty()) {
            throw new VideoNotFoundException();
        } else {
            return videos;
        }
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
