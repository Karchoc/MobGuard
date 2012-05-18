/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.Karchoc.MobGuard;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Karchoc
 */
public class Time {
    
	private static DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss: ");
        private static String time = format.format(new Date());
        
        public static String getTime(){
            return time;
        }
        
    
}
