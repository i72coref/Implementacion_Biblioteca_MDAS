package mdas.implementacion.principal;

import java.util.Scanner;
import mdas.implementacion.usuarios.*;
import mdas.implementacion.SistemaReserva.*;
import mdas.implementacion.Espacio.*;

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
					   "1. Iniciar Sesion.\n"+
					   "2. Registrar Nueva Cuenta. \n"+
					   "3. Salir. \n");
            opcion = sn.nextInt();
            sn.nextLine();
            
            switch(opcion) {
            case 1:
        		Identificacion opcionelegida1 = new Identificacion();
        		String userOnline = "";
    			userOnline = opcionelegida1.iniciarSesion();
    			if(userOnline != null) {
    				
    				if( (userOnline.indexOf("admin") == -1)) {
    					menuAlumno(userOnline);
    				}
    				else {
    					menuAdmin(userOnline);
    				}
        				
    			}
            	break;
            
            case 2:
            	
            	Identificacion opcionelegida2 = new Identificacion();
            	if(opcionelegida2.registroUsuario() == false) {
            		System.out.println("Registro Incorrecto vuelve a intentarlo!\n");
            	}
            	else {
            		System.out.println("Registro Correcto!\n");
            	}
            	
            	break;
            case 3:
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
			
			
		System.out.println("Bienvenido Alumno: \n"+
						   "-----------"+ 
						   "Seleccione una opcion valida:\n\n"+
						   "1. Reservar Aula.\n"+
						   "2. Consultar Reservas.\n"+
						   "3. Modificar Reserva\n"+
						   "4. Salir. \n");
		
        opcion = sn.nextInt();
        sn.nextLine();
        
		switch(opcion) {
		case 1:
			SistemaReserva opcionReserva = new SistemaReserva();
			opcionReserva.reservarAula(userOnline);
			break;
			
		case 2:
			SistemaReserva opcionConsultar = new SistemaReserva();
			opcionConsultar.consultarReservas();
			
			break;
			
		case 3:
			
			break;
			
		case 4:
			SistemaReserva opcionReserva1 = new SistemaReserva();
			opcionReserva1.consultarReservas();
			break;
			
        default:
        	System.out.println("Esa opción no está disponible o no has escrito el número bien.\n");
        	
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
			
			
		System.out.println("Bienvenido Administrador: \n"+
						   "-----------"+ 
						   "Seleccione una opcion valida:\n\n"+
						   "1. Registrar Sala de Estudio.\n"+
						   "2. Borrar Sala de Estudio.\n"+
						   "3. Salir. \n");
		
        opcion = sn.nextInt();
        sn.nextLine();
        
		switch(opcion) {
		case 1:
			GestionEspacio opcion1 = new GestionEspacio();
			if( opcion1.añadirEspacio() == true ) {
				System.out.println("El espacio se ha añadido correctamente");
			}
			break;
		case 2:
			
			break;
		case 3:
			System.out.println("\n \nGracias por usar el Software\n"+"Hasta la proxima!");
			salir = true;
			System.exit(0);
			break;
			
        default:
        	System.out.println("Esa opción no está disponible o no has escrito el número bien.");
        	
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
