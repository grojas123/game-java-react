
import axios from 'axios';
import { useFormik } from 'formik';

var LogoutBackend='/api/logout';

const validate = values => {};
function DoLogout() {
    const data = {};
    axios.post(LogoutBackend, data)
        .then(response => { console.log(response.data);})
        .catch(error => {
                            console.error('Something went wrong!', error);});
                         }

const LogoutForm=() =>{
     const formik = useFormik(
        {initialValues:{},
            validate,
            onSubmit: (values,{}) =>
                                                    {
                                                        DoLogout()
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


