package DB.Entite;

public class Intention_CriminelleEntite {
	private int ID;
	private Action_CriminelleEntite action_Criminelle;
	private CriminelEntite criminel;
	private LieuEntite lieu;

	public Intention_CriminelleEntite(int ID) {
		this.ID = ID;
	}

	public Intention_CriminelleEntite(int ID, Action_CriminelleEntite action_Criminelle, CriminelEntite criminel,
			LieuEntite lieu) {
		this.ID = ID;
		this.criminel=criminel;
		this.action_Criminelle = action_Criminelle;
		this.lieu=lieu;
	}

	public Intention_CriminelleEntite() {
		
	}

	public int getAction_CriminelleID() {
		return action_Criminelle.getID();
	}

	public void setAction_Criminelle(Action_CriminelleEntite action_Criminelle) {
		this.action_Criminelle = action_Criminelle;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getCriminelID() {
		return criminel.getID();
	}

	public void setCriminel(CriminelEntite criminel) {
		this.criminel = criminel;
	}

	public int getLieuID() {
		return lieu.getID();
	}

	public Action_CriminelleEntite getAction_Criminelle() {
		return action_Criminelle;
	}

	public CriminelEntite getCriminel() {
		return criminel;
	}

	public LieuEntite getLieu() {
		return lieu;
	}

	public void setLieu(LieuEntite lieu) {
		this.lieu = lieu;
	}
}
