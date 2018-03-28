public class Coordoner {
    private int x;
    private int y;
    public  Coordoner (int x,int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
    	return x;
    }
    public int getY(){
    	return y;
    }
    public int compareTo(Coordoner c){
    	if(this.getY()<c.getY()){
    		return -1;
    	}else{
    		if (this.getY()>c.getY()){
    			return 1;
    		}else{
    			if (this.getX()<c.getX()){
    				return 1;
    			}else{
    				if(this.getX()>c.getX()){
    					return -1;
    				}else{
    					return 0;
    				}
    			}
    		}
    	}
    }
}
