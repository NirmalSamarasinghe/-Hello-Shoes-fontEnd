package lk.ijse.gdse.helloshoesbackend.util;

import java.util.Base64;

public class UtilMatters {
    public static String generateId(){
        return null;
    }
    public static String convertToBase64(String data){
        return Base64.getEncoder().encodeToString(data.getBytes());
    }
}
