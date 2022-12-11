import java.io.FileNotFoundException;
import java.util.*;

public class HangMan {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Please Choose The Topic By Choosing Number:");
        System.out.println("1 - Celebrities" + "\n" + "2 - Countries" + "\n" + "3 - Movies" + "\n" + "4 - Musician and Artists" + "\n" + "5 - TV Series");
        Scanner sc = new Scanner(System.in);
        int chosenNumber = sc.nextInt();
        chosenNumber = CheckInput(chosenNumber);
        String GuessingLetter = sc.nextLine();
        Scanner scanner = new Scanner(TopicChosing.ChoseTopic(chosenNumber));
        ArrayList<String> allFileWords = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            allFileWords.add(scanner.nextLine());
        }
        //Choosing random word from the file
        Random ra = new Random();
        String word = allFileWords.get(ra.nextInt(allFileWords.size())).toLowerCase();
        System.out.println();
        //Creating the lists of guesses
        ArrayList<Character> PlayerGuess = new ArrayList<Character>();
        ArrayList<Character> UsedLetters = new ArrayList<Character>();
        PrintWord(word, PlayerGuess);
        int mistakes = 0;
        while (true) {
            if(!GetPlayerGuess(sc, word, PlayerGuess , UsedLetters)){
                CountingMistakes(mistakes , word);
                mistakes ++;
                if(mistakes >= 8){
                    break;
                }
            }
            if(PrintWord(word ,PlayerGuess)){
                break;
            }
        }
        if(mistakes < 8) {
            System.out.println(word + " Is The Word , Congratulation You Won The Game!");
        }
    }

    private static boolean GetPlayerGuess(Scanner sc, String word, ArrayList<Character> PlayerGuess, ArrayList<Character> UsedLetters) {
        System.out.println("Please enter a  character between a-z");
        Character chosenLetter = sc.nextLine().charAt(0);
        if(chosenLetter < 'a' || chosenLetter > 'z'){
            System.out.println("Please enter a character between a-z");
        }
        UsedLetters.add(chosenLetter);
        PrintUsedLetters(chosenLetter,UsedLetters);
        System.out.println();
        PlayerGuess.add(chosenLetter);
        return word.contains(String.valueOf(chosenLetter));
    }

    private static boolean PrintWord(String word, ArrayList<Character> PlayerGuess) {
        int counter = 0;
        for(int i = 0; i < word.length() ; i++){
            if(PlayerGuess.contains(word.charAt(i))){
                System.out.print(word.charAt(i));
                counter++;
            }
            else {
                if( word.charAt(i) ==  '\0'){
                    System.out.print('\0');
                }
                else{
                    System.out.print("-");
                }
            }
        }
        System.out.println();
        return word.length() == counter;
    }

    public static int CheckInput( int chosenNumber) {
        Scanner sc = new Scanner(System.in);
        while(chosenNumber < 1 || chosenNumber > 5) {
            System.out.println(chosenNumber + " Invalid input!");
            System.out.println(" Please Choose Number Between 1 - 5 ");
            chosenNumber = sc.nextInt();

        }
        return chosenNumber;
    }

//    public static Character CharactersLettersChoosing(Scanner sc) {
//        System.out.println("Please enter a  character between a-z");
//        String chosenLetter = sc.nextLine().toLowerCase();
//        boolean ans = true;
//        while(ans){
//            if(chosenLetter.charAt(0) - '0' > 97 || chosenLetter.charAt(0) - '0' < 122) {
//                ans = false;
//            }
//            System.out.println("Please enter a character between a-z");
//        }
//       return chosenLetter.charAt(0);
//    }

    public static boolean CountingMistakes(int mistakes , String word){
        System.out.println();
        System.out.print("\r"  + "|");
        if( mistakes >= 0) {
            System.out.println("---------");
            if (mistakes >= 1) {
                System.out.println("         |");
                System.out.println("         |");
                if (mistakes >= 2) {
                    System.out.print("       \\ ");
                    if (mistakes >= 3) {
                        System.out.print("O");
                        if (mistakes >= 4) {
                            System.out.println(" /");
                            if (mistakes >= 5) {
                                System.out.println("         |");
                                if (mistakes >= 6) {
                                    System.out.print("        /");
                                    if (mistakes >= 7) {
                                        System.out.println(" \\");
                                        System.out.println(" The Word Was " + word + " You Lost.");
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println();
        return true;
    }

    public static void PrintUsedLetters(Character letter,ArrayList<Character> UsedLetters){
        for(int i = 0 ; i < UsedLetters.size() ; i++){
            System.out.print(UsedLetters.get(i) + ",");
        }

    }
}
