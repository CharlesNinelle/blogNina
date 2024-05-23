package be.intecbrussel.blogteam2.service;

import be.intecbrussel.blogteam2.models.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    ResponseEntity<Post> getPostById(Long id);
    Post createPost(Post post);
    ResponseEntity<Post> updatePost(Long id, Post post);
    ResponseEntity<Void> deletePost(Long id);
}
