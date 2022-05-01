public class Test {
    public static void main(String[] args){
        String string = "World";
        long stringHash = 5381;
        int hashMultiplier1 = 33;
        int prime = 7;
        int N = 5;

        for(char c: string.toCharArray()){
            int character = c;
            stringHash = (stringHash * hashMultiplier1) + character;
        }

        long index = stringHash % N;
        System.out.println("**** FIRST INDEX ****");
        System.out.println(index);

        index = prime - (index % prime);

        System.out.println("**** SECOND INDEX ****");
        System.out.println(index);
    }
}
