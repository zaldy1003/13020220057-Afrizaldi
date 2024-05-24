package perpustakaan;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class koneksi {
    private static Connection con;
    public static Connection DBConnection(){
        String DBurl="jdbc:mysql://localhost:3306/perpustakaan_zaldy";
        String user="root";
        String Password="";
        
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = (Connection)DriverManager.getConnection(DBurl, user, Password);
        }catch(SQLException exc){
            System.out.println("koneksi Error" + exc.getMessage());
        }
        return con;
    }
    
    public static void closeConnection(){
        try{
            con.close();
        }catch(SQLException exc){
            System.out.println("Gagal menutup koneksi database" + exc.getMessage());
        }
    }
}
