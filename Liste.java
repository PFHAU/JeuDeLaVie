import java.io.*;

public class Liste {

    private Maillon first;

    public Liste (){
        first=null;

    }
   /* public void add (Maillon m) {
        if (this.first == null) this.first = m;
        else {
            Maillon tmp = this.first;
            while (tmp!=null && m.compareTo(tmp) == -1) {
                tmp = tmp.getSuivant();
            }
            if(tmp!=null){
            	m.setSuivant(tmp.getSuivant());
            	tmp.setSuivant(m);
            }else{
            	
            }
        }
    }*/
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
    				while(tmp.getSuivant()!=null && b){
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
