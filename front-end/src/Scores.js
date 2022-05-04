//import { v4 as uuidv4 } from 'uuid';
import axios from "axios";
import alasql from "alasql";
//import React, {useEffect, useState} from "react";
var GamesBackend='/api/games';

//function unique_id() {
//    return uuidv4()
//}

function getPlayersWithScores(arrayGamePlayerObjects) {
   let res = alasql('SELECT player,score FROM ?  WHERE score',[arrayGamePlayerObjects]);
   return res;
}
export const Scores = () => {
    //const [listScores, setScores] = useState({});
    const getScores = () =>axios.get(GamesBackend)
        .then((response)=>
            {
                var listGamePlayers=[];
                const listGames=response.data;
                const keysListGames=Object.keys(listGames);
                for (const key in keysListGames ){
                    //console.log(listGames[key]);
                    if (typeof(listGames[key]) !== 'undefined'){
                        listGames[key].map(gamePlayer=>{listGamePlayers.push(gamePlayer)})
                    }
                }
               return getPlayersWithScores(listGamePlayers);

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

    }*/}