/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unminuto.arquitecturaSoftware.paquetesTuristicos;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Cristian rodriguez    baruchneo@gmail.com
 * @author Cristian Vargas      cvarga35@uniminuto.edu.co
 * @author Yohan EspaNa         espanaqwe123@gmail.com
 * @author Wilson Lombana       sonwil1525@gmail.com
 * 
 */
public class PasswordUtils 
{
    private static String NUMEROS = "0123456789";
 
    private static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 
    private static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
 
    private static String ESPECIALES = "#$@-|%&";
    
    private static Integer LONGITUD = 8;
    
    
    public String hashPassword(String clave) throws NoSuchAlgorithmException
    {
        //SHA-1
        MessageDigest md;
        byte[] buffer, digest;
        String hash = "";
        buffer = clave.getBytes();
        md = MessageDigest.getInstance("SHA1");
        md.update(buffer);
        digest = md.digest();

        for(byte aux : digest) 
        {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) 
            {
                hash += "0";
            }
            hash += Integer.toHexString(b);
        }
        return hash;
    }
    
    public String generateAleatoriumPassword()
    {
        String key = NUMEROS + MAYUSCULAS + MINUSCULAS + ESPECIALES;
        String passwordResult = "";
        
        for (int i = 0; i < LONGITUD; i++) 
        {
            passwordResult+=(key.charAt((int)(Math.random() * key.length())));
	}
        
        return passwordResult;
    }
    
}
