import java.security.*;
import java.util.Arrays;
import java.io.*;
import javax.xml.bind.DatatypeConverter;
class main{
    
    public static void main(String[] args){
        
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            String key = "ckczppom";
            Long nonce = Long.valueOf(0);
            boolean work = true;
        
            while(work){
            String combined = key + nonce.toString();
                byte[] bytesOfMessage = combined.getBytes("UTF-8");
                byte[] thedigest = md.digest(bytesOfMessage);
                
                String hexvalue = DatatypeConverter.printHexBinary(thedigest);
                
                if (hexvalue.substring(0,5).equals("00000")){
                    System.out.println("Key: "+ key +" Nonce: " + nonce);
                    work = false;
                }
                nonce+=Long.valueOf(1);
            }
            
        } catch(NoSuchAlgorithmException e){
            
        } catch(UnsupportedEncodingException e){}
        
    }
    
}