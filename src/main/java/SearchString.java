import java.util.Scanner;

public class SearchString {

    protected static String searchString;

    protected SearchString(){
        Scanner input = new Scanner(System.in);
        searchString = input.nextLine();
    }

}