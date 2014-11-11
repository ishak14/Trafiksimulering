
public class Lane{

    public static class OverflowException extends RuntimeException {
        // Undantag som kastas n�r det inte gick att l�gga 
        // in en ny bil p� v�gen
    }

    private Car[] theLane; //* Lane inneh�ller en Car-array
    private int size_n; // en size_n som s�ger hur l�ng Car-arrayen ska vara

    //**
    //* skapar en Lane med en Car[n]
    //*
    public Lane(int n) {
	// Konstruerar ett Lane-objekt med plats f�r n fordon
    	
    	size_n = n;
    	theLane = new Car[size_n];
    	for (int i = 0; i < n; i++){
    		theLane[i] = null;
    	}  	
    }
    
    //**
    //* kanske v�rldens mest on�diga funktion?
    //*
    
    public int getLength(){
    	return this.theLane.length;
    }
    

    //**
    //* Stegar fram alla bilar i din Lane
    //*
    public void step() {
    	
      	for(int i = 0; i < (this.theLane.length - 1); i++){
      	
      		
        	if(theLane[i] == null && theLane[i+1] != null){
        			theLane[i] = theLane[i+1];
        			theLane[i+1] = null;
        			theLane[i].sub1_IntPosition();
        			
        	
        		}
        	
        
        	}
      	
	// Stega fram alla fordon (utom det p� plats 0) ett steg 
        // (om det g�r). (Fordonet p� plats 0 tas bort utifr�n 
	// mm h a metoden nedan.)
    }
    
    //**
    //* anv�nds den h�r????
    //*
    public void setSize_n(int _size_n){
    	this.size_n = _size_n;
    }
    //**
    //* returnerar f�rsta bilen i arrayen, samt tar bort den ifr�n arrayen.
    //*
    public Car getFirst() {
    
    	Car firstCar = this.theLane[0];
    		
    	this.theLane[0] = null;
    		return firstCar;
    		//returnerar bilen som st�r f�rst och tar bort den fr�n lane
    }

    //**
    //* returnerar f�rsta bilen i arrayen, utan att ta bort den.
    //*
    
    public Car firstCar() {
    	return this.theLane[0];
	
    }
    
    //**
    //* s�tter theLane[0] som null;
    //*
    
    public void setfirstCarNull(){
    	this.theLane[0] = null;
    }
    
    
    //**
    //* true om theLane[0] inneh�ller en bil, annars false
    //*
    public boolean firstNotNull() {
    	if(theLane[0] != null) 
    		return true;
    	else
    		return false;
    		  
    	}

    //**
    //* anv�nds den h�r???? vart is�fall ?
    //*
    public int getSize(){
    	return this.size_n;
    }
    
    //**
    //* returnerar Lane-objektets theLane
    //*
    public Car[] getLane(){
    	return theLane;
    }
    
    //**
    //* r�tt s�ker p� att den h�r inte anv�nds l�gnre..
    //*
    
    public void stepNotLast(){
     	for(int i = 0; i < (getLength() - 2); i++){
        	if(theLane[i] == null && theLane[i+1] != null){
        			theLane[i] = theLane[i+1];
        			theLane[i+1] = null;
        			theLane[i].sub1_IntPosition();
        			theLane[i].addBornTime(1);  // bilens borntime adderas med 1 f�r alla bilar
        		}
        	}
      	
	// Stega fram alla fordon (utom det p� plats 0) ett steg 
        // (om det g�r). (Fordonet p� plats 0 tas bort utifr�n 
	// mm h a metoden nedan.)
    }
    
    //**
    //* Returnerar true om sista elementet i arrayen �r tom, annars false
    //*
   
    public boolean lastFree() {
    	if(theLane[(theLane.length) - 1] == null )
    		return true;
    	else
    		return false;

    }
    //**
    //* ifall lastFree() 50% chans att den skapar en ny bil som l�ggs till i arrayens sista element.
    //*
    
    public void beginLast() throws OverflowException {
    	if (lastFree() == true){
    		
    		
    		this.theLane[this.theLane.length - 1] = new Car();
    		this.theLane[this.theLane.length - 1].setIntPosition(this.theLane.length - 1);
    		this.theLane[this.theLane.length - 1].addBornTime(1);
    	
    		
    	}
    	else
    	{
    		throw new OverflowException();
    	}


    }
    //**
    //* tar f�rsta elementet fr�n en array f�r att placera som sista
    //* plats i objektets array, ifall det g�r!
    public void putLast(Lane oldLane)  {
    	if (lastFree() == true ){
    		
    		this.theLane[this.theLane.length - 1] = oldLane.getFirst();
    		this.theLane[this.theLane.length - 1].setIntPosition(this.theLane.length - 1);
    		//this.theLane[this.theLane.length - 1].addBornTime(1);
    	}
    }

    //**
    //* printar ut gr�nnssnittet f�r bilv�gen och bilarna
    //* 
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
	
	
	

