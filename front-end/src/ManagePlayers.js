import { v4 as uuidv4 } from 'uuid';
import React, { useState, useEffect }  from 'react';
import axios from 'axios';
import { useFormik } from 'formik';
// PlayersBackend must be change in Sync with the value in package.json for now is set for the Backend and Frontend will be in the localhost ."http://localhost:8080"
var PlayersBackend='/players';
function unique_id() {
                      return uuidv4()
                     }

const validate = values => {
                            const errors = {};
                            if (values.firstName === 0 || values.firstName.replace(/^\s+|\s+$/gm, '').length === 0)
                                {
                                    errors.firstName = 'Required';
                                }
                                else
                                    if (values.firstName.length === 0)  {
                                                                        errors.firstName = 'The message must be no empty';
                                                                        }
                            if (values.lastName === 0 || values.lastName.replace(/^\s+|\s+$/gm, '').length === 0)
                                {
                                    errors.lastName = 'Required';
                                }
                            else
                                if (values.lastName.length === 0)
                                {
                                    errors.lastName = 'The message must be no empty';
                                }
                            return errors;
                            };
function AddPlayer(firstName,lastName,useStateUsers) {
    const data = { firstName: firstName, lastName: lastName };
    let listPlayers=useStateUsers.useStateUsers[0];
    let setPlayers=useStateUsers.useStateUsers[1];
    axios.post(PlayersBackend, data)
        .then(response => {
                            let temp_listPlayers=[...listPlayers,response.data]
                            setPlayers(temp_listPlayers);})
        .catch(error => {
                            console.error('Something went wrong!', error);});
                                                }

const AddPlayerForm=(useStateUsers) =>{
     const formik = useFormik(
        {initialValues:{firstName: '',lastName: '',},
            validate,
            onSubmit: (values,{resetForm}) =>
                                                    {
                                                        AddPlayer(values.firstName,values.lastName,useStateUsers);
                                                        resetForm();
                                                    },
                                                                                }
                                                                                );
    return (
        <form onSubmit={formik.handleSubmit}>
            <label htmlFor="firstName">First Name</label>
            <input
                id="firstName"
                name="firstName"
                type="text"
                onChange={formik.handleChange}
                value={formik.values.firstName}
            />
            <label htmlFor="lastName">Last Name</label>
            <input
                id="lastName"
                name="lastName"
                type="text"
                onChange={formik.handleChange}
                value={formik.values.lastName}
            />

            <button type="submit">Add user</button>
        </form>
    );
};

export const Users = () => {
   const [listPlayers, setPlayers] = useState({});
   const getPlayers = () =>axios.get(PlayersBackend)
                                                    .then((response)=>
                                                   {
                                                        const myPlayers=response.data._embedded.players;
                                                        setPlayers(myPlayers);
                                                   }
                                                            )
    useEffect(()=>getPlayers(),[])
    if (typeof(listPlayers.length) !== 'undefined') {
         return (
            <ul>
                <AddPlayerForm useStateUsers={[listPlayers, setPlayers]}/>
                {listPlayers.map(player =>
                    (<li className="d-flex justify-content-start" key={unique_id()}> {player.firstName} {player.lastName} </li>)
                                 )
                }
            </ul>
        );}
    return (
        <ul> </ul>
           );
}