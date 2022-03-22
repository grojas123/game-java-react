import React, {useEffect, useState} from "react";
import { v4 as uuidv4 } from 'uuid';
import axios from "axios";
var GamesBackend='/api/games';
function unique_id() {
    return uuidv4()
}
export const Games = () => {
    const [listGames, setGames] = useState({});
    const getGames = () =>axios.get(GamesBackend)
        .then((response)=>
            {
                const listGames=response.data;
                setGames(listGames);
            }
        )
    useEffect(()=>getGames(),[])

    if (typeof(listGames) !== 'undefined') {
        return (
            <ul>
                {Object.keys(listGames).forEach(key => { listGames[key].map(gameplayer_temp =>
                    console.log(gameplayer_temp.game_id,' ',gameplayer_temp.creation_date, ' ',
                                gameplayer_temp.player.id,' ',gameplayer_temp.player.firstName,' ',
                                gameplayer_temp.player.lastName,' ',gameplayer_temp.player.email))}
                )
                }
            </ul>
        );}
    return (
        <ul> </ul>
    );
}