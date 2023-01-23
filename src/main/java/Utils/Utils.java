package Utils;
import Controllers.AllObjModels;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils
{
    private static DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
    private static String date = dateformat.format(LocalDateTime.now());
    public static String getDay()
    { return DateTimeFormatter.ofPattern("dd").format(LocalDateTime.now()); }
    public static String getDate()
    { return date; }
    public static String dateOut()
    { return dateformat.format(LocalDateTime.now().plusDays(1).plusMinutes(30)); }
    static public Boolean cekInputNomor(String input)
    {
        try
        {
            Long.parseLong(input);
            return true;
        } catch (final NumberFormatException e)
        {
            return false;
        }
    }
}