package net.petemc.apocalypsedrops.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import net.petemc.apocalypsedrops.config.ApocalypseDropsConfig;
import org.jetbrains.annotations.NotNull;

/**
 * Adds the apocalypse drops to the loot of zombies and husks. The chances are read from the config every time
 * the loot is rolled.
 */
public class ApocalypseDropsLootModifier extends LootModifier {
    public static final MapCodec<ApocalypseDropsLootModifier> CODEC = RecordCodecBuilder.mapCodec(inst ->
            codecStart(inst).apply(inst, ApocalypseDropsLootModifier::new));

    public ApocalypseDropsLootModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        // The entity is checked instead of the loot table id. Drowned, zombie villagers etc. are other
        // entity types and stay unchanged.
        Entity entity = context.getOptionalParameter(LootContextParams.THIS_ENTITY);
        EntityType<?> type = entity == null ? null : entity.getType();
        boolean enabled = (type == EntityType.ZOMBIE && ApocalypseDropsConfig.ENABLE_ZOMBIE_DROPS.get())
                || (type == EntityType.HUSK && ApocalypseDropsConfig.ENABLE_HUSK_DROPS.get());
        if (!enabled) {
            return generatedLoot;
        }
        RandomSource random = context.getRandom();
        roll(generatedLoot, random, Items.ENDER_PEARL, ApocalypseDropsConfig.ENDER_PEARL_DROP_CHANCE);
        roll(generatedLoot, random, Items.BONE, ApocalypseDropsConfig.BONE_DROP_CHANCE);
        roll(generatedLoot, random, Items.GUNPOWDER, ApocalypseDropsConfig.GUNPOWDER_DROP_CHANCE);
        roll(generatedLoot, random, Items.STRING, ApocalypseDropsConfig.STRING_DROP_CHANCE);
        roll(generatedLoot, random, Items.SPIDER_EYE, ApocalypseDropsConfig.SPIDER_EYE_DROP_CHANCE);
        roll(generatedLoot, random, Items.PHANTOM_MEMBRANE, ApocalypseDropsConfig.PHANTOM_MEMBRANE_DROP_CHANCE);
        roll(generatedLoot, random, Items.POTATO, ApocalypseDropsConfig.POTATO_DROP_CHANCE);
        roll(generatedLoot, random, Items.CARROT, ApocalypseDropsConfig.CARROT_DROP_CHANCE);
        roll(generatedLoot, random, Items.BLAZE_ROD, ApocalypseDropsConfig.BLAZE_ROD_DROP_CHANCE);
        roll(generatedLoot, random, Items.NETHER_WART, ApocalypseDropsConfig.NETHER_WART_DROP_CHANCE);
        return generatedLoot;
    }

    private static void roll(ObjectArrayList<ItemStack> loot, RandomSource random, Item item, ModConfigSpec.DoubleValue chance) {
        double value = chance.get();
        if (value > 0.0 && random.nextFloat() < (float) value) {
            loot.add(new ItemStack(item));
        }
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
