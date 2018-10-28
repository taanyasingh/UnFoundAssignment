package parser;

public class Vehicle {
	String type;
	String id;
	String frame;
	String powerStation;
	public Wheel[] wheel;
	int wheelCount;
	String timeStamp;
	
	public void setValues(String type,String id, String frame, String powerStation, int wheelCount, String timeStamp){
		this.type=type;
		this.id= id;
		this.frame= frame;
		this.powerStation=powerStation;
		this.timeStamp= timeStamp;
		this.wheelCount=wheelCount;
		
	}
	public void setWheels(Wheel[] wheel ){
		this.wheel=wheel;
	}
	
	public String getType()
	{
		return type;
	}
	public String getId()
	{
		return id;
	}
	public String getFrame()
	{
		return frame;
	}
	public String getPowerstation()
	{
		return powerStation;
	}
	public String getTimestamp()
	{
		return timeStamp;
	}
	public int getWheelcount()
	{
		return wheelCount;
	}
}
