import axios from 'axios';
import {Field, Form, Formik} from 'formik';

var PlayersBackend='/rest/players';
var CheckUserBackend='/api/checkuser'

async function CheckUserBackendDatabase(email){

    let CheckUserBackendTemp=CheckUserBackend+'/'+email;
    const checkFoundUserPromise = await axios.get(CheckUserBackendTemp)
        .then(function (response) {
             return response})
        .catch(function (error) {
            // handle error
            console.log(error);
        });
    return checkFoundUserPromise.data;
}

function AddPlayer(firstName,lastName,email,password) {

    const data = { firstName: firstName, lastName: lastName,email: email,password: password,role:'ADMIN' };
    axios.post(PlayersBackend, data)
        .then(response => {console.log(response.data);})
        .catch(error => {
                            console.error('Something went wrong!', error);});
                                              }

export const RegPlayerForm=() =>{
     const validateEmailAsync = async email =>{
        if(email!=="") {var userOnDatabase=await CheckUserBackendDatabase(email)};
            if (email === 0 || email.replace(/^\s+|\s+$/gm, '').length === 0) { return  'Required :';}
            else if (email.length === 0) { return  'The email must be no empty ';}
            else if (!/^[A-Z\d._%+-]+@[A-Z\d.-]+\.[A-Z]{2,4}$/i.test(email)) { return  'Invalid email address :';}
            else if (userOnDatabase) { return  'email in use :';  }
        ;
    }

    const validationFirstName = value => {
        //var errorMessage;
        if (value === 0 || value.replace(/^\s+|\s+$/gm, '').length === 0)
        {return  'Required :'; }
        else if (value.length === 0)  { return  'The Firstname must be no empty'; }
    };

    const validationLastName = value => {
        //var errorMessage;
        if (value === 0 || value.replace(/^\s+|\s+$/gm, '').length === 0)
        {return  'Required :'; }
        else if (value.length === 0)  { return  'The Last Name must be no empty'; }
    };


    const validationPassword = value => {
        //var errorMessage;
        if (value === 0 || value.replace(/^\s+|\s+$/gm, '').length === 0)
        {return  'Required :'; }
        else if (value.length === 0)  { return  'The Password must be no empty'; }
    };

    return (
        <Formik
            initialValues={{ firstName: '', lastName: '', email: '',password:'' }}

            onSubmit={(values, {resetForm}) => {

                AddPlayer(values.firstName,values.lastName,values.email,values.password);
                resetForm();

            }}
        >
            {({ errors, touched }) =>(
            <Form >

                <label htmlFor="firstName" >First Name {errors.firstName && touched.firstName ? <div>{errors.firstName}</div> : null} </label>
                <Field validate={validationFirstName} name="firstName" type="text" />

                <label htmlFor="lastName">Last Name {errors.lastName && touched.lastName ? <div>{errors.lastName}</div> : null}</label>
                <Field validate={validationLastName} name="lastName" type="text" />

                <label htmlFor="email">Email Address {errors.email && touched.email ? <div>{errors.email}</div> : null}</label>
                <Field validate={validateEmailAsync}  name="email" type="email" />

                <label htmlFor="password">Password {errors.password && touched.password ? <div>{errors.password}</div> : null}</label>
                <Field validate={validationPassword} name="password" type="password" />

                <button type="submit">Submit</button>
            </Form>)}
        </Formik>
    );
};

export const RegUsers = () => {
          return (
            <ul>
                <RegPlayerForm/>
            </ul>
        )}


