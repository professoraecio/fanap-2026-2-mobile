package com.example.projeto10.util;
import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

public class UtilAlertDialog {

    public static void alerta(Context context, String titulo, String mensagem){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(titulo);
        builder.setMessage(mensagem);
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public static void alertaComAcao(Context context,
                                     String titulo,
                                     String mensagem,
                                     DialogInterface.OnClickListener sim,
                                     DialogInterface.OnClickListener nao){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(titulo)
                .setMessage(mensagem)
                .setPositiveButton("Sim", sim)
                .setNegativeButton("Não", nao)
                .show();

    }

}
