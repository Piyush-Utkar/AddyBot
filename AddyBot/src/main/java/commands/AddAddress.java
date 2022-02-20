package commands;

import imp.Declarations;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Scanner;

import static imp.Declarations.file;

public class AddAddress extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        if (event.getMember().hasPermission(Permission.ADMINISTRATOR) && args[0].equals(".addy-add")){
            String coinSymbol = args[1];
            String coinAddress = args[2];
            String memberID = event.getMember().getId();
                        try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Declarations.file,true));
                    bufferedWriter.append(memberID).append("- ").append("(").append(coinSymbol).append(") ").append(coinAddress);
                    bufferedWriter.close();
                    event.getChannel().sendMessage("Added Successfully!").complete();
                    } catch (IOException e) {
                    e.printStackTrace();
                    }
        }else if (!event.getMember().hasPermission(Permission.ADMINISTRATOR) && args[0].equals(".addy-add")){
            event.getChannel().sendMessage("You don't have the permission to use this command!").complete();
        }
    }
}
//            try {
//                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Declarations.file));
//
//                    } catch (IOException e) {
//                    e.printStackTrace();
//                    }