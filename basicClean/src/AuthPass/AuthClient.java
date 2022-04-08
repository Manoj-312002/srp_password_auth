package basicClean.src.AuthPass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.UUID;

public class AuthClient {
    public static void main(String[] args) throws Exception {

        Integer s = 543;
        String pc = "4443354h";
        byte[] CText = UUID.randomUUID().toString().replaceAll("-", "").getBytes();

        MessageDigest md = MessageDigest.getInstance("SHA3-256");
        md.update(s.byteValue());

        byte[] hashed_password = md.digest(pc.getBytes("utf-8"));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashed_password)
            sb.append(String.format("%02x", b));
        System.out.println(sb.toString());

        byte[] xor_ct_hs = CText;
        for (int i = 0; i < 32; i++)
            xor_ct_hs[i] ^= hashed_password[i];
        String xor_ct_hs_st = new String(xor_ct_hs, StandardCharsets.US_ASCII);
        xor_ct_hs_st = xor_ct_hs_st.replaceAll("[^\\p{Print}]", "");
        System.out.println(xor_ct_hs_st);
        String pathToImages = "/media/simhan/Simhan/CS/Projects/SRP/images/";
        TextToImage T = new TextToImage(xor_ct_hs_st, pathToImages + "t.jpg");

        Integer s1 = 342;
        md.update(s1.byteValue());
        byte[] hash1 = md.digest(pc.getBytes("utf-8"));

        // FileInputStream tfis = new FileInputStream(pathToImages + "t.jpg");
        // byte tData[] = new byte[tfis.available()];
        // tfis.read(tData);
        // int i = 0;
        // System.out.println(tData.length+" "+tData[0]);
        // for (byte b : tData) {
        //     tData[i] = (byte)(b ^ hash1[i]); 
        //     i++;       
        // }
        // FileOutputStream fos = new FileOutputStream(pathToImages + "t1.jpg");
        // fos.write(tData);
        // fos.close();
        // tfis.close();

    }
}