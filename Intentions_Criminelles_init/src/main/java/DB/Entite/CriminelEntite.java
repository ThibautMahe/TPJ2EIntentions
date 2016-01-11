package DB.Entite;

public class CriminelEntite {
	private int ID;
	private String name;
	private int age;

	public CriminelEntite() {
		this.name="";
		this.age=0;
	}
	
	public CriminelEntite(int ID){
		this.ID=ID;
		this.name="";
		this.age=0;
	}

	public CriminelEntite(String name) {
		this.name=name;
		this.age=0;
	}

	public CriminelEntite(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	public CriminelEntite(int ID, String name, int age) {
		this.ID=ID;
		this.name=name;
		this.age=age;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
