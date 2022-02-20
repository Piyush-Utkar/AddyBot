package imp;
import commands.AddAddress;
import commands.Check;
import commands.leaveWrongServer;
import commands.Help;
import commands.Addy;
import commands.GetAddy;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

import static imp.Declarations.getAllInfo;
import static imp.Declarations.jdaBuilder;

public class Main {
    public static void addEventListeners(){
        jdaBuilder.addEventListeners(new Help());
        jdaBuilder.addEventListeners(new AddAddress());
        jdaBuilder.addEventListeners(new leaveWrongServer());
        jdaBuilder.addEventListeners(new Check());
        jdaBuilder.addEventListeners(new GetAddy());
        jdaBuilder.addEventListeners(new Addy());
    }
    public static void main(String[] args) {
        getAllInfo();
        jdaBuilder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        jdaBuilder.setActivity(Activity.listening(".help"));
        addEventListeners();
        try {
            jdaBuilder.build();
        }catch (LoginException e){
            System.out.println("Unable To Login The Bot!\nPlease Refresh All Info Once.");
            getAllInfo();
        }
    }
}
