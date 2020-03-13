package com.dis.practica1;

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

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class App {
	public static void main(String[] args) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			// Creamos elementos en el documento
			Element rootElement = doc.createElement("Almacen");

			// Almacen como elemento raiz
			doc.appendChild(rootElement);

			// Creamos los elementos Productos, Clientes y Pedidos
			Element productos = doc.createElement("Productos");
			Element clientes = doc.createElement("Clientes");
			Element pedidos = doc.createElement("Pedidos");

			int option = -1;
			int flag1=0;
			int flag2=0;
			int flag3=0;
			Node producto;
			Node cliente;
			Node pedido;
			java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			while (option != 0) {
				clear();
				menu();

				option = Integer.parseInt(in.readLine());

				switch(option) {
				case 1:
					clear();
					if(flag1==0) {
						rootElement.appendChild(productos);
						flag1++;
					}
					producto = productoSubMenu(doc);
					productos.appendChild(producto);

					break;
				case 2:
					clear();
					if(flag2==0) {
						rootElement.appendChild(clientes);
						flag2++;
					}
					cliente = clienteSubMenu(doc);
					clientes.appendChild(cliente);

					break;
				case 3:
					clear();
					if(flag3==0) {
						rootElement.appendChild(pedidos);
						flag3++;
					}
					pedido = pedidoSubMenu(doc);
					pedidos.appendChild(pedido);

					break;
				case 4:
					String filePath = "almacen.xml";
					File xmlFile = new File(filePath);
					doc = dBuilder.parse(xmlFile);
					break;
				}
			}

			// Necesario para generar el output
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			// Necesario para mostrar el !doctype
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			DOMImplementation domImpl = doc.getImplementation();
			DocumentType doctype = domImpl.createDocumentType("doctype",
					"PracticaDis",
					"Almacen.dtd");
			// Hacemos la tabulacion necesaria para el xml
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId());
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "10");
			DOMSource source = new DOMSource(doc);

			// Creamos el archivo xml
			StreamResult console = new StreamResult(System.out);
			StreamResult file = new StreamResult(new File("almacen.xml"));

			// mostramos la informacion por pantalla y al archivo
			transformer.transform(source, console);
			transformer.transform(source, file);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void doc(int n) {




	}

	public static Node productoSubMenu(Document prod) throws IOException{
		String codigo;
		String nombre;
		String descripcion;
		String stock;
		String pendientes;
		String pasillo;
		String estanteria;
		String estante;
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Producto ->");
		System.out.print("Codigo:");
		codigo = in.readLine();

		System.out.print("Nombre:");
		nombre = in.readLine();

		System.out.print("Descripcion:");
		descripcion = in.readLine();

		System.out.print("Stock:");
		stock = in.readLine();

		System.out.println("\nLocalizacion ->");
		System.out.print("\tPasillo:");
		pasillo = in.readLine();

		System.out.print("\tEstanteria:");
		estanteria = in.readLine();

		System.out.print("\tEstante:");
		estante = in.readLine();

		System.out.print("Pendientes (de entrada en almacen):");
		pendientes = in.readLine();

		return (createProdElement(prod, codigo, nombre, descripcion, stock, pendientes, pasillo, estanteria, estante));
	}

	public static Node clienteSubMenu(Document prod) throws IOException {
		String nombre;
		String apellidos;
		String email; 
		String telefono;
		String calle; 
		String numero; 
		String codigop;
		String poblacion;
		String pais;
		String codigo;
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Cliente ->");
		System.out.print("Nombre:");
		nombre = in.readLine();

		System.out.print("Apellidos:");
		apellidos = in.readLine();

		System.out.print("ID:");
		codigo = in.readLine();

		System.out.print("Email:");
		email = in.readLine();

		System.out.print("Telefono de contacto:");
		telefono = in.readLine();

		System.out.println("Direccion ->");
		System.out.print("\tCalle:");
		calle = in.readLine();

		System.out.print("\tNumero:");
		numero = in.readLine();

		System.out.print("\tCodigo postal:");
		codigop = in.readLine();

		System.out.print("\tPoblacion:");
		poblacion = in.readLine();

		System.out.print("\tPais:");
		pais = in.readLine();

		return (createClienElement(prod, nombre, apellidos, email, telefono, calle, numero, codigop, poblacion, pais, codigo));
	}

	public static Node pedidoSubMenu(Document prod) throws IOException {
		String infoproducto;
		String codigo;
		String cantidad; 
		String destinatario;
		String fecha;
		String calle;
		String numero;
		String codigop;
		String poblacion;
		String pais;
		String id;
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Pedido ->");
		System.out.print("\tId:");
		id = in.readLine();

		System.out.println("\tProducto ->");
		System.out.print("\n\t\tCodigo:");
		codigo = in.readLine();

		System.out.print("\t\tInfo:");
		infoproducto = in.readLine();

		System.out.print("\t\tCantidad:");
		cantidad = in.readLine();

		System.out.println("Destinatario:");
		destinatario = in.readLine();

		System.out.println("Fecha de entrega estimada:");
		fecha = in.readLine();

		System.out.println("Direccion de entrega ->");
		System.out.print("\tCalle:");
		calle = in.readLine();

		System.out.print("\tNumero:");
		numero = in.readLine();

		System.out.print("\tCodigo postal:");
		codigop = in.readLine();

		System.out.print("\tPoblacion:");
		poblacion = in.readLine();

		System.out.print("\tPais:");
		pais = in.readLine();

		return (createPedElement(prod, codigo, infoproducto, cantidad, destinatario, fecha, calle, numero, codigop, poblacion, pais, id));
	}

	private static Node createProdElement(Document prod, String codigo, String nombre , String descripcion, String stock, 
			String pendientes, String pasillo, String estanteria, String estante ) {								
		Element producto = prod.createElement("Producto");
		Element localizacion = prod.createElement("Localizacion");		

		// atributo codigo
		producto.setAttribute("Codigo", codigo);

		// Creamos los elementos de Producto
		producto.appendChild(createElements(prod, producto, "Nombre", nombre));
		producto.appendChild(createElements(prod, producto, "Descripcion", descripcion));
		producto.appendChild(createElements(prod, producto, "Stock", stock));
		producto.appendChild(createElements(prod, producto, "Pendientes", pendientes));

		//Añadimos el elemento Localizacion en Producto, y los elementos de Localizacion
		producto.appendChild(localizacion);
		localizacion.appendChild(createElements(prod, localizacion, "Pasillo", pasillo));
		localizacion.appendChild(createElements(prod, localizacion, "Estanteria", estanteria));
		localizacion.appendChild(createElements(prod, localizacion, "Estante", estante));

		return producto;
	}

	private static Node createClienElement(Document clien, String nombre , String apellidos , String email, String telefono,
			String calle, String numero, String codigop, String poblacion, String pais, String codigo) {
		Element cliente = clien.createElement("Cliente");
		Element direccion = clien.createElement("Direccion");

		cliente.setAttribute("Id", codigo);

		cliente.appendChild(createElements(clien, cliente, "Nombre", nombre));
		cliente.appendChild(createElements(clien, cliente, "Apellidos", apellidos));
		cliente.appendChild(createElements(clien, cliente, "Email", email));
		cliente.appendChild(createElements(clien, cliente, "Telefono", telefono));

		cliente.appendChild(direccion);
		direccion.appendChild(createElements(clien, direccion, "Calle", calle));
		direccion.appendChild(createElements(clien, direccion, "Numero", numero));
		direccion.appendChild(createElements(clien, direccion, "CodigoPostal", codigop));
		direccion.appendChild(createElements(clien, direccion, "Poblacion", poblacion));
		direccion.appendChild(createElements(clien, direccion, "Pais", pais));

		return cliente;
	}

	private static Node createPedElement(Document ped, String nombreproducto , String cantidad , String destinatario,
			String fecha, String calle, String numero, String codigop, String poblacion, String pais, String codigo, String id) {
		Element pedido = ped.createElement("Pedido");
		Element direccion = ped.createElement("Direccion");
		Element producto = ped.createElement("Producto");

		pedido.setAttribute("Id", id);
		producto.setAttribute("Código", codigo);

		pedido.appendChild(producto);
		producto.appendChild(createElements(ped, pedido, "Info", nombreproducto));
		producto.appendChild(createElements(ped, pedido, "Cantidad", cantidad));

		pedido.appendChild(createElements(ped, pedido, "Destinatario", destinatario));
		pedido.appendChild(createElements(ped, pedido, "Fecha", fecha));

		pedido.appendChild(direccion);
		direccion.appendChild(createElements(ped, direccion, "Calle", calle));
		direccion.appendChild(createElements(ped, direccion, "Numero", numero));
		direccion.appendChild(createElements(ped, direccion, "CodigoPostal", codigop));
		direccion.appendChild(createElements(ped, direccion, "Poblacion", poblacion));
		direccion.appendChild(createElements(ped, direccion, "Pais", pais));

		return pedido;
	}


	private static Node createElements(Document doc, Element element, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}


	private static void addProducto(Document doc, String codigo, String nombre , String descripcion, String stock, String pendientes, String pasillo, String estanteria, String estante) {
		Element prod = null;
		NodeList productos = doc.getElementsByTagName("Productos");

		for (int i = 0; i < productos.getLength(); i++) {
			prod = (Element) productos.item(i);

			Element producto = doc.createElement("Producto");
			Element localizacion = doc.createElement("Localizacion");

			prod.appendChild(producto);
			producto.setAttribute("Codigo", codigo);
			//Valores de producto
			producto.appendChild(createElements(doc, producto,"Nombre", nombre));
			producto.appendChild(createElements(doc, producto,"Descripción", descripcion));
			producto.appendChild(createElements(doc, producto,"Stock", stock));
			producto.appendChild(createElements(doc, producto,"Pendientes", stock));
			//Valores de localización
			producto.appendChild(localizacion);
			localizacion.appendChild(createElements(doc, localizacion, "Pasillo", pasillo));
			localizacion.appendChild(createElements(doc, localizacion, "Estanteria", estanteria));
			localizacion.appendChild(createElements(doc, localizacion, "Estante", estante));
		}
	}


	private static void addClient(Document doc, String nombre , String apellidos , String email, String telefono, String calle, String numero, String codigop, String poblacion, String pais, String codigo) {
		Element client =  null;
		NodeList clientes = doc.getElementsByTagName("Clientes");

		for(int i = 0; i < clientes.getLength(); i++) {
			client = (Element) clientes.item(i);

			Element cliente = doc.createElement("Cliente");
			Element direccion = doc.createElement("Direccion");

			client.appendChild(cliente);           
			cliente.setAttribute("Id", codigo);
			//Valores cliente
			cliente.appendChild(createElements(doc, cliente, "Nombre", nombre));
			cliente.appendChild(createElements(doc, cliente, "Apellidos", apellidos));
			cliente.appendChild(createElements(doc, cliente, "Email", email));
			cliente.appendChild(createElements(doc, cliente, "Telefono", telefono));
			//Valores dirección
			cliente.appendChild(direccion);
			direccion.appendChild(createElements(doc, direccion, "Calle", calle));
			direccion.appendChild(createElements(doc, direccion, "Numero", numero));
			direccion.appendChild(createElements(doc, direccion, "CodigoPostal", codigop));
			direccion.appendChild(createElements(doc, direccion, "Poblacion", poblacion));
			direccion.appendChild(createElements(doc, direccion, "Pais", pais));
		}
	}


	private static void addPedido(Document doc, String nombreproducto , String cantidad ,String destinatario, String fecha, String calle, String numero, String codigop, String poblacion, String pais, String codigo, String id) {
		Element ped = null;
		NodeList pedidos = doc.getElementsByTagName("Pedidos");

		for(int i = 0; i < pedidos.getLength(); i ++) {
			ped = (Element) pedidos.item(i);

			Element pedido = doc.createElement("Pedido");
			Element direccion = doc.createElement("DireccionPedido");
			Element producto = doc.createElement("ProductoPedido");

			pedido.setAttribute("Id", id);
			producto.setAttribute("Código", codigo);
			//Valores producto
			pedido.appendChild(producto);
			producto.appendChild(createElements(doc, pedido, "Info", nombreproducto));
			producto.appendChild(createElements(doc, pedido, "Cantidad", cantidad));

			pedido.appendChild(createElements(doc, pedido, "Destinatario", destinatario));
			pedido.appendChild(createElements(doc, pedido, "Fecha", fecha));
			//Valores dirección
			pedido.appendChild(direccion);
			direccion.appendChild(createElements(doc, direccion, "CallePedido", calle));
			direccion.appendChild(createElements(doc, direccion, "NumeroPedido", numero));
			direccion.appendChild(createElements(doc, direccion, "CodigoPostalPedido", codigop));
			direccion.appendChild(createElements(doc, direccion, "PoblacionPedido", poblacion));
			direccion.appendChild(createElements(doc, direccion, "PaisPedido", pais));
		}
	}


	public static void clear() {
		System.out.print("\033[2J");
		System.out.flush();
	}

	public static void menu() {
		System.out.println("**************************");
		System.out.println("1.- Introducir Producto");
		System.out.println("2.- Introducir Cliente");
		System.out.println("3.- Introducir Pedido");
		System.out.println("4.- Cargar documento");
		System.out.println("0.- Salir");

		System.out.println("\nOpcion:");
	}
}
