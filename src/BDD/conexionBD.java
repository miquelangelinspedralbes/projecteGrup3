package BDD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class conexionBD {
	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/saberyganar";
    private static final String USUARIO = "root";
    private static final String CLAVE = "alumne";
    private static int contPreguntas = 1;
    static Connection conexion = null;
    
    public static Connection conectar() {
        
        try {
            Class.forName(CONTROLADOR);
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexi�n OK");
            try {
            	introducirMates(conexion, 15);
				introducirIngles(conexion);
				introducirLetras(conexion);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Error en la conexi�n");
            e.printStackTrace();
        }
        
        return conexion;
    }
    
    public static void introducirIngles(Connection conexion) throws IOException {
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    PreparedStatement stmt = null;
	    PreparedStatement incremental = null;
	    int i = 0;
        try
        {
        	archivo = new File ("angles.txt");
        	fr = new FileReader (archivo);
            br = new BufferedReader(fr);

             // Lectura del fichero
             String linea;
             String pregunta = "";
             while((linea=br.readLine())!=null) {
            	 if (i == 0) {
            		 stmt = null;
            		 stmt = conexion.prepareStatement("INSERT INTO INGLES VALUES (?,?,?,?)");
            		 incremental = conexion.prepareStatement("INSERT INTO PREGUNTAS VALUES ()");
            		 i++;
            	 }if (i == 1) {
            		 stmt.setString(4, linea);
            	 }else if (i == 2) {
            		 pregunta = pregunta + "|" + linea;
            		 stmt.setString(3, linea);
            	 }else if (i == 5) {
            		 pregunta = pregunta + "|" + linea;
            		 stmt.setString(2, pregunta);
            		 stmt.setInt(1, contPreguntas);
            		 incremental.executeUpdate();
            		 stmt.executeUpdate();
            		 contPreguntas++;
            		 pregunta = "";
            		 i = 0;
            	 }else {
            		 pregunta = pregunta + "|" + linea;
            	 }
             	i++;
             }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try{                    
                if( null != fr ){   
                   fr.close();     
                }                  
             }catch (Exception e2){ 
                e2.printStackTrace();
             }
        }
	}
    
    public static void introducirLetras(Connection conexion) throws IOException {
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    PreparedStatement stmt = null;
	    PreparedStatement incremental = null;
	    int numLetrasOcultas, numRandom;
	    char[] oculta;
	    String palabraOculta;
        try
        {
        	archivo = new File ("diccionari.txt");
        	fr = new FileReader (archivo);
            br = new BufferedReader(fr);

             // Lectura del fichero
             String linea;
             while((linea=br.readLine())!=null) {
            	 oculta = linea.toCharArray();
            	 stmt = conexion.prepareStatement("INSERT INTO LETRAS VALUES (?,?,?)");
        		 incremental = conexion.prepareStatement("INSERT INTO PREGUNTAS VALUES ()");
        		 incremental.executeUpdate();
        		 numLetrasOcultas = linea.length()/3;
        		 for (int i = 0; i < numLetrasOcultas; i++) {
        			 numRandom = (int) (Math.random()*linea.length());
        			 if (oculta[numRandom] != '*') {						
        				 oculta[numRandom] = '*';
					}else {
						i--;
					}
        		 }
        		 palabraOculta = new String(oculta);
        		 stmt.setInt(1, contPreguntas);
        		 stmt.setString(2, palabraOculta);
        		 stmt.setString(3, linea);
        		 stmt.executeUpdate();
        		 contPreguntas++;
             }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try{                    
                if( null != fr ){   
                   fr.close();     
                }                  
             }catch (Exception e2){ 
                e2.printStackTrace();
             }
        }
	}
    
    public static void introducirMates(Connection conexion, int cantInsert) throws IOException{
	    PreparedStatement stmt = null;
	    PreparedStatement incremental = null;
	    int randomLongitud, randomNum, randomOperacio, resultado;
	    String operacion = "";
        try
        {
             // Lectura del fichero
             for (int i = 0; i < cantInsert; i++){        	 
            	 stmt = conexion.prepareStatement("INSERT INTO MATES VALUES (?,?,?)");
        		 incremental = conexion.prepareStatement("INSERT INTO PREGUNTAS VALUES ()");
        		 incremental.executeUpdate();
        		 randomLongitud = (int) (Math.random()*5 + 4);
        		 for (int z = 0; z < randomLongitud; z++) {
        			 randomNum = (int) (Math.random()*11 + 2);
        			 randomOperacio = (int) (Math.random()*3);
        			 operacion += randomNum;
        			 if (z < (randomLongitud - 1)) {						
        				 if(randomOperacio == 0)
        					 operacion += " + ";
        				 else if(randomOperacio == 1)
        					 operacion += " - ";
        				 else
        					 operacion += " * ";
					}
        		 }
        		 ScriptEngineManager manager = new ScriptEngineManager();
        		 ScriptEngine engine = manager.getEngineByName("javascript");
        		 Object result = engine.eval(operacion);
        		 resultado = Integer.decode(result.toString());
        		 
        		 stmt.setInt(1, contPreguntas);
        		 stmt.setString(2, operacion);
        		 stmt.setInt(3, resultado);
        		 stmt.executeUpdate();
        		 contPreguntas++;
        		 operacion = "";
             }

        } catch (Exception e) {
            e.printStackTrace();
        } 
	}
    
    public Connection obtenerConexion() {
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
}
