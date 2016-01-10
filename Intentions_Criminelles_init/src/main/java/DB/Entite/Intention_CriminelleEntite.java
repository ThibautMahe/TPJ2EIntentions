package DB.Entite;

public class Intention_CriminelleEntite {
	private Action_CriminelleEntite Action_Criminelle;
	private CriminelEntite Criminel;
	private LieuEntite Lieu;

	public Action_CriminelleEntite getAction_Criminelle() {
		return Action_Criminelle;
	}

	public void setAction_Criminelle(Action_CriminelleEntite action_Criminelle) {
		Action_Criminelle = action_Criminelle;
	}

	public CriminelEntite getCriminel() {
		return Criminel;
	}

	public void setCriminel(CriminelEntite criminel) {
		Criminel = criminel;
	}

	public LieuEntite getLieu() {
		return Lieu;
	}

	public void setLieu(LieuEntite lieu) {
		Lieu = lieu;
	}
}
