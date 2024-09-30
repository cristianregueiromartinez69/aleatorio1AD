
package ficheroaleatorio;

import java.io.*;

/**
 * clase fichero aleatorio en donde tenemos los metodos de lectura y escritura
 * @author cristian
 * @version 1.0
 */
public class FicheroAleatorio {

	//arrays con la informacion a introducir
	String[] codes = { "p1", "p2", "p3" };
	String[] descricion = { "parafusos", "cravos ", "tachas" };
	int[] prices = { 3, 4, 5 };

	/**
	 * metodo para escribir en el fichero
	 * @param path la ruta del archivo
	 */
	public void writeFile(String path) {

		try {

			File file = new File(path);
			//comprobamos si existe el archivo para crearlo o no
			if (!file.exists()) {
				if (file.createNewFile()) {
					RandomAccessFile raf = new RandomAccessFile(file, "rw");

					//hacemos un bucle for con tantas vueltas como longitud del array a escribir
					for (int i = 0; i < 3; i++) {

						//introducimos espacios en blanco
						codes[i] = String.format("%-6s", codes[i]);
						descricion[i] = String.format("%-20s", descricion[i]);


						//escribimos
						raf.writeChars(codes[i]);
						raf.writeChars(descricion[i]);
						raf.writeInt(prices[i]);

					}
					//cerramos el fichero
					raf.close();
				} else {
					System.out.println("No se pudo crear el archivo");
				}
			} else {
				RandomAccessFile raf = new RandomAccessFile(file, "rw");

				for (int i = 0; i < 3; i++) {

					codes[i] = String.format("%-6s", codes[i]);
					descricion[i] = String.format("%-20s", descricion[i]);

					raf.writeChars(codes[i]);
					raf.writeChars(descricion[i]);
					raf.writeInt(prices[i]);

				}
				raf.close();
			}

		} catch (IOException e) {
			System.out.println("No se pudo encontrar el fichero");
		}

	}

	/**
	 * metodo para leer el fichero
	 * @param path la ruta del fichero
	 */
	public void readFile(String path) {
	    File file = new File(path);

	    try {
	    	//comprobamos si existe o no el fichero y si es un fichero
	        if (file.exists() && file.isFile()) {
	            RandomAccessFile raf = new RandomAccessFile(file, "r");




	            //nos posicionamos en la segundo array con el metodo seek
	            raf.seek(56);

	            /**
	             * importante entender esto:
	             * con el seek() lo que hacemos es posicionarnos en un byte en concreto
	             * creamos un stringBuilder
	             * lo anterior lo hacemos ya que con readchar estamos leyendo caracteres y tenemos que hacer un bucle para introducirlos en un string
	             * el codigo es 6 y la descripcion es 20
	             * el numero no es necesario
	             * despues lo imprimimos
	             *
	             */
	            StringBuilder code = new StringBuilder();
	            for (int j = 0; j < 6; j++) {
	                code.append(raf.readChar());
	            }

	            StringBuilder description = new StringBuilder();
	            for (int j = 0; j < 20; j++) {
	                description.append(raf.readChar());
	            }

	            int price = raf.readInt();

	            System.out.println(code.toString().trim());
	            System.out.println(description.toString().trim());
	            System.out.println(price);

	            raf.close();
	        }
	    } catch (IOException e) {
	        System.out.println("No se encontró el fichero");
	    }
	}



}
