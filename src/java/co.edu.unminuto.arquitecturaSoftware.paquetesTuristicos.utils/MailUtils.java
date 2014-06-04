/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unminuto.arquitecturaSoftware.paquetesTuristicos;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Cristian rodriguez    baruchneo@gmail.com
 * @author Cristian Vargas      cvarga35@uniminuto.edu.co
 * @author Yohan EspaNa         espanaqwe123@gmail.com
 * @author Wilson Lombana       sonwil1525@gmail.com
 * 
 */
public class MailUtils 
{
    private final Properties properties = new Properties();
    private Session session;
    
    private void init() 
    {
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.mail.sender", "cristian.l.rodriguez.perez@gmail.com");
        properties.put("mail.smtp.password", "Cristian2014");
        properties.put("mail.smtp.user", "cristian.l.rodriguez.perez@gmail.com");
        properties.put("mail.smtp.auth", "true");
        session = Session.getDefaultInstance(properties);
    }
    
    
    /**
     * Enviar correos electronicos por cuenta de gmail
     * @param destino
     * @param asunto
     * @param mensaje
     * @throws MessagingException 
     */
    public void send(String destino,String asunto, String mensaje) throws MessagingException
    {
        init();
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
        message.setSubject(asunto);
        message.setContent(mensaje,"text/html");
        Transport t = session.getTransport("smtp");
        t.connect((String) properties.get("mail.smtp.user"), (String) properties.get("mail.smtp.password"));
        t.sendMessage(message, message.getAllRecipients());
        t.close();
    }
    
    /**
     * Para usar esta opcion, solamente en donde van a enviar el código poner:
     * 
     * MailUtils mailUtils = new MailUtils();
     * mailUtils.send("destino@mail.com","Asunto mail","Mensage, puede ser en formato html");
     */
}
