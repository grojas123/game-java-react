import axios from "axios";
import {useState} from "react";
const CreateGameEndPoint="/api/games"
export async  function AddGamePromise() {
    const data = {};
    var createGameResponse = await axios.post(CreateGameEndPoint, data)
        .then(response => response)
        .catch(error => {
            console.error('Something went wrong!', error);});
       return createGameResponse;
}

export const CreateGameButton=() =>{
    const [playerData,setPlayerData]=useState({});
    const [isUserValidated,setUserValidation]=useState(true);

    async function CreateGame(){
        var dataGameCreate = await AddGamePromise();
        //console.log(dataGameCreate);
        if (typeof(dataGameCreate) !== "undefined"){
            setPlayerData(dataGameCreate);
            setUserValidation(true)

        }
        else if (typeof(dataGameCreate) == "undefined")
        {setUserValidation(false)}

    }
    console.log(playerData)
if (isUserValidated) {
    return <div>

        <button onClick={CreateGame}>Create New Game</button>

    </div>;}
else return <div><button onClick={CreateGame}>AddGame</button>
    User is no validated, pls do login and try again</div>
    /*return <GetDataBackendCreateGame/>*/
}