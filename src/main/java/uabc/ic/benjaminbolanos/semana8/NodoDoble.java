package uabc.ic.benjaminbolanos.semana8;

/**
 *
 * @author benjabolanos
 * @param <T>
 */
public class NodoDoble<T> {
    private T info;
    private NodoDoble sig;
    private NodoDoble ant;
    
    public NodoDoble(T info, NodoDoble ant, NodoDoble sig){
        this.info = info;
        this.sig = sig;
        this.ant = ant;
    }
    
    public NodoDoble(T info){
        this.info = info;
        sig = null;
        ant = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NodoDoble getSig() {
        return sig;
    }

    public void setSig(NodoDoble sig) {
        this.sig = sig;
    }

    public NodoDoble getAnt() {
        return ant;
    }

    public void setAnt(NodoDoble ant) {
        this.ant = ant;
    }
    
    @Override
    public String toString(){
        return info.toString();
    }
}
