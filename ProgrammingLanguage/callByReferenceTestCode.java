import java.util.HashMap;
import java.util.Map;

public class callByReferenceTestCode {

	public static void assignNumber(NumberClass num) {
		num.mNum = 10;
	}
	
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
		NumberClass mainNum = new NumberClass(1);
		System.out.println("init mainNum.getNumber():" + mainNum.getNumber());

		assignNumber(mainNum);
		System.out.println("after assignNumber(), mainNum.getNumber():" + mainNum.getNumber());
		
		assignNewNumber(mainNum);
		System.out.println("after assignNewNumber(), mainNum.getNumber():" + mainNum.getNumber());

		changeNumber(mainNum);
		System.out.println("after changeNumber(), mainNum.getNumber():" + mainNum.getNumber());
		System.out.println();
		
		
		Map map = new HashMap();
		map.put("num", 1);
		System.out.println("init map.get(\"num\"):" + map.get("num"));
		changeMap(map);
		System.out.println("after changeMap(), map.get(\"num\"):" + map.get("num"));
	}
}

class NumberClass {
	public int mNum;

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