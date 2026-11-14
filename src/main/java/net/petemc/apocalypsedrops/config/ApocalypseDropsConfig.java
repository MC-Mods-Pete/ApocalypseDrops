package net.petemc.apocalypsedrops.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ApocalypseDropsConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue ENABLE_ZOMBIE_DROPS = BUILDER
            .comment("If true, all the items below with a drop chance bigger than 0.0 will drop for Zombies")
            .translation("apocalypsedrops.configuration.enableZombieDrops")
            .define("enableZombieDrops", true);

    public static final ModConfigSpec.BooleanValue ENABLE_HUSK_DROPS = BUILDER
            .comment("If true, all the items below with a drop chance bigger than 0.0 will drop for Husks")
            .translation("apocalypsedrops.configuration.enableHuskDrops")
            .define("enableHuskDrops", true);

    public static final ModConfigSpec.DoubleValue GUNPOWDER_DROP_CHANCE = chance("gunpowderDropChance", "Gunpowder", 0.2, false);
    public static final ModConfigSpec.DoubleValue BONE_DROP_CHANCE = chance("boneDropChance", "Bones", 0.12, false);
    public static final ModConfigSpec.DoubleValue STRING_DROP_CHANCE = chance("stringDropChance", "String", 0.06, false);
    public static final ModConfigSpec.DoubleValue SPIDER_EYE_DROP_CHANCE = chance("spiderEyeDropChance", "Spider Eyes", 0.03, false);
    public static final ModConfigSpec.DoubleValue PHANTOM_MEMBRANE_DROP_CHANCE = chance("phantomMembraneDropChance", "Phantom Membranes", 0.04, false);
    public static final ModConfigSpec.DoubleValue ENDER_PEARL_DROP_CHANCE = chance("enderPearlDropChance", "Ender Pearls", 0.02, false);
    public static final ModConfigSpec.DoubleValue POTATO_DROP_CHANCE = chance("potatoDropChance", "Potatoes", 0.01, true);
    public static final ModConfigSpec.DoubleValue CARROT_DROP_CHANCE = chance("carrotDropChance", "Carrots", 0.01, true);
    public static final ModConfigSpec.DoubleValue BLAZE_ROD_DROP_CHANCE = chance("blazeRodDropChance", "Blaze Rods", 0.0, false);
    public static final ModConfigSpec.DoubleValue NETHER_WART_DROP_CHANCE = chance("netherWartDropChance", "Nether Warts", 0.0, false);

    public static final ModConfigSpec SPEC = BUILDER.build();

    private static ModConfigSpec.DoubleValue chance(String name, String itemName, double defaultValue, boolean vanillaDrop) {
        String note = vanillaDrop
                ? "(Note: 0.0 will not prevent " + itemName + " from dropping)"
                : "(from 0% never to 100% always)";
        return BUILDER
                .comment("Change this value to adjust the chance for " + itemName + " to drop | default: " + defaultValue
                        + " | range: 0.0 - 1.0 " + note)
                .translation("apocalypsedrops.configuration." + name)
                .defineInRange(name, defaultValue, 0.0, 1.0);
    }
}
