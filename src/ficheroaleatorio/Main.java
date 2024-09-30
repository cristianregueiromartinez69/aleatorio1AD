
package ficheroaleatorio;



import javax.swing.JOptionPane;

/**
 * clase main donde ejecutamos el programa
 * @author cristian
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) {
		//instanciamos el objeto
		FicheroAleatorio fa = new FicheroAleatorio();


		//introducimos una ruta y llamamos a los metodos
		String ruta = JOptionPane.showInputDialog("Introduce la ruta del archivo para introducir los datos: ");

		fa.writeFile(ruta);
		fa.readFile(ruta);

	}
    
}
