import java.util.*;

public class GuitarString {
	
	
	private Queue<Double> ringBuffer = new LinkedList<>();
	private int samplingRate = StdAudio.SAMPLE_RATE;
	public double energyDecayFactor = .996;
	
	//Pre: (Frequency > 0 || size of ring buffer > 2) (If not throw IllegalArgumentException)
	//Post: Creates ring buffer of capacity N zeros
	public GuitarString(double frequency) {
		
		int n = (int) (samplingRate/frequency);
		
		if(frequency <= 0 || n < 2) {
			
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i < n; i++) {
			ringBuffer.add((double)0);
		}
	}
	
	//Pre: (array size >= 20) (If not throw illegalArgumentException)
	//Post: (Fill ringBuffer with array values)
	public GuitarString(double[] init) {
		
		if(init.length < 2) {
			
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i < ringBuffer.size(); i++) {
			
			ringBuffer.poll();
			ringBuffer.add(init[i]);
		}
	}
	
	//Post: Add random values to ringBuffer
	public void pluck() {
		
		Random rd = new Random();
		
		for(int i = 0; i < ringBuffer.size(); i++) {
			
			ringBuffer.poll();
			ringBuffer.add(rd.nextDouble(.5 - -.5) + -.5);
		}
	}
	
	//Post: Karplus-Strong update
	public void tic() {
		
		
			
			double first = ringBuffer.poll();
			ringBuffer.add(((first + ringBuffer.peek())/2) * energyDecayFactor);
		
	}
	
	//Post: return first value in ringBuffer
	public double sample() {
		
		return ringBuffer.peek();
	}
}
