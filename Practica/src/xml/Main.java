package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Main {
	
	public static void main(String[] args) {
		 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder;
	        try {
	            dBuilder = dbFactory.newDocumentBuilder();
	            Document doc = dBuilder.newDocument();
	            // Añadimos elementos al documento
	            Element rootElement = doc.createElement("Almacen");
	            
	            // Añadimos el Almacen como root
	            doc.appendChild(rootElement);
	            
	            // Añadimos los elementos de Productos, Clientes y Pedidos
	            Element productos = doc.createElement("Productos");            
	            rootElement.appendChild(productos);
	            Element clientes = doc.createElement("Clientes");            
	            rootElement.appendChild(clientes);
	       
	            //
	            productos.appendChild(createProdElement(doc, "1234343", "3434", "4343date", "4328", "a434le", "431", "fefef", "fgdfefe"));	  
	            productos.appendChild(createProdElement(doc, "7565656", "3434", "4343date", "4328", "a434le", "431", "fefef", "fgdfefe"));	   

	            // 
	            clientes.appendChild(createClienElement(doc, "2", "John", "Cena", "45", "Male", "feff", "ggfegf", "gege", "ggeg"));
	            
	            // Necesario para generar el output
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            
	            // Hacemos la tabulación necesaria para el xml
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC,"yes");
	            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "10");
	            DOMSource source = new DOMSource(doc);

	            // Creamos el archivo xml
	            StreamResult console = new StreamResult(System.out);
	            StreamResult file = new StreamResult(new File("almacen.xml"));

	            // mostramos la informacion por pantalla y al archivo
	            transformer.transform(source, console);
	            transformer.transform(source, file);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
	 private static Node createProdElement(Document prod, String codigo, String nombre , String descripcion, String stock,
		        String pendientes, String pasillo, String estanteria, String estante ) {
		        Element producto = prod.createElement("Producto");
		        Element localizacion = prod.createElement("Localización");
		        // atributo codigo
		        producto.setAttribute("Código", codigo);

		        // Creamos los elementos de Producto
		        producto.appendChild(createElements(prod, producto, "Nombre", nombre));       
		        producto.appendChild(createElements(prod, producto, "Descripción", descripcion));      
		        producto.appendChild(createElements(prod, producto, "Stock", stock));
		        producto.appendChild(createElements(prod, producto, "Pendientes", pendientes));
		        
		        //Añadimos el elemento Localizacion en Producto, y los elementos de Localizacion 
		        producto.appendChild(localizacion);
		        localizacion.appendChild(createElements(prod, localizacion, "Pasillo", pasillo));
		        localizacion.appendChild(createElements(prod, localizacion, "Estantería", estanteria));
		        localizacion.appendChild(createElements(prod, localizacion, "Estante", estante));
		
		        return producto;
		    }
	 
	 private static Node createClienElement(Document clien, String nombre , String apellidos , String email, String telefono,
		        String calle, String numero, String codigop, String poblacion, String pais) {
		        Element cliente = clien.createElement("Cliente");
		        Element direccion = clien.createElement("Dirección");
		      
		     
		        cliente.appendChild(createElements(clien, cliente, "Nombre", nombre));		       
		        cliente.appendChild(createElements(clien, cliente, "Apellidos", apellidos));		        
		        cliente.appendChild(createElements(clien, cliente, "Email", email));		        
		        cliente.appendChild(createElements(clien, cliente, "Telefono", telefono));        
		        		        
		        cliente.appendChild(direccion);
		        direccion.appendChild(createElements(clien, direccion, "Calle", calle));
		        direccion.appendChild(createElements(clien, direccion, "Número", numero));
		        direccion.appendChild(createElements(clien, direccion, "CódigoPostal", codigop));
		        direccion.appendChild(createElements(clien, direccion, "Población", poblacion));
		        direccion.appendChild(createElements(clien, direccion, "País", pais));
		        
		        return cliente;
		    }
	    
	 
	 private static Node createElements(Document doc, Element element, String name, String value) {
	        Element node = doc.createElement(name);
	        node.appendChild(doc.createTextNode(value));
	        return node;
	    }


}
