



public class PasswordEncryptor {
	private static final String KEY = "ssntttaml";

    
    public static String encrypt(String password) {
        StringBuilder encryptedPassword = new StringBuilder();

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i); 
            char keyCh = KEY.charAt(i % KEY.length()); 
            char encryptedChar = (char) (ch + keyCh); 
            encryptedPassword.append(encryptedChar); 
        }

        return encryptedPassword.toString(); 
    }

    public static String decrypt(String encryptedPassword) {
        StringBuilder decryptedPassword = new StringBuilder();

        for (int i = 0; i < encryptedPassword.length(); i++) {
            char ch = encryptedPassword.charAt(i); 
            char keyCh = KEY.charAt(i % KEY.length()); 
            char decryptedChar = (char) (ch - keyCh); 
            decryptedPassword.append(decryptedChar); 
        }

        return decryptedPassword.toString(); 
    }

}

