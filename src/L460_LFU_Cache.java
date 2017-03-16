import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;


public class L460_LFU_Cache {
	int capacity;
	int usedCapacity;
	long timeStamp;
	
	final Map<Integer, Integer> kv = new ConcurrentHashMap<>();
	final Map<Integer, Integer> freq = new ConcurrentHashMap<>();
	final Map<Integer, Long> time = new ConcurrentHashMap<>();
	
	public L460_LFU_Cache(int capacity) {
		this.capacity = capacity;
		this.usedCapacity = 0;
	}

	public synchronized int get(int key) {
		if (kv.containsKey(key)) {
			freq.put(key, freq.get(key) + 1);
			time.put(key, timeStamp++);
			return kv.get(key);
		}
		
		return -1;
	}

	public synchronized void set(int key, int value) {
		if (capacity == 0) {
			return;
		}
		
		if (kv.containsKey(key)) {
			kv.put(key, value);
			freq.put(key, 0);
			time.put(key, timeStamp++);
			return;
		}
		
		if (usedCapacity < capacity) {
			usedCapacity ++;
			kv.put(key, value);
			freq.put(key, 0);
			time.put(key, timeStamp++);
			return;
		}
		Integer removedKey = -1;
		Integer removedFreq = Integer.MAX_VALUE;
		Long removedTime = Long.MAX_VALUE;
		
		print();
		System.out.println();
		for (Entry<Integer, Integer> item : freq.entrySet()) {
			if (item.getValue().intValue() < removedFreq.intValue() || (item.getValue().intValue() == removedFreq.intValue() && time.get(item.getKey()).longValue() < removedTime.longValue())) {
				removedKey = item.getKey();
				removedFreq = item.getValue();
				removedTime = time.get(removedKey);
			}
		}
		
		kv.remove(removedKey);
		freq.remove(removedKey);
		time.remove(removedKey);
		
		kv.put(key, value);
		freq.put(key, 0);
		time.put(key, timeStamp++);
	}
	
	void print() {
		for (Entry<Integer, Long> item : time.entrySet()) {
			System.out.println("Key:" + item.getKey() + "Value:" + item.getValue());
		}
	}
	
	public static void main(String args[]) {
		//[[2],[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]]

		L460_LFU_Cache obj = new L460_LFU_Cache(2);
		obj.set(2, 1);
		obj.set(3, 2);
		obj.get(3);
		obj.get(2);
		obj.set(4, 3);
		obj.get(2);
		obj.get(3);
		obj.get(4);
	}
}