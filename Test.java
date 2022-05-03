public class Test {
    public static void main(String[] args){
        String sampleInputs[] = {"Hello", "World", "fruitcake", "Chevy", "infinity"};
        int initialValue = 5381;
        int hashMultiplier = 33;
        int prime = 7;
        int size = 5;

        for(String string: sampleInputs){
            getIndex(string, initialValue, hashMultiplier, prime, size);
        }
    }

    public static void getIndex(String string, int initialValue, int hashMultiplier, int prime, int size){
        System.out.println("--- " + string + " ---");
        for(char c: string.toCharArray()){
            int character = c;
            initialValue = (initialValue * hashMultiplier) + character;
            //System.out.println(initialValue);
        }

        int index = initialValue % size;

        if(index < 0){
            index *= -1;
        }

        System.out.println("Index: " + index);

        //This for loop will take care of double hashing
        //It will produce next 4 possible indices to put the string in the hashTable
        //The earliest index where <EMPTY> or <REMOVED> is present will be used
        for(int i = 1; i < size; i++){
            int index1 = i*(prime - (index % prime));
            index1 = (index + index1) % size;
            System.out.println("Rehash: " + index1);
        }
    }
}
