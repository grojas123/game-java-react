//import logo from './logo.svg';
//import './App.css';
import {Users} from './ListPlayers';
import {Games} from './Games';
import {GameBoard} from './GameView';
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
            <Route path="/games" element ={<Games/>}/>
            <Route path="/scores" element ={<Scores/>}/>
            <Route path="/users" element ={<Users/>}/>
            <Route path="/regplayer" element ={<RegUsers/>}/>
            <Route path="/gameboard/:gameid/:gamernumber" element={<GameBoard/>}/>
            <Route path="/login" element={<LoginForm/>}/>
            <Route path="/logout" element={<LogoutUser/>}/>
        </Routes>

    </div>
  );
}

export default App;
