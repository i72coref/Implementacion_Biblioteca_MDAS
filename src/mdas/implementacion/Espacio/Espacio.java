package mdas.implementacion.Espacio;

public class Espacio {
	
	private int id;
	private String ubicacion, aforo, nombre;
	private Boolean proyector, pizarra;
	private enum categoriaEspacio {
		AULA,SALA_USO_MULTIPLE,LABORATORIO
	}
	
		public Espacio() {
			
		}

		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}
		/**
		 * @return the nombre
		 */
		public String getNombre() {
			return nombre;
		}
		
		/**
		 * @param nombre the nombre to set
		 */
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}

		/**
		 * @return the ubicacion
		 */
		public String getUbicacion() {
			return ubicacion;
		}

		/**
		 * @param ubicacion the ubicacion to set
		 */
		public void setUbicacion(String ubicacion) {
			this.ubicacion = ubicacion;
		}

		/**
		 * @return the aforo
		 */
		public String getAforo() {
			return aforo;
		}

		/**
		 * @param aforo the aforo to set
		 */
		public void setAforo(String aforo) {
			this.aforo = aforo;
		}

		/**
		 * @return the proyector
		 */
		public Boolean getProyector() {
			return proyector;
		}

		/**
		 * @param proyector the proyector to set
		 */
		public void setProyector(Boolean proyector) {
			this.proyector = proyector;
		}

		/**
		 * @return the pizarra
		 */
		public Boolean getPizarra() {
			return pizarra;
		}

		/**
		 * @param pizarra the pizarra to set
		 */
		public void setPizarra(Boolean pizarra) {
			this.pizarra = pizarra;
		}
	
}
