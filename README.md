# UnFoundAssignment
Tasks completed:-

1. index.html
            uploading xml file then passing to the Servlet XmlFetcher.java via POST method.
            
2. Srvlet-  XmlFetcher.java
              Checking  whether the Xml file isMultipart and then storing the Xml file to a specific path in the system.
              And passing the file path to jva class XMLParser.java where xml is parsed and processed accordingly.
3.  XMLParser.java
              In this file reading the file that is being stored in previous step and parsed using DocumentBuiderFactory instance 
              which is used as xmlparser.After fetching diffrent values of tags they are stored in the objects of vehicle class.
              objects are processed according to the requirement and getting the final result, is passed to the html generator 
              class SummaryResult.java 
4.SummaryResult.java
              this class generates the required response in the form of html page. Summary is in the tabular form with required 
              fields and corresponding values.
              
              
