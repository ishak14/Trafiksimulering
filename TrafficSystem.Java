import java.util.Scanner;
import java.util.Random;

public class TrafficSystem{
    // Definierar de vägar och signaler som ingår i det 
    // system som skall studeras.
    // Samlar statistik
	
    // Attribut som beskriver beståndsdelarna i systemet
    private Lane r0;
    private Lane r1;
    private Lane r2;
 
    private Light s1;
    private Light s2;
    private int Destination1;
    private int Destination2;
    private int bornTime1;
    private int bornTime2;
    

    
    // Diverse attribut för simuleringsparametrar (ankomstintensiteter,
    // int period;
    //private int greenPeriod;
    //private int arrivalIntensity;
    
    //private int time = 0;
    //ankomstintensitet =!=! hur ofta bilarna spawn
   
    //konstruktor
    
    public TrafficSystem(){
    	
    	System.out.println("Enter the size of r0: ");
    	Scanner input_size_r0 = new Scanner(System.in);
    	int size_r0 = input_size_r0.nextInt();
    	System.out.println("Enter the size of r1 and r2: ");
    	Scanner input_size_r1r2 = new Scanner(System.in);
    	int size_r1r2 = input_size_r1r2.nextInt();
    	System.out.println("Enter the period of s1: ");
    	Scanner input_s1Period = new Scanner(System.in);
    	int s1Period = input_s1Period.nextInt();
    	System.out.println("Enter the green period of s1: ");
    	Scanner input_s1Green = new Scanner(System.in);
    	int s1Green = input_s1Green.nextInt();
    	System.out.println("Enter the period of s2: ");    	
    	Scanner input_s2Period = new Scanner(System.in);
    	int s2Period = input_s2Period.nextInt();
    	System.out.println("Enter the green period of s2: ");
    	Scanner input_s2Green = new Scanner(System.in);
    	int s2Green = input_s2Green.nextInt();
    	
      	r0 = new Lane(size_r0);
    	r1 = new Lane(size_r1r2);
    	r2 = new Lane(size_r1r2);
    	s1 = new Light(s1Period, s1Green);
    	s2 = new Light(s2Period, s2Green);
    	
    }
    
    public TrafficSystem(int size_r0, int size_r1r2, int s1Period, int s1Green, int s2Period, int s2Green) {

    	r0 = new Lane(size_r0);
    	r1 = new Lane(size_r1r2);
    	r2 = new Lane(size_r1r2);
    	s1 = new Light(s1Period, s1Green);
    	s2 = new Light(s2Period, s2Green);
    }
    // destinationer...) statistik för destinationer de hamnar på

    /**
     * adderar till bornTime1 och bornTime2. inparameter är Carbilens bornTime i trafiken.
     */
    
    public void statBornTime1(int carBornTime){
    	
    	this.bornTime1 += carBornTime;
    			
    			this.Destination1++;
    }
    
    /**
     * 
     * @param carBornTime
     */
    
    public void statBornTime2(int carBornTime){
    	
    	this.bornTime2 += carBornTime;
    	
    			this.Destination2++;			
    }
	
    /**
     *  get bornTime1 & bornTime2, Destination1 & Destination2
     * @return
     */
    
    public int getBornTime1(){
    	return this.bornTime1;
    }
    
    public int getBornTime2(){
    	return this.bornTime2;
    }
    
    public int getDestination1(){
    	return Destination1;
    }
    
    public int getDestination2(){
    	return Destination2;
    }


    public void step() {
    	Random rand = new Random();
    	
    	/**
    	 * adderar vår bornTime för alla bilar i lane r0, r1, r2
    	 */
    
    	for(int i = 0; i < r0.getLane().length ; i++)
    		if(r0.getLane()[i] != null)
    			r0.getLane()[i].addBornTime(1);
    	
    	for(int i = 0; i < r1.getLane().length; i++)
    		if(r1.getLane()[i] != null)
    			r1.getLane()[i].addBornTime(1);
    	
    	for(int i = 0; i < r2.getLane().length; i++){
    		if(r2.getLane()[i] != null)
    			r2.getLane()[i].addBornTime(1);
    	}
    	 
    	/**
    	 * Ifall light s1 är grön och r1[0] innehåller en bil så tar den bort bilen och adderar 
    	 * bilens bornTime och destination++.
    	 */
    	
     	if(s1.isGreen() && r1.firstCar() != null){
     			
     		statBornTime1(r1.firstCar().getBorntime());
     		Destination1++;
     		r1.setfirstCarNull();
     	}
     	
     	if(s2.isGreen() && r2.firstCar() != null){
     		
     		statBornTime2(r2.firstCar().getBorntime());
     		Destination2++;
     		r2.setfirstCarNull();
     	}
     	
     	/**
     	 * ifall r0[0] inte innehåller en bil så stega r1 och r2
     	 */
    	
     	if(r0.firstNotNull() == false){
    		
    		r1.step();
    		r2.step();
    	}
	
    	/**
    	 * ifall r0[0] innehåller en bil så ska den flyttas till r1 eller r2. 
     	 * stegar r1 och r2.
    	 */
     	
     	if(r0.firstNotNull()) {
		
    	if(r0.firstCar().getDestination() == 2 && r2.lastFree()){
		r2.step();
		r2.putLast(r0);
		r1.step();
	}
	
	else if  (r0.firstCar().getDestination() == 1 && r1.lastFree()){
		
		r1.step();
		r1.putLast(r0);
		r2.step();
	}
	
	else if (r0.firstCar().getDestination() == 1 && r1.lastFree() == false){
		r1.step();
		r2.step();
		r1.putLast(r0);
	}
	else /*if  (r0.firstCar().getDestination() == 2 && r2.lastFree() == false)*/{
		r2.step();
		r2.putLast(r0);
		r1.step();
	}
    	}		

    	/**
    	 * stegar r0
    	 */
    	
     	r0.step();
    
    	/**
    	 * 
    	 * ifall r0 sista plats är fri så "kanske!" sätts en bil in
    	 */
       	
     	if(r0.lastFree() && rand.nextInt((1 - 0) + 1) + 0 >= 0.5) {
    			r0.beginLast();
       	}
    	
    	/**
    	 * stegar Lights s1 och s2
    	 */
     	s1.step();
    	s2.step();
    }
    
	
    /**
     * get r0, r1, r2, s1, s2
     * @return
     */
    
    public Lane getr0(){
    	return r0;
    }
    
    public Lane getr1(){
    	return r1;
    }
    
    public Lane getr2(){
    	return r2;
    }
    
    public Light gets1(){
    	return s1;
    }  
    
    public Light gets2(){
    	return s2;
    }

    public void printStatistics() {
	// Skriv statistiken samlad så här långt	
    }

    public void print() {
	// Skriv ut en grafisk representation av kösituationen
	// med hjälp av klassernas toString-metoder
    }
    
    public static void main(String [] args) {
    	
    	TrafficSystem traffic = new TrafficSystem(5,4,8,4,8,6);
    	traffic.step();
    
    	System.out.println(traffic.r1 +""+ traffic.r0);
    	System.out.println(traffic.r2);
 
    	//System.out.println(traffic.getr0());	
    }
}
