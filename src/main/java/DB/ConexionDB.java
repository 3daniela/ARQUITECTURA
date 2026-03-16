package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {

    public static Connection conectar(){

        Connection conn = null;

        try{

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crud_productos",
                    "root",
                    ""
            );

        }catch(Exception e){
            e.printStackTrace();
        }

        return conn;
    }
}