package com.example.windows.repository;

import com.example.windows.entity.OpeningType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OpeningTypeRepository extends JpaRepository<OpeningType, Long> {
}
