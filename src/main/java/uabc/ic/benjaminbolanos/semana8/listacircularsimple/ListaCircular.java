package uabc.ic.benjaminbolanos.semana8.listacircularsimple;

import java.util.Arrays;
import uabc.ic.benjaminbolanos.semana8.Nodo;

/**
 *
 * @author benjabolanos
 */
public class ListaCircular<T> {
    private Nodo<T> inicio;
    private Nodo<T> fin;
    
    public void insertarInicio(T dato){
        Nodo<T> n = new Nodo(dato, null);
        
        if(inicio == null){
            inicio = fin = n;
        } else {
            n.setSig(inicio);
            inicio = n;
            fin.setSig(inicio);
        }
    }
    
    public void insertarFin(T dato){
        Nodo<T> n = new Nodo(dato, null);
        if(inicio == null){
            inicio = fin = n;
            n.setSig(inicio);
        } else {
            n.setSig(inicio);
            fin.setSig(n);
            fin = n;
        }
    }
    
    public T eliminarInicio(){
        T dato = null;
        if(inicio == null){
            System.out.println("Lista vacia");
        } else {
            dato = inicio.getInfo();
            if(inicio == fin){
                inicio = fin = null;
            } else {
                fin.setSig(inicio.getSig());
                inicio = inicio.getSig();
            }
        }
        return dato;
    }
    
    public T eliminarFin(){
        T dato = null;
        if(inicio == null){
            System.out.println("Lista vacia");
        } else {
            dato = fin.getInfo();
            if(inicio == fin){
                inicio = fin = null;
            } else {
                Nodo r = inicio;
                while(r.getSig() != fin){
                    r = r.getSig();
                }
                fin = r;
                fin.setSig(inicio);
            }
        }
        return dato;
    }
    
    public String recorrer(){
        String rec = new String();
        Nodo<T> r = inicio;
        while(r!=fin){
            rec += r.getInfo().toString();
            r = r.getSig();
        }
        rec += r.getInfo().toString();
        return rec;
    }
    
    private String mostrarRecursivo(Nodo<T> x){
        if(inicio == null){
            return "Lista vacia";
        } else if(x.getSig() != inicio){
            return x.toString() + " " + mostrarRecursivo(x.getSig());
        } else {
            return x.toString();
        }
    }
    
    @Override
    public String toString(){
        return mostrarRecursivo(inicio);
    }
    
    public int size(){
        if(inicio == null){
            return 0;
        } else {
            int size = 1;
            Nodo r = inicio;
            while(r.getSig() != inicio){
                size++;
                r = r.getSig();
            }
            return size;
        }
    }
    
    public int buscar(T x){
        if(inicio != null){
            Nodo<T> r = inicio;
            int i = 0;
            while(r.getSig() != inicio){
                if(r.getInfo().equals(x))
                    return i;
                i++;
                r = r.getSig();
            }
            if(x == r.getInfo()){
                return i;
            }
        }
        return -1;
    }
    
    public Nodo<T> buscar(int i){
        if(i >= 0 && i < size()){
            Nodo<T> r = inicio;
            for(int j = 0; j < i; j++)
                r = r.getSig();
            return r;
        }
        return null;
    }
    
    public T eliminarPosicion(int posicion){
        T dato = null;
        if(posicion >= 0 && posicion < size()){
            if(posicion == 0){
                eliminarInicio();
            } else if(posicion == size()-1){
                eliminarFin();
            } else {
                Nodo<T> r = inicio, a = r;
                for(int i = 0; i < posicion; i++){
                    a = r;
                    r = r.getSig();
                }
                dato = r.getInfo();
                a.setSig(r.getSig());
            }
        }
        return dato;
    }
    
    public T eliminar(T x){
        int resultado = buscar(x);
        return eliminarPosicion(resultado);
    }
    
    public void ordenarLista(){
        T[] arr = toArray();
        Arrays.sort(arr);
        Nodo<T> r = inicio;
        for(T t : arr){
            r.setInfo(t);
            r = r.getSig();
        }
    }
    
    public T[] toArray(){
        T[] arr = (T[]) new Object[size()];
        Nodo<T> r = inicio;
        for(int i = 0; i < size(); i++){
            arr[i] = r.getInfo();
            r = r.getSig();
        }
        return arr;
    }
    
    public boolean insertarEnPosicion(T dato, int posicion){
        if(posicion >= 0 && posicion < size()){
            if(posicion == 0){
                insertarInicio(dato);
            } else if(posicion == size()-1){
                insertarFin(dato);
            } else {
                Nodo<T> n = new Nodo(dato);
                Nodo<T> s = buscar(posicion);
                Nodo<T> a = buscar(posicion - 1);
                a.setSig(n);
                n.setSig(s);
            }
            return true;
        }
        return false;
    }
}
