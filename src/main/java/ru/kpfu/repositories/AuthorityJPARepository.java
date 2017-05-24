package ru.kpfu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.entities.AuthorityJPA;

/**
 * Created by Anatoly on 23.05.2017.
 */
@Repository
public interface AuthorityJPARepository extends JpaRepository<AuthorityJPA, Integer> {
    AuthorityJPA findByAuthority(String role_user);
}
