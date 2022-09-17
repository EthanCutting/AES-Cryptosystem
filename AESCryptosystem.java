/*
    Assigment2 INTE2401/2402 Cloud Security
    S3660434
    s3660434@student.rmit.edu.au
    Ethan PP Cutting
*/
import javax.swing.JPanel;
import java.util.Arrays;
import java.util.Base64;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AESCryptosystem extends JFrame 
{
	private static final long serialVersionUID = 3L;
	public AESCryptosystem() 
    {	
	}
    public static void main(String[] args)
    {
    	
        // Creating frame and panel and text field and button
        JFrame f;
        // adding panel
        JPanel P;
        // For all of the labels
        JLabel ML, label1, label2, label3, label4, label6, label7, label8, label9;
        // text field for plaintext ,etc
        JTextField PlainText,Ky1,CipherText,Ky2,R1,R2;
        // For the buttons 
        JButton encrypt, decrypt;

        // Declaring all the components for the layout
        f = new JFrame("Panel");
        P = new JPanel();
        ML = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        R1 = new JTextField();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        R2 = new JTextField();
    // Setting the main label for AES cryptosystem
    ML.setText("AES Cryptosystem");
    // setting the text inside the labels
    label1.setText("AES Encryption");
    // This will display Plaintext 
    label2.setText("Plaintext:");
    // This will display Key
    label3.setText("key:");
    // This will display encrypted result
    label4.setText( "Encrypted Result");
    // This will display Aes decryption 
    label6.setText("AES Decryption");
    // This will display Ciphertext
    label7.setText("Ciphertext:");
    // This will display ciphertext
    label8.setText("key:");
    // This will display Decrypted Result
    label9.setText("Decrypted Result:");

    // This is for Encyptions and decryptions for AES cryptosystem
    PlainText = new JTextField();
    Ky1= new JTextField();
    encrypt = new JButton("Encrypt");
    CipherText = new JTextField();
    Ky2= new JTextField();
    decrypt = new JButton("Decrypt");

    //setting the positions of components needed for encryptions
    ML.setBounds(15, 80, 250, 34);
    // For AES Cryptosystem
    label1.setBounds(20, 120, 105, 33);
    // for AES Encrypted
    label2.setBounds(20, 185, 105, 32);
    // setting the positions for Plaintext
    PlainText.setBounds (95, 185, 405, 32);
    // setting the positions for key
    label3.setBounds(20, 225, 55, 32);
    // setting positions for key1 (JTextField)
    Ky1.setBounds(95, 225, 400, 32);
    // setting positions for encrypt when click button
    encrypt.setBounds(20, 270, 220, 32);
    // for encryption result 
    label4.setBounds(20, 335, 120, 32);
    // For res1
    R1.setBounds(20, 370, 420, 32);
    //setting the positions of components needed for decryptions
    label6.setBounds(20, 420, 120, 32);
    // setting the positions for ciphertext
    label7.setBounds(20, 480, 120, 32);
    // setting the positions for Cipher text
    CipherText.setBounds(145, 470, 400, 32);
    // setting the positions for key 2
    label8.setBounds(25, 520, 100, 32);
    // setting the positions for key2
    Ky2.setBounds(140, 520, 400, 32);
    // setting the positions for decrypt buttons
    decrypt.setBounds(20, 570, 150, 32);
    // setting the positions for Decrypt results
    label9.setBounds(25, 620, 105, 32);
    // setting  the positions for res2
    R2.setBounds(25, 650, 305, 32);
    // Here this will add all of the components to the panels
    P.setLayout(null);
    // adding panel for main label
    P.add(ML);
    // adding panel for label 1
    P.add(label1);
    // adding panel for label 1
    P.add(label2);
    // adding panel for label 2
    P.add(PlainText);
    // adding panel for Plaintext
    P.add(label3);
    // adding panel for lb3
    P.add(Ky1);
    // adding panel for key1
    P.add(label4);
    // adding panel for lb4
    P.add(R1);
    // adding panel for res1
    P.add(label6);
    // adding panel for lb6
    P.add(label7);
    // adding panel for lb7
    P.add(CipherText);
    // adding panel for ciphertext
    P.add(label8);
    // adding panel for lb8
    P.add(Ky2);
    // adding panel for key2
    P.add(label9);
    // adding panel for lb9
    P.add(R2);
    // adding panel for res2
    P.add(encrypt);
    // adding panel for encrypt
    P.add(decrypt);

    //add panel to frame
    f.getContentPane().add(P);
    // This will set the size of the frame for the panel
    f.setSize(800,1000);
    // This will set true so you can open the panel
    f.setVisible(true);

    //click event handler for encrypt button
    encrypt.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent a)
        {
            //reading the plaintext inside the textfield
            String FS = PlainText.getText();
            //reading the key
            String ky = Ky1.getText();
            //calling the encrypt method to encrypt
            String es = AESCryptosystem.encrypt(FS, ky);
            //displaying the result in result textfield
            StringBuffer stribuff = new StringBuffer();
            char c[] = es.toCharArray();
            // for loop
			 for(int i = 0; i < c.length; i++) 
             {
			     String hs = Integer.toHexString(c[i]);
			     stribuff.append(hs);
			  }
			 String rs = stribuff.toString();
             R1.setText(rs);
        }
    });

    //click event handler for decrypt button
    decrypt.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent a)
        {
            //reading the ciphertext inside the textfield
            String es = CipherText.getText();
            //reading the key
            String ky = Ky2.getText();
            //calling the decrypt method to decrypt
            String rs = new String();
            char[] cA = es.toCharArray();
            for(int i = 0; i < cA.length; i=i+2) 
            {
               String st = ""+cA[i]+""+cA[i+1];
               char c = (char)Integer.parseInt(st, 16);
               rs = rs + c;
            }
            String decryptedString = AESCryptosystem.decrypt(rs, ky) ;
            //displaying the result in result textfield
			 R2.setText(decryptedString);
        }
        });
    }

    private static SecretKeySpec thesecretKey;
    private static byte[] mk;
    // This is for making the key bigger 
    public static void settingtheKey(String primary)
    {
        MessageDigest sha256 = null;
        try 
        {
            mk = primary.getBytes("UTF-8");
            sha256 = MessageDigest.getInstance("SHA-256");
            mk = sha256.digest(mk);
            mk = Arrays.copyOf(mk, 16);
            thesecretKey = new SecretKeySpec(mk, "AES");
        }
        catch (NoSuchAlgorithmException a) 
        {
            a.printStackTrace();
        }
        catch (UnsupportedEncodingException a) 
        {
            a.printStackTrace();
        }
    }

    // Main class to encrypt your input
    public static String encrypt(String StringforEncrypt, String thesecretencryp)
    {
        try
        {
            
            // This will set the key and it will change the key into 48 words
            settingtheKey(thesecretencryp);
            // adding cipher method
            Cipher crypto = Cipher.getInstance("AES/ECB/PKCS5Padding");
            crypto.init(Cipher.ENCRYPT_MODE, thesecretKey);
            return Base64.getEncoder().encodeToString(crypto.doFinal(StringforEncrypt.getBytes("UTF-8")));
        }
        catch (Exception a)
        {
            System.out.println("Their is a error encrypting: " + a.toString());
        }
        return null;
    }

    // this is to decrypt the ciphertext
    public static String decrypt(String stringforDecrypt, String thesecretdecry)
    {
        try
        {
            // This a set key method and this is for expand and to half the key into 48 words
            settingtheKey(thesecretdecry);
            // adding cipher method
            Cipher crypto = Cipher.getInstance("AES/ECB/PKCS5Padding");
            crypto.init(Cipher.DECRYPT_MODE, thesecretKey);
            return new String(crypto.doFinal(Base64.getDecoder().decode(stringforDecrypt)));
        }
        catch (Exception a)
        {
            System.out.println("Their is a error decrypting: " + a.toString());
        }
        return null;
    }
}