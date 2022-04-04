package uabc.ic.benjaminbolanos.semana8.listasimple;

/**
 *
 * @author bbola
 */
public class TestListaSimple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaSimple<String> ls = new ListaSimple();
        ls.insertarFin("Diana");
        ls.insertarFin("Vero");
        ls.insertarInicio("Saul");
        ls.insertarFin("Asiatico");
        ls.insertarInicio("Pezas");
        System.out.println("Lista inicial: " + ls);
        ls.insertarEnPosicion("Ja", 2);
        System.out.println("Lista al insertar 'Ja' en la posicion 2: " + ls);
        ls.ordenarLista();
        System.out.println("Lista ordenada: " + ls);
        System.out.println("Posicion de 'Ja': " + ls.buscar("Ja"));
        System.out.println("Elemento en la posicion 3: " + ls.buscar(3));
        ls.eliminar("Vero");
        System.out.println("Lista al eliminar 'Vero': " + ls);
        ls.eliminarPosicion(0);
        System.out.println("Lista al eliminar el elemento en la posicion 0: " + ls);
    
    }
    
}
