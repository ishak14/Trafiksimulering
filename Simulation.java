
public class Simulation {

    public static void main(String [] args) {
	// Skapar ett TrafficSystem
	// Utfšr stegningen, anropar utskriftsmetoder

	
    TrafficSystem traffic = new TrafficSystem(12,4,16,14,10,5);
   int counter = 0;
   while (counter < 40){
		for (int i = 0; i < 100; i++){
		System.out.println("\n");
		}
   traffic.step();
   
   	System.out.println("Green1: " + traffic.gets1().isGreen() );
   	System.out.println("Green2: " + traffic.gets1().isGreen() );
    System.out.println("BornTime1 " + traffic.getBornTime1() );
    System.out.println("BornTime2 " + traffic.getBornTime2() );
    System.out.println("Destination1 " + traffic.getDestination1());
    System.out.println("Destination2 " + traffic.getDestination2());
    System.out.println("______________________________________________________________");
   	System.out.println("\n");
  	System.out.println(traffic.getr1() +""+ traffic.getr0());
	System.out.println("                          //");
	System.out.println(traffic.getr2());
   	System.out.println("\n");
	System.out.println("______________________________________________________________");
   	System.out.println("\n");

	//System.out.println("\n");
	


	try {
	    Thread.sleep(50);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    	//traffic.getr0().toString();
    	//traffic.getr1().toString();
        //traffic.getr2().toString();
    	
    	//traffic.step();

    	counter ++;
   
    }
   System.out.println("average bornTime1 " +traffic.getBornTime1() / traffic.getDestination1());
   System.out.println("average bornTime2 " +traffic.getBornTime2() / traffic.getDestination2());
    }
}
