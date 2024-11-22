package culturemedia.controllers;

import java.util.*;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.impl.culturemediaServiceImpl;

public class culturemediaController {

    private final culturemediaServiceImpl cultureMediaService;

    public culturemediaController(culturemediaServiceImpl cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }

    public List<Video> find_allVideos() throws VideoNotFoundException {
        List<Video> videos = null;
        videos = cultureMediaService.getAllVideos();
        return videos;
    }
}
