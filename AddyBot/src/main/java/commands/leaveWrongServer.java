package commands;

import imp.Declarations;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class leaveWrongServer extends ListenerAdapter {
    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        if (!event.getGuild().getId().equals(Declarations.guildID)){
            event.getGuild().leave().complete();
        }
    }
}
