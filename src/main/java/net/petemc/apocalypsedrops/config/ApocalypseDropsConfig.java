package net.petemc.apocalypsedrops.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ApocalypseDropsConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.BooleanValue ENABLE_ZOMBIE_DROPS = BUILDER
            .comment("If true, all the items below with a drop chance bigger than 0.0 will drop for Zombies")
            .define("enableZombieDrops", true);

    public static final ForgeConfigSpec.BooleanValue ENABLE_HUSK_DROPS = BUILDER
            .comment("If true, all the items below with a drop chance bigger than 0.0 will drop for Husks")
            .define("enableHuskDrops", true);

    public static final ForgeConfigSpec.DoubleValue GUNPOWDER_DROP_CHANCE = chance("gunpowderDropChance", "Gunpowder", 0.2, false);
    public static final ForgeConfigSpec.DoubleValue BONE_DROP_CHANCE = chance("boneDropChance", "Bones", 0.12, false);
    public static final ForgeConfigSpec.DoubleValue STRING_DROP_CHANCE = chance("stringDropChance", "String", 0.06, false);
    public static final ForgeConfigSpec.DoubleValue SPIDER_EYE_DROP_CHANCE = chance("spiderEyeDropChance", "Spider Eyes", 0.03, false);
    public static final ForgeConfigSpec.DoubleValue PHANTOM_MEMBRANE_DROP_CHANCE = chance("phantomMembraneDropChance", "Phantom Membranes", 0.04, false);
    public static final ForgeConfigSpec.DoubleValue ENDER_PEARL_DROP_CHANCE = chance("enderPearlDropChance", "Ender Pearls", 0.02, false);
    public static final ForgeConfigSpec.DoubleValue POTATO_DROP_CHANCE = chance("potatoDropChance", "Potatoes", 0.01, true);
    public static final ForgeConfigSpec.DoubleValue CARROT_DROP_CHANCE = chance("carrotDropChance", "Carrots", 0.01, true);
    public static final ForgeConfigSpec.DoubleValue BLAZE_ROD_DROP_CHANCE = chance("blazeRodDropChance", "Blaze Rods", 0.0, false);
    public static final ForgeConfigSpec.DoubleValue NETHER_WART_DROP_CHANCE = chance("netherWartDropChance", "Nether Warts", 0.0, false);

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    private static ForgeConfigSpec.DoubleValue chance(String name, String itemName, double defaultValue, boolean vanillaDrop) {
        String note = vanillaDrop
                ? "(Note: 0.0 will not prevent " + itemName + " from dropping)"
                : "(from 0% never to 100% always)";
        return BUILDER
                .comment("Change this value to adjust the chance for " + itemName + " to drop | default: " + defaultValue
                        + " | range: 0.0 - 1.0 " + note)
                .defineInRange(name, defaultValue, 0.0, 1.0);
    }
}
