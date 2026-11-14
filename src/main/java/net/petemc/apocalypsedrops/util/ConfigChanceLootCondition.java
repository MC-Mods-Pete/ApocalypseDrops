package net.petemc.apocalypsedrops.util;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

/**
 * Loot condition that reads the drop chance from the config every time the loot is rolled.
 * A condition with a fixed chance would be baked into the loot table when it is loaded, so
 * changes made in the config screen would only apply after a reload or restart.
 * The condition is only added at runtime and never serialized, so it reuses the vanilla
 * random chance codec.
 */
public class ConfigChanceLootCondition implements LootItemCondition {
    private final BooleanSupplier enabled;
    private final DoubleSupplier chance;

    public ConfigChanceLootCondition(BooleanSupplier enabled, DoubleSupplier chance) {
        this.enabled = enabled;
        this.chance = chance;
    }

    @Override
    public MapCodec<LootItemRandomChanceCondition> codec() {
        return LootItemRandomChanceCondition.MAP_CODEC;
    }

    @Override
    public boolean test(LootContext context) {
        double value = chance.getAsDouble();
        return enabled.getAsBoolean() && value > 0.0 && context.getRandom().nextFloat() < (float) value;
    }
}
