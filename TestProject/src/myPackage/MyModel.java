package myPackage;

public class MyModel {


	private String studentName;
	private int studentID=10;

	static {
		
	}
	
	public MyModel()
	{
		System.out.println("In base MyModel");
	}
	
	public MyModel (String studentName, int studentID) {

		this.studentName = studentName;
		this.studentID = studentID;
	}

//	public abstract void testAbstract();
	
	public String toString() {
		
		if(studentID == 0)
		{
			System.out.println("0");
		}
		StringBuffer tempStr = new StringBuffer(studentID + "");
		tempStr.append(",");
//		tempStr.append(studentName);
		return tempStr.toString();
	}

}
