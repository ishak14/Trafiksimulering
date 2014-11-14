
public class Lane{
	/**
	 * 
	 * @author Ishak & Dyrssen
	 *
	 */
    public static class OverflowException extends RuntimeException {
        // Undantag som kastas när det inte gick att lägga 
        // in en ny bil på vägen
    }
    
    /**
     * 
     */
    private Car[] theLane; //* Lane innehåller en Car-array, utan element
    private int size_n; // integer size_n säger till hur många element Car-arrayen ska innehålla

    /**
     * skapar en Lane med en n Car:s.
     * @param n
     */
    
    public Lane(int n) {
	// Konstruerar ett Lane-objekt med plats för n fordon
    	
    	size_n = n;
    	theLane = new Car[size_n];
    	for (int i = 0; i < n; i++){
    		theLane[i] = null;
    	}  	
    }
    
    //**
    //* kanske världens mest onödiga funktion?
    //*
    
    //  public int getLength(){
    //	return this.theLane.length;
    // }
    
    /**
     * Stegar fram alla bilar i din Lane
     */
    
    public void step() {
    	
      	for(int i = 0; i < (this.theLane.length - 1); i++){
      		
        	if(theLane[i] == null && theLane[i+1] != null){
        			theLane[i] = theLane[i+1];
        			theLane[i+1] = null;
        		//	theLane[i].sub1_IntPosition();
        		}
        	}
      	// Stega fram alla fordon (utom det på plats 0) ett steg 
        // (om det går). (Fordonet på plats 0 tas bort utifrån 
      	// mm h a metoden nedan.)
    }
    

    
    /**
     * returnerar första bilen i arrayen, samt tar bort den ifrån arrayen.
     * @return
     */
    
    public Car getFirst() {
    
    	Car firstCar = this.theLane[0];
    		
    	this.theLane[0] = null;
    		return firstCar;
    		//returnerar bilen som står först och tar bort den från lane
    }

    /**
     * returnerar första bilen i arrayen, utan att ta bort den.
     * @return
     */
    
    public Car firstCar() {
    	return this.theLane[0];
	
    }
    
    /**
     * sätter theLane[0] som null;
     */
    
    public void setfirstCarNull(){
    	this.theLane[0] = null;
    }
   
    /**
     * true om theLane[0] innehåller en bil, annars false
     * @return
     */
    
    public boolean firstNotNull() {
    	if(theLane[0] != null) 
    		return true;
    	else
    		return false;		  
    	}

    //**
    //* används den här???? vart isåfall ?
    //*
   // public int getSize(){
   // 	return this.size_n;
   // }
    
    /**
     * returnerar Lane-objektets theLane
     * @return
     */
    public Car[] getLane(){
    	return theLane;
    }
    
    /**
     * rätt säker på att den här inte används lägnre.
     */
    
    public void stepNotLast(){
     	for(int i = 0; i < (this.theLane.length - 2); i++){
        	if(theLane[i] == null && theLane[i+1] != null){
        			theLane[i] = theLane[i+1];
        			theLane[i+1] = null;
        			//theLane[i].sub1_IntPosition();
        			theLane[i].addBornTime(1);  // bilens borntime adderas med 1 för alla bilar
        		}
        	}
	// Stega fram alla fordon (utom det på plats 0) ett steg 
        // (om det går). (Fordonet på plats 0 tas bort utifrån 
	// mm h a metoden nedan.)
    }
   
    /**
     * Returnerar true om sista elementet i arrayen är tom, annars false
     * @return
     */
    
    public boolean lastFree() {
    	if(theLane[(theLane.length) - 1] == null )
    		return true;
    	else
    		return false;
    }
   
    /**
     * ifall lastFree() så (0 - 100) % chans att den skapar en ny bil som läggs till i arrayens sista element.
     * @throws OverflowException
     */
    public void beginLast() throws OverflowException {
    	if (lastFree() == true){
    			
    		this.theLane[this.theLane.length - 1] = new Car();
    		//this.theLane[this.theLane.length - 1].setIntPosition(this.theLane.length - 1);
    		this.theLane[this.theLane.length - 1].addBornTime(1);	
    	}
    	else
    	{
    		throw new OverflowException();
    	}
    }
   
    /**
     * tar första elementet från en array för att placera som sista
     * plats i objektets array, ifall det går!
     * @param oldLane
     */
    public void putLast(Lane oldLane)  {
    	if (lastFree() == true ){
    		this.theLane[this.theLane.length - 1] = oldLane.getFirst();
    		//this.theLane[this.theLane.length - 1].setIntPosition(this.theLane.length - 1);	
    	}
    }

    /**
     * printar ut grännssnittet för bilvägen och bilarna
     */
    
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < theLane.length; i++) {
    		if(theLane[i] != null){
    	sb.append(" " + theLane[i].toString()); //" - " + Integer.toString(i)+ " " +
    		}
    		else{
    			sb.append(" =="+i+"== ");
    			}			
    		}
    	return sb.toString();   		
    }	
    


    
}	
	
	
	

