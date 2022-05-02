package com.asapp.backend.challenge.application.repositories;

import com.asapp.backend.challenge.application.model.data.AuthToken;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AuthTokenRepository extends CrudRepository<AuthToken, String> {

    @Override
    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM tokens WHERE token = (:uuid) AND timestamp >= now() - interval '1 hours' ", nativeQuery = true)
    Optional<AuthToken> findById(String uuid);
}
