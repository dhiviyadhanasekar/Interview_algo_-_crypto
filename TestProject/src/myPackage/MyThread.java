package myPackage;



public class MyThread extends Thread {
	
	public MyThread(String threadName)
	{
		super(threadName);
	}
	
	public void run ()
	{
		System.out.println(getName());
		synchronized(this)
		{
			
		}
	}
}

