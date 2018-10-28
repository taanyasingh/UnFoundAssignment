package parser;

public class Wheel {
	String material;
	String position;
	
	public void setValues(String pos, String mat)
	{
		this.position=pos;
		this.material=mat;
	}
	public String getMat()
	{
		return material;
	}
	public String getPos()
	{
		return position;
	}

}
