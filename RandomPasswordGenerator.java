package Projects;

import java.util.Scanner;
import static java.lang.Math.random;

public class RandomPasswordGenerator {
    int randDigits;
    char [] randSpecialChar;
    char [] randUpCase;
    char [] randLowCase;
    char [] complex;
    int noOfPasswords;
    int lengthOfPassword;
    int complexityOfPassword;
    void instructions(){
        System.out.println("          --------------Random Password Generator--------------");
        System.out.println("_________________________________________________________________________________");
        System.out.print("NOTE: Password keys -> 1 for numeric password, 2 for uppercase alphabet password," +
                "\n\t  3 for lowercase alphabet password, 4 for special character password and" +
                "\n\t  5 for complex password. Press enter to continue: ");
    }
    void chooseRandomChar(){
        randDigits = (int) (random()*10);
        randUpCase = new char[] {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S',
                'T','U','V','W','X','Y','Z'};
        randLowCase = new char[] {'a','b','c','d','e','f','g','h','i','j','k', 'l','m','n','o','p','q','r','s',
                't','u','v','w','x','y','z'};
        randSpecialChar = new char[] {'!','@','#','$','%','&','*','^','~','?','_'};
        complex = new char[] {'0','1','2','3','4','5','6','7','8','9','!','@', '#','$','%','&','*','^','~','?',
                '_','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W',
                'X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u',
                'v','w','x','y','z'};
    }
    void generatePasswords(){
        switch (complexityOfPassword){
            case 1: //generate numeric password
                for (int i=1; i<=noOfPasswords; i++){
                    System.out.print("Password "+i+": ");
                    for (int j=1; j<=lengthOfPassword; j++){
                        System.out.print(randDigits);
                        chooseRandomChar();
                    }
                    System.out.println();
                }
                break;
            case 2: //generate uppercase alphabets password
                for (int i=1; i<=noOfPasswords; i++){
                    System.out.print("Password "+i+": ");
                    for (int j=1; j<=lengthOfPassword; j++){
                        System.out.print(randUpCase[(int) (random()*26)]);
                        chooseRandomChar();
                    }
                    System.out.println();
                }
                break;
            case 3: //generate lowercase alphabets password
                for (int i=1; i<=noOfPasswords; i++){
                    System.out.print("Password "+i+": ");
                    for (int j=1; j<=lengthOfPassword; j++){
                        System.out.print(randLowCase[(int) (random()*26)]);
                        chooseRandomChar();
                    }
                    System.out.println();
                }
                break;
            case 4: //generate special character password
                for (int i=1; i<=noOfPasswords; i++){
                    System.out.print("Password "+i+": ");
                    for (int j=1; j<=lengthOfPassword; j++){
                        System.out.print(randSpecialChar[(int) (random()*11)]);
                        chooseRandomChar();
                    }
                    System.out.println();
                }
                break;
            case 5: //generate complex password
                for (int i=1; i<=noOfPasswords; i++){
                    System.out.print("Password "+i+": ");
                    for (int j=1; j<=lengthOfPassword; j++){
                        System.out.print(complex[(int) (random()*63)]);
                        chooseRandomChar();
                    }
                    System.out.println();
                }
                break;
        }
    }
    void userInput(){
        instructions();
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("_________________________________________________________________________________");
        System.out.print("Number of random passwords do you want to generate: ");
        noOfPasswords = sc.nextInt();
        System.out.print("Length of password: ");
        lengthOfPassword = sc.nextInt();
        System.out.print("Complexity of password, enter key: ");
        do {
            complexityOfPassword = sc.nextInt();
        } while (!isValidUserInput());
        chooseRandomChar();
        generatePasswords();
        quit();
    }
    boolean isValidUserInput(){
        if (complexityOfPassword<1 || complexityOfPassword>5) {
            System.out.print("Invalid complexity, enter key again: ");
            return false;
        }
        else return true;
    }
    void quit(){
        System.out.println("_________________________________________________________________________________");
        System.out.println("          -------Thanks!!!-------");
    }
    public static void main(String[] args) {
        RandomPasswordGenerator rpg = new RandomPasswordGenerator();
        rpg.userInput();
    }
}
