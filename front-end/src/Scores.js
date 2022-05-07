import { v4 as uuidv4 } from 'uuid';
import axios from "axios";
import alasql from "alasql";
import React, {useEffect, useState} from "react";
var GamesBackend='/api/games';

function unique_id() {
    return uuidv4()
}

function getPlayersWithScores(arrayGamePlayerObjects) {
   let res = alasql('SELECT player->id , ARRAY(_) AS gamePlayer_player FROM ? WHERE score IS NOT NULL GROUP BY player->id',[arrayGamePlayerObjects]);
   let scores_per_all_players_count=[];
   res.map(scores=>{
                    let scores_per_player_count={player:{},losses:0,wins:0,tides:0,total:0};
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
                                                            scores_per_player_count.total=scores_per_player_count.losses+scores_per_player_count.tides+scores_per_player_count.wins;
                                                            })
        scores_per_all_players_count.push(scores_per_player_count)
    })
    return scores_per_all_players_count;
}

export const Scores = () => {
    const [listScores, setScores] = useState({});
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
                const listScores=getPlayersWithScores(listGamePlayers);
                setScores(listScores);
            }
        )

    useEffect(()=>getScores(),[])

   if (typeof(listScores.map) !== 'undefined') {
        return (
            <div>
                <table className="table table-sm table-bordered">
                    <thead><tr key={unique_id()}><th>Player</th><th>Total</th><th>Wins</th><th>Losses</th><th>Tides</th></tr>
                    </thead>
                    <tbody>
               {listScores.map(score => (
                  <tr key={unique_id()}><td>{score.player.firstName}{" "}{score.player.lastName}</td><td>{score.total}</td><td>{score.wins}</td><td>{score.losses}</td><td>{score.tides}</td>
                  </tr>))}

                    </tbody>
                </table>
            </div>
        )

    } else {return <div></div>}
}