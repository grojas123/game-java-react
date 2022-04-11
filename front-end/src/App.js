//import logo from './logo.svg';
import './App.css';
import {Users} from './ManagePlayers'
import {Games} from './Games'
import {GameViewPlayer} from './GameView'
import { Routes,Route } from 'react-router';

function App() {
  return (
    <div className="App">
        <Routes>
            <Route path="/" element ={<Users/>}/>
            <Route path="/games" element ={<Games/>}/>
            <Route path="/gameview" element={<GameViewPlayer/>}/>
        </Routes>
    </div>
  );
}

export default App;
