package be.intecbrussel.blogteam2.service;

import be.intecbrussel.blogteam2.models.Like;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LikeService {
    List<Like> getAllLikes();
    ResponseEntity<Like> getLikeById(Long id);
    Like createLike(Like like);
    ResponseEntity<Void> deleteLike(Long id);
}
