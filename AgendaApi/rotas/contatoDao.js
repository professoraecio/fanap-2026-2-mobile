const express = require('express');
const router = express.Router();
const url = require('url');
const queryString = require('querystring');
const mysql = require('./mysql').pool;

// http://localhost:3000/api.agenda/contato-dao/create
router.post('/create',(req,res,next) => {
    const {nome,fone,email} = req.body
    const contato = {nome,fone,email} 
    mysql.getConnection((error,conn) => {
        if(error){
            return res.status(500).send({
                error : error,
                response : null
            });
        }
        conn.query(
            'INSERT INTO contato (nome,fone,email) VALUES (?,?,?)',
            [contato.nome,contato.fone,contato.email],
            (error,resultado,field) => {
                conn.release();
                if(error){
                    return res.status(500).send({
                        error : error,
                        response : null
                    });
                }
                res.status(201).send({
                    response : 'Contato cadastrado com sucesso!',
                    id_contato : resultado.insertId
                });
            }
        )
    });
});

// http://localhost:3000/api.agenda/contato-dao/getId?id=4
router.get('/getId',(req,res,next) => {
    
    const reqUrl = url.parse(req.url); // URL requisição
    const queryParams = queryString.parse(reqUrl.query);
    const id = queryParams.id;

    /*
    res.status(200).send("ID solicitado " + id);
    */
   mysql.getConnection((error,conn) => {
        if(error){
            return res.status(500).send({
                error : error,
                response : null
            });
        }
        conn.query(
            'SELECT * FROM contato WHERE id = ?;',
            [id],
            (error,resultado,fields) => {
                conn.release();
                if(error){
                    return res.status(500).send({
                    error : error,
                    response : null
                    });
                }
                return res.status(200).send({
                    response : resultado
                });
            }
        )
   });

});

// http://localhost:3000/api.agenda/contato-dao/getAll
router.get('/getAll',(req,res,next) => {
    mysql.getConnection((error,conn) => {
        if(error){
            return res.status(500).send({
                error : error,
                response : null
            });
        }
        conn.query(
            'SELECT * FROM contato',
            (error,resultado,fields) => {
                conn.release();
                if(error){
                    return res.status(500).send({
                        error : error,
                        response : null
                    });
                }
                return res.status(200).send({
                    response : resultado
                });
            }
        )
    });
});

// http://localhost:3000/api.agenda/contato-dao/update
router.post('/update',(req,res,next) => {
    const {id_contato , nome , fone , email} = req.body;
    const contato = {id_contato , nome , fone , email} 
    mysql.getConnection((error,conn) => {
        if(error){
            return res.status(500).send({
                error : error,
                response : null
            });
        }
        conn.query(
            'UPDATE contato SET nome=? , fone=? , email=? WHERE id=?;',
            [contato.nome , contato.fone , contato.email , contato.id_contato],
            (error,resultado,fields) => {
                conn.release();
                if(error){
                    return res.status(500).send({
                        error : error,
                        response : null
                    });
                }
                return res.status(200).send({
                    response : 'Contato atualizado com sucesso',
                    'Dados do contato' : contato
                });
            }
        )
    });
});

// http://localhost:3000/api.agenda/contato-dao/delete
router.post('/delete',(req,res,next) => {
    const {id_contato} = req.body;
    const contato = {id_contato} 
    mysql.getConnection((error,conn) => {
        if(error){
            return res.status(500).send({
                error : error,
                response : null
            });
        }
        conn.query(
            'DELETE FROM contato WHERE id=?;',
            [contato.id_contato],
            (error,resultado,fields) => {
                conn.release();
                if(error){
                    return res.status(500).send({
                        error : error,
                        response : null
                    });
                }
                return res.status(200).send({
                    response : 'Contato excluído com sucesso',
                    'Dados do contato' : contato
                });
            }
        )
    });
});

module.exports = router;