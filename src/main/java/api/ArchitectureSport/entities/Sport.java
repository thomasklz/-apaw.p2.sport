package api.ArchitectureSport.entities;

public class Sport {

	private int id;
	private String deporte;

	public Sport() {

	}

	public Sport(int id, String deporte) {
		this.id = id;
		this.deporte = deporte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDerporte(String deporte) {
		this.deporte = deporte;
	}

	@Override
	public String toString() {
		return "deporte [deporte=" + deporte + "]";
	}

}
