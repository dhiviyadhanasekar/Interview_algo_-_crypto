package myPackage;

public class LightBulbs {

	int lights=0b11010;
	boolean isOn(int i) {
		int temp = (lights>>i) & 1;
		if(temp == 1) return true;
		return false;
	}
	
	int toggle(int start, int end)
	{
		int temp = 1<<(end-start+1);
		temp = temp-1;
		System.out.println(convertToBinary(temp));
		temp <<= start;
		lights = lights^temp;
		
		return lights;
	}
	
	String convertToBinary(int i){
		return Integer.toString(i, 2);
	}
	
	public static void main(String[] args) {
			
		LightBulbs ob = new LightBulbs();
		System.out.println(ob.isOn(0));	
		
		int newLight = ob.toggle(1,3);
		System.out.println(ob.convertToBinary(newLight));
	}
}
