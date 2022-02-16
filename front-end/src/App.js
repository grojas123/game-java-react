//import logo from './logo.svg';
import './App.css';
import {Users} from './ManagePlayers'
import { Routes, Route} from "react-router-dom";

function App() {
  return (
    <div className="App">
        <Routes>
            <Route path="/" element ={<Users/>}/>
        </Routes>
    </div>
  );
}

export default App;
