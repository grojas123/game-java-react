
import axios from 'axios';
import { useFormik } from 'formik';

var PlayersBackend='/rest/players';
var CheckUserBackend='/api/checkuser'
var checkFoundUser=false;
function CheckUserBackendDatabase(email){

    let CheckUserBackendTemp=CheckUserBackend+'/'+email;
    axios.get(CheckUserBackendTemp)
        .then(function (response) {
             if (typeof(response.data) !== 'undefined') {checkFoundUser=response.data } else {checkFoundUser=false;}
             //console.log(dataReturn)
            //return dataReturn;

        })
        .catch(function (error) {
            // handle error
            console.log(error);
        })
        .then(function () {
            // always executed
        });
   // if(typeof(dataReturn) !== 'undefined'){console.log("undefined");dataReturn=false}
   // console.log(dataReturn)
    return checkFoundUser;
}

function AddPlayer(firstName,lastName,email,password) {

    const data = { firstName: firstName, lastName: lastName,email: email,password: password,role:'ADMIN' };
    axios.post(PlayersBackend, data)
        .then(response => {console.log(response.data);})
        .catch(error => {
                            console.error('Something went wrong!', error);});
                                                }
const validate = values => {
    const errors = {};
    if (values.firstName === 0 || values.firstName.replace(/^\s+|\s+$/gm, '').length === 0)
        {errors.firstName = 'Required :'; }
        else if (values.firstName.length === 0)  { errors.firstName = 'The Firstname must be no empty'; }
    if (values.lastName === 0 || values.lastName.replace(/^\s+|\s+$/gm, '').length === 0)
        { errors.lastName = 'Required :';}
        else if (values.lastName.length === 0) { errors.lastName = 'The Lastname must be no empty'; }

    if (values.email === 0 || values.email.replace(/^\s+|\s+$/gm, '').length === 0)
            { errors.email = 'Required :';}
                else if (values.email.length === 0) { errors.email = 'The email must be no empty ';}
                else if (!/^[A-Z\d._%+-]+@[A-Z\d.-]+\.[A-Z]{2,4}$/i.test(values.email)) { errors.email = 'Invalid email address :';}
                else if (!CheckUserBackendDatabase(values.email)) {
                    //console.log(CheckUserBackendDatabase(values.email))
                    //console.log(values.email)
                    errors.email = 'email in use :';  }

    if (values.password === 0 || values.password.replace(/^\s+|\s+$/gm, '').length === 0)
            { errors.password = 'Required :';}
    else if (values.password.length === 0)
            { errors.password = 'The password must be no empty'; }
    return errors;
};
const RegPlayerForm=() =>{
     const formik = useFormik(
        {initialValues:{firstName: '',lastName: '',email: '',password:''},
            validate,
            onSubmit: (values,{resetForm}) =>
                                                    {
                                                       // console.log(values);
                                                        AddPlayer(values.firstName,values.lastName,values.email,values.password);
                                                        resetForm();
                                                    },
                                                                                }
                                                                                );
    return (
        <form onSubmit={formik.handleSubmit}>
            <label htmlFor='firstName'>
                {formik.errors.firstName&& <div className="error">{formik.errors.firstName}
                </div>}
            </label>
            <label htmlFor="firstName">First Name</label>
            <input
                id="firstName"
                name="firstName"
                type="text"
                onChange={formik.handleChange}
                value={formik.values.firstName}

            />
            <label htmlFor='lastName'>
                {formik.errors.lastName&& <div className="error">{formik.errors.lastName}
                </div>}
            </label>
            <label htmlFor="lastName">Last Name</label>
            <input
                id="lastName"
                name="lastName"
                type="text"
                onChange={formik.handleChange}
                value={formik.values.lastName}
            />
            <label htmlFor='email'>
                {formik.errors.email&& <div className="error">{formik.errors.email}
                </div>}
            </label>
            <label htmlFor="email">email</label>
            <input
                id="email"
                name="email"
                type="text"
                onChange={formik.handleChange}
                value={formik.values.email}
            />
            <label htmlFor='password'>
                {formik.errors.password&& <div className="error">{formik.errors.password}
                </div>}
            </label>
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


