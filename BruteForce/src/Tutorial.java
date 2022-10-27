import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Tutorial {

    Tutorial(){
        compare();
    }

    static void compare(){
        byte[] userDefined = null;
        try {
            userDefined = hash(Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter your integer !")));
        }
        catch (Exception e) {
            compare();
        }

        for(int i =0; i<2147000000;i++) {
            System.out.println(i);
           if(MessageDigest.isEqual(hash(i), userDefined)) {
               System.out.println("Found a match for " + i);
               System.exit(0);
               break;
           }
        }
        System.out.println("No match found !");

    }

    static byte[] hash(int input) {
        byte[] output=null;
        String inp=Integer.toString(input);
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            output = digest.digest(inp.getBytes(StandardCharsets.UTF_8));
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return output;
    }
    public static void main(String[] args) {

        new Tutorial();
    }
}