package net.petemc.apocalypsedrops.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.petemc.apocalypsedrops.config.ApocalypseDropsConfigs;

public class ApocalypseDropsLootTableModifiers {
    private static final Identifier ZOMBIE_ID =
            new Identifier("minecraft", "entities/zombie");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (ZOMBIE_ID.equals(id)) {
                LootPool.Builder poolBuilderEnderPerls = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(ApocalypseDropsConfigs.CHANCE_ENDER_PEARL))
                        .with(ItemEntry.builder(Items.ENDER_PEARL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilderEnderPerls.build());

                LootPool.Builder poolBuilderBones = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(ApocalypseDropsConfigs.CHANCE_BONE))
                        .with(ItemEntry.builder(Items.BONE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilderBones.build());

                LootPool.Builder poolBuilderGunpowder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(ApocalypseDropsConfigs.CHANCE_GUNPOWDER))
                        .with(ItemEntry.builder(Items.GUNPOWDER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilderGunpowder.build());

                LootPool.Builder poolBuilderString = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(ApocalypseDropsConfigs.CHANCE_STRING))
                        .with(ItemEntry.builder(Items.STRING))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilderString.build());

                LootPool.Builder poolBuilderSpiderEye = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(ApocalypseDropsConfigs.CHANCE_SPIDER_EYE))
                        .with(ItemEntry.builder(Items.SPIDER_EYE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilderSpiderEye.build());

                LootPool.Builder poolBuilderPhantomMembrane = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(ApocalypseDropsConfigs.CHANCE_PHANTOM_MEMBRANE))
                        .with(ItemEntry.builder(Items.PHANTOM_MEMBRANE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilderPhantomMembrane.build());

                LootPool.Builder poolBuilderPotato = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(ApocalypseDropsConfigs.CHANCE_POTATO))
                        .with(ItemEntry.builder(Items.POTATO))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilderPotato.build());

                LootPool.Builder poolBuilderCarrot = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(ApocalypseDropsConfigs.CHANCE_CARROT))
                        .with(ItemEntry.builder(Items.CARROT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilderCarrot.build());

                LootPool.Builder poolBuilderBlazePowder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(ApocalypseDropsConfigs.CHANCE_BLAZE_POWDER))
                        .with(ItemEntry.builder(Items.BLAZE_POWDER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilderBlazePowder.build());

                LootPool.Builder poolBuilderNetherWart = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(ApocalypseDropsConfigs.CHANCE_NETHER_WART))
                        .with(ItemEntry.builder(Items.NETHER_WART))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilderNetherWart.build());
            }
        });
    }
}



