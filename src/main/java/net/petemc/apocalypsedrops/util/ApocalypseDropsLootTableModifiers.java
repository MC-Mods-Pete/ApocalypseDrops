package net.petemc.apocalypsedrops.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.petemc.apocalypsedrops.config.ApocalypseDropsConfigs;

public class ApocalypseDropsLootTableModifiers {

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((id, tableBuilder, source) -> {
            if ((EntityType.ZOMBIE.getLootTableId() == id && source.isBuiltin() && ApocalypseDropsConfigs.ZOMBIE_DROPS_ENABLED) ||
                (EntityType.HUSK.getLootTableId()   == id && source.isBuiltin() && ApocalypseDropsConfigs.HUSK_DROPS_ENABLED)) {
                if (ApocalypseDropsConfigs.CHANCE_ENDER_PEARL > 0.0) {
                    LootPool.Builder poolBuilderEnderPerls = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(ApocalypseDropsConfigs.CHANCE_ENDER_PEARL))
                            .with(ItemEntry.builder(Items.ENDER_PEARL))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                    tableBuilder.pool(poolBuilderEnderPerls);
                }

                if (ApocalypseDropsConfigs.CHANCE_BONE > 0.0) {
                    LootPool.Builder poolBuilderBones = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(ApocalypseDropsConfigs.CHANCE_BONE))
                            .with(ItemEntry.builder(Items.BONE))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                    tableBuilder.pool(poolBuilderBones);
                }

                if (ApocalypseDropsConfigs.CHANCE_GUNPOWDER > 0.0) {
                    LootPool.Builder poolBuilderGunpowder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(ApocalypseDropsConfigs.CHANCE_GUNPOWDER))
                            .with(ItemEntry.builder(Items.GUNPOWDER))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                    tableBuilder.pool(poolBuilderGunpowder);
                }

                if (ApocalypseDropsConfigs.CHANCE_STRING > 0.0) {
                    LootPool.Builder poolBuilderString = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(ApocalypseDropsConfigs.CHANCE_STRING))
                            .with(ItemEntry.builder(Items.STRING))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                    tableBuilder.pool(poolBuilderString);
                }

                if (ApocalypseDropsConfigs.CHANCE_SPIDER_EYE > 0.0) {
                    LootPool.Builder poolBuilderSpiderEye = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(ApocalypseDropsConfigs.CHANCE_SPIDER_EYE))
                            .with(ItemEntry.builder(Items.SPIDER_EYE))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                    tableBuilder.pool(poolBuilderSpiderEye);
                }

                if (ApocalypseDropsConfigs.CHANCE_PHANTOM_MEMBRANE > 0.0) {
                    LootPool.Builder poolBuilderPhantomMembrane = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(ApocalypseDropsConfigs.CHANCE_PHANTOM_MEMBRANE))
                            .with(ItemEntry.builder(Items.PHANTOM_MEMBRANE))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                    tableBuilder.pool(poolBuilderPhantomMembrane);
                }

                if (ApocalypseDropsConfigs.CHANCE_POTATO > 0.0) {
                    LootPool.Builder poolBuilderPotato = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(ApocalypseDropsConfigs.CHANCE_POTATO))
                            .with(ItemEntry.builder(Items.POTATO))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                    tableBuilder.pool(poolBuilderPotato);
                }

                if (ApocalypseDropsConfigs.CHANCE_CARROT > 0.0) {
                    LootPool.Builder poolBuilderCarrot = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(ApocalypseDropsConfigs.CHANCE_CARROT))
                            .with(ItemEntry.builder(Items.CARROT))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                    tableBuilder.pool(poolBuilderCarrot);
                }

                if (ApocalypseDropsConfigs.CHANCE_BLAZE_ROD > 0.0) {
                    LootPool.Builder poolBuilderBlazePowder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(ApocalypseDropsConfigs.CHANCE_BLAZE_ROD))
                            .with(ItemEntry.builder(Items.BLAZE_ROD))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                    tableBuilder.pool(poolBuilderBlazePowder);
                }

                if (ApocalypseDropsConfigs.CHANCE_NETHER_WART > 0.0) {
                    LootPool.Builder poolBuilderNetherWart = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(ApocalypseDropsConfigs.CHANCE_NETHER_WART))
                            .with(ItemEntry.builder(Items.NETHER_WART))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                    tableBuilder.pool(poolBuilderNetherWart);
                }
            }
        });
    }
}



