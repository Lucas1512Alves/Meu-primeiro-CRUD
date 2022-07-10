package util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    
    /* recebe uma data e converte em quantidade de dias */
    public static long dateToInteger(Date date){
        Calendar dataBase = Calendar.getInstance();
        dataBase.set(1970, 0, 1, 0, 0);
        
        double timeDiffInMilliseconds = Math.ceil(date.getTime() - dataBase.getTimeInMillis());
        return (long) Math.ceil(timeDiffInMilliseconds / (86400000));
    }
    
    /* recebe uma quantidade de dias e converte em uma data formatada */
    public static String integerToDate(long dateInDays){
        return DateUtil.formatIntDateToString(dateInDays);
    }
    
    /* recebe uma string "12/04/2022" e retorna um Date 'Wed Jan 04 00:00:00 BRT 2022' */
    public static Date dateToJFormattedFieldDate(String strDate){
        Date date = new Date();
        date.setTime(
                Date.parse(
                        strDate.split("/")[2] + "/" + 
                        strDate.split("/")[1] + "/" + 
                        strDate.split("/")[0]));
        
        return date;
    }
    
    /* recebe a quantidade de dias a ser adicionada na data base e transforma a data retornada em uma data string formatada - '22/04/2022' */
    private static String formatIntDateToString(long days){
        
        Date date = DateUtil.addDaysInDateBase(days);
        String dateFinal;
        
        if (date.getDate() < 10) {
            dateFinal = "0" + Integer.toString(date.getDate());
        }
        else {
            dateFinal = Integer.toString(date.getDate());
        }
        
        if ((date.getMonth() + 1) < 10) {
            dateFinal += "/0" + Integer.toString((date.getMonth() + 1)) + "/" + Integer.toString(date.getYear() + 1900);
        }
        else {
            dateFinal += "/" + (Integer.toString((date.getMonth() + 1))) + "/" + Integer.toString(date.getYear() + 1900);
        }
        
        return dateFinal;
    }
    
     /* recebe uma quantidade de dias e adiciona-os a data base */
    private static Date addDaysInDateBase(long days){
        
        Date dateConverted = new Date();
        dateConverted.setTime(Date.parse("1970/1/1") + (86400000 * (days)));
        
        return dateConverted;
    } 
}
