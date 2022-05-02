package com.codeoftheweb.salvo.repositories;

import com.codeoftheweb.salvo.domain.Player;
import com.codeoftheweb.salvo.domain.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {

}