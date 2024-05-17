import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    NoteBook myNoteBook = new NoteBook();

    public void showMenu(){
        mainMenu();
        Scanner scan = new Scanner(System.in);
        System.out.println("if you want to close the program enter 0");
        int option = 2;
        while(option != 0) {
            option = scan.nextInt();
            try {
                if (option == 1) {
                    myNoteBook.Add();
                }
                else if (option == 2) {
                    myNoteBook.remove();
                }
                else if (option == 3) {
                    myNoteBook.notes();
                }
                else if (option == 4) {
                    myNoteBook.export();
                } else if (option == 0) {
                    return;
                } else
                    throw new InvalidNumberException();
            } catch (InvalidNumberException e) {
                System.out.println(e.getMessage());
            }
            mainMenu();
        }

    }
    public void mainMenu(){
        System.out.println("..............................");
        System.out.println("1-Add");
        System.out.println("2-Remove");
        System.out.println("3-Notes");
        System.out.println("4-Export");
        System.out.println("..............................");
        System.out.println();
        System.out.println("please choose an option");
        System.out.println();
    }

}

