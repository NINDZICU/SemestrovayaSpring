package ru.kpfu.service;

/**
 * Created by Anatoly on 15.05.2017.
 */
import java.util.List;
import org.springframework.stereotype.Service;
import ru.kpfu.entities.CommentJPA;
import ru.kpfu.entities.GoodJPA;
import ru.kpfu.entities.UserJPA;

@Service
public interface CommentDAOInt {
    List<CommentJPA> findAllComment();

    List<CommentJPA> findCommentsByUser(UserJPA var1);

    List<CommentJPA> findCommentsByGood(GoodJPA var1);

    void addComment(CommentJPA var1);

    void deleteComment(int var1);
}
