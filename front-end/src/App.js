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
import {GameBoardV2} from "./gameview/gameBoardV2";
import {Suspense} from "react";

function App() {
  return (
      <Suspense fallback={<h1>Loading</h1>}>
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
            <Route path="/gameboardnew/:gameid" element={<GameBoardV2/>}/>
            <Route path="/gameboard/:gameid" element={<GameBoard/>}/>
            <Route path="/login" element={<LoginForm/>}/>
            <Route path="/logout" element={<LogoutUser/>}/>
        </Routes>

    </div>
      </Suspense>
  );
}

export default App;
