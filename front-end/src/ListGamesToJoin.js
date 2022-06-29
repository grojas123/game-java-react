import React, {useCallback, useEffect, useState} from "react";
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
    function JoinGame(gameid) {
        var JoinGameEndPoint=GamesBackend+"/join/"+gameid;

        axios.post(JoinGameEndPoint)
            .then(response => {

                console.log(response.data);

            })
            .catch(error => {
                console.error('Something went wrong!', error);});
        //forceUpdate();
    }


    const [listGamesToJoin, setGamesToJoin] = useState({});

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
        setGamesToJoin(listGamesData);
    }

    useEffect(()=>getGamesData(),[])

    function JoinGameGetListGames(gameid){
        JoinGame(gameid)
        setTimeout(function () {getGamesData()},500);
    }
    if (typeof(listGamesToJoin) !== 'undefined') {
          const keysList=Object.keys(listGamesToJoin);


           return (
               <div>
                   <h3>Logged user: {LocalUsername}</h3>
                   <button onClick={()=>navigate('/logout')}>
                       Logout user
                   </button>
                  <h3>Games waiting pairs to play</h3>

               <ul>
                  {keysList.map(key => (listGamesToJoin[key].map((gameplayer_temp) =>

                      (<li className="d-flex justify-content-start" key={unique_id()}>
                          {gameplayer_temp.game_id} {" "}
                          {gameplayer_temp.creation_date} {" "}
                          {gameplayer_temp.player.id} {" "}
                          {gameplayer_temp.player.firstName} {" "}
                          {gameplayer_temp.player.lastName} {" "}
                          {gameplayer_temp.player.email} {" "}
                           <button onClick={()=>{JoinGameGetListGames(gameplayer_temp.game_id)}}>
                              Join to the game </button><></>
                      </li>))))}
               </ul>
               </div>)

}}