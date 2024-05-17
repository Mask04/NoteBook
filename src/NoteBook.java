import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

public class NoteBook {
    private HashMap<String , Note> notes;
    public NoteBook(){
        notes = new HashMap<>();
    }
    public void Add(){
        System.out.println("please choose title for note");
        Scanner scan = new Scanner(System.in);
        String title = scan.nextLine();

        if (titleExist(title)){
            System.out.println("title is already exist");
        }
        else{
            System.out.println("ok feel free to write. enter '#' to finish");
            String info = "";
            do {
                String tmp = scan.nextLine();
                info = info  + "\n" +tmp ;
            }while (!info.contains("#"));
            Note newNote = new Note(title , info );
            notes.put(title , newNote);
            System.out.println("note is added successfully");
        }
    }
    public void remove() throws InvalidNumberException {
        showNotes();
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        int i = 1;
        for (Note note : notes.values()){
            if (option == i){
                notes.remove(note.getTitle());
                System.out.println("note remove successfully");
                return;
            } else if (option > notes.size()) {
                throw new InvalidNumberException();
            } else {
                if (i > notes.size()){
                    throw  new InvalidNumberException();
                }
            }
                i++;
        }
    }
    public void notes() throws InvalidNumberException {
        showNotes();
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        int i = 1;
        for (Note note : notes.values()){
            if (option == i){
                System.out.println("................." + note.getTitle() + ".................");
                System.out.println(notes.get(note.getTitle()).getInfo());
            }
            else if (option > notes.size()) {
                throw new InvalidNumberException();
            }
            i++;
        }

    }
    public void export() throws InvalidNumberException {
        showNotes();
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        int i = 1;
        for (Note note : notes.values()){
            if (option == i){
                try {
                    FileWriter writer = new FileWriter("C:\\Users\\ASUS\\OneDrive\\Desktop\\FILE\\ApWorkShop8.txt");
                    writer.write("..........." + note.getTitle() +".............." +"\n");
                    writer.write(note.getInfo());
                    writer.close();
                }catch (IOException e){
                    System.out.println("path not found");
                }
            }else if (option > notes.size()) {
                throw new InvalidNumberException();
            }
            else {
                if (i > notes.size()){
                    throw  new InvalidNumberException();
                }
            }
            i++;
        }

    }
    public boolean titleExist(String t){
        for (String title : notes.keySet()){
            if(title.equals(t))
                return true;
        }
        return false;
    }
    private void showNotes(){
        int i = 1;
        for (Note note : notes.values()){
            System.out.println(i +"-" + note.getTitle() +"    " + note.getTime()+ "\n");
            i++;
        }
    }



}
