package org.wcci.apimastery.storage;


import org.springframework.stereotype.Service;
import org.wcci.apimastery.entities.Artist;
import org.wcci.apimastery.entities.Comment;
import org.wcci.apimastery.repositories.CommentRepository;

import java.util.Collection;

@Service
public class CommentStorage {
    CommentRepository commentRepo;

    public CommentStorage(CommentRepository commentRepo) {
        this.commentRepo = commentRepo;
    }

    public Comment findById(long id) {
        return commentRepo.findById(id).get();
    }

    public Collection<Comment> getAllComments() {
        return (Collection<Comment>) commentRepo.findAll();
    }

    public void addComment(Comment comment) {
        commentRepo.save(comment);
    }

    public void deleteComment(long commentId) {
        commentRepo.deleteById(commentId);
    }
}
