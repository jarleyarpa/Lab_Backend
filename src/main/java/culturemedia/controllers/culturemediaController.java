package culturemedia.controllers;

import java.util.List;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.impl.culturemediaServiceImpl;

private class culturemediaController {

    private final culturemediaServiceImpl culturemediaService;

    public culturemediaController(culturemediaServiceImpl culturemediaService) {
        this.culturemediaService = culturemediaService;
    }

    public List<Video> getAllVideos() throws VideoNotFoundException {
        List<Video> videos = culturemediaService.getAllVideos();
        if (videos == null || videos.isEmpty()) {
            throw new VideoNotFoundException();
        }
        return videos;
    }
}
