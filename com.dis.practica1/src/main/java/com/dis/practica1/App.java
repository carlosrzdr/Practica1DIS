package com.dis.practica1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App 
{			
	
    public static void main( String[] args )
    {
		Almacen almacen = new Almacen();
		Xml xml = new Xml();
		
		try {									
			java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int opc1 = 0;
			int opc2 = 0;
			int Continue = 1;
						
			Menu.MenuInicio();
			opc1 = Integer.parseInt(in.readLine());
						
			switch(opc1) {
			case 1:
				xml.newXml();
				break;
			case 2:
				xml.loadXml(almacen);
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
					almacen.addProducto(xml);
					break;
				case 2:
					almacen.addCliente(xml);
					break;
				case 3:
					almacen.addPedido(xml);
					break;
				}
			}
			
			if (Continue == 1) {
				xml.save();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
    }  
}