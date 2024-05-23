package be.intecbrussel.blogteam2.service;

import be.intecbrussel.blogteam2.exception.ResourceNotFoundException;
import be.intecbrussel.blogteam2.models.Comment;
import be.intecbrussel.blogteam2.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public ResponseEntity<Comment> getCommentById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id: " + id));
        return ResponseEntity.ok(comment);
    }

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public ResponseEntity<Comment> updateComment(Long id, Comment comment) {
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id: " + id));
        existingComment.setTitle(comment.getTitle());
        existingComment.setLikes(comment.getLikes());
        existingComment.setContext(comment.getContext());
        return ResponseEntity.ok(commentRepository.save(existingComment));
    }

    @Override
    public ResponseEntity<Void> deleteComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id: " + id));
        commentRepository.delete(comment);
        return ResponseEntity.noContent().build();
    }
}
