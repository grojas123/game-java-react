import axios from "axios";
import {useState} from "react";
const CreateGameEndPoint="/api/games"
export function AddGame() {
    const [isUserValidated, setPlayerValidation] = useState(false);
    const data = {};
    const UNAUTHORIZED = 401;
   axios.post(CreateGameEndPoint, data)
        .then(response => {console.log(response.data);})
        .catch(error => {
            console.error('Something went wrong!', error);});
    axios.interceptors.response.use(
        response => {
            setPlayerValidation(true)
            return response},
        error => {
            const {status} = error.response;
            if (status === UNAUTHORIZED) {
                setPlayerValidation(false);
                console.log("No Authorized",status);
            }
            return Promise.reject(error);
        }

    );
    console.log(isUserValidated);
    if (isUserValidated) {return <div> You can create games</div> }
    else {return  <div> You dont did login cannot create games</div>}


}