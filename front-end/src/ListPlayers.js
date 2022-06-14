import { v4 as uuidv4 } from 'uuid';
import React, { useState, useEffect }  from 'react';
import axios from 'axios';
// PlayersBackend must be change in Sync with the value in package.json for now is set for the Backend and Frontend will be in the localhost ."http://localhost:8080"
var PlayersBackend='/api/players';

function unique_id() {
                      return uuidv4()
                     }


export const Users = () => {
   const [listPlayers, setPlayers] = useState({});
   const getPlayers = () =>axios.get(PlayersBackend)
                                                    .then((response)=>
                                                   {
                                                        const myPlayers=response.data;
                                                        setPlayers(myPlayers);
                                                   }
                                                            )
    useEffect(()=>getPlayers(),[])
    if (typeof(listPlayers.length) !== 'undefined') {
         return (
            <ul>
              {/*  <AddPlayerForm useStateUsers={[listPlayers, setPlayers]}/>*/}
                {listPlayers.map(player =>
                    (<li className="d-flex justify-content-start" key={unique_id()}> {player.firstName} {player.lastName} {player.email} </li>)
                                 )
                }
            </ul>
        );}
    return (
        <ul> </ul>
           );}

