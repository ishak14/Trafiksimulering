
public class Lane{

    public static class OverflowException extends RuntimeException {
        // Undantag som kastas n�r det inte gick att l�gga 
        // in en ny bil p� v�gen
    }

    private Car[] theLane;
    public int size_n;

    public Lane(int n) {
	// Konstruerar ett Lane-objekt med plats f�r n fordon
    	
    	size_n = n;
    	theLane = new Car[size_n];
    	for (int i = 0; i < n; i++){
    		theLane[i] = null;
    	}  	
    }
    
    public int getLength(){
    	return this.theLane.length;
    }
    
    /*
    public void step() {
    	
      	for(int i = 0; i < (getLength() - 1); i++){
        	if(theLane[i].spookyCar == true && theLane[i+1].spookyCar == false){
        			theLane[i] = theLane[i+1];
        			theLane[i+1] = new Car();
        			theLane[i].intPosition += -1;
        			// varf�r vill den inte h�mta intPosition?
        		}
        	}
    	
	// Stega fram alla fordon (utom det p� plats 0) ett steg 
        // (om det g�r). (Fordonet p� plats 0 tas bort utifr�n 
	// mm h a metoden nedan.)
    }
    */
    
    public void step() {
    	
      	for(int i = 0; i < (getLength() - 1); i++){
        	if(theLane[i] == null && theLane[i+1] != null){
        			theLane[i] = theLane[i+1];
        			theLane[i+1] = null;
        			theLane[i].intPosition += -1;
        			// varf�r vill den inte h�mta intPosition?
        		}
        	}
      	
	// Stega fram alla fordon (utom det p� plats 0) ett steg 
        // (om det g�r). (Fordonet p� plats 0 tas bort utifr�n 
	// mm h a metoden nedan.)
    }
    
/*
    public Car getFirst() {
    
    	Car firstCar = theLane[0];
    		
    	theLane[0].spookyCar = true;
    		return firstCar;
    		//returnerar bilen som st�r f�rst och tar bort den fr�n lane
    }
    */

    public Car getFirst() {
    
    	Car firstCar = this.theLane[0];
    		
    	this.theLane[0] = null;
    		return firstCar;
    		//returnerar bilen som st�r f�rst och tar bort den fr�n lane
    }

    public Car firstCar() {
    	return theLane[0];
	// Returnera bilen som st�r f�rst utan att ta bort den
    }

/*
    public boolean lastFree() {
    	if(theLane[(theLane.length) - 1].spookyCar == true)
    		return true;
    	else
    		return false;
	// Returnera true om sista platsen ledig, annars false
    }
    */
   
    public boolean lastFree() {
    	if(theLane[(theLane.length) - 1] == null )
    		return true;
    	else
    		return false;
	// Returnera true om sista platsen ledig, annars false
    }
    
    public void beginLast(int size_n) throws OverflowException {
    	if (lastFree() == true){
    		
    		theLane[size_n - 1] = new Car(false);
    		theLane[size_n - 1].intPosition = ((size_n) - 1);
    	}
    	else
    	{
    		throw new OverflowException();
    	}

	// St�ll en bil p� sista platsen p� v�gen
	// (om det g�r).
    }
    
    public void putLast(Lane oldLane, int size_n) throws OverflowException {
    	if (lastFree() == true){
    		
    		this.theLane[size_n - 1] = oldLane.getFirst();
    		this.theLane[size_n - 1].intPosition = ((size_n) - 1);
    	}
    	else
    	{
    		throw new OverflowException();
    	}

	// St�ll en bil p� sista platsen p� v�gen
	// (om det g�r).
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
	L.beginLast(10); //byter namn fr�n putLast....
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
	//LT.step();

	System.out.println("                                  //");
	System.out.println(LT);
	
}	
	
}	
	
	
	

