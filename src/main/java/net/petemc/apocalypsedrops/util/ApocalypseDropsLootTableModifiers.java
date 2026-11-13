package net.petemc.apocalypsedrops.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.util.Identifier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.petemc.apocalypsedrops.config.ApocalypseDropsConfig;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class ApocalypseDropsLootTableModifiers {
    private static final Identifier ZOMBIE_ID = new Identifier("minecraft", "entities/zombie");
    private static final Identifier HUSK_ID = new Identifier("minecraft", "entities/husk");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (ZOMBIE_ID.equals(id)) {
                addDrops(tableBuilder, () -> ApocalypseDropsConfig.INSTANCE.enableZombieDrops);
            } else if (HUSK_ID.equals(id)) {
                addDrops(tableBuilder, () -> ApocalypseDropsConfig.INSTANCE.enableHuskDrops);
            }
        });
    }

    // One pool per item. Enabled flag and chance are read from the config when the loot is rolled,
    // so changes in the config screen are active immediately without reloading the loot tables.
    private static void addDrops(LootTable.Builder tableBuilder, BooleanSupplier enabled) {
        addDrop(tableBuilder, enabled, Items.ENDER_PEARL, () -> ApocalypseDropsConfig.INSTANCE.enderPearlDropChance);
        addDrop(tableBuilder, enabled, Items.BONE, () -> ApocalypseDropsConfig.INSTANCE.boneDropChance);
        addDrop(tableBuilder, enabled, Items.GUNPOWDER, () -> ApocalypseDropsConfig.INSTANCE.gunpowderDropChance);
        addDrop(tableBuilder, enabled, Items.STRING, () -> ApocalypseDropsConfig.INSTANCE.stringDropChance);
        addDrop(tableBuilder, enabled, Items.SPIDER_EYE, () -> ApocalypseDropsConfig.INSTANCE.spiderEyeDropChance);
        addDrop(tableBuilder, enabled, Items.PHANTOM_MEMBRANE, () -> ApocalypseDropsConfig.INSTANCE.phantomMembraneDropChance);
        addDrop(tableBuilder, enabled, Items.POTATO, () -> ApocalypseDropsConfig.INSTANCE.potatoDropChance);
        addDrop(tableBuilder, enabled, Items.CARROT, () -> ApocalypseDropsConfig.INSTANCE.carrotDropChance);
        addDrop(tableBuilder, enabled, Items.BLAZE_ROD, () -> ApocalypseDropsConfig.INSTANCE.blazeRodDropChance);
        addDrop(tableBuilder, enabled, Items.NETHER_WART, () -> ApocalypseDropsConfig.INSTANCE.netherWartDropChance);
    }

    private static void addDrop(LootTable.Builder tableBuilder, BooleanSupplier enabled, Item item, DoubleSupplier chance) {
        LootPool.Builder poolBuilder = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(() -> new ConfigChanceLootCondition(enabled, chance))
                .with(ItemEntry.builder(item))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
        tableBuilder.pool(poolBuilder);
    }
}
