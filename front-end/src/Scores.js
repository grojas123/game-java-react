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
    //let res = alasql('SELECT game_id,player,score FROM ? WHERE score',[arrayGamePlayerObjects]);
    //console.log(res);
    let res01 = alasql('SELECT player->id , ARRAY(_) AS gamePlayer_per_player FROM ? WHERE score GROUP BY player->id',[arrayGamePlayerObjects]);
    console.log(res01);
    /*var data = [{
        "crs": null,
        "type": "FeatureCollection",
        "features": [
            {
                "geometry": {
                    "type": "Point",
                    "coordinates": [
                        -122.382626,
                        47.6657641
                    ]
                },
                "type": "Feature",
                "id": 18,
                "properties": {
                    "event_set__all": [
                        {
                            "category__category": "Live",
                            "title": "the Tallboys",
                            "cost": "$5",
                            "description": "",
                            "slug": "the-tallboys"
                        }
                    ],
                    "neighborhood__slug": "ballard",
                    "venue": "Tractor Tavern",
                    "neighborhood__neighborhood": "Ballard",
                    "address": "5213 Ballard Ave NW, Seattle, WA 98107, USA",
                    "slug": "tractor-tavern"
                }
            }
        ]
    },
        {
            "crs": null,
            "type": "FeatureCollection",
            "features": [
                {
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            -122.382626,
                            47.6657641
                        ]
                    },
                    "type": "Feature",
                    "id": 18,
                    "properties": {
                        "event_set__all": [
                            {
                                "category__category": "Live1",
                                "title": "the Tallboys",
                                "cost": "$5",
                                "description": "",
                                "slug": "the-tallboys"
                            }
                        ],
                        "neighborhood__slug": "ballard",
                        "venue": "Tractor Tavern",
                        "neighborhood__neighborhood": "Ballard",
                        "address": "5213 Ballard Ave NW, Seattle, WA 98107, USA",
                        "slug": "tractor-tavern"
                    }
                }
            ]
        },
        {
            "crs": null,
            "type": "FeatureCollection",
            "features": [
                {
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            -122.382626,
                            47.6657641
                        ]
                    },
                    "type": "Feature",
                    "id": 18,
                    "properties": {
                        "event_set__all": [
                            {
                                "category__category": "Live1",
                                "title": "the Tallboys",
                                "cost": "$5",
                                "description": "",
                                "slug": "the-tallboys"
                            }
                        ],
                        "neighborhood__slug": "ballard",
                        "venue": "Tractor Tavern",
                        "neighborhood__neighborhood": "Ballard",
                        "address": "5213 Ballard Ave NW, Seattle, WA 98107, USA",
                        "slug": "tractor-tavern"
                    }
                }
            ]
        }];

// This version doesn't work : var res = alasql('SELECT features->0->properties->event_set__all->0->category__category
// AS category, ARRAY(_) AS points FROM ? GROUP BY category',[data]);
    var res = alasql('SELECT features->0->properties->event_set__all->0->category__category , ARRAY(_) AS points FROM ? GROUP BY features->0->properties->event_set__all->0->category__category ',[data]);
    console.log(res);*/

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