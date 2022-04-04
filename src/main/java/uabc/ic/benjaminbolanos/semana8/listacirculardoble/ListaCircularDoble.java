package uabc.ic.benjaminbolanos.semana8.listacirculardoble;

import java.util.Arrays;
import uabc.ic.benjaminbolanos.semana8.NodoDoble;

/**
 *
 * @author benjabolanos
 * @param <T>
 */
public class ListaCircularDoble<T> {
    private NodoDoble<T> inicio;
    private NodoDoble<T> fin;
    
    public ListaCircularDoble(){
        inicio = fin = null;
    }
    
    public void insertarInicio(T dato){
        NodoDoble<T> n = new NodoDoble(dato);
        if(inicio == null){
            inicio = fin = n;
            n.setSig(inicio);
            n.setAnt(inicio);
        } else {
            n.setSig(inicio);
            inicio.setAnt(n);
            inicio = n;
            fin.setSig(inicio);
            n.setAnt(fin);
        }
    }
    
    public void insertarFin(T dato){
        NodoDoble<T> n = new NodoDoble(dato);
        if(inicio == null){
            inicio = fin = n;
            n.setSig(inicio);
            n.setAnt(inicio);
        } else {
            n.setSig(inicio);
            inicio.setAnt(n);
            fin.setSig(n);
            n.setAnt(fin);
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
                inicio.setAnt(fin);
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
                NodoDoble r = fin.getAnt();
                r.setSig(inicio);
                inicio.setAnt(r);
                fin = r;
            }
        }
        return dato;
    }
    
    public String recorrer(){
        String rec = new String();
        if(inicio == null){
            rec = "Lista vacia";
        } else {
            NodoDoble<T> r = inicio;
            while(r != fin){
                rec += r.toString() + " ";
                r = r.getSig();
            }
            rec += r.toString();
        }
        return rec;
    }
    
    private String mostrarRecursivo(NodoDoble x){
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
            NodoDoble<T> r = inicio;
            int size = 1;
            while(r.getSig() != inicio){
                size++;
                r = r.getSig();
            }
            return size;
        }
    }
    
    public T eliminar(T x){
        int resultado = buscar(x);
        T dato = null;
        if( resultado == 0){
            dato = eliminarInicio();
        } else if(resultado == size() - 1){
            dato = eliminarFin();
        } else {
            NodoDoble<T> r = inicio;
            for(int i = 0; i < resultado; i++){
                r = r.getSig();
            }
            dato = r.getInfo();
            r.getAnt().setSig(r.getSig());
            r.getSig().setAnt(r.getAnt());
        }
        return dato;
    }
    
    public int buscar(T x){
        if(inicio != null){
            NodoDoble<T> r = inicio;
            int i = 0;
            while(r.getSig() != inicio){
                if(x.equals(r.getInfo())){
                    return i;
                }
                r = r.getSig();
                i++;
            }
            if(x == r.getInfo()){
                return i;
            }
        }
        return -1;
    }
    
    public NodoDoble<T> buscar(int i){
        if(i >= 0 && i < size()){
            NodoDoble<T> r = inicio;
            for(int j = 0; j < i; j++){
                r = r.getSig();
            }
            return r;
        }
        return null;
    }
    
    public T eliminarPosicion(int posicion){
        T dato = null;
        if(posicion >= 0 && posicion < size()){
            if(posicion == 0){
                dato = eliminarInicio();
            } else if(posicion == size()-1){
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
        for (T t : arr) {
            r.setInfo(t);
            r = r.getSig();
        }
    }
    
    public T[] toArray(){
        T[] arr =(T[]) new Object[size()];
        NodoDoble<T> r = inicio;
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
