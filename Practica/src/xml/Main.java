package xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

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
	            // A�adimos elementos al documento
	            Element rootElement = doc.createElement("Almacen");
	            
	            // A�adimos el Almacen como root
	            doc.appendChild(rootElement);
	            
	            // A�adimos los elementos de Productos, Clientes y Pedidos
	            Element productos = doc.createElement("Productos");            
	            rootElement.appendChild(productos);
	            Element clientes = doc.createElement("Clientes");            
	            rootElement.appendChild(clientes);
	            Element pedidos = doc.createElement("Pedidos");            
	            rootElement.appendChild(pedidos);
	        
	        int option = -1;    
	        Node producto;
	        Node cliente;
	        Node pedido;
	        java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			while (option != 0) {
				Menu();
				option = Integer.parseInt(in.readLine());
				switch(option) {
				case 1:
					producto = productoSubMenu(doc);
					productos.appendChild(producto);
						break;
				case 2:
					cliente = clienteSubMenu(doc);
					clientes.appendChild(cliente);
						break;
				case 3:
					pedido = pedidoSubMenu(doc);
					pedidos.appendChild(pedido);
						break;
				}
			}
			
			// Necesario para generar el output
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            // Hacemos la tabulaci�n necesaria para el xml
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
	
	public static void doc(int n) {
		
 

        
	}
	
	public static Node productoSubMenu(Document prod) throws IOException {
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String codigo; String nombre ; String descripcion; String stock;
        String pendientes; String pasillo; String estanteria; String estante;
        System.out.println("Producto.");
        System.out.println("C�digo:");
		codigo = in.readLine();
		System.out.println("Nombre:");
		nombre = in.readLine();
		System.out.println("Descripci�n:");
		descripcion = in.readLine();
		System.out.println("Stock:");
		stock = in.readLine();
		System.out.println("Localizaci�n.");
		System.out.println("\tPasillo:");
		pasillo = in.readLine();
		System.out.println("\tEstanter�a:");
		estanteria = in.readLine();
		System.out.println("\tEstante:");
		estante = in.readLine();
		System.out.println("Pendientes (de entrada en almac�n):");
		pendientes = in.readLine();
		
		return (createProdElement(prod, codigo, nombre, descripcion, stock, pendientes, pasillo, estanteria, estante));
	}
	
	public static Node clienteSubMenu(Document prod) throws IOException {
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String nombre ; String apellidos ; String email; String telefono;
        String calle; String numero; String codigop; String poblacion; String pais;
        System.out.println("Cliente.");
        System.out.println("Nombre:");
		nombre = in.readLine();
		System.out.println("Apellidos:");
		apellidos = in.readLine();
		System.out.println("Email:");
		email = in.readLine();
		System.out.println("Tel�fono de contacto:");
		telefono = in.readLine();
		System.out.println("Direcci�n.");
		System.out.println("\tCalle:");
		calle = in.readLine();
		System.out.println("\tN�mero:");
		numero = in.readLine();
		System.out.println("\tC�digo postal:");
		codigop = in.readLine();
		System.out.println("\tPoblaci�n:");
		poblacion = in.readLine();
		System.out.println("\tPa�s:");
		pais = in.readLine();
		
		return (createClienElement(prod, nombre, apellidos, email, telefono, calle, numero, codigop, poblacion, pais));
	}
	
	public static Node pedidoSubMenu(Document prod) throws IOException {
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String productos ; String cantidad ; String destinatario;
        String fecha; String calle; String numero; String codigop; String poblacion; String pais;
        System.out.println("Pedido.");
        System.out.println("Productos:");
		productos = in.readLine();
		System.out.println("Cantidad:");
		cantidad = in.readLine();
		System.out.println("Destinatario:");
		destinatario = in.readLine();
		System.out.println("Fecha de entrega estimada:");
		fecha = in.readLine();
		System.out.println("Direcci�n de entrega.");
		System.out.println("\tCalle:");
		calle = in.readLine();
		System.out.println("\tN�mero:");
		numero = in.readLine();
		System.out.println("\tC�digo postal:");
		codigop = in.readLine();
		System.out.println("\tPoblaci�n:");
		poblacion = in.readLine();
		System.out.println("\tPa�s:");
		pais = in.readLine();
		
		return (createPedElement(prod, productos, cantidad, destinatario, fecha, calle, numero, codigop, poblacion, pais));
	}
	
	 private static Node createProdElement(Document prod, String codigo, String nombre , String descripcion, String stock,
		        String pendientes, String pasillo, String estanteria, String estante ) {
		        Element producto = prod.createElement("Producto");
		        Element localizacion = prod.createElement("Localizaci�n");
		        // atributo codigo
		        producto.setAttribute("C�digo", codigo);

		        // Creamos los elementos de Producto
		        producto.appendChild(createElements(prod, producto, "Nombre", nombre));       
		        producto.appendChild(createElements(prod, producto, "Descripci�n", descripcion));      
		        producto.appendChild(createElements(prod, producto, "Stock", stock));
		        producto.appendChild(createElements(prod, producto, "Pendientes", pendientes));
		        
		        //A�adimos el elemento Localizacion en Producto, y los elementos de Localizacion 
		        producto.appendChild(localizacion);
		        localizacion.appendChild(createElements(prod, localizacion, "Pasillo", pasillo));
		        localizacion.appendChild(createElements(prod, localizacion, "Estanter�a", estanteria));
		        localizacion.appendChild(createElements(prod, localizacion, "Estante", estante));
		
		        return producto;
		    }
	 
	 private static Node createClienElement(Document clien, String nombre , String apellidos , String email, String telefono,
		        String calle, String numero, String codigop, String poblacion, String pais) {
		        Element cliente = clien.createElement("Cliente");
		        Element direccion = clien.createElement("Direcci�n");
		      
		     
		        cliente.appendChild(createElements(clien, cliente, "Nombre", nombre));		       
		        cliente.appendChild(createElements(clien, cliente, "Apellidos", apellidos));		        
		        cliente.appendChild(createElements(clien, cliente, "Email", email));		        
		        cliente.appendChild(createElements(clien, cliente, "Telefono", telefono));        
		        		        
		        cliente.appendChild(direccion);
		        direccion.appendChild(createElements(clien, direccion, "Calle", calle));
		        direccion.appendChild(createElements(clien, direccion, "N�mero", numero));
		        direccion.appendChild(createElements(clien, direccion, "C�digoPostal", codigop));
		        direccion.appendChild(createElements(clien, direccion, "Poblaci�n", poblacion));
		        direccion.appendChild(createElements(clien, direccion, "Pa�s", pais));
		        
		        return cliente;
		    }
	    
	 private static Node createPedElement(Document ped, String productos , String cantidad , String destinatario,
		        String fecha, String calle, String numero, String codigop, String poblacion, String pais) {
		        Element pedido = ped.createElement("Pedido");
		        Element direccion = ped.createElement("Direcci�n");
		      
		        // 
		        pedido.appendChild(createElements(ped, pedido, "Productos", productos));
		        pedido.appendChild(createElements(ped, pedido, "Cantidad", cantidad));
		        pedido.appendChild(createElements(ped, pedido, "Destinatario", destinatario));		       
		        pedido.appendChild(createElements(ped, pedido, "Fecha", fecha));
		        
		        pedido.appendChild(direccion);
		        direccion.appendChild(createElements(ped, direccion, "Calle", calle));
		        direccion.appendChild(createElements(ped, direccion, "N�mero", numero));
		        direccion.appendChild(createElements(ped, direccion, "C�digoPostal", codigop));
		        direccion.appendChild(createElements(ped, direccion, "Poblaci�n", poblacion));
		        direccion.appendChild(createElements(ped, direccion, "Pa�s", pais));
		     	
		        return pedido;
		    }

	 
	 private static Node createElements(Document doc, Element element, String name, String value) {
	        Element node = doc.createElement(name);
	        node.appendChild(doc.createTextNode(value));
	        return node;
	    }
	 
	 public static void Menu() {
			System.out.println("**************************");
			System.out.println("1.- Introducir Producto");
			System.out.println("2.- Introducir Cliente");
			System.out.println("3.- Introducir Pedido");
			System.out.println("0.- Salir");
		}


}
