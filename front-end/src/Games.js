import React, {useEffect, useState} from "react";
import { v4 as uuidv4 } from 'uuid';
import axios from "axios";
import {useNavigate} from "react-router";
var GamesBackend='/api/games';
function unique_id() {
    return uuidv4()
}

const compareTwoValues =(value01,value02) =>{
    return value01 === value02;
}

export const Games = () => {
    const navigate = useNavigate();
    var LocalUsername=localStorage.getItem('username');
    const [listGames, setGames] = useState({});
    const getGames = () =>axios.get(GamesBackend)
        .then((response)=>
            {
                const listGames=response.data;
                //console.log(listGames);
                setGames(listGames);
            }
        )
    useEffect(()=>getGames(),[])

    if (typeof(listGames) !== 'undefined') {
          const keysList=Object.keys(listGames);
          //console.log(keysList);
          //console.log(listGames);
           return (
               <div>
                   <h3>Logged user: {LocalUsername}</h3>
                   <button onClick={()=>navigate('/logout')}>
                       Logout user
                   </button>
               <ul>
                  {keysList.map(key => (listGames[key].map((gameplayer_temp,index) =>

                      (<li className="d-flex justify-content-start" key={unique_id()}>
                          {gameplayer_temp.game_id} {" "}
                          {gameplayer_temp.creation_date} {" "}
                          {gameplayer_temp.player.id} {" "}
                          {gameplayer_temp.player.firstName} {" "}
                          {gameplayer_temp.player.lastName} {" "}
                          {gameplayer_temp.player.email} {" "}
                          {compareTwoValues(gameplayer_temp.player.email,LocalUsername)? <button onClick={()=>navigate('/gameboard/'+ gameplayer_temp.game_id+'/'+index)}>
                              Go to game </button>:<></>}
                      </li>))))}
               </ul>
               </div>)

}}