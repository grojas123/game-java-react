//import logo from './logo.svg';
import './App.css';
import {Users} from './ManagePlayers'
import {Games} from './Games'
import {GameBoard} from './GameView'
import { Routes,Route } from 'react-router';
import {Scores} from "./Scores";

function App() {
  return (
    <div className="App">
        <Routes>
            <Route path="/" element ={<Users/>}/>
            <Route path="/games" element ={<Games/>}/>
            <Route path="/scores" element ={<Scores/>}/>
            <Route path="/gameboard/:gameid/:gamernumber" element={<GameBoard/>}/>
        </Routes>
    </div>
  );
}

export default App;
