import axios from "axios";
const gamePlayerId=13;
const GamesBackendPrefix='/api/games/players/'
const gamePlayerPostfix='/ships'
const AddShipsBackend=GamesBackendPrefix+gamePlayerId+gamePlayerPostfix;
const shipsLocationsTest=[
    {
        "row_id": 0,
        "rowLetter": "A",
        "oneCol": 0,
        "twoCol": 0,
        "thirdCol": 0,
        "fourthCol": 0,
        "fiveCol": 0,
        "sixCol": 0,
        "sevenCol": 0,
        "eighthCol": 0,
        "nineCol": 0,
        "tenCol": 0
    },
    {
        "row_id": 1,
        "rowLetter": "B",
        "oneCol": 1,
        "twoCol": 1,
        "thirdCol": 0,
        "fourthCol": 0,
        "fiveCol": 1,
        "sixCol": 1,
        "sevenCol": 1,
        "eighthCol": 1,
        "nineCol": 0,
        "tenCol": 0
    },
    {
        "row_id": 2,
        "rowLetter": "C",
        "oneCol": 0,
        "twoCol": 0,
        "thirdCol": 0,
        "fourthCol": 0,
        "fiveCol": 0,
        "sixCol": 0,
        "sevenCol": 0,
        "eighthCol": 0,
        "nineCol": 0,
        "tenCol": 0
    },
    {
        "row_id": 3,
        "rowLetter": "D",
        "oneCol": 0,
        "twoCol": 0,
        "thirdCol": 0,
        "fourthCol": 0,
        "fiveCol": 0,
        "sixCol": 0,
        "sevenCol": 0,
        "eighthCol": 0,
        "nineCol": 0,
        "tenCol": 0
    },
    {
        "row_id": 4,
        "rowLetter": "E",
        "oneCol": 0,
        "twoCol": 0,
        "thirdCol": 0,
        "fourthCol": 0,
        "fiveCol": 0,
        "sixCol": 0,
        "sevenCol": 0,
        "eighthCol": 0,
        "nineCol": 1,
        "tenCol": 0
    },
    {
        "row_id": 5,
        "rowLetter": "F",
        "oneCol": 0,
        "twoCol": 0,
        "thirdCol": 1,
        "fourthCol": 0,
        "fiveCol": 0,
        "sixCol": 0,
        "sevenCol": 0,
        "eighthCol": 0,
        "nineCol": 1,
        "tenCol": 0
    },
    {
        "row_id": 6,
        "rowLetter": "G",
        "oneCol": 0,
        "twoCol": 0,
        "thirdCol": 1,
        "fourthCol": 0,
        "fiveCol": 0,
        "sixCol": 0,
        "sevenCol": 0,
        "eighthCol": 0,
        "nineCol": 1,
        "tenCol": 0
    },
    {
        "row_id": 7,
        "rowLetter": "H",
        "oneCol": 0,
        "twoCol": 0,
        "thirdCol": 1,
        "fourthCol": 0,
        "fiveCol": 0,
        "sixCol": 0,
        "sevenCol": 1,
        "eighthCol": 0,
        "nineCol": 0,
        "tenCol": 0
    },
    {
        "row_id": 8,
        "rowLetter": "I",
        "oneCol": 0,
        "twoCol": 0,
        "thirdCol": 1,
        "fourthCol": 0,
        "fiveCol": 0,
        "sixCol": 0,
        "sevenCol": 1,
        "eighthCol": 0,
        "nineCol": 0,
        "tenCol": 0
    },
    {
        "row_id": 9,
        "rowLetter": "J",
        "oneCol": 0,
        "twoCol": 0,
        "thirdCol": 1,
        "fourthCol": 0,
        "fiveCol": 0,
        "sixCol": 0,
        "sevenCol": 1,
        "eighthCol": 0,
        "nineCol": 0,
        "tenCol": 0
    }
]

function CreateShipsOnGamePlayer(BoardShips) {

    const data = {BoardShips};
    axios.post(AddShipsBackend, data)
        .then(response => {console.log(response.data);})
        .catch(error => {
            console.error('Something went wrong!', error);});
}
export const ShipsOnGamePlayer=()=>(
    <div>
    <button onClick={()=>CreateShipsOnGamePlayer(shipsLocationsTest)}>
        Save Ships </button>
    </div>)
