public class StrongBox<E> {
    private E data;
    private KeyType keyType;
    private long cnt;

    public StrongBox(KeyType keyType) {
        this.keyType = keyType;
    }
    
    public void put(E data) {
        this.data = data;
    }
    
    public E get() {
        cnt++;

        switch (keyType) {
            // Arrow構文でbreak省略可能
            case PADLOCK -> {
                if (cnt < 1024) {
                    return null;
                }
            } 
            case BUTTON -> {
                if (cnt < 10000) {
                    return null;
                }
            }
            case DIAL -> {
                if (cnt < 30000) {
                    return null;
                }
            }
            case FINGER -> {
                if (cnt < 1000000L) {
                    return null;
                }
            }
        }

        cnt = 0;
        return data;
    }
}