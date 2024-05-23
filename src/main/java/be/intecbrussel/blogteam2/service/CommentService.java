package be.intecbrussel.blogteam2.service;

import be.intecbrussel.blogteam2.models.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();
    ResponseEntity<Comment> getCommentById(Long id);
    Comment createComment(Comment comment);
    ResponseEntity<Comment> updateComment(Long id, Comment comment);
    ResponseEntity<Void> deleteComment(Long id);
}
