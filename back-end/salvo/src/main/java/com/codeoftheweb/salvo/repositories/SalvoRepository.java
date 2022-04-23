package com.codeoftheweb.salvo.repositories;

import com.codeoftheweb.salvo.domain.Salvo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalvoRepository extends JpaRepository<Salvo, Long> {
}