package uabc.ic.benjaminbolanos.semana8.listadoble;

import java.util.Arrays;
import uabc.ic.benjaminbolanos.semana8.NodoDoble;

/**
 *
 * @author benjabolanos
 * @param <T>
 */
public class ListaDoble<T> {
    private NodoDoble<T> inicio;
    
    public ListaDoble(){
        inicio = null;
    }
    
    public void insertarInicio(T dato){
        NodoDoble<T> n = new NodoDoble(dato, null, inicio);
        if(inicio == null){
            inicio.setAnt(n);
        }
        inicio = n;
    }
    
    public void insertarFin(T dato){
        NodoDoble<T> n = new NodoDoble(dato, null, null);
        if(inicio == null){
            n.setAnt(inicio);
            inicio = n;
        } else {
            NodoDoble r = inicio;
            while(r.getSig() != null){
                r = r.getSig();
            }
            r.setSig(n);
            n.setAnt(r);
        }
    }
    
    public T eliminarInicio(){
        T dato;
        if(inicio == null){
            System.out.println("Lista vacia");
            dato = null;
        } else{
            dato = inicio.getInfo();
            if(inicio.getSig() == null){
                inicio = null;
            } else {
                inicio = inicio.getSig();
                inicio.setAnt(null);
            }
        }
        return dato;
    }
    
    public T eliminarFin(){
        T dato;
        if(inicio == null){
            System.out.println("Lista Vacia");
            dato = null;
        } else {
            if(inicio.getSig() == null){
                dato = inicio.getInfo();
                inicio = null;
            } else {
                NodoDoble<T> r = inicio;
                while(r.getSig() != null){
                    r = r.getSig();
                }
                dato = r.getInfo();
                r.getAnt().setSig(null);
            }
        }
        return dato;
    }
    
    public String recorrer(){
        String info = new String();
        if(inicio == null){
            info = "Lista Vacia.";
        } else {
            NodoDoble<T> r = inicio;
            while(r != null){
                info += r.toString() + " ";
                r = r.getSig();
            }
        }
        return info;
    }
    
    private String mostrarRecursivo(NodoDoble<T> x){
        if(inicio == null){
            return "Lista vacia";
        } else if(x.getSig() != null){
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
        NodoDoble r = inicio;
        while(r != null){
            size++;
            r = r.getSig();
        }
        return size;
    }
    
    public int buscar(T x){
        if(inicio != null){
            NodoDoble<T> r = inicio;
            int i = 0;
            while(r != null){
                if(r.getInfo().equals(x)){
                    return i;
                }
                i++;
                r = r.getSig();
            }
        }
        System.out.println("a");
        return -1;
    }
    
    public NodoDoble<T> buscar(int i){
        if(i >= 0 && i < size()){
            NodoDoble<T> r = inicio;
            for(int j = 0; j < i; j++)
                r = r.getSig();
            return r;
        }
        return null;
    }
    
    public T eliminar(T x){
        int resultado = buscar(x);
        return eliminarPosicion(resultado);
    }
    
    public T eliminarPosicion(int posicion){
        T dato = null;
        if(posicion >= 0 && posicion < size()){
            if(posicion == 0){
                dato = eliminarInicio();
            } else if(posicion == size() - 1){
                dato = eliminarFin();
            } else {
                NodoDoble<T> r = inicio;
                for(int i = 0; i < posicion; i++){
                    r = r.getSig();
                }
                dato = r.getInfo();
                r.getAnt().setSig(r.getSig());
                r.getSig().setAnt(r.getAnt());
            }
        }
        return dato;
    }
    
    public void ordenarLista(){
        T[] arr = toArray();
        Arrays.sort(arr);
        NodoDoble<T> r = inicio;
        for(T t : arr){
            r.setInfo(t);
            r = r.getSig();
        }
    }
    
    public T[] toArray(){
        T[] arr = (T[]) new Object[size()];
        NodoDoble<T> r = inicio;
        int i = 0;
        while(r!=null){
            arr[i] = r.getInfo();
            r = r.getSig();
            i++;
        }
        return arr;
    }
    
    public Boolean insertarEnPosicion(T dato, int posicion){
        if(posicion >= 0 && posicion < size()){
            if(posicion == 0){
                insertarInicio(dato);
            } else if(posicion == size()-1){
                insertarFin(dato);
            } else {
                NodoDoble<T> n = new NodoDoble(dato);
                NodoDoble<T> s = buscar(posicion);
                NodoDoble<T> a = buscar(posicion-1);
                s.setAnt(n);
                a.setSig(n);
                n.setAnt(a);
                n.setSig(s);
            }
            return true;
        }
        return false;
    }
    
}
