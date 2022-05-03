public class StringHash{
    int size;
    int initialValue;
    int hashMultiplier;
    int relativePrime;

    String[] table;

    public StringHash(int size, int initialValue, int hashMultiplier, int relativePrime){
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
        int i = 0;
        int index = this.getIndex(data, 0);
        System.out.print("Searching " + "\"" + data + "\"");
        while(true){
            if(i >= size){
                System.out.println("FAILED");
                System.out.println("\n FALSE");
                return false;
            }
            if(table[index].equals("<EMPTY>")){
                System.out.println(" -> " + index);
                System.out.println("FAILED");
                System.out.println("FALSE");
                return false;
            }

            if(table[index].equals(data)){
                System.out.println(" -> " + index);
                System.out.println("TRUE");
                return true;
            }
            
            System.out.print(" -> " +index);
            index = getIndex(data, ++i);
        }
    }
    
    public boolean add(String data){
        int i = 0;
        int index = this.getIndex(data, 0);
        System.out.print("Adding " + "\"" + data + "\"");
        while(true){
            if(i >= size){
                System.out.println("FAILED");
                return false;
            }
            if(table[index].equals("<EMPTY>") || table[index].equals("<REMOVED>")){
                table[index] = data;
                System.out.println(" -> " + index);
                return true;
            }
            System.out.print(" -> " +index);
            index = getIndex(data, ++i);
        }
    }
    
    public boolean remove(String data){
        int i = 0;
        int index = this.getIndex(data, 0);
        System.out.print("Removing " + "\"" + data + "\"");
        while(true){
            if(i >= size){
                System.out.println("\n FALSE");
                return false;
            }
            if(table[index].equals("<EMPTY>") || table[index].equals("<REMOVED>")){
                System.out.println(" -> " + index);
                System.out.println("FALSE");
                return false;
            }

            if(table[index].equals(data)){
                table[index] = "<REMOVED>";
                System.out.println(" -> " + index);
                System.out.println("TRUE");
                return true;
            }
            
            System.out.print(" -> " +index);
            index = getIndex(data, ++i);
        }
    }
    
    public void displayTable(){
        for(int i = 0; i < size; i++){
            System.out.println(i + " : " + table[i]);
        }
        System.out.println("\n");
    }
    
    public void resize(){
        int newSize = this.size << 1;
        this.size = newSize;
        String newTable[] = new String[newSize];
        // System.out.println("NewTable size: " + newTable.length);
        for(int i = 0; i < newSize; i++){
            newTable[i] = "<EMPTY>";
        }
        for(String data: this.table){
            int i = 0;
            int index = this.getIndex(data, i);
            System.out.print("Rehashing " + "\"" + data + "\"");
            while(true){
                if(i >= newSize){
                    System.out.println("FAILED");
                    break;
                }
                if(newTable[index].equals("<EMPTY>") || newTable[index].equals("<REMOVED>")){
                    newTable[index] = data;
                    System.out.println(" -> " + index);
                    break;
                }
                System.out.print(" -> " +index);
                index = getIndex(data, ++i);
            }
        }
        this.table = newTable;
        // System.out.println("Updated table size: " + table.length);
    }

    private int getIndex(String string, int i){
        // System.out.println("--- " + string + " ---");
        int iVlaue = this.initialValue;
        for(char c: string.toCharArray()){
            int character = c;
            iVlaue = (iVlaue * hashMultiplier) + character;
            //System.out.println(initialValue);
        }

        int index = iVlaue % size;

        if(index < 0){
            index *= -1;
        }

        // System.out.println("Index: " + index);

        int index1 = i*(relativePrime - (index % relativePrime));
        index1 = (index + index1) % size;
        // System.out.println("Rehash: " + index1);
        return index1;
    }
}
