package net.petemc.apocalypsedrops.config;

import com.mojang.datafixers.util.Pair;
import net.petemc.apocalypsedrops.ApocalypseDrops;

public class ApocalypseDropsConfigs {
    public static SimpleConfig CONFIG;
    private static ApocalypseDropsConfigProvider configs;

    public static float CHANCE_GUNPOWDER;
    public static float CHANCE_BONE;
    public static float CHANCE_STRING;
    public static float CHANCE_SPIDER_EYE;
    public static float CHANCE_PHANTOM_MEMBRANE;
    public static float CHANCE_ENDER_PEARL;
    public static float CHANCE_POTATO;
    public static float CHANCE_CARROT;
    public static float CHANCE_BLAZE_POWDER;
    public static float CHANCE_NETHER_WART;

    public static void registerConfigs() {
        configs = new ApocalypseDropsConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(ApocalypseDrops.MOD_ID + "_config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("gunpowder.drop.chance", 0.2f), "(value: 0.0 - 1.0)");
        configs.addKeyValuePair(new Pair<>("bone.drop.chance", 0.12f), "(value: 0.0 - 1.0)");
        configs.addKeyValuePair(new Pair<>("string.drop.chance", 0.06f), "(value: 0.0 - 1.0)");
        configs.addKeyValuePair(new Pair<>("spider_eye.drop.chance", 0.03f), "(value: 0.0 - 1.0)");
        configs.addKeyValuePair(new Pair<>("phantom_membrane.drop.chance", 0.04f), "(value: 0.0 - 1.0)");
        configs.addKeyValuePair(new Pair<>("ender_pearl.drop.chance", 0.02f), "(value: 0.0 - 1.0)");
        configs.addKeyValuePair(new Pair<>("potato.drop.chance", 0.01f), "(value: 0.0 - 1.0)");
        configs.addKeyValuePair(new Pair<>("carrot.drop.chance", 0.01f), "(value: 0.0 - 1.0)");
        configs.addKeyValuePair(new Pair<>("blaze_powder.drop.chance", 0.0f), "(value: 0.0 - 1.0)");
        configs.addKeyValuePair(new Pair<>("nether_wart.drop.chance", 0.0f), "(value: 0.0 - 1.0)");
    }

    private static void assignConfigs() {
        CHANCE_GUNPOWDER = (float) CONFIG.getOrDefault("gunpowder.drop.chance", 0.2f);
        CHANCE_BONE = (float) CONFIG.getOrDefault("bone.drop.chance", 0.12f);
        CHANCE_STRING = (float) CONFIG.getOrDefault("string.drop.chance", 0.06f);
        CHANCE_SPIDER_EYE = (float) CONFIG.getOrDefault("spider_eye.drop.chance", 0.03f);
        CHANCE_PHANTOM_MEMBRANE = (float) CONFIG.getOrDefault("phantom_membrane.drop.chance", 0.04f);
        CHANCE_ENDER_PEARL = (float) CONFIG.getOrDefault("ender_pearl.drop.chance", 0.02f);
        CHANCE_POTATO = (float) CONFIG.getOrDefault("potato.drop.chance", 0.01f);
        CHANCE_CARROT = (float) CONFIG.getOrDefault("carrot.drop.chance", 0.01f);
        CHANCE_BLAZE_POWDER = (float) CONFIG.getOrDefault("blaze_powder.drop.chance", 0.0f);
        CHANCE_NETHER_WART = (float) CONFIG.getOrDefault("nether_wart.drop.chance", 0.0f);

        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}
