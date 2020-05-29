package mdas.implementacion.usuarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


public class Identificacion {
	
	
	
    /** 
     * Comprueba que los Datos introducidos por el Usuario o Administrador son correctos.
     * El usuario del administrador siempre contendrá admin, de lo contrario será un usuario normal más.
     * @return null Si las credenciales introducidas por el usuario no concuerdan con las del fichero: Users.csv
     */
	
	public String iniciarSesion() {
		
		
		try{
			
			Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner, perteneciente a la biblioteca util
			String user="",pass="";
			System.out.println("Escriba el nombre de usuario: ");
			user=entradaEscaner.nextLine();
			
			System.out.println("Escriba el password: ");
			pass=entradaEscaner.nextLine();
			
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
	
	/** 
	 * Guarda las credenciales introducidas por un usuario normal y se guardan en el fichero: Users.csv.
	 * Si un Administrador se desea registrar, no podrá hacerlo, ya que no se contempla que el nombre de ususario pueda contener addmin.
	 * @return True si se ha registrado correctamente
	 * @return False en caso contrario.
	 */
	public boolean registroUsuario() {
		
		Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner, perteneciente a la biblioteca util
		String user="",pass="";
		FileWriter fichero = null;
        BufferedWriter pw = null;

	    String ficheroUsuarios = "Users.csv";
	    
	    try{

		System.out.println("Escriba el nombre de usuario: ");
		user=entradaEscaner.nextLine();
		while( (user.indexOf("admin") != -1)) {
			System.out.println("No puedes crear un usuario con nombre: admin");
			System.out.println("Escriba de nuevo el nombre de usuario: ");
			user=entradaEscaner.nextLine();
		}
		System.out.println("Escriba una contraseña: ");
		pass=entradaEscaner.nextLine();
		//Meter comprobacion
		fichero = new FileWriter("files" + File.separator + ficheroUsuarios, true);
        pw = new BufferedWriter(fichero);
        pw.write(user + ";" + pass + "\n");
        pw.close();
        
        entradaEscaner.close();
		return true;
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Registro Incorrecto");
		return false;
		
	} //FIN boolean Registro Usuario
	
}
