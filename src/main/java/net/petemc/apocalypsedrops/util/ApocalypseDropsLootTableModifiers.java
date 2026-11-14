package net.petemc.apocalypsedrops.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.petemc.apocalypsedrops.config.ApocalypseDropsConfig;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class ApocalypseDropsLootTableModifiers {

    private static final String ZOMBIE_TABLE = "minecraft:entities/zombie";
    private static final String HUSK_TABLE = "minecraft:entities/husk";

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            String id = key.identifier().toString();
            if (ZOMBIE_TABLE.equals(id)) {
                addDrops(tableBuilder, () -> ApocalypseDropsConfig.INSTANCE.enableZombieDrops);
            } else if (HUSK_TABLE.equals(id)) {
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
        LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .when(() -> new ConfigChanceLootCondition(enabled, chance))
                .add(LootItem.lootTableItem(item))
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f)));
        tableBuilder.withPool(poolBuilder);
    }
}
