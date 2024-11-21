package culturemedia.repository;

import culturemedia.model.View;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ViewsRepositoryImpl implements ViewsRepository {
    private final List<View> views = new ArrayList<>();

    @Override
    public List<View> findAll() {
        return new ArrayList<>(views);
    }

    @Override
    public View save(View view) {
        views.add(view);
        return view;
    }

    @Override
    public List<View> findByUserFullName(String userFullName) {
        List<View> result = new ArrayList<>();
        for (View view : views) {
            if (view.userFullName().equalsIgnoreCase(userFullName)) {
                result.add(view);
            }
        }
        return result;
    }

    @Override
    public List<View> findByStartPlayingTime(LocalDateTime startPlayingTime) {
        List<View> result = new ArrayList<>();
        for (View view : views) {
            if (view.starPlayingTime().equals(startPlayingTime)) {
                result.add(view);
            }
        }
        return result;
    }

    @Override
    public List<View> findByAgeRange(int minAge, int maxAge) {
        List<View> result = new ArrayList<>();
        for (View view : views) {
            if (view.age() >= minAge && view.age() <= maxAge) {
                result.add(view);
            }
        }
        return result;
    }

    @Override
    public List<View> findByVideo(String videoCode) {
        List<View> result = new ArrayList<>();
        for (View view : views) {
            if (view.video().code().equals(videoCode)) {
                result.add(view);
            }
        }
        return result;
    }
}
