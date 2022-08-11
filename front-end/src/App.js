//import logo from './logo.svg';
//import './App.css';
import {Users} from './ListPlayers';
import {ListGames} from './ListGames';
import {CreateGameButton} from './forms/CreateGame';
/*import {GetBoardDataVariable} from './GameViewv3';*/
/*import {GameBoard} from './GameView';*/
import {GameBoard} from './gameview/GameViewv2';
import { Routes,Route } from 'react-router';
import {Scores} from "./Scores";
import LoginForm from "./forms/LoginForm";
import {RegUsers} from "./forms/RegPlayers";
import {LogoutUser} from "./LogoutPlayer";
import {ListGamesToJoin} from "./ListGamesToJoin";
import {ShipsOnGamePlayer} from "./forms/CreateShips";
import {GameBoardv1} from "./gameview/gamboardv1";


function App() {
  return (
    <div className="App">
        <Routes>
            <Route path="/" element ={<LoginForm/>}/>
            <Route path="/games" element ={<ListGames/>}/>
            <Route path="/gamestojoin" element ={<ListGamesToJoin/>}/>
            <Route path="/creategame" element={<CreateGameButton/>}/>
            <Route path="/scores" element ={<Scores/>}/>
            <Route path="/users" element ={<Users/>}/>
            <Route path="/regplayer" element ={<RegUsers/>}/>
            <Route path="/saveships" element={<ShipsOnGamePlayer/>}/>
         {/*  <Route path="/getdata" element={<GetBoardDataVariable/>}/>*/}
            {/*<Route path="/gameboard/:gameid/:gamernumber" element={<GameBoard/>}/>*/}
            <Route path="/gameboardnew" element={<GameBoardv1/>}/>
            <Route path="/gameboard/:gameid" element={<GameBoard/>}/>
            <Route path="/login" element={<LoginForm/>}/>
            <Route path="/logout" element={<LogoutUser/>}/>
        </Routes>

    </div>
  );
}

export default App;
