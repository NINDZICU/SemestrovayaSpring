package ru.kpfu.service;

/**
 * Created by Anatoly on 15.05.2017.
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.entities.CommentJPA;
import ru.kpfu.entities.GoodJPA;
import ru.kpfu.entities.UserJPA;
import ru.kpfu.repositories.CommentJPARepository;

@Service
public class CommentDAO implements CommentDAOInt {
    @Autowired
    CommentJPARepository commentJPARepository;

    public CommentDAO() {
    }

    public List<CommentJPA> findAllComment() {
        return this.commentJPARepository.findAll();
    }

    public List<CommentJPA> findCommentsByUser(UserJPA userJPA) {
        return this.commentJPARepository.findCommentJPASByUser(userJPA);
    }

    public List<CommentJPA> findCommentsByGood(GoodJPA good) {
        return this.commentJPARepository.findCommentJPASByGood(good);
    }

    public void addComment(CommentJPA comment) {
        this.commentJPARepository.save(comment);
    }

    public void deleteComment(int id) {
        this.commentJPARepository.delete(Integer.valueOf(id));
    }
}

