
import axios from 'axios';
import { useFormik } from 'formik';

var PlayersBackend='/rest/players';


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
function AddPlayer(firstName,lastName,email,password) {

    const data = { firstName: firstName, lastName: lastName,email: email,password: password,role:'ADMIN' };
    axios.post(PlayersBackend, data)
        .then(response => {console.log(response.data);})
        .catch(error => {
                            console.error('Something went wrong!', error);});
                                                }

const RegPlayerForm=() =>{
     const formik = useFormik(
        {initialValues:{firstName: '',lastName: '',email: '',password:''},
            validate,
            onSubmit: (values,{resetForm}) =>
                                                    {
                                                        console.log(values);
                                                        AddPlayer(values.firstName,values.lastName,values.email,values.password);
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
            <label htmlFor="email">email</label>
            <input
                id="email"
                name="email"
                type="text"
                onChange={formik.handleChange}
                value={formik.values.email}
            />
            <label htmlFor="password">password</label>
            <input
                id="password"
                name="password"
                type="password"
                onChange={formik.handleChange}
                value={formik.values.password}
            />
            <button type="submit">Add user</button>
        </form>
    );
};

export const RegUsers = () => {
          return (
            <ul>
                <RegPlayerForm/>
            </ul>
        )}


