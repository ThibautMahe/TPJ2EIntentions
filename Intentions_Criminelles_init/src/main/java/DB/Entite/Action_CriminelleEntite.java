package DB.Entite;

public class Action_CriminelleEntite {
	private int ID;
	private LieuEntite lieu;
	private String action;

	public Action_CriminelleEntite() {
		this.lieu.ID = 0;
		this.action = "";
	}

	public Action_CriminelleEntite(String action) {
		this.lieu.ID = 0;
		this.action = action;
	}

	public Action_CriminelleEntite(String action, LieuEntite lieu) {
		this.lieu = lieu;
		this.action = action;
	}

	public LieuEntite getLieu() {
		return lieu;
	}

	public void setLieu(LieuEntite lieu) {
		this.lieu = lieu;
	}

	public int getLieuID() {
		return lieu.getID();
	}

	public Action_CriminelleEntite(int ID) {
		this.ID = ID;
		this.action = "";
	}

	public Action_CriminelleEntite(int ID, String action) {
		this.ID = ID;
		this.action = action;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}
