import java.util.Random;

public class Car{

    private int bornTime;
    private int dest; // 1 f�r rakt fram, 2 f�r v�nstersv�ng   
	public int intPosition;
	public boolean spookyCar;
    
    // konstruktor och get-metoder
    public Car(int _bornTime, int _dest){
    		bornTime = _bornTime;
    		dest = _dest; /// �ker endast rakt just nu.......	
    		intPosition = 19;
    }  
    
    public Car(boolean spookyCar){
    	
    	Random rand = new Random();
    	
    	bornTime = 2;
    	dest = (rand.nextInt((2 - 1) + 1) + 1);
    	intPosition = 1;
    	this.spookyCar = spookyCar;
    }

    public Car() {
    	Random rand = new Random();
    	
    	bornTime = 2;
    	dest = (rand.nextInt((2 - 1) + 1) + 1);
    	intPosition = 1337;
    	spookyCar = true;
    }

    public String  toString()  {
    	   	
    	return "(Car: bornTime: " + this.bornTime +", " +
    				"Destination: " + this.dest +", " +
    				"currentPosition: " + this.intPosition + ")";
    	}
}
    	   
    /*
    	else{
    		return "Car (bornTime: " + this.bornTime +", " +
    				"Destination: <Empty>, " +
    				"currentPosition: " + "spookyCar" + ")" + "\n";
    	}
    	}
    }
*/
    
    
    
    
    