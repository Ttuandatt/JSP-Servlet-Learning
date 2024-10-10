package util;

import java.security.MessageDigest;
import java.util.Base64;

public class MaHoa {
    public static String toSHA1(String str) {
        String salt = "ascseknqawcmkfkadsljkhiahw";  // Muối để thêm vào chuỗi trước khi mã hóa
        String result = null;
        str = str + salt;  // Thêm muối vào chuỗi
        
        try {
            // Tách chuỗi thành mảng byte sử dụng mã hóa UTF-8
            byte[] dataBytes = str.getBytes("UTF-8");
            
            // Tạo thể hiện của MessageDigest với thuật toán SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            
            // Cập nhật lại mảng các kỷ tự đã mã hóa bằng thuật toán SHA-1 từ mảng các ký tự kiểu byte dataBytes  
            md.update(dataBytes);
            
            // Thực hiện băm dữ liệu và trả về mảng byte
            byte[] digestBytes = md.digest();
            
            // Mã hóa kết quả bằng Base64
            result = Base64.getEncoder().encodeToString(digestBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	System.out.println(toSHA1("123456"));
    }
}
