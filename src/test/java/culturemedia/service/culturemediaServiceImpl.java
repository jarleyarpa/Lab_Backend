package service;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.service.culturemediaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class culturemediaServiceImpl {

    private culturemediaService culturemediaService;

    @BeforeEach
    void init() {
        culturemediaService = new culturemediaService() {
            @Override
            public List<Video> getAllVideos() throws VideoNotFoundException {
                return List.of();
            }

            @Override
            public Video addVideo(Video video) {
                return null;
            }

            @Override
            public View addView(View view) {
                return null;
            }

            @Override
            public List<View> getViewsByVideo(String code) {
                return List.of();
            }
        };
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
        assertThrows(VideoNotFoundException.class, () -> {
            culturemediaService.getAllVideos();
        });
    }
}
