import java.io.*;
import java.util.ArrayList;


public class Perceptron {

	/**
	 * @param args
	 * @throws IOException, FileNotFoundException 
	 */
	public static void main(String[] args) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		int count = 0;
		double sum =0;
		float op;
		//double lr = 0.1;
		//int iterations = 100;
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		Attribute a = new Attribute();
		Weights w = new Weights();
		String s;
		s = br.readLine();
		//System.out.println("first line= " +s);
		String inputs[] = s.split("\\t");
		ArrayList<Attribute> attlist = new ArrayList<Attribute>(); //Stores attributes names
		for(int i=0;i<inputs.length;i++)
		{

			a.name = inputs[i];
			attlist.add(a);
			//System.out.println("name =" +a.name);
		}


		//t.Training1();
		//System.out.println("no of attributes = " +inputs.length);
		w.setwc(inputs.length);
		w.Initialize();

		ArrayList<ArrayList<String>>inputRecords=new ArrayList<ArrayList<String>>();
		//ArrayList<Double> o = new ArrayList<Double>();
		
		while((s=br.readLine())!=null)
		{
			ArrayList<String>arrL=new ArrayList<String>();
			String[] line=s.split("\\s+");
			for(int i=0;i<line.length;i++)
				arrL.add(line[i]);                
			inputRecords.add(arrL);
		}
		//System.out.println("input records size=" +inputRecords.size());
		for(int x=0;x<Integer.parseInt(args[3])%inputRecords.size();x++){
		for(int y=0;y<inputRecords.size();y++){
			sum =0;
			for(int j=0;j<inputs.length;j++){
				//System.out.println("weights=" +w.weight.get(j));

				sum+=w.weight.get(j)*Integer.parseInt(inputRecords.get(y).get(j));
				//System.out.println("summation=" +sum);
			}
			if(sum>=0.5){ op = (float) 1; }
			else op = (float) 0;
			float t=(Integer.parseInt(inputRecords.get(y).get(inputs.length))-op);
			for(int j=0;j<inputs.length;j++){
				
				//System.out.println("op=" +op);
				double new_weight = w.weight.get(j) + (Float.valueOf(args[2]))*t*Integer.parseInt(inputRecords.get(y).get(j));
				count++;
				//System.out.println("new weight=" +new_weight);
				w.weight.set(j, new_weight);
				//System.out.println("new weights=" +w.weight.get(j));
			
//			o.add(sum);
//			System.out.println("o=" +o);
//			System.out.println("o.add(sum)" +o.get(y));
			}
		}
		}
		int correct1 = 0;
		
		//System.out.println("count=" +count);
		//w.displayWeights();
		for(int y=0;y<inputRecords.size();y++){
			sum=0;
			for(int j=0;j<inputs.length;j++){
			//System.out.println("weights=" +w.weight.get(j1));

				sum+=w.weight.get(j)*Integer.parseInt(inputRecords.get(y).get(j));
				//System.out.println("summation=" +sum);
			}
		
				if(sum>=0.5){ op = (float) 1; }
				else op = (float) 0;
			//System.out.println("class=" +Integer.parseInt(inputRecords.get(y).get(inputs.length))+ "op="+op);
		if(Integer.parseInt(inputRecords.get(y).get(inputs.length))==op) { correct1++; }
		}
		
		float p_trc = (correct1/(float)inputRecords.size())*100; 
		System.out.println("Percentage accuracy of Train data=" +p_trc);
		//System.out.println("no of rows="+count);
		//System.out.println("name of input records" +inputRecords);
		
		
		//Testing phase
		BufferedReader br1 = new BufferedReader(new FileReader(args[1]));
		double sum1 =0;
		double op1;
		int correct =0;
		String s1;
		s1 = br1.readLine();
		//System.out.println("first line= " +s);
		String inputs1[] = s1.split("\\t");
		ArrayList<Attribute> attlist1 = new ArrayList<Attribute>(); //Stores attributes names
		for(int i1=0;i1<inputs.length;i1++)
		{

			a.name = inputs1[i1];
			attlist1.add(a);
			//System.out.println("name =" +a.name);
		}
		ArrayList<ArrayList<String>>inputRecords1=new ArrayList<ArrayList<String>>();
		//ArrayList<Double> o = new ArrayList<Double>();
		
		while((s1=br1.readLine())!=null)
		{
			ArrayList<String>arrL1=new ArrayList<String>();
			String[] line1=s1.split("\\s+");
			for(int i1=0;i1<line1.length;i1++)
				arrL1.add(line1[i1]);                
			inputRecords1.add(arrL1);
		}
		for(int y1=0;y1<inputRecords1.size();y1++){
			sum1=0;
			for(int j1=0;j1<inputs1.length;j1++){
			//System.out.println("weights=" +w.weight.get(j1));

				sum1+=w.weight.get(j1)*Integer.parseInt(inputRecords1.get(y1).get(j1));
				//System.out.println("summation=" +sum);
			}
			
				if(sum1>=0.5){ op1 = (float) 1; }
				else op1 = (float) 0;
			//System.out.println("class=" +Integer.parseInt(inputRecords1.get(y1).get(inputs1.length))+ "op="+op1);
		if(Integer.parseInt(inputRecords1.get(y1).get(inputs1.length))==op1) { correct++; }
		
			


}
		float p_ttc = (correct/(float)inputRecords1.size())*100; 
		System.out.println("Percentage accuracy of Test data=" +p_ttc);
	}
}
