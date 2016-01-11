package DB.Entite;

public class Intention_CriminelleEntite {
	private int ID;
	private Action_CriminelleEntite Action_Criminelle;
	private CriminelEntite Criminel;
	private LieuEntite Lieu;

	public Intention_CriminelleEntite(int ID) {
		this.ID = ID;
	}

	public Intention_CriminelleEntite(int ID, Action_CriminelleEntite action_Criminelle, CriminelEntite criminel,
			LieuEntite lieu) {
		this.ID = ID;
		this.Criminel=criminel;
		this.Action_Criminelle = action_Criminelle;
		this.Lieu=lieu;
	}

	public Intention_CriminelleEntite() {
		
	}

	public int getAction_CriminelleID() {
		return Action_Criminelle.getID();
	}

	public void setAction_Criminelle(Action_CriminelleEntite action_Criminelle) {
		this.Action_Criminelle = action_Criminelle;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getCriminelID() {
		return Criminel.getID();
	}

	public void setCriminel(CriminelEntite criminel) {
		this.Criminel = criminel;
	}

	public int getLieuID() {
		return Lieu.getID();
	}

	public Action_CriminelleEntite getAction_Criminelle() {
		return Action_Criminelle;
	}

	public CriminelEntite getCriminel() {
		return Criminel;
	}

	public LieuEntite getLieu() {
		return Lieu;
	}

	public void setLieu(LieuEntite lieu) {
		this.Lieu = lieu;
	}
}
