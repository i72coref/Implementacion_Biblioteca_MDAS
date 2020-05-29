package mdas.implementacion.SistemaReserva;

public interface IGestionReserva {

	public String getAsignatura();
	public void setAsignatura(String asignatura);
	public String getNombreAlumnoReserva();
	public void setNombreAlumnoReserva(String nombreAlumnoReserva);
	public int getNumAlumnos();
	public void setNumAlumnos(int numAlumnos);
	
	public void reservarAula(String userOnline);
	public void comprobarAulas(int aforoRequerido, int respuestaProyector, int respuestaPizarra, String userOnline);
	public void guardarReserva(String userAlumnoReserva, String nombreAula, String fecha);
	public void consultarReservas();
	public String comprobarDisponibilidadDeFecha(String aulaDeseada);
	public Boolean comprobarFechaConFicheroDeReserva(String fechaDeseada, String aulaDeseada);
	public Boolean comprobarFechaConLaActualDelDia();
	public void removeLineFromFile(String file, String lineToRemove);
	
}
