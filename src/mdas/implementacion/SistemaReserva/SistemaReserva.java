/**
 * Fichero que gestiona todo el sistema de reservas
 * @version 1.0, 29/05/2020
 * @author David Bermejo Sanchez, Francisco Javier Cordoba Rey, Jorge Jesus Chaparro Ibarra, Manuel Gomez Serrano, Sergio Alhama Cosano
 */

package mdas.implementacion.SistemaReserva;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;




public class SistemaReserva {

	/** 
	 * Permite escoger que caracteristicas tiene que tener el aula que deseas
	 * @param userOnline Usuario que esta conectado
	 * @return nada
	 */
	
	public void reservarAula(String userOnline) {//He pensado en que tengamos una ilsta con las posibilidades y que en funcion de las respuestas que nos den les asignmos ese aula, que estaria en un doc
		

	    try {
	    	//meter comprobacion para ver si esta en lista negra o no
			Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner, perteneciente a la biblioteca util

	    	int aforoRequerido = 0, respuestaProyector = 0, respuestaPizarra = 0;
	    	System.out.println("¿Que aforo necesitas para el aula? (indicar numero)");
	    	
	    	aforoRequerido = entradaEscaner.nextInt();
			entradaEscaner.nextLine();//Con esto limpiamos el buffer, ya que next int coge los enteros que encuentre pero se deja el salto de linea \n, por tanto, el siguiente nextLine se come el salto de linea y genera problemas
				    	
	    	System.out.println("¿Necesitas proyector? 1->Si 2->No");
	    	
	    	respuestaProyector = entradaEscaner.nextInt();
			entradaEscaner.nextLine();//Con esto limpiamos el buffer, ya que next int coge los enteros que encuentre pero se deja el salto de linea \n, por tanto, el siguiente nextLine se come el salto de linea y genera problemas
				    	
	    	System.out.println("¿Necesitas pizarra? 1->Si 2->No");
	    	
	    	respuestaPizarra = entradaEscaner.nextInt();
			entradaEscaner.nextLine();//Con esto limpiamos el buffer, ya que next int coge los enteros que encuentre pero se deja el salto de linea \n, por tanto, el siguiente nextLine se come el salto de linea y genera problemas
			
	    	//ahora lo mandamos a otra funcion para hacer el check con el doc de aulas.txt
			comprobarAulas(aforoRequerido,respuestaProyector,respuestaPizarra, userOnline);
			
			entradaEscaner.close();
	    }catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	/** 
	 * Comprueba las aulas en funcion de lo especificado previamente
	 * @param aforoRequerido 
	 * @param respuestaProyector
	 * @param respuestaPizarra
	 * @param userOnline
	 * @return nada
	 */
	
	public void comprobarAulas(int aforoRequerido, int respuestaProyector, int respuestaPizarra, String userOnline) {
		
		
	    try {
	    	
			int aforoAula = 0, proyectorAula = 0, pizarraAula = 0;
	    	
	    	String ficheroAulas = "Aulas.csv";
			BufferedReader readerAulas = new BufferedReader(new FileReader("files" + File.separator + ficheroAulas));

	        System.out.println("Buscamos aulas disponibles..");
	        String line = "";
	        while((line = readerAulas.readLine()) != null){
	        	//Nombre;ubicacion;aforo;proyector(1 es si, 2 es no);pizarra
	        	
	            String[] array = line.split(";");
	            String part1 = array[0]; //nombre Aula
	    		String part2 = array[1]; //ubicacion
	    		String part3 = array[2]; //aforo
	    		String part4 = array[3]; //proyector
	    		String part5 = array[4]; //pizarra
	    		String part6 = array[5]; //Tipo sala
	    		
	    		
	    		aforoAula = Integer.parseInt(part3);
	    		proyectorAula = Integer.parseInt(part4);
	    		pizarraAula = Integer.parseInt(part5);

	    		if(aforoAula > aforoRequerido && proyectorAula == respuestaProyector && pizarraAula == respuestaPizarra) {
	    			String fechaDisponible = comprobarDisponibilidadDeFecha(part1);
	    			System.out.println("El aula asignada es " + part1 + " el día " + fechaDisponible + " ubicada en " + part2);
	    			guardarReserva(userOnline, part1, fechaDisponible);
	    			readerAulas.close();
	    			return;//Salgo de la funcion
	    		}
	        }
	        
	        System.out.println("No se ha podido encontrar ningun aula disponible con las especificaciones dadas");
	        readerAulas.close();
	        
	    }catch (Exception e) {
			// TODO: handle exception
		}
	    
		
	}
	
	/** 
	 * Guarda la reserva en el fichero de reservas
	 * @param userAlumnoReserva
	 * @param nombreAula
	 * @param fecha
	 * @return nada
	 */
	
	public void guardarReserva(String userAlumnoReserva, String nombreAula, String fecha) {
		FileWriter fichero = null;
        BufferedWriter pw = null;
		try {

			System.out.println("Guardando reserva...");
			String ficheroReservas = "Reservas.csv";
			fichero = new FileWriter("files" + File.separator + ficheroReservas, true);
            pw = new BufferedWriter(fichero);
            pw.write(userAlumnoReserva + ";" + fecha + ";" + userAlumnoReserva + ";" + nombreAula + "\n");
            pw.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	/** 
	 * Muestra las reservas en vigor actualmente
	 * @return nada
	 */
	
	public void consultarReservas() {
		
		try {
	
			String ficheroReservas= "Reservas.csv";
			BufferedReader readerStudent = new BufferedReader(new FileReader("files" + File.separator + ficheroReservas));
	        
	        String line = "";
	        while((line = readerStudent.readLine()) != null){        	
	        	
	        	//Alumno alTemp = new Alumno(0,null,null,0);
	            String[] array = line.split(";");
	            String part1 = array[0]; //Alumno
	    		String part2 = array[1]; //Fecha
	    		String part3 = array[2]; //Responsable
	    		String part4 = array[3]; //Aula
	    		
	    		if(comprobarFechaConLaActualDelDia(part2)) {
		    		System.out.println("El alumno " + part1 + " ha realizado una reserva para el día " + part2 + " del aula " + part4 + " y como responsable " + part3);
	    		}
	    		
	        }
	        
	        readerStudent.close();
		
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/** 
	 * Guarda la reserva en el fichero de reservas
	 * @param userOnline
	 * @return boolean por si tiene o no reservas realizadas el usuario
	 */
	
	public boolean consultarReservasUser(String UserOnline) {
		try {
			
			String ficheroReservas= "Reservas.csv";
			BufferedReader readerStudent = new BufferedReader(new FileReader("files" + File.separator + ficheroReservas));
	       int reservasEncontradas = 0;
			String line = "";
	        while((line = readerStudent.readLine()) != null){        	
	        	
	        	//Alumno alTemp = new Alumno(0,null,null,0);
	            String[] array = line.split(";");
	            String part1 = array[0]; //Alumno
	    		String part2 = array[1]; //Fecha
	    		String part3 = array[2]; //Responsable
	    		String part4 = array[3]; //Aula
	    		
	    		if(part1.equals(UserOnline) && comprobarFechaConLaActualDelDia(part2)) {
	    			reservasEncontradas = 1;
		    		System.out.println("El alumno " + UserOnline + " ha realizado una reserva para el día " + part2 + " del aula " + part4 + " y como responsable " + part3);
	    		}
	    		
	        }
	        
	        readerStudent.close();
			
	        if(reservasEncontradas == 1) {
	        	return true;
	        }else {
	        	return false;
	        }
	        
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	/** 
	 * Comprueba que escribes esta disponible
	 * @param aulaDeseada
	 * @return String con la fecha deseada
	 */
	
	public String comprobarDisponibilidadDeFecha(String aulaDeseada) {
		
		try {
			Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner, perteneciente a la biblioteca util
			Boolean check = false;
			System.out.println("Escriba la fecha para la reserva: dd/MM/yyyy");
			String fechaDeseada = entradaEscaner.nextLine();
			
			check = comprobarFechaConFicheroDeReserva(fechaDeseada,aulaDeseada);
			while(!check) {
				System.out.println("Escoja otra fecha");
				fechaDeseada = entradaEscaner.nextLine();
				check = comprobarFechaConFicheroDeReserva(fechaDeseada,aulaDeseada);
			}
			entradaEscaner.close();
			return fechaDeseada;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
		
	}
	
	/** 
	 * Comprueba en la base de datos para el aula deseada si esta disponible el dia deseado
	 * @param fechaDeseada
	 * @param aulaDeseada
	 * @return boolean por si esta disponible el dia para el aula o no
	 */
	
	public Boolean comprobarFechaConFicheroDeReserva(String fechaDeseada, String aulaDeseada) {

	    
	    try {
	    	
	    	String ficheroReservas = "Reservas.csv";
			BufferedReader readerReservas = new BufferedReader(new FileReader("files" + File.separator + ficheroReservas));

	        System.out.println("Comprobando que no coincidan fechas reservadas previamente...");
	        String line = "";
	        while((line = readerReservas.readLine()) != null){
	        	
	            String[] array = line.split(";");
	            String part1 = array[0]; //Alumno
	    		String part2 = array[1]; //Fecha
	    		String part3 = array[2]; //Responsable
	    		String part4 = array[3]; //Aula

	    		if(aulaDeseada.equals(part4) && fechaDeseada.equals(part2)) {
	    			
	    			readerReservas.close();
	    	        System.out.println("Ese dia ya ha sido reservado, escoja otro");
	    			return false;//Salgo de la funcion
	    		}
	        }
	        System.out.println("Fecha disponible");
	        readerReservas.close();
	        return true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;

		
	}
	
	/** 
	 * Nos permite modificar una reserva del propio usuario cambiando la reserva completa o su fecha
	 * @param userOnline
	 * @return boolean para comprobar si tiene reservas realizadas o no, devolviendo al menu en caso de no tener ninguna reserva
	 */
	
	public boolean modificarUnaReserva(String UserOnline) {
		FileWriter fichero = null;
        BufferedWriter pw = null;
		try {
			
			if (consultarReservasUser(UserOnline) == true) {
				System.out.println("Estamos Activos");
			
			
			Scanner sn = new Scanner (System.in);
			int opcion;
			
	        
	        
	        System.out.println("¿Que Reserva quieres modificar? Indica la fecha de esa reserva \n");
	        String fechaReferencia = sn.nextLine();
	        
	        String ficheroReservas= "Reservas.csv";
			BufferedReader readerStudent = new BufferedReader(new FileReader("files" + File.separator + ficheroReservas));
	        
	        String line = "";
	        String alumnoM="";
	        String fechaM="";
	        String responsableM="";
	        String aulaM="";
	        String lineToRemove="";
	        
	        while((line = readerStudent.readLine()) != null){        	
	        	
	        	
	            String[] array = line.split(";");
	            String part1 = array[0]; //Alumno
	    		String part2 = array[1]; //Fecha
	    		String part3 = array[2]; //Responsable
	    		String part4 = array[3]; //Aula
	    		
	    		if(part2.equals(fechaReferencia)) {
	    			alumnoM = part1;
	    			fechaM=part2;
	    			responsableM=part3;
	    			aulaM=part4;
	    			
	    			lineToRemove = alumnoM + ";" + fechaM + ";" + responsableM + ";" + aulaM;
	    			
	    		}
	        }
	        
	        readerStudent.close();
	        
			
			System.out.println("¿Que dato de la Reserva deseas modificar?: \n"+
			   		"------------------------------------------------"+ 
			   "Seleccione una opcion valida:\n\n"+
			   "1. Fecha\n"+
			   "2. Aula/Reserva\n");
			
			opcion = sn.nextInt();
	        sn.nextLine();
			removeLineFromFile(ficheroReservas, lineToRemove);

			switch(opcion) {
			
			
			case 1:
				System.out.println("Escrible la nueva fecha: dd/MM/yyyy");
				String fechaModificada = sn.nextLine();
				
				while(!comprobarFechaConLaActualDelDia(fechaModificada)) {
					System.out.println("Escribe una fecha posterior al día de hoy");
				}
				
				fichero = new FileWriter("files" + File.separator + ficheroReservas, true);
	            pw = new BufferedWriter(fichero);
	            pw.write(alumnoM + ";" + fechaModificada + ";" + responsableM + ";" + aulaM + "\n");
	            
	            System.out.println("Fecha modificada");
	            pw.close();
				
				break;
				
			case 2:
				
				reservarAula(UserOnline);
				
				break;
				
				
			default:
				System.out.println("Esa opción no está disponible o no has escrito el número bien.\n");
			}
			
			sn.close();
			return true; //modificarUnaReserva
			}else {
				System.out.println("No tienes reservas realizadas, por tanto, no puedes modificar");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}
	
	/** 
	 * comprobación de la fecha pasada como parametro para saber si es anterior, igual o posterior al día de hoy
	 * @param fechaDeseada
	 * @return boolean true si la fecha actual es anterior a la deseada y false si es igual o superior
	 */
	
	public Boolean comprobarFechaConLaActualDelDia(String fechaDeseada) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			
	        Calendar fechaActual = new GregorianCalendar();
	        //Obtenemos el valor del año, mes, día
	        int año = fechaActual.get(Calendar.YEAR);
	        int mes = fechaActual.get(Calendar.MONTH);
	        int dia = fechaActual.get(Calendar.DAY_OF_MONTH);
	        
	        String cadenaFechaActual = dia+"/"+(mes+1)+"/"+año;
			
			Date fechaActualAComparar = sdf.parse(cadenaFechaActual);
			Date fechaDeseadaAComparar = sdf.parse(fechaDeseada);
			
			if(0 > fechaActualAComparar.compareTo(fechaDeseadaAComparar)) {//Este caso si la fecha actual es mas pronto que la deseada
				return true;
			}else {
				return false;
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	/** 
	 * Borra una linea del fichero de reservas
	 * @param ficheroReservas
	 * @param lineToRemove
	 * @return nada
	 */
	
	public void removeLineFromFile(String ficheroReservas, String lineToRemove) {

		Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner, perteneciente a la biblioteca util
		String nombresala=lineToRemove;
		
	    BufferedReader br = null;
	    BufferedWriter bw = null;
	    File fold = null;
	    File fnew = null;
	    String ruta1 = ficheroReservas;
	    String ruta2 = "aux"+ficheroReservas;
	    
	    try{
	    
	    fold = new File("files" + File.separator + ruta1);
	    fnew = new File("files" + File.separator + ruta2);
		
		if(fold.exists()) {
			
			br = new BufferedReader(new FileReader(fold));
			String linea;
			
			while( (linea=br.readLine()) != null) {
				
				if (linea.indexOf(nombresala) == -1) {
				
				bw = new BufferedWriter(new FileWriter(fnew, true));
				bw.write(linea+"\n");
				bw.close();
				}
				else {
				
				}
			}
			br.close();
			
			bw = new BufferedWriter(new FileWriter(fnew, true));	
			bw.close();
			entradaEscaner.close();
			fold.delete();
			fnew.renameTo(fold);
		}
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
