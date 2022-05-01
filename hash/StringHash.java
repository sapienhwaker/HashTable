package hash;

public interface StringHash {
    
    public boolean contains(String data);
    public boolean add(String data);
    public boolean remove(String data);
    public void displayTable();
    void resize();
}
