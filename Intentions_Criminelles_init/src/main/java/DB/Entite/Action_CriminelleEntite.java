package DB.Entite;

public class Action_CriminelleEntite {
	private int ID;
	private String action;

	public Action_CriminelleEntite() {
		this.action = "";
	}

	public Action_CriminelleEntite(String action) {
		this.action = action;
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
