//import { v4 as uuidv4 } from 'uuid';
import axios from "axios";
import alasql from "alasql";
//import React, {useEffect, useState} from "react";
var GamesBackend='/api/games';

/*function unique_id() {
    return uuidv4()
}*/

function getPlayersWithScores(arrayGamePlayerObjects) {
   //console.log(arrayGamePlayerObjects);
   let res = alasql('SELECT player->id , ARRAY(_) AS gamePlayer_player FROM ? WHERE score IS NOT NULL GROUP BY player->id',[arrayGamePlayerObjects]);
   let scores_per_all_players_count=[];
   res.map(scores=>{
                    let scores_per_player_count={player:{},losses:0,wins:0,tides:0};
                    scores.gamePlayer_player.map(score=> {
                                                            scores_per_player_count.player=score.player;
                                                            switch (score.score.score){
                                                                    case 0:
                                                                        scores_per_player_count.losses=scores_per_player_count.losses+1;
                                                                        break;
                                                                    case 0.5 :
                                                                        scores_per_player_count.tides=scores_per_player_count.tides+1;
                                                                        break;
                                                                    case 1 :
                                                                        scores_per_player_count.wins=scores_per_player_count.wins+1;
                                                                        break;
                                                                    default:
                                                                    console.log("No value in scores_per_player_count")
                                                                                    }
                                                            })
        scores_per_all_players_count.push(scores_per_player_count)
    })
    //console.log(scores_per_all_players_count);
    return scores_per_all_players_count;
}

export const Scores = () => {
    //const [listScores, setScores] = useState({});
    const getScores = () =>axios.get(GamesBackend)
        .then((response)=>
            {
                var listGamePlayers=[];
                const listGames=response.data;
                if (typeof(listGames) !== 'undefined') {
                const keysListGames=Object.keys(listGames);
                keysListGames.map(keyGames=>{
                    listGames[keyGames].map(gameplayer=>listGamePlayers.push(gameplayer))
                })}
                getPlayersWithScores(listGamePlayers);
                return getPlayersWithScores(listGamePlayers)

            }
        )
    console.log(getScores());
    return <div></div>
    //useEffect(()=>getScores(),[])

   /* if (typeof(listScores) !== 'undefined') {
        const keysList=Object.keys(listScores);
        //console.log(keysList);
        return (
            <ul>
                {keysList.map(key => (listScores[key].map(gameplayer_temp =>
                    (<li className="d-flex justify-content-start" key={unique_id()}>
                        {gameplayer_temp.game_id} {" "}
                        {gameplayer_temp.creation_date} {" "}
                        {gameplayer_temp.player.id} {" "}
                        {gameplayer_temp.player.firstName} {" "}
                        {gameplayer_temp.player.lastName} {" "}
                        {gameplayer_temp.player.email} </li>))))}
            </ul>)

    }*/
}