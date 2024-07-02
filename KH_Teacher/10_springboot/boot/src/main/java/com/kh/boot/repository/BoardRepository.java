package com.kh.boot.repository;

import com.kh.boot.domain.entity.Board;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BoardRepository extends JpaRepository<Board, String> {
}
