
public class Light {
    private int period;
    private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...
    private int green; // Signalen gr�n n�r time<green 

    public Light(int period, int green) {
    	
    	this.period = period;
    	this.green = green;
    }

    public void step() { 
    	
    	if (time == period){
    		time = 0;
    	}
    	else
    		time++;	
    	
       // Stegar fram klocka ett steg
    }

    public boolean isGreen()   {
    	
    	if(time < green){
    		return true;
    	}
    	else 
    		return false;
    	
    	}
	// Returnerar true om time<green, annars false
    

    public String  toString()  {
    	return "Light (period: " + this.period + 
				"time: " + this.time +
				"green: " + this.green +")" + "\n";
    }
	
}

