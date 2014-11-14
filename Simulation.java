
public class Simulation {
	
	/**
	 * 
	 * @param args
	 */
	
    public static void main(String [] args) {
	
    TrafficSystem traffic = new TrafficSystem();
    int counter = 0;
    while (counter < 40){
		for (int i = 0; i < 40; i++){
		System.out.println("\n");
		}
    traffic.step();
   
   	System.out.println("Green1: " + traffic.gets1().isGreen() );
   	System.out.println("Green2: " + traffic.gets1().isGreen() );
    System.out.println("BornTime1 " + traffic.getBornTime1() );
    System.out.println("BornTime2 " + traffic.getBornTime2() );
    System.out.println("Destination1 " + traffic.getDestination1());
    System.out.println("Destination2 " + traffic.getDestination2());
   	System.out.println("\n");
  	System.out.println(traffic.getr1() +""+ traffic.getr0());
	System.out.println("                           //");
	System.out.println(traffic.getr2());
   	System.out.println("\n");

   	/**
   	 * 
   	 */
	
   	try {
	    Thread.sleep(200);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    	counter ++;
    }
   System.out.println("average bornTime1: " +traffic.getBornTime1() / traffic.getDestination1());
   System.out.println("average bornTime2:5 " +traffic.getBornTime2() / traffic.getDestination2());
    }
}
