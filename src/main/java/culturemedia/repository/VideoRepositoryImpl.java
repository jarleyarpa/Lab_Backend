package culturemedia.repository;

import culturemedia.model.Video;
import java.util.ArrayList;
import java.util.List;

public class VideoRepositoryImpl implements VideoRepository {
    private final List<Video> videos = new ArrayList<>();

    @Override
    public List<Video> findAll() {
        return new ArrayList<>(videos);
    }

    @Override
    public Video save(Video video) {
        videos.add(video);
        return video;
    }

    @Override
    public List<Video> find(String title) {
        List<Video> result = new ArrayList<>();
        for (Video video : videos) {
            if (video.title().equalsIgnoreCase(title)) {
                result.add(video);
            }
        }
        return result;
    }

    @Override
    public List<Video> find(Double fromDuration, Double toDuration) {
        List<Video> result = new ArrayList<>();
        for (Video video : videos) {
            if (video.duration() >= fromDuration && video.duration() <= toDuration) {
                result.add(video);
            }
        }
        return result;
    }
}
