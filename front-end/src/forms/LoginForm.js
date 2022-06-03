import React, {useState} from 'react';
import { Formik } from 'formik';
import axios from "axios";
//import {Games} from "../Games";
import {useNavigate} from "react-router";

const LoginForm = () => {
    const navigate = useNavigate();
    const handleClick = () => {
        navigate("/games");
    }
    const [success,setSuccess]=useState(false);
    const [errorValidation,setErrorValidation]=useState(false)

    const handleSubmit = (values) =>{
        var bodyFormData = new FormData();
        bodyFormData.append('username',values.email)
        bodyFormData.append('password',values.password)
        axios({
            method: "post",
            url: "/api/login",
            data: bodyFormData,
            headers: { "Content-Type": "multipart/form-data", "mode": "cors" },
        })
            .then(function (response) {
               if (response.statusText==='OK'){
                   //console.log(response.statusText==='OK')
                   //console.log(response.data.username)
                   localStorage.setItem("username", response.data.username)
                   setSuccess(true)
                   //console.log(localStorage.getItem("username"))
                   navigate("/games")

               } else if (response.statusText==='') {
                   //console.log(!response.statusText==='')
                   setErrorValidation(true)
                }
            })
            .catch(function (response) {
                //handle error
                console.log('error ', response);
            })

        ;
    }


    return (
        success ? (
                <section>
                    <h3>You are logging in</h3>
                    <div className="d-grid gap-2" >
                    <button variant="primary" size="lg" onClick={handleClick} type="button" />

                    </div>
                    </section>

            ):
            (
        <section>
        <div><b>{errorValidation ? 'Error the combination user/password invalid':''}</b></div>

    <div>

        <h1>Login</h1>
        <Formik
            initialValues={{ email: '', password: '' }}
            validate={values => {
                const errors = {};
                if (!values.email) {
                    errors.email = 'Required';
                } else if (
                    !/^[A-Z\d._%+-]+@[A-Z\d.-]+\.[A-Z]{2,}$/i.test(values.email)
                ) {
                    errors.email = 'Invalid email address';
                }
                return errors;
            }}
            onSubmit={(values, {setSubmitting}) => {
                setTimeout(() => {
                    handleSubmit(values);
                    setSubmitting(false);
                   // resetForm()
                }, 400);
                //resetForm();
            }}
        >
            {({
                  values,
                  errors,
                  touched,
                  handleChange,
                  handleBlur,
                  handleSubmit,
                  isSubmitting,
                  /* and other goodies */
              }) => (
                <form onSubmit={handleSubmit}>
                    <label htmlFor="email">Email :</label>
                    {errors.email && touched.email && errors.email}
                    <input
                        type="email"
                        name="email"
                        onChange={handleChange}
                        onBlur={handleBlur}
                        value={values.email}
                    />

                    <label htmlFor="password">Password :</label>
                    {errors.password && touched.password && errors.password}
                    <input
                        type="password"
                        name="password"
                        onChange={handleChange}
                        onBlur={handleBlur}
                        value={values.password}
                    />
                    <button type="submit" disabled={isSubmitting}>
                        Submit
                    </button>
                </form>
            )}
        </Formik>
    </div>
</section>)
    )};


export default LoginForm;