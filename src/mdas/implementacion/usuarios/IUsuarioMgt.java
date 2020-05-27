package mdas.implementacion.usuarios;

public interface IUsuarioMgt {
	
	public String getUser();
	public void setUser(String user);
	public String getPassword();
	public void setPassword(String password);
	public String iniciarSesion();
	boolean registroUsuario2();

}
