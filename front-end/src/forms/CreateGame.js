import axios from "axios";
import {useState} from "react";
const GameEndPoint="/api/games"
async function GetGames(setGames){
    const getGames =  await axios.get(GameEndPoint)
        .then((response)=>
            {
                const listGames=response.data;
                //console.log(listGames);
                setGames(listGames);
            }
        )

}

export async  function AddGamePromise() {
    const data = {};
    var createGameResponse = await axios.post(GameEndPoint, data)
        .then(response => response)
        .catch(error => {
            console.error('Something went wrong!', error);});
       return createGameResponse;
}

export const CreateGameButton=(gamesProps) =>{
    const [isUserValidated,setUserValidation]=useState(true);

    async function CreateGame(){
        var dataGameCreate = await AddGamePromise();
        //console.log(dataGameCreate.data);
        if (typeof(dataGameCreate) !== "undefined"){
            setUserValidation(true)

        }
        else if (typeof(dataGameCreate) == "undefined")
        {setUserValidation(false)}

    }


function CreateGameAndUpdate() {
        CreateGame();
        setTimeout(function () {GetGames(gamesProps.setGames)},500)

}

    if (isUserValidated) {
    return <div>

        <button onClick={CreateGameAndUpdate}>Create New Game</button>

    </div>;}
else return <div><button onClick={CreateGame}>AddGame</button>
    User is no validated, pls do login and try again</div>

}