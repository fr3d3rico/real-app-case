import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import * as serviceWorker from './serviceWorker';

import 'bootstrap/dist/css/bootstrap.css';

import axios from 'axios';

axios.defaults.baseURL = 'http://localhost:8080';

axios.interceptors.request.use(req => {
    //console.log(req);

    return req;
}, error => {
    //console.log(error);
    return Promise.reject(error);
});

axios.interceptors.response.use(res => {
    //console.log(res);

    return res;
}, error => {
    //console.log(error);
    return Promise.reject(error);
});

ReactDOM.render(<App />, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
