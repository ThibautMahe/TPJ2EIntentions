package DB.Entite;

public class LieuEntite {
	int ID;
	private String emplacement;

	public LieuEntite() {
		this.emplacement = "";
	}
	
	public LieuEntite(int ID) {
		this.ID=ID;
		this.emplacement = "";
	}

	public LieuEntite(String emplacement) {
		this.emplacement = emplacement;
	}

	public LieuEntite(int ID,String emplacement) {
		this.ID=ID;
		this.emplacement = emplacement;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
}
