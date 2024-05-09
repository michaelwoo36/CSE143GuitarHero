
public class Guitar37 implements Guitar {

		GuitarString[] strings = new GuitarString[37];
		String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
		private int tic = 0;
		
		public Guitar37 () {
			
			for(int i = 0; i < 37; i++) {
				strings[i] = new GuitarString(440 * Math.pow(2, ((i - 24) / 12.0)));
			}
		}
		public void playNote(int pitch) {
			
			strings[pitch + 24].pluck();
	    }

	    public boolean hasString(char string) {
	    	
	    	for(int i = 0; i < KEYBOARD.length(); i++) {
	    		if(string == KEYBOARD.charAt(i)) {
	    			return true;
	    		}
	    	}
	    	return false;
	    }
	    
	    public void pluck(char string) {
	        if(hasString(string)) {
	        	strings[KEYBOARD.indexOf(string)].pluck();
	        }
	    	
	    }

	    public double sample() {
	    	double sum = 0;
	    	for(int i = 0; i < strings.length; i++) {
	    		sum += strings[i].sample();
	    	}
	        return sum;
	    }

	    public void tic() {
	    	for(int i = 0; i < strings.length; i++) {
	    		strings[i].tic();
	    	}
	    	tic++;
	    }

	    public int time() {
	    	
	    	if(tic == 0) {
	    		 return -1; 
	    	}
	        return tic;
	       
	    }
	}