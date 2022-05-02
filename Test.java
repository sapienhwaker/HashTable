public class Test {
    public static void main(String[] args){
        String sampleInputs[] = {"Hello", "World", "fruitcake", "Chevy", "infinity"};
        int stringHash = 5381;
        int hashMultiplier = 33;
        int prime = 7;
        int N = 10;

        for(String string: sampleInputs){
            getIndex(string, stringHash, hashMultiplier, prime, N);
        }
    }

    public static void getIndex(String string, int stringHash, int hashMultiplier, int prime, int N){
        System.out.println("--- " + string + " ---");
        for(char c: string.toCharArray()){
            int character = c;
            stringHash = (stringHash * hashMultiplier) + character;
            //System.out.println(stringHash);
        }

        long index = stringHash % N;

        if(index < 0){
            index *= -1;
        }

        System.out.println("Index: " + index);

        //This for loop will take care of double hashing
        //It will produce next 4 possible indices to put the string in the hashTable
        //The earliest index where <EMPTY> or <REMOVED> is present will be used
        for(int i = 1; i < 5; i++){
            long index1 = i*(prime - (index % prime));
            index1 = (index + index1) % N;
            System.out.println("Rehash: " + index1);
        }
    }
}
