//import logo from './logo.svg';
import './App.css';
import {Users} from './ManagePlayers'
import {Games} from './Games'
import { Routes,Route } from 'react-router';

function App() {
  return (
    <div className="App">
        <Routes>
            <Route path="/" element ={<Users/>}/>
            <Route path="/games" element ={<Games/>}/>
        </Routes>
    </div>
  );
}

export default App;
