package commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static imp.Declarations.file;

public class
Check extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if (event.getMember().hasPermission(Permission.ADMINISTRATOR) && event.getMessage().getContentRaw().equals(".check")) {
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains(event.getMember().getId())){
                        String[] linee = line.split(" ");
                        event.getChannel().sendMessage(line.replace(event.getMember().getId()+"- ","")).complete();
                    }
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
