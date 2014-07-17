
public class DataStructures {
	
	//y1 = 100 * n + 10
	//y2 = 5 * n * n + 2
	//write a program that will compare the two values where n = 100 in increments of 10
	
	public static int gety1(int value){
		value = 100 * value + 10;
		return value;
	}

	
	public static int gety2(int value){
		value = 5 * value * value +2;		
		return value;
	}
	
	public static int valueCompare(int a, int b){
		if (a > b)
			return a;
		
		return b;		
	}
	
	
	public static void removeDup(char[] str){
		if (str == null) return;//if null then exit
		int len = str.length; //len is the length of the char array
		if (len < 2) return;// if lenth is one then exit
		
		int tail = 1;//tail?
		
		for (int i = 1; i < len; i++){//counting up the length 
			int j;
			for (j=0; j < tail; j++){//
				if (str[i] == str[j]) break;
			}
			if (j == tail){
				str[tail] = str[i];
				tail++;
			}
		}
		str[tail] = 0;
	}
	
	
	
	
	
	public static void main(String[] args) {
		String[] x = {"", "", "", "x", "x", "", "x", "x", "", "", "", "", ""};
		DoubleX game = new DoubleX(x);
		game.solver();
		
		System.out.println(game.toString());
		
	}

}
