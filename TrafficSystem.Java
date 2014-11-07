
public class TrafficSystem {
    // Definierar de vägar och signaler som ingår i det 
    // system som skall studeras.
    // Samlar statistik
    
    // Attribut som beskriver beståndsdelarna i systemet
    private Lane r0;
    private Lane r1;
    private Lane r2;
    private Lane d1;
    private Lane d2;
    private Light s1;
    private Light s2;
    private int Destination1;
    private int Destination2;
    

    // Diverse attribut för simuleringsparametrar (ankomstintensiteter,
    int period;
    int greenPeriod;
    int arrivalIntensity;
    
    private int time = 0;
    //ankomstintensitet =!=! hur ofta bilarna spawn
    // destinationer...) statistik för destinationer de hamnar på
    
    public void destination_Stat(){
    	if (r1.firstCar() != null)
    		Destination1 += 1;
    	
    	if (r2.firstCar() != null)
    		Destination2 += 1;
    }

    // Diverse attribut för statistiksamling
    
    


    public TrafficSystem() {...}

    public readParameters() {
	// Läser in parametrar för simuleringen
	// Metoden kan läsa från terminalfönster, dialogrutor
	// eller från en parameterfil. Det sista alternativet
	// är att föredra vid uttestning av programmet eftersom
	// man inte då behöver mata in värdena vid varje körning.
        // Standardklassen Properties är användbar för detta. 
    }

    public void step() {
      	r0.step();
    	r1.step();
    	r2.step();
    	
    	Car r1Car, r2Car;
    	
    	if (s1.isGreen())
    		r1Car = r1.getFirst();
    	if (s2.isGreen())
    		r2Car = r2.getFirst();
    	
    	
    	if(r0.firstNotNull())
    		{
    		
    	if(r0.firstCar().destination() == 2 && r2.lastFree())
    		r2.putLast(r0, r2.getLength());
    	else { if(r1.lastFree())
    		r1.putLast(r0, r1.getLength());
    		 }
    	
    		}
    
    	if(r0.lastFree())
    		r0.beginLast(r0.getLength());
    	
    	s1.step();
    	s2.step();
 
	// Skapa bilar, lägg in och ta ur på de olika Lane-kompenenterna
    }

    public void printStatistics() {
	// Skriv statistiken samlad så här långt
    }

    public void print() {
	// Skriv ut en grafisk representation av kösituationen
	// med hjälp av klassernas toString-metoder
    }

}
