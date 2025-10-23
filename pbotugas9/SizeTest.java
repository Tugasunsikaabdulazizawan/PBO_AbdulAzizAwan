import java.util.ArrayList;
import java.util.Collections;
public class SizeTest
{
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList();
		arr.add(4);
		arr.add(2);
		arr.add(3);
		arr.add(1);
		System.out.println(arr);
		int b = arr.size();
		System.out.println("The size is: " + b);
		
	}
}