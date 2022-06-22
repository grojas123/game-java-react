import React, {useEffect, useState} from "react";
import { v4 as uuidv4 } from 'uuid';
import axios from "axios";
import {useNavigate} from "react-router";
var GamesBackend='/api/games';
function unique_id() {
    return uuidv4()
}

export const ListGamesToJoin = () => {

    const navigate = useNavigate();
    var LocalUsername=localStorage.getItem('username');
    const [listGames, setGames] = useState({});
    const getGames = async () =>axios.get(GamesBackend)
        .then((response)=>
            {
                const listGames=response.data;
                //console.log(listGames);
                  return(listGames);
            }
        )
    const getGamesData= async () =>{
        let listGamesData = await getGames();
        const keysList01=Object.keys(listGamesData);
        keysList01.map(function (key)
            {if(listGamesData[key].length===1)
                return listGamesData[key]
                else return delete listGamesData[key]});
        //console.log(resultmap);
        // console.log(listGamesData);
        setGames(listGamesData);
    }
    useEffect(()=>getGamesData(),[])

    if (typeof(listGames) !== 'undefined') {
          const keysList=Object.keys(listGames);


           return (
               <div>
                   <h3>Logged user: {LocalUsername}</h3>
                   <h3>Games waiting pairs to game</h3>
                   <button onClick={()=>navigate('/logout')}>
                       Logout user
                   </button>
               <ul>
                  {keysList.map(key => (listGames[key].map((gameplayer_temp) =>

                      (<li className="d-flex justify-content-start" key={unique_id()}>
                          {gameplayer_temp.game_id} {" "}
                          {gameplayer_temp.creation_date} {" "}
                          {gameplayer_temp.player.id} {" "}
                          {gameplayer_temp.player.firstName} {" "}
                          {gameplayer_temp.player.lastName} {" "}
                          {gameplayer_temp.player.email} {" "}
                           <button onClick={()=>navigate('/gameboard/'+ gameplayer_temp.game_id)}>
                              Join to the game </button>:<></>
                      </li>))))}
               </ul>
               </div>)

}}