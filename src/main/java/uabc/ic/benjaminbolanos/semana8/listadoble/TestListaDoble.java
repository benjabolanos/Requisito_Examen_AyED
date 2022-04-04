package uabc.ic.benjaminbolanos.semana8.listadoble;

/**
 *
 * @author bbola
 */
public class TestListaDoble {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaDoble<String> ld = new ListaDoble();
        ld.insertarFin("Diana");
        ld.insertarFin("Vero");
        ld.insertarInicio("Saul");
        ld.insertarFin("Asiatico");
        ld.insertarInicio("Pezas");
        System.out.println("Lista inicial: " + ld);
        ld.insertarEnPosicion("Ja", 2);
        System.out.println("Lista al insertar 'Ja' en la posicion 2: " + ld);
        ld.ordenarLista();
        System.out.println("Lista ordenada: " + ld);
        System.out.println("Posicion de 'Ja': " + ld.buscar("Ja"));
        System.out.println("Elemento en la posicion 3: " + ld.buscar(3));
        System.out.println(ld.eliminar("Vero"));
        System.out.println("Lista al eliminar 'Vero': " + ld);
        ld.eliminarPosicion(0);
        System.out.println("Lista al eliminar el elemento en la posicion 0: " + ld);
    
    }
    
}
