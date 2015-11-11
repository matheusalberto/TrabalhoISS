package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerarCriptografiaSenha {
    
    public static String criptografaSenha (String senha){
        MessageDigest algoritmo;
        try {
            algoritmo = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = algoritmo.digest(senha.getBytes("UTF-8"));
            
            StringBuilder hexString = new StringBuilder();
            for(byte b : messageDigest){
                hexString.append(String.format("%02X", 0xFF & b));
            }
            senha = hexString.toString();            
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(GerarCriptografiaSenha.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return senha;
    }
    
}
