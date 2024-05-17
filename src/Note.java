import java.time.LocalDateTime;

public class Note {
    private String title;
    private String info;
    private LocalDateTime time;
    public Note(String title , String info){
        this.title = title;
        this.time = LocalDateTime.now();
        if (info.contains("#")){
            info = info.split("#")[0];
        }
        this.info = info;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public LocalDateTime getTime(){
        return time;
    }
}
