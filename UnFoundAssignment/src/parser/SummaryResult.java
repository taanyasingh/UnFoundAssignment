package parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class SummaryResult {
	public void genarateResponseFie(Vehicle[] vehicle, int size, HashMap<String, Integer> vehicleType)
	{
		System.out.println("inside result class :");
		System.out.println("no of objects :"+size);
		try {
			File f = new File("C:\\Users\\Tanya\\workspace\\UnFoundAssignment\\WebContent\\Response.html");

			f.getParentFile().mkdirs(); 
			f.createNewFile();
			FileWriter newHtmlFile= new FileWriter(f);

			StringBuffer response= new StringBuffer();
			response.append(" <!DOCTYPE html>\n<html>\n<head>\n<title>Summary</title>\n");
			response.append("<style>\n");
			response.append("table#t01 tr:nth-child(even) {\nbackground-color: #eee;\n}\ntable#t01 tr:nth-child(odd) {\nbackground-color: #fff;\n}\ntable#t01 th {\nbackground-color: black;\ncolor: white;}");
			response.append("\n</style>\n");
			response.append("</head>\n<body>\n<h1></h1>\n");
			response.append("<table id=\"t01\">\n");
			response.append("<tr>\n<th>Vehicle Name</th>\n<th>IDs</th>\n<th>Frame</th>\n<th>Powertrain</th>\n<th>Wheels</th>\n<th>Timestamp</th>\n</tr>");
			for(int i=0; i<size;i++)
			{
				response.append("<tr>\n");
				response.append("<td>"+vehicle[i].getType()+"</td>\n");
				response.append("<td>"+vehicle[i].getId()+"</td>\n");
				response.append("<td>"+vehicle[i].getFrame()+"</td>\n");
				response.append("<td>"+vehicle[i].getPowerstation()+"</td>\n");
				response.append("<td>");
				for (int j=0; j<vehicle[i].getWheelcount(); j++)
				{
					response.append(vehicle[i].wheel[j].getMat()+", "+vehicle[i].wheel[j].getPos());
				}
				response.append("</td>");
				response.append("<td>"+vehicle[i].getTimestamp()+"</td>\n");
				
				
			}
			response.append("</table>\n");
			response.append("<br><br>");
			response.append("<label>Overall Summary :</label>");
			response.append("");
			response.append("\n</body>\n</html> ");
			System.out.println(response);
			
			newHtmlFile.write(response.toString());
			newHtmlFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
