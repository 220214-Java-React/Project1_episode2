package Services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import bcrypt;  add the correct import statement later when jacob works on it

public class Encryption {


    public String toHash (String password) {

        //takes in string param password hashes it and returns it
        String encryptedPass = null;
        try
        {
            /* MessageDigest instance for MD5. */
            /* Add plain-text password bytes to digest using MD5 update() method. */
            /* Convert the hash value into bytes */
            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes());
            byte[] bytes = m.digest();
            StringBuilder s = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            /* Complete hashed password in hexadecimal format */
            encryptedPass = s.toString();

        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return encryptedPass;
    }


    public Boolean Auth (String passToCheck) throws NoSuchAlgorithmException {

        Boolean authenticated = false;
        String hashedPass = null;

        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(passToCheck.getBytes());
        byte[] bytes = m.digest();
        StringBuilder s = new StringBuilder();
        for(int i=0; i< bytes.length; i++)
        {
            s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        /* Complete hashed password in hexadecimal format */
        hashedPass = s.toString();

        if(hashedPass == passToCheck) {
            authenticated = true;
        }

        return authenticated;
    }

}
