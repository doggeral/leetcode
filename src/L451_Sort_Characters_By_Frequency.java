import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L451_Sort_Characters_By_Frequency {
	public String frequencySort(String s) {
		char [] array = s.toCharArray();
		
		int [] occur = new int[256];
		
		for (int i=0; i<array.length; i++) {
			occur[array[i]] ++;
		}
		
		List<Item> list = new ArrayList<>();
		for (int i=0; i<256; i++) {
			if (occur[i] > 0) {
				list.add(new Item((char) i, occur[i]));
			}
		}
		
		Collections.sort(list);
		StringBuilder res = new StringBuilder();
		for (int i=0; i<list.size(); i++) {
			Item item = list.get(i);
			for (int j=0; j<item.frequence; j++) {
				res.append(item.c);
			}
			
		}
		
		return res.toString();
	}
	
	public class Item implements Comparable<Item>{
		private char c;
		private int frequence;
		@Override
		public int compareTo(Item o) {
			// TODO Auto-generated method stub
			if (o.frequence > this.frequence) {
				return 1;
			} else {
				return -1;
			}
		}
		
		public Item(char c, int freq) {
			this.c = c; 
			this.frequence = freq;
		}
		
	}
}