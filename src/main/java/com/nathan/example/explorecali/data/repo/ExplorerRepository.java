package com.nathan.example.explorecali.data.repo;

import com.nathan.example.explorecali.data.entity.Explorer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExplorerRepository extends JpaRepository<Explorer, Integer> {
    Optional<Explorer> findByPersonFirstNameLike(@Param("firstName")String firstName);
}
