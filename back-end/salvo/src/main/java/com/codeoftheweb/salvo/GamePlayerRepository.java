package com.codeoftheweb.salvo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource
public interface  GamePlayerRepository extends JpaRepository<GamePlayer,Long> {
    List<GamePlayer> findByid(Long id);
    List<GamePlayer> findByPlayer_Id(Long id);
    List<GamePlayer> findByGame_Id(Long id);
   // @Query("SELECT gamePlayerCreationDate from GamePlayer")
   // List<GamePlayer> findGamelayer01();

}