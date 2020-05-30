package com.nathan.example.explorecali.data.repo;

import com.nathan.example.explorecali.data.entity.Explorer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExplorerRepository extends JpaRepository<Explorer, Integer> {
}
