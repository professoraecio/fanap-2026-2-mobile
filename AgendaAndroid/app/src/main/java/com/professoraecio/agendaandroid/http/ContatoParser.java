package com.professoraecio.agendaandroid.http;

import android.util.Log;

import com.professoraecio.agendaandroid.model.Contato;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ContatoParser {

    public Contato getContatoFromJson(String contatoJson) {
        Contato contato = new Contato();

        try{
            JSONObject contatoJsonObj = new JSONObject(contatoJson);
            JSONArray contacts = contatoJsonObj.getJSONArray("response");

            for(int i = 0 ; i < contacts.length(); i++){
                JSONObject contatoObj = contacts.getJSONObject(i);
                contato.setId_contato(contatoObj.getInt("id_contato"));
                contato.setNome(contatoObj.getString("nome"));
                contato.setFone(contatoObj.getString("fone"));
                contato.setEmail(contatoObj.getString("email"));
            }

        }catch (Exception e){
            Log.d("DEBUG-MODE",e.toString());
        }

        return contato;
    }

    public ArrayList<Contato> getContatosFromJson(String contatoJson) {
        Contato contato = new Contato();
        ArrayList<Contato> contatos = new ArrayList<Contato>();
        try{
            JSONObject contatoJsonObj = new JSONObject(contatoJson);
            JSONArray contacts = contatoJsonObj.getJSONArray("response");

            for(int i = 0 ; i < contacts.length(); i++){
                JSONObject contatoObj = contacts.getJSONObject(i);
                contato = new Contato();
                contato.setId_contato(contatoObj.getInt("id_contato"));
                contato.setNome(contatoObj.getString("nome"));
                contato.setFone(contatoObj.getString("fone"));
                contato.setEmail(contatoObj.getString("email"));
                contatos.add(contato);
            }

        }catch (Exception e){
            Log.d("DEBUG-MODE",e.toString());
        }

        return contatos;
    }

}
