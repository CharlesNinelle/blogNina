package be.intecbrussel.blogteam2.service;

import be.intecbrussel.blogteam2.exception.ResourceNotFoundException;
import be.intecbrussel.blogteam2.models.Post;
import be.intecbrussel.blogteam2.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public ResponseEntity<Post> getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
        return ResponseEntity.ok(post);
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public ResponseEntity<Post> updatePost(Long id, Post post) {
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());
        existingPost.setLikes(post.getLikes());
        existingPost.setComments(post.getComments());
        return ResponseEntity.ok(postRepository.save(existingPost));
    }

    @Override
    public ResponseEntity<Void> deletePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
        postRepository.delete(post);
        return ResponseEntity.noContent().build();
    }
}
