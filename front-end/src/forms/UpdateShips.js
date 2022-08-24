import axios from "axios";
import {useState} from "react";
const UpdateShipsEndPoint="/api/updateships/"

export async  function UpdateShipsPromise(data,gameid) {
    let UpdateShipsEndPointGameid=UpdateShipsEndPoint+gameid;
    //console.log(UpdateShipsEndPointGameid)
    var updateShipsResponse = await axios.post(UpdateShipsEndPointGameid, data)
        .then(response => response)
        .catch(error => {
            console.error('Something went wrong!', error);});
       return updateShipsResponse;
}

export const UpdateShips=(data,gameid) =>{

    async function UpdateShips(){
        var dataShipsUpdate = await UpdateShipsPromise(data,gameid);
        console.log(dataShipsUpdate)

    }
    UpdateShips(data,gameid)

}