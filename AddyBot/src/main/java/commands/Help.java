package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;


public class Help extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        Member member = event.getMember();
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setAuthor(event.getGuild().getName());
        embedBuilder.setTitle("Help Menu");
        embedBuilder.setFooter(event.getMember().getUser().getName(),member.getUser().getAvatarUrl());
        if (member.hasPermission(Permission.ADMINISTRATOR) && event.getMessage().getContentRaw().equals(".help")){
            embedBuilder.setDescription("`.addy-add <coinSymbol> <address>`- add an address\n\n`.check`- get your address list");
            embedBuilder.setColor(Color.green);
            event.getChannel().sendMessage(embedBuilder.build()).complete();
        }else if (!member.hasPermission(Permission.ADMINISTRATOR) && event.getMessage().getContentRaw().equals(".help")){
            embedBuilder.setColor(Color.CYAN);
            embedBuilder.setDescription("`.addy @Username`- To Get All Payment Options\n\n`.get-addy <coinSymbol> @Username`- get particular address");
            event.getChannel().sendMessage(embedBuilder.build()).queue();
        }
    }
}
