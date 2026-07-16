public class StrongBox<E> {
    private E data;
    
    public void put(E data) {
        this.data = data;
    }
    
    public E get() {
        return data;
    }
}