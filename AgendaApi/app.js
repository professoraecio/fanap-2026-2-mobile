const URL_BASE = '/api.agenda';
const express = require('express');
const app = express();
const morgan = require('morgan');
app.use(morgan('dev'));
const bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({extended : false}));
app.use(bodyParser.json());

const contatoDao = require('./rotas/contatoDao');
app.use(URL_BASE + '/contato-dao',contatoDao);

/*
// http://localhost:3000/api.agenda
app.use(URL_BASE,(req,res,next) => {
    res.status(200).send({
        response : 'ROTA padrão da API REST funcionou!'
    });
});
*/

module.exports = app;