//import logo from './logo.svg';
//import './App.css';
import {Users} from './ListPlayers';
import {ListGames} from './ListGames';
import {AddGame} from './forms/CreateGame';
/*import {GetBoardDataVariable} from './GameViewv3';*/
/*import {GameBoard} from './GameView';*/
import {GameBoard} from './GameViewv2';
import { Routes,Route } from 'react-router';
import {Scores} from "./Scores";
import LoginForm from "./forms/LoginForm";
import {RegUsers} from "./forms/RegPlayers";
import {LogoutUser} from "./LogoutPlayer";


function App() {
  return (
    <div className="App">
        <Routes>
            <Route path="/" element ={<LoginForm/>}/>
            <Route path="/games" element ={<ListGames/>}/>
            <Route path="/creategame" element={<AddGame/>}/>
            <Route path="/scores" element ={<Scores/>}/>
            <Route path="/users" element ={<Users/>}/>
            <Route path="/regplayer" element ={<RegUsers/>}/>
         {/*  <Route path="/getdata" element={<GetBoardDataVariable/>}/>*/}
            {/*<Route path="/gameboard/:gameid/:gamernumber" element={<GameBoard/>}/>*/}

            <Route path="/gameboard/:gameid" element={<GameBoard/>}/>
            <Route path="/login" element={<LoginForm/>}/>
            <Route path="/logout" element={<LogoutUser/>}/>
        </Routes>

    </div>
  );
}

export default App;
