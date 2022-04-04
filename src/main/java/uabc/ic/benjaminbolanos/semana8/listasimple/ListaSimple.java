package uabc.ic.benjaminbolanos.semana8.listasimple;

import java.util.Arrays;
import uabc.ic.benjaminbolanos.semana8.Nodo;

/**
 *
 * @author benjabolanos
 * @param <T>
 */
public class ListaSimple<T> {
    private Nodo<T> inicio;
    
    public ListaSimple(){
        inicio = null;
    }
    
    public void insertarInicio(T dato){
        Nodo<T> n = new Nodo(dato, inicio);
        inicio = n;
    }
    
    public void insertarFin(T dato){
        Nodo<T> n = new Nodo(dato, null);
        if(inicio == null){
            n.setSig(inicio);
            inicio = n;
        } else {
            Nodo<T> r = inicio;
            while(r.getSig() != null){
                r = r.getSig();
            }
            r.setSig(n);
            n.setSig(null);
        }
    }
    
    public T eliminarInicio(){
        T dato;
        if(inicio == null){
            dato = null;
        } else {
            dato = inicio.getInfo();
            inicio = inicio.getSig();
        }
        return dato;
    }
    
    public T eliminarFin(){
        T dato;
        if(inicio == null){
            dato = null;
        } else {
            if(inicio.getSig() == null){
                dato = inicio.getInfo();
                inicio = null;
            } else {
                Nodo<T> r = inicio, a = r;
                while(r.getSig() != null){
                    a = r;
                    r = r.getSig();
                }
                dato = r.getInfo();
                a.setSig(null);
            }
        }
        return dato;
    }
    
    public String recorrer(){
        String cadena = new String();
        if(inicio != null){
            Nodo<T> r = inicio;
            while(r != null){
                cadena += r.toString() + " ";
                r = r.getSig();
            }
        } else {
            cadena = "Lista Vacia";
        }
        return cadena;
    }
    
    private String mostrarRecursivo(Nodo x){
        if(inicio == null){
            return "Lista vacia";
        } else if(x.getSig()!= null){
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
        int size = 0;
        Nodo r = inicio;
        while(r!=null){
            size++;
            r = r.getSig();
        }
        return size;
    }
    
    public Nodo<T> buscar(int i){
        if(i < 0 || i >= size()){
            return null;
        } else {
            Nodo<T> r = inicio;
            for(int j = 0; j < i; j++){
                r = r.getSig();
            }
            return r;
        }
    }
    
    public int buscar(T x){
        if(inicio != null){
            Nodo<T> r = inicio;
            int i = 0;
            while(r!= null){
                if(r.getInfo().equals(x)){
                    return i;
                }
                i++;
                r = r.getSig();
            }
        }
        return -1;
    }
    
    public T eliminarPosicion(int posicion){
        T dato = null;
        if(posicion >= 0 && posicion < size()){
            if(posicion == 0){
                dato = eliminarInicio();
            } else if(posicion == size()-1){
                dato = eliminarFin();
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
        int i = 0;
        while(r!=null){
            arr[i] = r.getInfo();
            r = r.getSig();
            i++;
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
