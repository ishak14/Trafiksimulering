
public class Lane{

    public static class OverflowException extends RuntimeException {
        // Undantag som kastas när det inte gick att lägga 
        // in en ny bil på vägen
    }

    private Car[] theLane;
    public int size_n;

    public Lane(int n) {
	// Konstruerar ett Lane-objekt med plats för n fordon
    	
    	size_n = n;
    	theLane = new Car[size_n];
    	for (int i = 0; i < n; i++){
    		theLane[i] = null;
    	}  	
    }
    
    public int getLength(){
    	return this.theLane.length;
    }

    
    public void step() {
    	
      	for(int i = 0; i < (getLength() - 1); i++){
        	if(theLane[i] == null && theLane[i+1] != null){
        			theLane[i] = theLane[i+1];
        			theLane[i+1] = null;
        			theLane[i].sub1_IntPosition();
        			theLane[i].addBornTime(1);
        			// bilens borntime adderas med 1 för alla bilar
        		}
        	}
      	
	// Stega fram alla fordon (utom det på plats 0) ett steg 
        // (om det går). (Fordonet på plats 0 tas bort utifrån 
	// mm h a metoden nedan.)
    }
    


    public Car getFirst() {
    
    	Car firstCar = this.theLane[0];
    		
    	this.theLane[0] = null;
    		return firstCar;
    		//returnerar bilen som står först och tar bort den från lane
    }

    public Car firstCar() {
    	return theLane[0];
	// Returnera bilen som står först utan att ta bort den
    }
    
    public boolean firstNotNull() {
    	if(theLane[0] != null) 
    		return true;
    	else
    		return false;
    		  
    	}
    

   
    public boolean lastFree() {
    	if(theLane[(theLane.length) - 1] == null )
    		return true;
    	else
    		return false;
	// Returnera true om sista platsen ledig, annars false
    }
    
    public void beginLast(int size_n) throws OverflowException {
    	if (lastFree() == true){
    		
    		
    		theLane[size_n - 1] = new Car();
    		theLane[size_n - 1].setIntPosition(size_n - 1);
    		
    	}
    	else
    	{
    		throw new OverflowException();
    	}

	// Ställ en bil på sista platsen på vägen
	// (om det går).
    }
    
    public void putLast(Lane oldLane, int size_n) throws OverflowException {
    	if (lastFree() == true){
    		
    		this.theLane[size_n - 1] = oldLane.getFirst();
    		this.theLane[size_n - 1].setIntPosition(size_n - 1);
    	}
    	else
    	{
    		throw new OverflowException();
    	}

	// Ställ en bil på sista platsen på vägen
	// (om det går).
    }

    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < theLane.length; i++) {
    		if(theLane[i] != null){
    		
    	sb.append(" - " + Integer.toString(i)+ " " + theLane[i].toString() + " - ");
    		}
    		else{
    			sb.append(" =="+i+"== ");
    			}
    			
    		}
    	return sb.toString();   		
}
    
public static void main(String args[]){
	
	Lane L = new Lane(10);
	Lane LS = new Lane(5);
	Lane LT = new Lane(5);
	L.beginLast(10); //byter namn från putLast....
	L.step();
	L.step();
	L.step();
	L.step();
	L.step();
	L.step();
	L.step();
	L.step();
	L.step();


	LT.putLast(L, LT.getLength());	
	System.out.println(LS + "--" +  L);
	LT.step();

	System.out.println("                                  //");
	System.out.println(LT);
	
}	
	
}	
	
	
	

