package uabc.ic.benjaminbolanos.semana8.listacircularsimple;

/**
 *
 * @author bbola
 */
public class ListaCircularTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaCircular<String> lc = new ListaCircular();
        lc.insertarFin("Diana");
        lc.insertarFin("Vero");
        lc.insertarInicio("Saul");
        lc.insertarFin("Asiatico");
        lc.insertarInicio("Pezas");
        System.out.println("Lista inicial: " + lc);
        lc.insertarEnPosicion("Ja", 2);
        System.out.println("Lista al insertar 'Ja' en la posicion 2: " + lc);
        lc.ordenarLista();
        System.out.println("Lista ordenada: " + lc);
        System.out.println("Posicion de 'Ja': " + lc.buscar("Ja"));
        System.out.println("Elemento en la posicion 3: " + lc.buscar(3));
        lc.eliminar("Vero");
        System.out.println("Lista al eliminar 'Vero': " + lc);
        lc.eliminarPosicion(0);
        System.out.println("Lista al eliminar el elemento en la posicion 0: " + lc);
    
    }
    
}
