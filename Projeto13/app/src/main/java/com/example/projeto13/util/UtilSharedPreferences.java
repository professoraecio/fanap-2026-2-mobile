package com.example.projeto13.util;

import android.content.Context;
import android.content.SharedPreferences;

public class UtilSharedPreferences {

    private static final String SHARED_PREFERENCES_NAME = "MEU_BANCO_DE_DADOS_LOCAL.sql";

    public static void salvarString(Context context, String chave, String valor) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(chave, valor);
        editor.apply();

    }

    public static String lerString(Context context, String chave, String valorCasoNaoExistaNenhumDado) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(chave, valorCasoNaoExistaNenhumDado);
    }

    public static void clearPreferences(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
