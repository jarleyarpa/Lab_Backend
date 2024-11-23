package culturemedia.controllers;

import java.util.List;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.impl.culturemediaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class culturemediaController {

    private final culturemediaServiceImpl culturemediaService;

    public culturemediaController(culturemediaServiceImpl culturemediaService) {
        this.culturemediaService = culturemediaService;
    }

    @GetMapping("/videos")
    public List<Video> getAllVideos() throws VideoNotFoundException {
        List<Video> videos = culturemediaService.getAllVideos();
        if (videos == null || videos.isEmpty()) {
            throw new VideoNotFoundException("No Videos Found");
        }
        return videos;
    }

    @PostMapping("/videos")
    public Video save(@RequestBody Video video) {
        culturemediaService.save(video);
        return video;
    }
}
