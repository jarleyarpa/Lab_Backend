package culturemedia.service.impl;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.service.culturemediaService;

import java.util.ArrayList;
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

    public List<Video> findByTitle(String title) throws VideoNotFoundException {
        List<Video> videos = videoRepository.findAll();
        List<Video> matchingVideos = new ArrayList<>();
        for (Video video : videos) {
            if (video.title().toLowerCase().contains(title.toLowerCase())) {
                matchingVideos.add(video);
            }
        }
        if(matchingVideos.isEmpty()) {
            throw new VideoNotFoundException(title);
        }
        return matchingVideos;
    }

    public List<Video> findByDuration(Double duration, double v) throws VideoNotFoundException {
        List<Video> videos = videoRepository.findAll();
        List<Video> savedVideos = new ArrayList<>();
        for (Video video : videos) {
            if (video.duration().equals(duration)) {
                savedVideos.add(video);
            }
        }
        if (savedVideos.isEmpty()){
            throw new VideoNotFoundException();
        }
        return savedVideos;
    }
}
