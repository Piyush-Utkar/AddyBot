package imp;

import net.dv8tion.jda.api.JDABuilder;

import java.io.File;
import java.util.Scanner;

public class Declarations {
    public static JDABuilder jdaBuilder;
    public static String myID;
    public static String guildID;
    public  static File file = new File("addys.txt");


    public static void getAllInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is The Info The Same? (Y/N)");
        String answer = scanner.nextLine().toLowerCase();
        if (answer.equals("y")){
            myID = "895221110889656320";
            guildID = "942082862885257246";
            jdaBuilder = JDABuilder.createDefault("OTQzMDUyMTM2MDI2MDgzNDE4.Ygtbvg.bqWqEeRT09Plbe8em-ZpGLudgm0");
        }else if (answer.equals("n")){
            System.out.println("What is your id?");
            myID = scanner.nextLine();
        System.out.println("What is bot's token?");
            jdaBuilder = JDABuilder.createDefault(scanner.nextLine());
            System.out.println("What is guild's id?");
            guildID = scanner.nextLine();
        }else {
            System.out.println("Wrong Input Try Again");
            getAllInfo();
        }
    }
}
