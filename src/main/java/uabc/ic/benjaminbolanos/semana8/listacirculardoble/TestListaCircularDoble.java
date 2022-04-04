package uabc.ic.benjaminbolanos.semana8.listacirculardoble;

/**
 *
 * @author bbola
 */
public class TestListaCircularDoble {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaCircularDoble<String> lcd = new ListaCircularDoble();
        lcd.insertarFin("Diana");
        lcd.insertarFin("Vero");
        lcd.insertarInicio("Saul");
        lcd.insertarFin("Asiatico");
        lcd.insertarInicio("Pezas");
        System.out.println("Lista inicial: " + lcd);
        lcd.insertarEnPosicion("Ja", 2);
        System.out.println("Lista al insertar 'Ja' en la posicion 2: " + lcd);
        lcd.ordenarLista();
        System.out.println("Lista ordenada: " + lcd);
        System.out.println("Posicion de 'Ja': " + lcd.buscar("Ja"));
        System.out.println("Elemento en la posicion 3: " + lcd.buscar(3));
        lcd.eliminar("Vero");
        System.out.println("Lista al eliminar 'Vero': " + lcd);
        lcd.eliminarPosicion(0);
        System.out.println("Lista al eliminar el elemento en la posicion 0: " + lcd);
    }
    
}
