package parser;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.Map;
//import java.util.Set;
//import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParser {
	public HashMap< String, Integer> vehicleType= new HashMap<String, Integer>();
	
	public void XmlFileParser(File xmlFile)
	{
		//System.out.println("inside parser class:"+file);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		
		try {

			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("vehicle");
			System.out.println("Number of elements present in vehicle tag :"+nList.getLength());
			
			//vehicle object
			Vehicle[] vehicle= new Vehicle[nList.getLength()];
			//System.out.println("Number of elements present in vehicle tag :"+nList.);
			int temp = 0;
			String type;
			for (temp = 0; temp < nList.getLength(); temp++) {
				vehicle[temp]= new Vehicle();
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String resultID= eElement.getElementsByTagName("id").item(0).getTextContent();
					System.out.println("ID : "+ eElement.getElementsByTagName("id").item(0).getTextContent());
					String resultFrame= eElement.getElementsByTagName("material").item(0).getFirstChild().getNodeValue();
					//String resultFrame= eElement.getElementsByTagName("frame").item(0).getNodeValue();
					System.out.println("Frame :"+resultFrame);
					//String resultWheels= eElement.getChildNodes();
					NodeList  wheel= eElement.getElementsByTagName("wheel");
					//System.out.println(" length of list"+ wheel.getLength());
					int wheelcount= wheel.getLength();
					
					Wheel[] wheelObj= new Wheel[wheelcount];
					for(int i=0; i<wheel.getLength();i++)
					{
						wheelObj[i]= new Wheel();
						String material= eElement.getElementsByTagName("material").item(0).getTextContent();
						String position= eElement.getElementsByTagName("position").item(0).getTextContent();
						wheelObj[i].setValues(position, material);
						System.out.println("inside wheel loop :"+wheelObj[i].getMat()+"   "+wheelObj[i].getPos());
						
					}
					String resultPowertrain= eElement.getElementsByTagName("powertrain").item(0).getTextContent();
					String timestamp=null;
					System.out.println("powrtrain :"+ resultPowertrain);
					
					type= getVehicleType(resultID,resultFrame,resultPowertrain,wheelcount);
					System.out.println("type of the vehicle:"+ type);
					vehicle[temp].setValues(type, resultID, resultFrame, resultPowertrain, wheelcount, timestamp);
					vehicle[temp].setWheels(wheelObj);
					System.out.println("id:"+vehicle[temp].getId());
					System.out.println("frame : "+vehicle[temp].getFrame());
					System.out.println("powertrain :"+vehicle[temp].getPowerstation());
					System.out.println("vehicle type:"+vehicle[temp].getType());
					System.out.println("wheel count:"+vehicle[temp].getWheelcount());
					
					if(vehicleType.containsKey(type))
					{
						for(Map.Entry m:vehicleType.entrySet()){ 
							int value= (int)m.getValue();
							m.setValue(value);
							//System.out.println(m.getKey()+" "+m.getValue());  
						}  
					}else{
						vehicleType.put(type, 1);
					}
					}
			}
			
			
			
			for(Map.Entry m:vehicleType.entrySet()){  
				   System.out.println("Summary \n "+m.getKey()+" "+m.getValue());  
				  }  
			
			SummaryResult result= new SummaryResult();
			result.genarateResponseFie(vehicle, temp, vehicleType);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

	private String getVehicleType(String resultID, String resultFrame,String resultPowertrain, int wheelcount) {
		
		if(resultFrame.equalsIgnoreCase("plastic"))
		{
			if(resultPowertrain.equalsIgnoreCase("Human") && wheelcount==3 )
			{
				return "Big Wheel";
			}else if(resultPowertrain.equalsIgnoreCase("Bernoulli"))
			{
				return "Hang Glider";
			}
				
		}
		else if(resultFrame.equalsIgnoreCase("metal"))
		{
			if(resultPowertrain.equalsIgnoreCase("Human") && wheelcount==2 )
			{
				return "Bicycle";
			}else if(resultPowertrain.equalsIgnoreCase("Internal Combustion") && wheelcount==2 )
			{
				return "Motorcycle";
			}
			else if(resultPowertrain.equalsIgnoreCase("Internal Combustion") && wheelcount==4 )
			{
				return "Car";
			}
			
		}
		return null;
		
	}

}
