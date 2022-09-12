import axios from "axios";
import {useState} from "react";
const UpdateSalvoEndPoint="/api/updatesalvo/"

export async  function UpdateSalvoPromise(data,gameid) {
    let UpdateSalvoEndPointGameid=UpdateSalvoEndPoint+gameid;

    var updateShipsResponse = await axios.post(UpdateSalvoEndPointGameid, data)
        .then(response => response)
        .catch(error => {
            console.error('Something went wrong!', error);});
       return updateShipsResponse;
}

export const UpdateSalvo=(data,gameid) =>{

    async function UpdateSalvo(){
        var dataSalvoUpdate = await UpdateSalvoPromise(data,gameid);
        //console.log(dataSalvoUpdate);
        return dataSalvoUpdate;
    }
    return UpdateSalvo(data,gameid)

}