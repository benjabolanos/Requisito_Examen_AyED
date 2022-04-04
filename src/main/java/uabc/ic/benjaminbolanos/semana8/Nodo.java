package uabc.ic.benjaminbolanos.semana8;

/**
 *
 * @author benjabolanos
 * @param <T>
 */
public class Nodo<T> {
    private T info;
    private Nodo<T> sig;
    
    public Nodo(T info, Nodo<T> sig){
        this.info = info;
        this.sig = sig;
    }
    
    public Nodo(T info){
        this.info = info;
        sig = null;
    }
    
    public Nodo(){
        info = null;
        sig = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo<T> getSig() {
        return sig;
    }

    public void setSig(Nodo<T> sig) {
        this.sig = sig;
    }
    
    @Override
    public String toString(){
        return info.toString();
    }
}
