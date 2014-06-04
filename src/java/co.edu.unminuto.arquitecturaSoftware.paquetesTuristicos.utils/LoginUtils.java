/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unminuto.arquitecturaSoftware.paquetesTuristicos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Cristian rodriguez    baruchneo@gmail.com
 * @author Cristian Vargas      cvarga35@uniminuto.edu.co
 * @author Yohan EspaNa         espanaqwe123@gmail.com
 * @author Wilson Lombana       sonwil1525@gmail.com
 * 
 */
public class LoginUtils 
{
    public String crearUsuario(String nombre, String apellido) throws NullPointerException
    {
        String userResult;
        
        String tempName = (nombre.indexOf(" ") >= 0)? nombre.substring(0, nombre.indexOf(" ")) : nombre;
        String tempLastName = (apellido.indexOf(" ") >= 0) ? apellido.substring(0, apellido.indexOf(" ")) : apellido;
        userResult = tempName.toLowerCase() + "." + tempLastName.toLowerCase();
        return userResult;
    }
    
    public String updateUser(String usuarioRepetido, String usuario)
    {
        int posicion;
        String nuevoUsuarioResult;
        Pattern patron = Pattern.compile(usuario+"(\\d+)$");
        Matcher matcher = patron.matcher(usuarioRepetido);
        posicion = Integer.parseInt(matcher.group(1));
        posicion++;
        nuevoUsuarioResult = usuario + posicion;
        return nuevoUsuarioResult;
    }
}
