package service;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ViewsRepositoryImpl;
import culturemedia.service.culturemediaService;
import culturemedia.service.impl.culturemediaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class culturemediaServiceTest {

    private final culturemediaService culturemediaService = new culturemediaServiceImpl(new VideoRepositoryImpl(), new ViewsRepositoryImpl());

    @BeforeEach
    void init() {
    }

    // Helper method to save videos
    void saveVideos() {
        List<Video> videos = List.of(
                new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Título 2", "----", 5.5),
                new Video("03", "Título 3", "----", 4.4),
                new Video("04", "Título 4", "----", 3.5),
                new Video("05", "Clic 5", "----", 5.7),
                new Video("06", "Clic 6", "----", 5.1)
        );

        for (Video video : videos) {
            culturemediaService.addVideo(video);
        }
    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        saveVideos();
        List<Video> videos = culturemediaService.getAllVideos();
        assertEquals(6, videos.size());
    }

    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        assertThrows(VideoNotFoundException.class, culturemediaService::getAllVideos);
    }

    @Test
    void when_FindByTitle_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        saveVideos();
        List<Video> videos = culturemediaService.findByTitle("Título 1");
        assertEquals(1, videos.size());
    }

    @Test
    void when_FindByTitle_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        saveVideos();
        assertThrows(VideoNotFoundException.class, () -> {
            culturemediaService.findByTitle("Título Inexistente");
        });
    }

    @Test
    void when_FindByDuration_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        saveVideos();
        List<Video> videos = culturemediaService.findByDuration(4.0, 5.0);
        assertEquals(3, videos.size());
    }

    @Test
    void when_FindByDuration_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        saveVideos();
        assertThrows(VideoNotFoundException.class, () -> {
            culturemediaService.findByDuration(10.0, 15.0);
        });
    }
}
