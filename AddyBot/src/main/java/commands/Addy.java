package commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Addy extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String[] message = event.getMessage().getContentRaw().split(" ");
        if (message[0].equals(".addy")){
            Member member = event.getMessage().getMentionedMembers().get(0);
            if (member.hasPermission(Permission.ADMINISTRATOR)){
                try {
                    Scanner scanner = new Scanner(new File("addys.txt"));
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains(member.getId())){
                            event.getChannel().sendMessage(line.replace(member.getId()+"- ","")).complete();
                        }
                    }
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }

            }else if (!member.hasPermission(Permission.ADMINISTRATOR)){
                event.getMessage().reply("Try with an admin's username!").complete();
            }
        }
    }
}
