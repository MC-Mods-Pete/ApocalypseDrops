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
import net.petemc.apocalypsedrops.config.ApocalypseDropsConfig;

public class ApocalypseDropsLootTableModifiers {

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((id, tableBuilder, source) -> {
            if ((EntityType.ZOMBIE.getLootTableId() == id && source.isBuiltin() && ApocalypseDropsConfig.INSTANCE.enableZombieDrops) ||
                (EntityType.HUSK.getLootTableId()   == id && source.isBuiltin() && ApocalypseDropsConfig.INSTANCE.enableHuskDrops)) {
                if (ApocalypseDropsConfig.INSTANCE.enderPearlDropChance > 0.0) {
                    LootPool.Builder poolBuilderEnderPerls = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder((float) ApocalypseDropsConfig.INSTANCE.enderPearlDropChance))
                            .with(ItemEntry.builder(Items.ENDER_PEARL))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                    tableBuilder.pool(poolBuilderEnderPerls);
                }

                if (ApocalypseDropsConfig.INSTANCE.boneDropChance > 0.0) {
                    LootPool.Builder poolBuilderBones = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder((float) ApocalypseDropsConfig.INSTANCE.boneDropChance))
                            .with(ItemEntry.builder(Items.BONE))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                    tableBuilder.pool(poolBuilderBones);
                }

                if (ApocalypseDropsConfig.INSTANCE.gunpowderDropChance > 0.0) {
                    LootPool.Builder poolBuilderGunpowder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder((float) ApocalypseDropsConfig.INSTANCE.gunpowderDropChance))
                            .with(ItemEntry.builder(Items.GUNPOWDER))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                    tableBuilder.pool(poolBuilderGunpowder);
                }

                if (ApocalypseDropsConfig.INSTANCE.stringDropChance > 0.0) {
                    LootPool.Builder poolBuilderString = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder((float) ApocalypseDropsConfig.INSTANCE.stringDropChance))
                            .with(ItemEntry.builder(Items.STRING))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                    tableBuilder.pool(poolBuilderString);
                }

                if (ApocalypseDropsConfig.INSTANCE.spiderEyeDropChance > 0.0) {
                    LootPool.Builder poolBuilderSpiderEye = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder((float) ApocalypseDropsConfig.INSTANCE.spiderEyeDropChance))
                            .with(ItemEntry.builder(Items.SPIDER_EYE))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                    tableBuilder.pool(poolBuilderSpiderEye);
                }

                if (ApocalypseDropsConfig.INSTANCE.phantomMembraneDropChance > 0.0) {
                    LootPool.Builder poolBuilderPhantomMembrane = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder((float) ApocalypseDropsConfig.INSTANCE.phantomMembraneDropChance))
                            .with(ItemEntry.builder(Items.PHANTOM_MEMBRANE))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                    tableBuilder.pool(poolBuilderPhantomMembrane);
                }

                if (ApocalypseDropsConfig.INSTANCE.potatoDropChance > 0.0) {
                    LootPool.Builder poolBuilderPotato = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder((float) ApocalypseDropsConfig.INSTANCE.potatoDropChance))
                            .with(ItemEntry.builder(Items.POTATO))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                    tableBuilder.pool(poolBuilderPotato);
                }

                if (ApocalypseDropsConfig.INSTANCE.carrotDropChance > 0.0) {
                    LootPool.Builder poolBuilderCarrot = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder((float) ApocalypseDropsConfig.INSTANCE.carrotDropChance))
                            .with(ItemEntry.builder(Items.CARROT))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                    tableBuilder.pool(poolBuilderCarrot);
                }

                if (ApocalypseDropsConfig.INSTANCE.blazeRodDropChance > 0.0) {
                    LootPool.Builder poolBuilderBlazePowder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder((float) ApocalypseDropsConfig.INSTANCE.blazeRodDropChance))
                            .with(ItemEntry.builder(Items.BLAZE_ROD))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                    tableBuilder.pool(poolBuilderBlazePowder);
                }

                if (ApocalypseDropsConfig.INSTANCE.netherWartDropChance > 0.0) {
                    LootPool.Builder poolBuilderNetherWart = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder((float) ApocalypseDropsConfig.INSTANCE.netherWartDropChance))
                            .with(ItemEntry.builder(Items.NETHER_WART))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                    tableBuilder.pool(poolBuilderNetherWart);
                }
            }
        });
    }

}



