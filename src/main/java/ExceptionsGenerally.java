public class ExceptionsGenerally {

    public static void main(String[] args) {
        String input;
        try{
            input = args[0];
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("More input strings  needed");
            return;
        }
        System.out.println("Input string :" + input);

    }

}
