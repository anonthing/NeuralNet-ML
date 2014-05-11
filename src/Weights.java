import java.util.ArrayList;


public class Weights {
	int weightcount;
	ArrayList<Double> weight= new ArrayList<Double>();
	public int setwc(int wc){
	
		weightcount = wc;
		return weightcount;
	}
	public void Initialize(){
		
		for(int wc=0; wc<weightcount;wc++){
			weight.add((double) 0);
			
		}
	}
	
public void displayWeights(){
	for(int w_c=0; w_c<weightcount; w_c++){
		System.out.println("new weight counts=" +weight.get(w_c));
	}
}
}
