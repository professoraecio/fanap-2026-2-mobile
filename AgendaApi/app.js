const URL_BASE = '/api.agenda';
const express = require('express');
const app = express();
const morgan = require('morgan');
app.use(morgan('dev'));
const bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({extended : false}));
app.use(bodyParser.json());

// http://localhost:3000/api.agenda
app.use(URL_BASE,(req,res,next) => {
    res.status(200).send({
        response : 'URL PADRAO DO APP FUNCIONOU!'
    });
});

// rota nao encontrada
app.use((req,res,next) => {
    const erro = new Error('Rota Inexistente');
    erro.status = 404;
    next(erro);
});

module.exports = app;