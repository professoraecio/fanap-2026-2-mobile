package com.professoraecio.projeto06.util;
import java.util.Calendar;
public class UtilTime {

    public static int getHoraAtual(){
        Calendar calendar = Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        return hora;
    }

    public static int getMinutoAtual(){
        Calendar calendar = Calendar.getInstance();
        int minuto = calendar.get(Calendar.MINUTE);
        return minuto;
    }

}
