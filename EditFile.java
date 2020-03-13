package xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Main {

	public static void main(String[] args) throws SAXException, IOException, TransformerException {		
		String filePath = "TestShop.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

	        doc.getDocumentElement().normalize();
	        
	        addProducto(doc);
	        writeXMLFile(doc);
	        
	        
	        //Generar output
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			
			// Hacemos la tabulacion necesaria para el xml
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");			
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "10");
			DOMSource source = new DOMSource(doc);
			
			//creación archivo
			//StreamResult console = new StreamResult(System.out);
			
			
			// mostramos la informacion por pantalla y al archivo
			//transformer.transform(source, console);
	        
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	private static void addElement(Document doc) {
        NodeList users = doc.getElementsByTagName("Cliente");
        Element emp = null;

        // loop for each user
        for (int i = 0; i < users.getLength(); i++) {
            emp = (Element) users.item(i);
            Element salaryElement = doc.createElement("Edad");
            salaryElement.appendChild(doc.createTextNode("45"));
            emp.appendChild(salaryElement);
        }
    }
	
	private static void addProducto(Document doc) {
		Element prod = null;
        NodeList productos = doc.getElementsByTagName("Productos");        
        
        // atributo codigo
        //producto.setAttribute("Codigo", "666");

        // loop for each 'productos'
        for (int i = 0; i < productos.getLength(); i++) {
            prod = (Element) productos.item(i);
            
            //Creamos el elemento producto y lacalización
            Element producto = doc.createElement("Producto");
            Element localizacion = doc.createElement("Localizacion");
            prod.appendChild(producto);            
            // atributo codigo
            producto.setAttribute("Codigo", "567");    
            
            //Creamos los elementos de producto 
            Element NameProd = doc.createElement("Nombre");
            Element DescProd = doc.createElement("Descripción");
            Element StockProd = doc.createElement("Stock");
            Element PendProd = doc.createElement("Pendientes");
            
            //Valores a los elementos
            NameProd.appendChild(doc.createTextNode("Pipa"));            
            DescProd.appendChild(doc.createTextNode("Fumar"));
            StockProd.appendChild(doc.createTextNode("3"));
            PendProd.appendChild(doc.createTextNode("6"));
            
            //Añadimos el elemento Localizacion en Producto, y los elementos de Localizacion  
            producto.appendChild(localizacion);
            Element LocPasilloProd = doc.createElement("Pasillo");
            Element LocEstanteriaProd = doc.createElement("Estantería");
            Element LocEstanteProd = doc.createElement("Estante");
            
            //Valores a localización
            LocPasilloProd.appendChild(doc.createTextNode("5"));
            LocEstanteriaProd.appendChild(doc.createTextNode("34"));
            LocEstanteProd.appendChild(doc.createTextNode("1"));
            
                        
            localizacion.appendChild(LocPasilloProd);
            localizacion.appendChild(LocEstanteriaProd);
            localizacion.appendChild(LocEstanteProd);
            producto.appendChild(NameProd);
            producto.appendChild(DescProd);
            producto.appendChild(StockProd);
            producto.appendChild(PendProd);
        }
    }
	
	private static void writeXMLFile(Document doc) throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
		doc.getDocumentElement().normalize();
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("TestShop.xml"));
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(source, result);
		System.out.println("XML file updated successfully");
	}
	
	private static Node createElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;    
	}

}
