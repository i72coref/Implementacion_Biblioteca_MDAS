package mdas.implementacion.SistemaReserva;

public class Reserva {

	private String asignatura,nombreAlumnoReserva;
	private int numAlumnos;
	
	
	public Reserva() {
		
	}


	/**
	 * @return the asignatura
	 */
	public String getAsignatura() {
		return asignatura;
	}


	/**
	 * @param asignatura the asignatura to set
	 */
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}


	/**
	 * @return the nombreAlumnoReserva
	 */
	public String getNombreAlumnoReserva() {
		return nombreAlumnoReserva;
	}


	/**
	 * @param nombreAlumnoReserva the nombreAlumnoReserva to set
	 */
	public void setNombreAlumnoReserva(String nombreAlumnoReserva) {
		this.nombreAlumnoReserva = nombreAlumnoReserva;
	}


	/**
	 * @return the numAlumnos
	 */
	public int getNumAlumnos() {
		return numAlumnos;
	}


	/**
	 * @param numAlumnos the numAlumnos to set
	 */
	public void setNumAlumnos(int numAlumnos) {
		this.numAlumnos = numAlumnos;
	}
}
