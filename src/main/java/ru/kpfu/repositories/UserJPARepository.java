package ru.kpfu.repositories;

/**
 * Created by Anatoly on 15.05.2017.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.entities.UserJPA;

@Repository
public interface UserJPARepository extends JpaRepository<UserJPA, Integer> {
    UserJPA findUserJPAByLogin(String login);
}