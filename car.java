import java.util.Random;

public class Car{

    private int bornTime;
    private int dest; // 1 för rakt fram, 2 för vänstersväng   
	public int intPosition;
	public boolean spookyCar;
    
    // konstruktor och get-metoder
    public Car(int _bornTime, int _dest){
    		bornTime = _bornTime;
    		dest = _dest; /// åker endast rakt just nu.......	
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
    
    
    
    
    