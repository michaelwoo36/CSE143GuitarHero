
public class Main {
	
	public static void main(String[] args) {

		
		Guitar37 guitar = new Guitar37();

        while (true) {

            // check if the user has typed a key; if so, process it   
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                guitar.pluck(key);
                
            }

            // compute the superposition of samples

            double sample = guitar.sample();

            // play the sample on standard audio
            
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step   
            guitar.tic();
           
        }
     }
}
