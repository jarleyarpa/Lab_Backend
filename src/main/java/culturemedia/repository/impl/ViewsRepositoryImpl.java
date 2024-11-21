package culturemedia.repository.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import culturemedia.model.View;
import culturemedia.repository.ViewsRepository;

public class ViewsRepositoryImpl implements ViewsRepository {

    private final List<View> views;

    public ViewsRepositoryImpl() {
        this.views = new ArrayList<>();
    }

    @Override
    public List<View> findAll() {
        return List.of();
    }

    @Override
    public View save(View view) {
        this.views.add( view );
        return view;
    }

    @Override
    public List<View> findByUserFullName(String userFullName) {
        return List.of();
    }

    @Override
    public List<View> findByStartPlayingTime(LocalDateTime startPlayingTime) {
        return List.of();
    }

    @Override
    public List<View> findByAgeRange(int minAge, int maxAge) {
        return List.of();
    }

    @Override
    public List<View> findByVideo(String code) {
        return List.of();
    }
}