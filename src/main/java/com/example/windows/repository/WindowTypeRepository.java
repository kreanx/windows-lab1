package com.example.windows.repository;

import com.example.windows.entity.WindowType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WindowTypeRepository extends JpaRepository<WindowType, Long> {

}
