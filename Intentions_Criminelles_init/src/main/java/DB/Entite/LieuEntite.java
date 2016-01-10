package DB.Entite;

public class LieuEntite {
	private String emplacement;

	public LieuEntite() {
		this.emplacement = "";
	}

	public LieuEntite(String emplacement) {
		this.emplacement = emplacement;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}
}
