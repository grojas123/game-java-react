
import axios from 'axios';
import { useFormik } from 'formik';
import {useNavigate} from "react-router";

var LogoutBackend='/api/logout';

const validate = values => {};
function DoLogout() {

    const data = {};
    axios.post(LogoutBackend, data)
        .then(response => {
            localStorage.removeItem("username")
            //console.log(response.data);
        })
        .catch(error => {
                            console.error('Something went wrong!', error);});
                         }

const LogoutForm=() =>{
    const navigate = useNavigate();
    const formik = useFormik(
        {initialValues:{},
            validate,
            onSubmit: (values,{}) =>
                                                    {
                                                        DoLogout()
                                                        navigate('/')
                                                    },
                                                                                }
                                                                                );
    return (
        <form onSubmit={formik.handleSubmit}>
            <button type="submit">Logout user</button>
        </form>
    );
};

export const LogoutUser = () => {
           return (
            <ul>
                <LogoutForm/>
            </ul>
        )}


