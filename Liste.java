import java.io.*;

public class Liste {

    private Maillon first;

    public Liste (){
        first=null;

    }
    
    public void add(Coordoner p){
    	Maillon c = new Maillon(p);
    	if (this.vide()){
    		this.first=c;
    	}else{
    		Maillon tmp=this.first;
    		if(tmp.compareTo(c)<0){
    			c.setSuivant(tmp);
    			this.first=c;
    		}else{
    			if(tmp.getSuivant()==null){
    				tmp.setSuivant(c);
    			}else{
    				boolean b= true;
    				while(tmp.getSuivant()!=null){
    					if(tmp.getSuivant().compareTo(c)>0){
    						tmp=tmp.getSuivant();
    					}else{
    						c.setSuivant(tmp.getSuivant());
    						tmp.setSuivant(c);
    						b=false;
    					}
    				}
    				if (b){
    					tmp.setSuivant(c);
    				}
    			}
    		}
    	}
    }

    public boolean vide(){
        return first == null;
    }

    public Maillon getFirst() {
        return first;
    }

    public void setFirst(Maillon first) {
        this.first = first;
    }

}
