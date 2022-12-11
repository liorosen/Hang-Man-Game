import java.io.File;
import java.util.Scanner;

public class TopicChosing {
    public static File ChoseTopic(int chosenNumber) {
        File file = new File("/C:/Users/lioro/Desktop/project/welcome.txt/");
        switch (chosenNumber) {
            case 1:
                file = new File("/C:/Users/lioro/Desktop/project/Celebrities.txt/");
                break;
            case 2:
                file = new File("/C:/Users/lioro/Desktop/project/Countries.txt/");
                break;
            case 3:
                file = new File("/C:/Users/lioro/Desktop/project/movies.txt/");
                break;
            case 4:
                file = new File("/C:/Users/lioro/Desktop/project/Musician and Artists.txt/");
                break;
            case 5:
                file = new File("/C:/Users/lioro/Desktop/project/TV Series.txt/");
                break;
        }
        return file;
    }


}
