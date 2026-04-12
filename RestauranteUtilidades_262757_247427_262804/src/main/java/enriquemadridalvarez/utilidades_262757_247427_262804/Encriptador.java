/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enriquemadridalvarez.utilidades_262757_247427_262804;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author BALAMRUSH
 */
public class Encriptador {
    
    private static final String claveSecreta = "ClaveSecreta1234";
    
    public static String encriptar(String texto) throws Exception{
        SecretKeySpec clave = new SecretKeySpec(claveSecreta.getBytes("UTF-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS55Padding");
        cipher.init(Cipher.ENCRYPT_MODE, clave);
        byte[] encriptado = cipher.doFinal(texto.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encriptado);
    }
    
    public static String deseencriptar(String textoEncriptado)throws Exception{
        SecretKeySpec clave = new SecretKeySpec(claveSecreta.getBytes("UTF-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS55Padding");
        cipher.init(Cipher.DECRYPT_MODE, clave);
        byte[] deseencriptado = cipher.doFinal(Base64.getDecoder().decode(textoEncriptado));
        return new String(deseencriptado, "UTF-8");
    }
}
