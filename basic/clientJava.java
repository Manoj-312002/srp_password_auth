package basic;
import java.security.*;
import java.util.Base64;
import java.util.UUID; 

public class clientJava {
    public static void main(String[] args) throws Exception {

        Integer s = 543;
        String pc = "4443354h";
        byte [] CText = UUID.randomUUID().toString().replaceAll("-", "" ).getBytes();

        MessageDigest md = MessageDigest.getInstance("SHA3-256");
        md.update( s.byteValue() );

        byte[] hashed_password = md.digest( pc.getBytes("utf-8") );
        
        StringBuilder sb = new StringBuilder();
        for (byte b : hashed_password )  sb.append(String.format("%02x", b));
        System.out.println(sb.toString());
        
        byte [] xor_ct_hs = CText;
        for( int i = 0; i < 32; i++ )  xor_ct_hs[i] ^= hashed_password[i];
        
        String xor_ct_hs_st = new String( xor_ct_hs , "utf-8" );
        
        StringBuilder sb1 = new StringBuilder();
        for (byte b : xor_ct_hs )  sb1.append(String.format("%02x", b));
        System.out.println(sb1.toString());
        
        System.out.println( xor_ct_hs_st );
        System.out.println( Base64.getEncoder().encodeToString( xor_ct_hs ) );
        // textToImg tx = new textToImg();
        
    }
}