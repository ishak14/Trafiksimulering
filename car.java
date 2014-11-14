
import java.util.Random;

public class Car{
    
	/**
	 * 
	 */
	
    private int bornTime; //gjort de public
    private int dest; // 1 för rakt fram, 2 för vänstersväng   
	//private int intPosition; //gjort de public
	   
    // konstruktor och get-metoder
   public Car(int _bornTime){
    	
    	Random rand = new Random();
    	
    		bornTime = _bornTime;
    		dest =  (rand.nextInt((2 - 1) + 1) + 1);
    	//	intPosition = 1337;
    }  
    
    
    /**
     * 
     */
    public Car(){
    	
    	Random rand = new Random();
    	
    	bornTime = 0;
    	dest = (rand.nextInt((2 - 1) + 1) + 1);
    	//intPosition = 1337;
    }
    
    /**
     * 
     * @return
     */
    
    public int getDestination() {
    	return dest;
    }
    
    /**
     * 
     * @return
     */
    
    public int getBorntime(){
    	return bornTime;
    }
    
   // public void sub1_IntPosition() {
   // 	intPosition += -1;
   // }
    
    /**
     * 
     * @param a
     */
    
    public void addBornTime(int a){
    	bornTime +=  a;
    }
    
    //public int getIntPosition(){
    //	return this.intPosition;
   // }
    
    //public void setIntPosition(int a){
    //	this.intPosition = a;
    //}
    
    /**
     * 
     */
    
    public String toString()  {
    	   	/*
    	return "[Car(bT: " + this.bornTime +", " +
    				"D: " + this.dest +", " +
    				"cP: " + this.intPosition + ")" + "]";
    				*/
    	return "(|"+ this.dest + "|]";
    	}
    
    public boolean bornTimeEquals(Car car1, Car car2){
    	if(car1.getBorntime() == car2.getBorntime()){
    		return true;
    	}
    	else return false;
    	
    }
}
    	   

    
    
    