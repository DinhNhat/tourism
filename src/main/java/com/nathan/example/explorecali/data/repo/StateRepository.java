package com.nathan.example.explorecali.data.repo;

import com.nathan.example.explorecali.data.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, String> {
}
