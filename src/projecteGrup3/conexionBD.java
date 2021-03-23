package projecteGrup3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionBD {
	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://192.168.1.147:3306/SABERYGANAR";
    private static final String USUARIO = "precognissql";
    private static final String CLAVE = "precognissql";

    public static Connection conectar() {
        Connection conexion = null;
        
        try {
            Class.forName(CONTROLADOR);
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexi�n OK");

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Error en la conexi�n");
            e.printStackTrace();
        }
        
        return conexion;
    }
    public static void main(String[] args) {
    	conectar();
    }
}
