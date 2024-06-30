package net.petemc.apocalypsedrops.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import net.petemc.apocalypsedrops.ApocalypseDrops;

@Config(name = ApocalypseDrops.MOD_ID)
public class ApocalypseDropsConfig implements ConfigData
{
    @ConfigEntry.Gui.Excluded
    public static ApocalypseDropsConfig INSTANCE;

    public static void init()
    {
        AutoConfig.register(ApocalypseDropsConfig.class, JanksonConfigSerializer::new);
        INSTANCE = AutoConfig.getConfigHolder(ApocalypseDropsConfig.class).getConfig();
        if ((INSTANCE.gunpowderDropChance < 0.0) || (INSTANCE.gunpowderDropChance > 1.0)) {
            ApocalypseDrops.LOGGER.warn("Value for gunpowderDropChance not in range (valid range 0.0 - 1.0), using default.");
            INSTANCE.gunpowderDropChance = 0.2;
        }
        if ((INSTANCE.boneDropChance < 0.0) || (INSTANCE.boneDropChance > 1.0)) {
            ApocalypseDrops.LOGGER.warn("Value for boneDropChance not in range (valid range 0.0 - 1.0), using default.");
            INSTANCE.boneDropChance = 0.12;
        }
        if ((INSTANCE.stringDropChance < 0.0) || (INSTANCE.stringDropChance > 1.0)) {
            ApocalypseDrops.LOGGER.warn("Value for stringDropChance not in range (valid range 0.0 - 1.0), using default.");
            INSTANCE.stringDropChance = 0.06;
        }
        if ((INSTANCE.spiderEyeDropChance < 0.0) || (INSTANCE.spiderEyeDropChance > 1.0)) {
            ApocalypseDrops.LOGGER.warn("Value for spiderEyeDropChance not in range (valid range 0.0 - 1.0), using default.");
            INSTANCE.spiderEyeDropChance = 0.03;
        }
        if ((INSTANCE.phantomMembraneDropChance < 0.0) || (INSTANCE.phantomMembraneDropChance > 1.0)) {
            ApocalypseDrops.LOGGER.warn("Value for phantomMembraneDropChance not in range (valid range 0.0 - 1.0), using default.");
            INSTANCE.phantomMembraneDropChance = 0.04;
        }
        if ((INSTANCE.enderPearlDropChance < 0.0) || (INSTANCE.enderPearlDropChance > 1.0)) {
            ApocalypseDrops.LOGGER.warn("Value for enderPearlDropChance not in range (valid range 0.0 - 1.0), using default.");
            INSTANCE.enderPearlDropChance = 0.02;
        }
        if ((INSTANCE.potatoDropChance < 0.0) || (INSTANCE.potatoDropChance > 1.0)) {
            ApocalypseDrops.LOGGER.warn("Value for potatoDropChance not in range (valid range 0.0 - 1.0), using default.");
            INSTANCE.potatoDropChance = 0.01;
        }
        if ((INSTANCE.carrotDropChance < 0.0) || (INSTANCE.carrotDropChance > 1.0)) {
            ApocalypseDrops.LOGGER.warn("Value for carrotDropChance not in range (valid range 0.0 - 1.0), using default.");
            INSTANCE.carrotDropChance = 0.01;
        }
        if ((INSTANCE.blazeRodDropChance < 0.0) || (INSTANCE.blazeRodDropChance > 1.0)) {
            ApocalypseDrops.LOGGER.warn("Value for blazeRodDropChance not in range (valid range 0.0 - 1.0), using default.");
            INSTANCE.blazeRodDropChance = 0.0;
        }
        if ((INSTANCE.netherWartDropChance < 0.0) || (INSTANCE.netherWartDropChance > 1.0)) {
            ApocalypseDrops.LOGGER.warn("Value for netherWartDropChance not in range (valid range 0.0 - 1.0), using default.");
            INSTANCE.netherWartDropChance = 0.0;
        }
    }

    @ConfigEntry.Gui.Tooltip()
    @Comment("If true, all the items below with a drop chance bigger than 0.0 will drop for Zombies")
    public boolean enableZombieDrops = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If true, all the items below with a drop chance bigger than 0.0 will drop for Husks")
    public boolean enableHuskDrops = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("Change this value to adjust the chance for Gunpowder to drop | default: 0.2 | range: 0.0 - 1.0 (from 0% never to 100% always)")
    public double gunpowderDropChance = 0.2;

    @ConfigEntry.Gui.Tooltip()
    @Comment("Change this value to adjust the chance for Bones to drop | default: 0.12 |  range: 0.0 - 1.0 (from 0% never to 100% always)")
    public double boneDropChance = 0.12;

    @ConfigEntry.Gui.Tooltip()
    @Comment("Change this value to adjust the chance for String to drop | default: 0.06 |  range: 0.0 - 1.0 (from 0% never to 100% always)")
    public double stringDropChance = 0.06;

    @ConfigEntry.Gui.Tooltip()
    @Comment("Change this value to adjust the chance for Spider Eyes to drop | default: 0.03 |  range: 0.0 - 1.0 (from 0% never to 100% always)")
    public double spiderEyeDropChance = 0.03;

    @ConfigEntry.Gui.Tooltip()
    @Comment("Change this value to adjust the chance for Phantom Membranes to drop | default: 0.04 |  range: 0.0 - 1.0 (from 0% never to 100% always)")
    public double phantomMembraneDropChance = 0.04;

    @ConfigEntry.Gui.Tooltip()
    @Comment("Change this value to adjust the chance for Ender Pearls to drop | default: 0.02 |  range: 0.0 - 1.0 (from 0% never to 100% always)")
    public double enderPearlDropChance = 0.02;

    @ConfigEntry.Gui.Tooltip()
    @Comment("Change this value to adjust the chance for Potatoes to drop | default: 0.01 |  range: 0.0 - 1.0 (Note: 0.0 will not prevent Potatoes from dropping)")
    public double potatoDropChance = 0.01;

    @ConfigEntry.Gui.Tooltip()
    @Comment("Change this value to adjust the chance for Carrots to drop | default: 0.01 |  range: 0.0 - 1.0 (Note: 0.0 will not prevent Carrots from dropping)")
    public double carrotDropChance = 0.01;

    @ConfigEntry.Gui.Tooltip()
    @Comment("Change this value to adjust the chance for Blazes Rods to drop | default: 0.0 |  range: 0.0 - 1.0 (from 0% never to 100% always)")
    public double blazeRodDropChance = 0.0;

    @ConfigEntry.Gui.Tooltip()
    @Comment("Change this value to adjust the chance for Nether Warts to drop | default: 0.0 |  range: 0.0 - 1.0 (from 0% never to 100% always)")
    public double netherWartDropChance = 0.0;
}
