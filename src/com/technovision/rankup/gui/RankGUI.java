package com.technovision.rankup.gui;

import com.technovision.rankup.RankUp;
import me.Cmaaxx.PlayTime.PlayTimeAPI;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class RankGUI implements InventoryHolder, Listener {

    public static List<String> activeGui = new ArrayList<String>();

    private Inventory inv;
    private Player player;

    public RankGUI(Player player) {
        Bukkit.getServer().getPluginManager().registerEvents(this, RankUp.PLUGIN);
        this.player = player;
        inv = Bukkit.createInventory(this, 9, "Ranks");
        addItems(player);
    }

    private void addItems(Player player) {
        inv.setItem(0, createGuiItem(Material.STAINED_GLASS_PANE, 7, " "));
        inv.setItem(1, createGuiItem(Material.STAINED_GLASS_PANE, 7, " "));
        inv.setItem(7, createGuiItem(Material.STAINED_GLASS_PANE, 7, " "));
        inv.setItem(8, createGuiItem(Material.STAINED_GLASS_PANE, 7, " "));

        double bal = RankUp.ECON.getBalance(player);
        int playtime = PlayTimeAPI.getHours(player);

        ArrayList<String> lore1 = new ArrayList<>();
        lore1.add(" ");
        lore1.add("§7Purchase ranks with in-game");
        lore1.add("§7money and playtime or through");
        lore1.add("§7the online shop.");
        lore1.add(" ");
        if (bal >= 500000000.0) { lore1.add("§7§lMoney:§a§l $500 Million");
        } else { lore1.add("§7§lMoney:§c§l $500 Million"); }
        if (playtime >= 250) { lore1.add("§7§lPlaytime:§a§l 250 Hours");
        } else { lore1.add("§7§lPlaytime:§c§l 250 Hours"); }
        lore1.add(" ");
        lore1.add("§a§nbuy.mythicpvp.net");
            inv.setItem(2, createGuiItem(Material.STONE_SWORD, "§a§lElite Rank", lore1));
        if (player.hasPermission("rankup.elite")) {
            ArrayList<String> lore = new ArrayList<>();
            lore.add(" ");
            lore.add("§7Purchase ranks with in-game");
            lore.add("§7money and playtime or through");
            lore.add("§7the online shop.");
            lore.add(" ");
            if (bal >= 1000000000.0) { lore.add("§7§lMoney:§a§l $1 Billion");
            } else { lore.add("§7§lMoney:§c§l $1 Billion"); }
            if (playtime >= 850) { lore.add("§7§lPlaytime:§a§l 850 Hours");
            } else { lore.add("§7§lPlaytime:§c§l 850 Hours"); }
            lore.add(" ");
            lore.add("§b§nbuy.mythicpvp.net");
            inv.setItem(3, createGuiItem(Material.IRON_SWORD, "§b§lHero Rank", lore));
        } else {
            inv.setItem(3, createGuiItem(Material.STAINED_CLAY, 14, "§c§lLOCKED"));
        }

        if (player.hasPermission("rankup.hero")) {
            ArrayList<String> lore = new ArrayList<>();
            lore.add(" ");
            lore.add("§7Purchase ranks with in-game");
            lore.add("§7money and playtime or through");
            lore.add("§7the online shop.");
            lore.add(" ");
            if (bal >= 5000000000.0) { lore.add("§7§lMoney:§a§l $5 Billion");
            } else { lore.add("§7§lMoney:§c§l $5 Billion"); }
            if (playtime >= 2500) { lore.add("§7§lPlaytime:§a§l 2,500 Hours");
            } else { lore.add("§7§lPlaytime:§c§l 2,500 Hours"); }
            lore.add(" ");
            lore.add("§d§nbuy.mythicpvp.net");
            inv.setItem(4, createGuiItem(Material.GOLD_SWORD, "§d§lMystic Rank", lore));
        } else {
            inv.setItem(4, createGuiItem(Material.STAINED_CLAY, 14, "§c§lLOCKED"));
        }

        if (player.hasPermission("rankup.mystic")) {
            ArrayList<String> lore = new ArrayList<>();
            lore.add(" ");
            lore.add("§7Purchase ranks with in-game");
            lore.add("§7money and playtime or through");
            lore.add("§7the online shop.");
            lore.add(" ");
            if (bal >= 10000000000.0) { lore.add("§7§lMoney:§a§l $10 Billion");
            } else { lore.add("§7§lMoney:§c§l $10 Billion"); }
            if (playtime >= 5000) { lore.add("§7§lPlaytime:§a§l 5,000 Hours");
            } else { lore.add("§7§lPlaytime:§c§l 5,000 Hours"); }
            lore.add(" ");
            lore.add("§c§nbuy.mythicpvp.net");
            inv.setItem(5, createGuiItem(Material.DIAMOND_SWORD, "§c§lImmortal Rank", lore));
        } else {
            inv.setItem(5, createGuiItem(Material.STAINED_CLAY, 14, "§c§lLOCKED"));
        }

        if (player.hasPermission("rankup.immortal")) {
            ArrayList<String> lore = new ArrayList<>();
            lore.add(" ");
            lore.add("§7Purchase ranks with in-game");
            lore.add("§7money and playtime or through");
            lore.add("§7the online shop.");
            lore.add(" ");
            if (bal >= 25000000000.0) { lore.add("§7§lMoney:§a§l $25 Billion");
            } else { lore.add("§7§lMoney:§c§l $25 Billion"); }
            if (playtime >= 10000) { lore.add("§7§lPlaytime:§a§l 10,000 Hours");
            } else { lore.add("§7§lPlaytime:§c§l 10,000 Hours"); }
            lore.add(" ");
            lore.add("§6§nbuy.mythicpvp.net");
            inv.setItem(6, createGuiItem(Material.NETHER_STAR, "§6§lLegend Rank", lore));
        } else {
            inv.setItem(6, createGuiItem(Material.STAINED_CLAY, 14, "§c§lLOCKED"));
        }
    }

    private ItemStack createGuiItem(final Material material, int dataValue, final String name) {
        final ItemStack item = new ItemStack(material, 1, (short) dataValue);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    private ItemStack createGuiItem(final Material material, final String name, final List<String> lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        return item;
    }

    public void openInventory(Player player) {
        player.openInventory(inv);
        activeGui.add(player.getName());
    }

    @EventHandler
    public void onGuiActivation(InventoryClickEvent event){
        if (event.getClickedInventory() == null) { return; }
        Player player = (Player) event.getWhoClicked();
        if (activeGui.contains(player.getName()) && event.getCurrentItem().getType() != Material.AIR) {
            event.setCancelled(true);
            if (event.getClickedInventory().getType() == InventoryType.PLAYER) { return; }
            if (event.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) { return; }
            if (event.getCurrentItem().getType() == Material.STAINED_CLAY) { return; }
            if (event.isLeftClick()) {
                player.closeInventory();
                addRank(player, event.getCurrentItem().getType());
            }
        }
    }

    private void addRank(Player player, Material item) {
        String name = player.getName();
        String rank = "";
        String color = "";
        double deduct = 0.0;
        boolean valid = false;
        FireworkEffect fireworkEffect = null;
        int timePlayed = PlayTimeAPI.getHours(player);
        if (item == Material.STONE_SWORD) {
            rank = "elite";
            color = "§a";
            deduct = 500000000.0;
            if (RankUp.ECON.getBalance(player) >= deduct && timePlayed >= 250) { valid = true; }
            fireworkEffect = FireworkEffect.builder().flicker(false).trail(true).with(FireworkEffect.Type.BALL).withColor(Color.LIME).withFade(Color.GREEN).build();
        }
        if (item == Material.IRON_SWORD) {
            rank = "hero";
            color = "§b";
            deduct = 1000000000.0;
            if (RankUp.ECON.getBalance(player) >= deduct && timePlayed >= 850) { valid = true; }
            fireworkEffect = FireworkEffect.builder().flicker(false).trail(true).with(FireworkEffect.Type.BALL).withColor(Color.AQUA).withFade(Color.BLUE).build();
        }
        if (item == Material.GOLD_SWORD) {
            rank = "mystic";
            color = "§d";
            deduct = 5000000000.0;
            if (RankUp.ECON.getBalance(player) >= deduct && timePlayed >= 2500) { valid = true; }
            fireworkEffect = FireworkEffect.builder().flicker(false).trail(true).with(FireworkEffect.Type.BALL).withColor(Color.PURPLE).withFade(Color.BLACK).build();
        }
        if (item == Material.DIAMOND_SWORD) {
            rank = "immortal";
            color = "§c";
            deduct = 10000000000.0;
            if (RankUp.ECON.getBalance(player) >= deduct && timePlayed >= 5000) { valid = true; }
            fireworkEffect = FireworkEffect.builder().flicker(false).trail(true).with(FireworkEffect.Type.BALL).withColor(Color.RED).withFade(Color.WHITE).build();
        }
        if (item == Material.NETHER_STAR) {
            rank = "legend";
            color = "§6";
            deduct = 25000000000.0;
            if (RankUp.ECON.getBalance(player) >= deduct && timePlayed >= 10000) { valid = true; }
            fireworkEffect = FireworkEffect.builder().flicker(false).trail(true).with(FireworkEffect.Type.BALL).withColor(Color.ORANGE).withFade(Color.RED).build();
        }
        if (player.hasPermission("rankup." + rank)) {
            player.sendMessage("§c§l(!) §cYou already purchased that rank!");
            return;
        }
        if (!valid) {
            rank = rank.toUpperCase().charAt(0) + rank.substring(1);
            player.sendMessage("§c§l(!) §cYou do not meet the in-game requirements!");
            player.sendMessage("§c§l(!) §cYou can purchase §l" + rank + " Rank §cat §nbuy.mythicpvp.net");
            return;
        }
        String permCommand = "luckperms user " + name + " parent set " + rank;
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), permCommand);
        RankUp.ECON.withdrawPlayer(player, deduct);
        rank = rank.toUpperCase().charAt(0) + rank.substring(1);
        player.sendMessage("§a§l(!) §aYou ranked up to §n" + rank);

        Title title = new Title(color + "§l" + rank + " Rank", "You ranked up!");
        title.send(player);

       Location location = player.getLocation();
       new InstantFirework(fireworkEffect, location);
    }

    @EventHandler
    public void onGuiClosing(InventoryCloseEvent event){
        Player player = (Player) event.getPlayer();
        if (activeGui.contains(player.getName())) {
            activeGui.remove(player.getName());
        }
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
