package main;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.jdbc.Driver;
import java.sql.SQLException;

public class koneksi {

    private static Connection con;
    public static Connection DBConnection(){
        String DBurl="jdbc:mysql://localhost:3306/mahasiswa_pbo";
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
