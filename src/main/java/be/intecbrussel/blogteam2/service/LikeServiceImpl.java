package be.intecbrussel.blogteam2.service;

import be.intecbrussel.blogteam2.exception.ResourceNotFoundException;
import be.intecbrussel.blogteam2.models.Like;
import be.intecbrussel.blogteam2.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Override
    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }

    @Override
    public ResponseEntity<Like> getLikeById(Long id) {
        Like like = likeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Like not found with id: " + id));
        return ResponseEntity.ok(like);
    }

    @Override
    public Like createLike(Like like) {
        return likeRepository.save(like);
    }

    @Override
    public ResponseEntity<Void> deleteLike(Long id) {
        Like like = likeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Like not found with id: " + id));
        likeRepository.delete(like);
        return ResponseEntity.noContent().build();
    }
}
