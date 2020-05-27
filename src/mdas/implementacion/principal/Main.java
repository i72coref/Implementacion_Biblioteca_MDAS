package mdas.implementacion.principal;

import java.util.Scanner;
import mdas.implementacion.usuarios.*;
import mdas.implementacion.SistemaReserva.*;

public class Main {
	
	
	public static void main(String[] args) {
		
		try {
			
	
		Scanner sn = new Scanner (System.in); //Creación de un objeto Scanner, perteneciente a la biblioteca util
        boolean salir = false;
        int opcion;
        while(!salir) {
    		System.out.println("Sistema de Reserva de Bibliotecas\n" +
					   "----------------------------------\n"+
					   "Seleccione una opcion valida:\n\n"+
					   "1. Iniciar Sesion: Alumno.\n"+
					   "2. Iniciar Sesion: Administrador.\n"+
					   "3. Registrar Nueva Cuenta. \n"+
					   "4. Salir. \n");
            opcion = sn.nextInt();
            sn.nextLine();
            
            switch(opcion) {
            case 1:
        		Identificacion opcionelegida1 = new Identificacion();
        		String userOnline = "";
    			userOnline = opcionelegida1.iniciarSesion();
    			if(userOnline != null) {
        			menuAlumno(userOnline);	
    			}
            	break;
            
            case 2:
            	//Funciones opcionelegida2 = new Funciones();
            	String adminOnline = "";
            	//adminOnline = opcionelegida2.iniciarSesion();
    			if(adminOnline != null) {
        			//menuAlumno(userOnline);	
    			}
            	
            	break;
            case 3:
            	
    			Identificacion opcionelegida3 = new Identificacion();
    			opcionelegida3.registroUsuario();
            	break;
            	
            case 4:
    			System.out.println("\n \nGracias por usar el Software\n"+"Hasta la proxima!");
    			salir = true;
    			System.exit(0);
            	
            	break;
            	
            default:
            	System.out.println("Esa opción no está disponible!\n\n");
            
            
            } //Fin Switch
        	
        	
        	
        } //Fin While
        
        sn.close();
		
		}catch(Exception e) {
			
		} finally {
		
		}

	} //VOID main
	
	public static void menuAlumno(String userOnline){
		
		try {
		boolean salir = false;
		Scanner sn = new Scanner (System.in);
		int opcion;
		
		while(!salir) {
			
			
		System.out.println("Bienvenido: \n"+
						   "-----------"+ 
						   "Seleccione una opcion valida:\n\n"+
						   "1. Reservar Aula.\n"+
						   "2. Mis Reservas.\n"+
						   "3. Mis Sanciones.\n"+
						   "4. Consultar Reservas.\n"+
						   "5. Salir. \n");
		
        opcion = sn.nextInt();
        sn.nextLine();
        
		switch(opcion) {
		case 1:
			SistemaReserva opcionReserva = new SistemaReserva();
			opcionReserva.reservarAula(userOnline);
			break;
			
		case 2:
			
			
			break;
			
		case 3:
			
			break;
			
		case 4:
			SistemaReserva opcionReserva1 = new SistemaReserva();
			opcionReserva1.consultarReservas();
			break;
			
        default:
        	System.out.println("Esa opción no está disponible.");
        	
		} //fin switch
		
		} //fin while
		
		sn.close();
		
		}catch(Exception e) {
			
		} finally {
		
		}
	} //VOID menuAlumno
	
	public static void menuAdmin(String userOnline){
		
		try {
		boolean salir = false;
		Scanner sn = new Scanner (System.in);
		int opcion;
		
		while(!salir) {
			
			
		System.out.println("Bienvenido: \n"+
						   "-----------"+ 
						   "Seleccione una opcion valida:\n\n"+
						   "1. Añadir Aula.\n"+
						   "2. Borrar Sala"+
						   "3. Salir. \n");
		
        opcion = sn.nextInt();
        sn.nextLine();
        
		switch(opcion) {
		case 1:
			//Funciones opcion1 = new Funciones();
			//opcion1.añadirSala();
			break;
		case 2:
			
			break;
		case 3:
			System.out.println("\n \nGracias por usar el Software\n"+"Hasta la proxima!");
			salir = true;
			System.exit(0);
			break;
			
        default:
        	System.out.println("Esa opción no está disponible.");
        	
		} //fin switch
		
		} //fin while
		
		sn.close();
		
		}catch(Exception e) {
			
		} finally {
		
		}
	} //VOID menuAdmin
	
	/*
	public static void ReservaAula(String[] args) {
		
		
		System.out.println("Reserva de Aula: \n"+
				   		   "--------------- \n");
		
		System.out.println("Intruduce el Numero de alumnos:\n");
		
		
	} //Void Reserva Aula
	
	public static void MisSanciones(String[] args) {
		
	} //Void Mis Sanciones*/
	
} //Clase MAIN.
