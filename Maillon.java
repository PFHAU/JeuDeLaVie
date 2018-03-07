public class Maillon {
	private Object o;
	private Maillon suivant;
	public Maillon (Object o){
		this.o=o;
		this.suivant=null;
	}
	public Object getO() {
		return o;
	}

	public void setO(Object o) {
		this.o = o;
	}

	public Maillon getSuivant() {
		return suivant;
	}

	public void setSuivant(Maillon suivant) {
		this.suivant = suivant;
	}
	public int compareTo(Object obj){
		return ((Maillon) this.o).compareTo(((Maillon) obj).o);
	}


}
