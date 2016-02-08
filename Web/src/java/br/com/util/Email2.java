package br.com.util;

import java.util.List;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email2 {

    private static String username = "ccuem2013@gmail.com";
    private static String password = "uemcc2013";

    public static void Email(List<String> lista, String texto, String assunto) {
        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); //Remetente
            Address[] toUser;
            message.setSubject(assunto);//Assunto
            message.setText(texto);
            for (String listaEmail1 : lista) {
                toUser = InternetAddress.parse(listaEmail1); //DESTINATÁRIO(S)
                message.setRecipients(Message.RecipientType.TO, toUser);
                Transport.send(message); //Método para enviar a mensagem criada
            }
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
