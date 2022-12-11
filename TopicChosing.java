import java.io.File;
import java.util.Scanner;

public class TopicChosing {
    public static File ChoseTopic(int chosenNumber) {
        File file = new File("/C:/Users/lioro/IdeaProjects/HangMan/src/DataBases/welcome.txt/");
        switch (chosenNumber) {
            case 1:
                file = new File("/C:/Users/lioro/IdeaProjects/HangMan/src/DataBases/Celebrities.txt/");
                break;
            case 2:
                file = new File("/C:/Users/lioro/IdeaProjects/HangMan/src/DataBases/Countries.txt/");
                break;
            case 3:
                file = new File("/C:/Users/lioro/IdeaProjects/HangMan/src/DataBases/movies.txt/");
                break;
            case 4:
                file = new File("/C:/Users/lioro/IdeaProjects/HangMan/src/DataBases/Musician and Artists.txt/");
                break;
            case 5:
                file = new File("/C:/Users/lioro/IdeaProjects/HangMan/src/DataBases/TV Series.txt/");
                break;
        }
        return file;
    }


}
