package mdas.implementacion.usuarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class Identificacion {
	
	public String iniciarSesion() {
		
		
		try{
			
			Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner, perteneciente a la biblioteca util
			String user="",pass="";
			System.out.println("Escriba el nombre de usuario: ");
			user=entradaEscaner.nextLine();
			
			System.out.println("Escriba el password: ");
			pass=entradaEscaner.nextLine();
			//C:\\Users\\david\\git\\MDAS_proyecto\\files
			
			String ficheroUsuarios ="Users.csv";
			BufferedReader readerUser = new BufferedReader(new FileReader("files" + File.separator + ficheroUsuarios));
			
			String line = "";
	        while((line = readerUser.readLine()) != null){

	            String[] array = line.split(";");
	            String part1 = array[0]; //user
	    		String part2 = array[1]; //password

	    		if(user.equals(part1) && pass.equals(part2)) {
	    			Usuario alTemp = new Usuario();
		    		alTemp.setUser(part1);
		    		alTemp.setPassword(part2);
		            System.out.println("Inicio de sesión correcto");
		            readerUser.close();
		            return user;
	    		}
	    		
	        }
			readerUser.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Usuario o password incorrecto");
		
		return null;
	}
	
public boolean registroUsuario() {
		
		Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner, perteneciente a la biblioteca util
		String user="",pass="";
		FileWriter fichero = null;
        BufferedWriter pw = null;

	    String ficheroUsuarios = "Users.csv";
	    
	    try{

		System.out.println("Escriba el nombre de usuario: ");
		user=entradaEscaner.nextLine();
		System.out.println("Escriba una contraseña: ");
		pass=entradaEscaner.nextLine();
		//Meter comprobacion
		fichero = new FileWriter("files" + File.separator + ficheroUsuarios, true);
        pw = new BufferedWriter(fichero);
        pw.write(user + ";" + pass + "\n");
        pw.close();

		return true;
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Registro Incorrecto");
		return false;
		
	} //FIN boolean Registro Usuario
	
	public boolean registroUsuario2() {
		Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner, perteneciente a la biblioteca util
		String user="",pass="";
		
	    BufferedReader br = null;
	    BufferedWriter bw = null;
	    File fold = null;
	    File fnew = null;
	    String ruta1 = "C:\\Users\\Pnh\\git\\MDAS_proyecto22\\files\\Users2.csv";
	    String ruta2 = "C:\\Users\\Pnh\\git\\MDAS_proyecto22\\files\\Users.csv";
	    
	    try{
	    
	    fold = new File(ruta1);
	    fnew = new File(ruta2);

		System.out.println("Escriba el nombre de usuario: ");
		user=entradaEscaner.nextLine();
		System.out.println("Escriba una contraseña: ");
		pass=entradaEscaner.nextLine();
		
		if(fold.exists()) {
			
			br = new BufferedReader(new FileReader(fold));
			String linea;
			
			while( (linea=br.readLine()) != null) {
				bw = new BufferedWriter(new FileWriter(fnew, true));
				bw.write(linea+"\n");
				bw.close();
			}
			br.close();
			
			bw = new BufferedWriter(new FileWriter(fnew, true));	
			bw.write(user+";"+pass);
			bw.close();
			
			fold.delete();
			fnew.renameTo(fold);
		}
		System.out.println("Registro Correcto!");
		return true;
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Registro Incorrecto");
		return false;
		
	}
}
