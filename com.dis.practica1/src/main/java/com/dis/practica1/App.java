package com.dis.practica1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.dis.practica1.Cliente;
import com.dis.practica1.DatosItem;
import com.dis.practica1.Menu;
import com.dis.practica1.Pedido;
import com.dis.practica1.Producto;

public class App 
{			
	
    public static void main( String[] args )
    {
    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();
												
			java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int opc1 = 0;
			int opc2 = 0;
			int Continue = 1;
						
			Menu.MenuInicio();
			opc1 = Integer.parseInt(in.readLine());
						
			switch(opc1) {
			case 1:
				setUp1(dBuilder);
				break;
			case 2:
				setUp2(dBuilder);
				break;
			default:
				Continue = 0; //En caso de que se inserte una opción no válida
				break;
			}
			
			while(opc2 != 4 && Continue == 1) {
				Menu.MenuCRUD();
				opc2 = Integer.parseInt(in.readLine());				
				
				switch(opc2) {
				case 1:
					productos.appendChild(crearProducto(doc));
					break;
				case 2:
					clientes.appendChild(crearCliente(doc));
					break;
				case 3:
					pedidos.appendChild(crearPedido(doc));
					break;
				}
			}
			
			saveXML(doc);

		} catch (Exception e) {
			e.printStackTrace();
		}
    }    
    
    static Node rootElement; //Será la etiqueta raíz del documento xml
	static Node productos = null; //Etiqueta que contendrá todos los productos
	static Node clientes = null; //Etiqueta que contendrá todos los clientes
	static Node pedidos = null; //Etiqueta que contendrá todos los pedidos
	static Document doc = null;
	
    private static void setUp1(DocumentBuilder dBuilder) { //En el caso de que se quiera crear de cero un xml
    	doc = dBuilder.newDocument();			
		rootElement = doc.createElement("Almacen");
		productos = doc.createElement("Productos");
		clientes = doc.createElement("Clientes");
		pedidos = doc.createElement("Pedidos");
		
		doc.appendChild(rootElement); //Se agrega el elemento raíz
		rootElement.appendChild(productos); //Se anidan las etiquetas hijas
		rootElement.appendChild(clientes);
		rootElement.appendChild(pedidos);
    }
    
    private static void setUp2(DocumentBuilder dBuilder) throws SAXException, IOException { //En el caso de que se quiera cargar un xml
    	String filePath = "almacen.xml";
        File xmlFile = new File(filePath);
        doc = dBuilder.parse(xmlFile);
        rootElement = (Element) doc.getElementsByTagName("Almancen").item(0);
        productos = (Element) doc.getElementsByTagName("Productos").item(0);
        clientes = (Element) doc.getElementsByTagName("Clientes").item(0);
        pedidos = (Element) doc.getElementsByTagName("Pedidos").item(0);
    }
    
    private static Node crearProducto(Document doc) throws IOException {		
		Producto producto = DatosItem.datosProducto();
		//Se crea el objeto de tipo producto con los valores pedidos por teclado
		
		Element Producto = doc.createElement("Producto"); 
		Node localizacion = doc.createElement("Localizacion");
 		
		//Se crean y agregan las etiquetas que conforman a un producto
		Producto.setAttribute("Codigo", producto.getCodigo());
		Producto.appendChild(crearEtiqueta(doc, "NombreProducto", producto.getNombreProducto()));
		Producto.appendChild(crearEtiqueta(doc, "Descripcion", producto.getDescripcion()));
		Producto.appendChild(crearEtiqueta(doc, "Stock", producto.getStock()));
		Producto.appendChild(crearEtiqueta(doc, "Pendientes", producto.getPendientes()));
		Producto.appendChild(localizacion);
		
		//Se crean y agregan las etiquetas que conforman la localización de un producto
		localizacion.appendChild(crearEtiqueta(doc, "Pasillo", producto.getPasillo()));
		localizacion.appendChild(crearEtiqueta(doc, "Estanteria", producto.getEstanteria()));
		localizacion.appendChild(crearEtiqueta(doc, "Estante", producto.getEstante()));		

		return Producto;
	}
	      
    private static Node crearCliente(Document doc) throws IOException {
    	Cliente cliente = DatosItem.datosCliente();
    	//Se crea el objeto de tipo cliente con los valores pedidos por teclado
    	
    	Element Cliente = doc.createElement("Cliente");
    	Node direccion = doc.createElement("Direccion");
    	
    	//Se crean y agregan las etiquetas que conforman a un cliente
    	Cliente.setAttribute("id", cliente.getId());
    	Cliente.appendChild(crearEtiqueta(doc, "Nombre", cliente.getNombre()));
    	Cliente.appendChild(crearEtiqueta(doc, "Apellidos", cliente.getApellidos()));
    	Cliente.appendChild(crearEtiqueta(doc, "Email", cliente.getEmail()));
    	Cliente.appendChild(crearEtiqueta(doc, "Telefono", cliente.getTelefono()));
    	Cliente.appendChild(direccion);
    	
    	//Se crean y agregan las etiquetas que conforman la dirección de un cliente
    	direccion.appendChild(crearEtiqueta(doc, "Calle", cliente.getCalle()));
    	direccion.appendChild(crearEtiqueta(doc, "Numero", cliente.getNumero()));
    	direccion.appendChild(crearEtiqueta(doc, "CodigoPostal", cliente.getCodigoPostal()));
    	direccion.appendChild(crearEtiqueta(doc, "Poblacion", cliente.getPoblacion()));
    	direccion.appendChild(crearEtiqueta(doc, "Pais", cliente.getPais()));
    	
    	return Cliente;
    }    
    
    private static Node crearPedido(Document doc) throws IOException {
    	Pedido pedido = DatosItem.datosPedido();
    	//Se crea el objeto de tipo pedido con los valores pedidos por teclado
    	
    	Element Pedido = doc.createElement("Pedido");
    	Element producto = doc.createElement("ProductoPedido");
    	Node direccion = doc.createElement("DireccionPedido");
    	
    	//Se crean y agregan las etiquetas que conforman a un pedido
    	Pedido.setAttribute("id", pedido.getId());
    	Pedido.appendChild(producto);
    	
    	//Etiquetas relacionadas con el producto de un pedido
    	producto.setAttribute("Codigo", pedido.getCodigo());
    	producto.appendChild(crearEtiqueta(doc, "Info", pedido.getInfo()));
    	producto.appendChild(crearEtiqueta(doc, "Cantidad", pedido.getCantidad()));
    	
    	Pedido.appendChild(crearEtiqueta(doc, "Destinatario", pedido.getDestinatario()));
    	Pedido.appendChild(crearEtiqueta(doc, "Fecha", pedido.getFecha()));
    	Pedido.appendChild(direccion);
    	
    	//Se crean y agregan las etiquetas que conforman la dirección del destinatario del pedido
    	direccion.appendChild(crearEtiqueta(doc, "CallePedido", pedido.getCalle()));
    	direccion.appendChild(crearEtiqueta(doc, "NumeroPedido", pedido.getNumero()));
    	direccion.appendChild(crearEtiqueta(doc, "CodigoPostalPedido", pedido.getCodigoPostal()));
    	direccion.appendChild(crearEtiqueta(doc, "PoblacionPedido", pedido.getPoblacion()));
    	direccion.appendChild(crearEtiqueta(doc, "PaisPedido", pedido.getPais()));
    	
    	return Pedido;
    }    
    
    //Método para crear una etiqueta
    private static Node crearEtiqueta(Document doc, String NombreEtiqueta, String ContenidoEtiqueta) {
		Element node = doc.createElement(NombreEtiqueta); 
		node.appendChild(doc.createTextNode(ContenidoEtiqueta)); 
		return node;
	}
    
    //Método para guardar los datos en el documento xml
    private static void saveXML(Document doc) throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
				
		DOMImplementation domImpl = doc.getImplementation();
		DocumentType doctype = domImpl.createDocumentType("doctype","PracticaDis","almacen.dtd");
		
		transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId()); //incluir DTD
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no"); //Cabecera xml
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");				
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); //n-espacios para tabular		
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
					
		StreamResult console = new StreamResult(System.out);
		StreamResult file = new StreamResult(new File("almacen.xml"));

		//Mostrar resultado: 
		transformer.transform(new DOMSource(doc), console); //Por consola
		transformer.transform(new DOMSource(doc), file); //Escribir en el documento
	}    
}