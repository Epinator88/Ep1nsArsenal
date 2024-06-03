package weaponjam.ep1ns_arsenal;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import weaponjam.ep1ns_arsenal.commands.getAllCommand;
import weaponjam.ep1ns_arsenal.commands.kitCommand;
import weaponjam.ep1ns_arsenal.commands.storedQuery;
import weaponjam.ep1ns_arsenal.listeners.*;
import weaponjam.ep1ns_arsenal.tasks.*;

import javax.xml.stream.events.Namespace;
import java.util.ArrayList;
import java.util.List;

public final class Ep1ns_Arsenal extends JavaPlugin {

    public static Ep1ns_Arsenal instance;

    public ItemStack bow = new ItemStack(Material.BOW);

    public ItemStack doubleaxe = new ItemStack(Material.NETHERITE_AXE);

    public ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS);

    public ItemStack fakePearl = new ItemStack(Material.ENDER_PEARL);

    public ItemStack gatlingBow = new ItemStack(Material.CROSSBOW);

    public ItemStack vampSword = new ItemStack(Material.NETHERITE_SWORD);

    public ItemStack godShield = new ItemStack(Material.SHIELD);

    public ItemStack trident = new ItemStack(Material.TRIDENT);

    public NamespacedKey specialArrow = new NamespacedKey(this, "specialArrow");

    public NamespacedKey jumpTimer = new NamespacedKey(this, "jumpTimer");

    public NamespacedKey axeTimer = new NamespacedKey(this, "axeTimer");

    public NamespacedKey storedHealth = new NamespacedKey(this, "storedHealth");

    public NamespacedKey funnyTrident = new NamespacedKey(this, "funnyTrident");

    public ItemStack infGapple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);

    public ItemStack infGappleCool = new ItemStack(Material.STICK);

    @Override
    public void onEnable() {
        instance = this;
        ItemMeta x = doubleaxe.getItemMeta();
        x.setDisplayName(ChatColor.BLUE + "Explosive Battleaxe");
        List<String> axelore = new ArrayList<>();
        axelore.add("A combustible axe.");
        axelore.add("You take much less damage from exploding others.");
        axelore.add("Be sure not to cut yourself!");
        axelore.add("COOLDOWN: 5 SECONDS (FOR EXPLOSION)");
        x.setLore(axelore);
        x.setUnbreakable(true);
        doubleaxe.setItemMeta(x);
        doubleaxe.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 1);
        doubleaxe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
        getServer().getPluginManager().registerEvents(new hitByCoolStuffListner(), this);

        ItemMeta y = bow.getItemMeta();
        y.setDisplayName(ChatColor.AQUA + "Repulsor Bow");
        List<String> bowLore = new ArrayList<>();
        bowLore.add("A bow imbued with Wind Magic.");
        bowLore.add("Arrows shot with the bow are not affected by gravity.");
        bowLore.add("Slows your fall when you charge a shot for more accuracy.");
        bowLore.add("Some arrows can launch hit players!");
        bowLore.add("Very windy");
        y.setLore(bowLore);
        y.setUnbreakable(true);
        bow.setItemMeta(y);
        bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
        bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
        bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
        getServer().getPluginManager().registerEvents(new shootSpecialArrowListener(), this);
        getServer().getPluginManager().registerEvents(new RepulseListener(), this);

        ItemMeta z = boots.getItemMeta();
        z.setDisplayName(ChatColor.YELLOW + "Longfall Boots");
        List<String> bootLore = new ArrayList<>();
        bootLore.add("Longfall boots. Completely negate fall damage, even lethal falls.");
        bootLore.add("Press SHIFT to launch yourself up.");
        bootLore.add("COOLDOWN: 3 SECONDS (FOR LAUNCH)");
        z.setLore(bootLore);
        z.setUnbreakable(true);
        boots.setItemMeta(z);
        getServer().getPluginManager().registerEvents(new longfallListener(), this);

        ItemMeta b = infGapple.getItemMeta();
        b.setDisplayName(ChatColor.LIGHT_PURPLE + "Goated Apple");
        List<String> gapLore = new ArrayList<>();
        gapLore.add("A TOTALLY ORIGINAL buffing fruit.");
        gapLore.add("Infinite. Let the core regrow to eat it again.");
        gapLore.add("Completely original and did not come from anywhere else.");
        b.setLore(gapLore);
        infGapple.setItemMeta(b);
        getServer().getPluginManager().registerEvents(new gappleUpdateListener(), this);

        ItemMeta c = infGappleCool.getItemMeta();
        c.setDisplayName("Goated Core");
        List<String> coreLore = new ArrayList<>();
        coreLore.add("The core of a Goated Apple.");
        coreLore.add("Regrows automatically after 2m of having been eaten");
        coreLore.add("Throw it away if you want, I guess. It won't regrow again though.");
        c.setLore(coreLore);
        infGappleCool.setItemMeta(c);
        infGappleCool.addUnsafeEnchantment(Enchantment.DURABILITY, 1);

        ItemMeta d = fakePearl.getItemMeta();
        d.setDisplayName(ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + "Fake Ender Pearl");
        List<String> pearlLore = new ArrayList<>();
        pearlLore.add("A neat marble that looks like an Ender Pearl");
        pearlLore.add("Throwing it looks like a pearl, but when it lands,");
        pearlLore.add("nothing happens. Good for throwing people off.");
        d.setLore(pearlLore);
        fakePearl.setItemMeta(d);
        getServer().getPluginManager().registerEvents(new throwFakeListener(), this);

        ItemMeta e = gatlingBow.getItemMeta();
        e.setDisplayName(ChatColor.AQUA + "Gatling Bow");
        List<String> gatLore = new ArrayList<>();
        gatLore.add("A gatling bow, meant for rapid fire.");
        gatLore.add("Press LEFT CLICK to launch an arrow.");
        gatLore.add("Also, doesn't work when charged.");
        gatLore.add("And doesn't work with tipped arrows. I can't make this TOO overpowered.");
        gatLore.add("Also, don't shoot it upwards. Just don't.");
        e.setLore(gatLore);
        e.setUnbreakable(true);
        gatlingBow.setItemMeta(e);
        getServer().getPluginManager().registerEvents(new gatlingListener(), this);

        ItemMeta f = vampSword.getItemMeta();
        f.setDisplayName(ChatColor.BLUE + "Vampirism Sword");
        List<String> swordLore = new ArrayList<>();
        swordLore.add("A sword that steals the life of those it damages.");
        swordLore.add("The sword stores stolen health, and applies it only when the foe is slain");
        swordLore.add("All health is given at once, no matter who is still alive.");
        swordLore.add("Barely works on non-player entities. Loses most of its charge, but is good in a pinch.");
        swordLore.add("sussy test");
        f.setLore(swordLore);
        f.setUnbreakable(true);
        vampSword.setItemMeta(f);
        vampSword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
        vampSword.addEnchantment(Enchantment.FIRE_ASPECT, 1);
        getServer().getPluginManager().registerEvents(new onVampSteal(), this);

        ItemMeta g = godShield.getItemMeta();
        g.setDisplayName(ChatColor.YELLOW + "Nullifying Shield");
        List<String> shieldLore = new ArrayList<>();
        shieldLore.add("An impenetrable shield.");
        shieldLore.add("Nullifies all attacks added from the plugin.");
        shieldLore.add("Can only be disabled with an axe.");
        shieldLore.add("If hit, will slightly decrease stored Health in the Vampirism Sword");
        g.setLore(shieldLore);
        g.setUnbreakable(true);
        godShield.setItemMeta(g);
        godShield.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1000);

        ItemMeta a = trident.getItemMeta();
        a.setDisplayName(ChatColor.BLUE + "Ender Trident");
        List<String> triLore = new ArrayList<>();
        triLore.add("A trident only found in End Cities.");
        triLore.add("On hit, brings the target back to the thrower.");
        triLore.add("GET OVER HERE!!!");
        a.setUnbreakable(true);
        a.setLore(triLore);
        trident.setItemMeta(a);
        trident.addEnchantment(Enchantment.LOYALTY, 3);
        getServer().getPluginManager().registerEvents(new tridentGotchaListener(), this);

        onNewPlayer();

        getCommand("giveall").setExecutor(new getAllCommand());

        getCommand("storedquery").setExecutor(new storedQuery());

        getCommand("kit").setExecutor(new kitCommand());

        getServer().getPluginManager().registerEvents(new potPunchListener(), this);

        getServer().getPluginManager().registerEvents(new playerJoinEvent(), this);
    }

    public void onNewPlayer()
    {
        for(World j : getServer().getWorlds())
        {
            for(Player p : j.getPlayers())
            {
                p.getPersistentDataContainer().set(jumpTimer, PersistentDataType.INTEGER, 30);
                p.getPersistentDataContainer().set(axeTimer, PersistentDataType.INTEGER, 50);
                p.getPersistentDataContainer().set(storedHealth, PersistentDataType.DOUBLE, 0.0);
                BukkitTask countdownTask = new countdownTask(p, this).runTaskTimer(this, 0L, 2L);
            }
        }
    }

    public static boolean isShieldDown(Player p)
    {
        if(p.getInventory().getItemInOffHand().equals(Ep1ns_Arsenal.instance.godShield))
        {
            if(p.isBlocking())
            {
                return false;
            }
        }
        return true;
    }
}
