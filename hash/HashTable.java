package hash;

public class HashTable implements StringHash{
    int size;
    int initialValue;
    int hashMultiplier;
    int relativePrime;

    String[] table;

    public HashTable(int size, int initialValue, int hashMultiplier, int relativePrime){
        this.size = size;
        this.initialValue = initialValue;
        this.hashMultiplier = hashMultiplier;
        this.relativePrime = relativePrime;

        table = new String[size];

        for(int i = 0; i < size; i++){
            table[i] = "<EMPTY>";
        }
    }

    public boolean contains(String data){
        int index = getIndex(data);
        if(table[index].equals("<EMPTY>") || table[index].equals("<REMOVED>")){
            System.out.println("Searching " + "\"" + data +"\" -> " + index);
            System.out.println("FALSE");
            return false;
        }
        System.out.println("TRUE");
        return false;
    }
    
    public boolean add(String data){
        int index = this.getIndex(data);
        if(table[index].equals("<EMPTY>")){
            table[index] = data;
            System.out.println("Adding " + "\"" + data +"\" -> " + index);
            return true;
        }
        index = rehash(index, this.relativePrime);
        if(index < 0 && index > size-1){
            table[index] = data;
            return true;
        }
        return false;
    }
    
    public boolean remove(String data){
        int index = this.getIndex(data);
        if(table[index].equals(data)){
            table[index] = "<REMOVED>";
            System.out.println("Removing " + "\"" + data +"\" -> " + index);
            return true;
        }
        return false;
    }
    
    public void displayTable(){
        for(int i = 0; i < size; i++){
            System.out.println(i + " : " + table[i]);
        }
        System.out.println("\n");
    }
    
    public void resize(){
        this.size = this.size << 1;
        String newTable[] = new String[this.size];
        System.out.println("NewTable size: " + newTable.length);
        for(String eachData: this.table){
            int index = getIndex(eachData);
            newTable[index] = eachData;
        }
        this.table = newTable;
        System.out.println("Updated table size: " + table.length);
    }

    private int getIndex(String string){

        int stringHash = this.initialValue;
        int hashMultiplier = this.hashMultiplier;
        int prime = this.relativePrime;
        int N = this.size;

        for(char c: string.toCharArray()){
            int character = c;
            stringHash = (stringHash * hashMultiplier) + character;
        }

        int index = stringHash % N;

        System.out.println("**** INDEX ****");
        System.out.println(index);

        return index;
    }

    private int rehash(int hash1, int prime){
        int index = prime - (hash1 % prime);
        return index;
    }
}
