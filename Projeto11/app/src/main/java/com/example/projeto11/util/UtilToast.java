package com.example.projeto11.util;

import android.content.Context;
import android.widget.Toast;

public class UtilToast {

    public static void toast(Context context, String msg, int duracaoMsg) {
        Toast.makeText(context,msg,duracaoMsg).show();
    }

    public static void msgCurta(Context context, String msg){
        toast(context,msg,Toast.LENGTH_SHORT); // cerca de 2 segundos
    }

    public static void msgLonga(Context context, String msg){
        toast(context,msg,Toast.LENGTH_LONG); // cerca de 5 segundos
    }

}
