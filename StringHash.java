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
        System.out.println("Adding " + "\"" + data + "\" -> ");
        if(table[index].equals("<EMPTY>") || table[index].equals("<REMOVED>")){
            table[index] = data;
            System.out.print(index);
            return true;
        }

        int i = 1;
        while(i < size){
            index = hasTwo(index, i++);
            System.out.print(" -> " + index);
            if(table[index].equals("<EMPTY>") || table[index].equals("<REMOVED>")){
                table[index] = data;
                //System.out.println("Adding " + "\"" + data +"\" -> " + index);
                return true;
            }
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
        int stringHash = initialValue;
        for(char c: string.toCharArray()){
            int character = c;
            stringHash = initialValue;
            stringHash = (stringHash * hashMultiplier) + character;
            System.out.println(stringHash);
        }

        int index = stringHash % size;

        if(index < 0){
            index *= -1;
        }

        System.out.println("**** INDEX ****");
        System.out.println(index);
        return index;
    }

    private int hasTwo(int index, int i){
        int index1 = i*(relativePrime - (index % relativePrime));
        index1 = (index + index1) % size;
        System.out.println("**** SECOND INDEX ****");
        System.out.println(index1);
        return index1;
    }
}
