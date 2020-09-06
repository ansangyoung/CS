import java.util.HashMap;
import java.util.Map;

public class callByReferenceTestCode {
	
	public static void assignNewNumber(NumberClass num) {
		num = new NumberClass(20);
	}
	
	public static void changeNumber(NumberClass num) {
		num.setNumber(30);
	}
	
	public static void changeMap(Map map) {
		map.put("num", 2);
	}
	
	public static void main(String[] args) {
		NumberClass mainNum = new NumberClass(10);
		assignNewNumber(mainNum);
		System.out.println("mainNum.getNumber():" + mainNum.getNumber());
		
		changeNumber(mainNum);
		System.out.println("mainNum.getNumber():" + mainNum.getNumber());
		
		Map map = new HashMap();
		map.put("num", 1);
		System.out.println("map.get(\"num\"):" + map.get("num"));
		changeMap(map);
		System.out.println("map.get(\"num\"):" + map.get("num"));
	}
}

class NumberClass {
	private int mNum;
	
	public NumberClass(int num) {
		mNum = num;
	}
	
	public int getNumber() {
		return mNum;
	}
	
	public void setNumber(int num) {
		mNum = num;
	}
}