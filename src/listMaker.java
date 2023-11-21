import java.util.Scanner;
import java.util.ArrayList;

public class listMaker {
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final String menu = "A - Add D - Delete P - Print Q - Quit: ";
        boolean done = false;

        do {
            displayList();
            System.out.println();
            String command = safeInput.getRegExString(scanner, menu, "[AaDdPpQq]");
            command = command.toUpperCase();

            switch(command)
            {
                case "A":
                    String item = safeInput.getNonZeroLengthString(scanner, "Add an item to the list: ");
                    list.add(item);
                    // prompt user for list item
                    // make sure not an empty string (get nonzero)
                    // add to the list
                    break;
                case "D":
                    int deleteItem = safeInput.getInt(scanner, "Select an item to delete: ");
                    list.remove(deleteItem - 1);
                    // prompt user for number of item to delete
                    // translate number to an index by subtracting 1
                    // remove item from list
                    break;
                case "P":
                    break;
                case "Q":
                    done = safeInput.getYNConfirm(scanner, "Are you sure?");
                    break;
            }
        } while(!done);
    }
    private static void displayList()
    {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        if(!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%2d%3s", i + 1, list.get(i));
            }
        }
        else
            System.out.println("+++                List is empty             +++");
        System.out.print("\n+++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}