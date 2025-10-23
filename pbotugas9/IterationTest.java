import java.util.ArrayList;
public class IterationTest
{
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Object");
		arr.add("Programming");
		arr.add(1, "Oriented");
		
		for (int i = 0; i < arr.size(); i++){
		    System.out.print(arr.get(i) + " ");
		}
	    System.out.println();
	    
	    for (String str : arr){
	        System.out.print(str + " ");
	    }
	    
	    
	}
}