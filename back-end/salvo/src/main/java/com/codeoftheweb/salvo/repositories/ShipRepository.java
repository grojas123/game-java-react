package com.codeoftheweb.salvo.repositories;

import com.codeoftheweb.salvo.domain.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShipRepository extends JpaRepository<Ship,Long> {

}
