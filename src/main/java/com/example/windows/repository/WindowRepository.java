package com.example.windows.repository;

import com.example.windows.entity.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WindowRepository extends JpaRepository<Window, Long> {

}
