package mdas.implementacion.Espacio;

public interface IEspacioMgt {
	
	public int getId();
	public String getNombre();
	public void setNombre(String nombre);
	public void setId(int id);
	public String getUbicacion();
	public void setUbicacion(String ubicacion);
	public String getAforo();
	public void setAforo(String aforo);
	public Boolean getProyector();
	public void setProyector(Boolean proyector);
	public Boolean getPizarra();
	public void setPizarra(Boolean pizarra);
	public boolean añadirEspacio();
	public void mostrarEspacios();
	
}
