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
   let res = alasql('SELECT player->id , ARRAY(_) AS gamePlayer_per_player FROM ? WHERE score GROUP BY player->id',[arrayGamePlayerObjects]);
    console.log(res);

    return 1;
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
                return (listGamePlayers)

            }
        )
    getScores();
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