package ru.kpfu.repositories;

/**
 * Created by Anatoly on 15.05.2017.
 */
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.entities.CommentJPA;
import ru.kpfu.entities.GoodJPA;
import ru.kpfu.entities.UserJPA;

@Repository
public interface CommentJPARepository extends JpaRepository<CommentJPA, Integer> {
    List<CommentJPA> findCommentJPASByGood(GoodJPA var1);

    List<CommentJPA> findCommentJPASByUser(UserJPA var1);
}
