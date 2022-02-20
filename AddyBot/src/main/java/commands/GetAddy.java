package commands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GetAddy extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String[] message = event.getMessage().getContentRaw().split(" ");
        Member member = event.getMessage().getMentionedMembers().get(0);
        if (message[0].equals(".get-addy")){
            try {
                Scanner scanner = new Scanner(new File("addys.txt"));
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains(event.getMessage().getMentionedMembers().get(0).getId()) && line.contains(message[1])){
                        event.getChannel().sendMessage(line.replace(member.getId()+"- ("+message[1]+") ","")).complete();
                        break;
                    }
                }
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }
    }
}
