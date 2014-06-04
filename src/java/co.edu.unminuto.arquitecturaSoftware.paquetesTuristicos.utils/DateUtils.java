/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unminuto.arquitecturaSoftware.paquetesTuristicos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Cristian rodriguez    baruchneo@gmail.com
 * @author Cristian Vargas      cvarga35@uniminuto.edu.co
 * @author Yohan EspaNa         espanaqwe123@gmail.com
 * @author Wilson Lombana       sonwil1525@gmail.com
 * 
 */
public class DateUtils 
{
    public Date stringToDate(String dateString, String format) throws ParseException
    {
        //formato por defecto yyyy-MM-dd HH:mm:ss
        Date dateReturn = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        dateReturn = simpleDateFormat.parse(dateString);
        return dateReturn;
    }
    
    public String dateToString(Date date, String format)
    {
        String dateStringResult = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        dateStringResult = simpleDateFormat.format(date);
        return dateStringResult;
    }
}
