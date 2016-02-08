package br.com.util;

import java.util.List;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

    private static String username = "maatheusaalberto@gmail.com";
    private static String password = "albertomatheus";

    public static void Email(List<String> lista, String texto, String assunto) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        session.setDebug(false);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); //REMETENTE

            Address[] toUser = null;

            message.setSubject(assunto); //ASSUNTO
            message.setText(texto); //TEXTO DA MENSAGEM

            //AQUI VAI ENVIAR PRA CADA EMAIL DA LISTA
            for (String listaEmail1 : lista) {
                toUser = InternetAddress.parse(listaEmail1); //DESTINATÁRIO(S)
                message.setRecipients(Message.RecipientType.TO, toUser);
                Transport.send(message); //Método para enviar a mensagem criada
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
