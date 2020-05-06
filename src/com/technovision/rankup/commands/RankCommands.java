package com.technovision.rankup.commands;

import com.technovision.rankup.gui.RankGUI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class RankCommands implements Listener, CommandExecutor {

    public static final String RANKUP = "rankup";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            String cmd = command.getName();
            if (cmd.equalsIgnoreCase(RANKUP) && args.length == 0) {
                RankGUI rankGUI = new RankGUI(player);
                rankGUI.openInventory(player);
                return true;
            }
        } else {
        sender.sendMessage(ChatColor.RED + "Only players can use this command!");
        }
        return true;
    }
}
