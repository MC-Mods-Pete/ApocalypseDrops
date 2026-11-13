package net.petemc.apocalypsedrops.util;

import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.LootConditionTypes;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.condition.LootConditionType;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

/**
 * Loot condition that reads the drop chance from the config every time the loot is rolled.
 * A condition with a fixed chance would be baked into the loot table when it is loaded, so
 * changes made in the config screen would only apply after a reload or restart.
 * The condition is only added at runtime and never serialized, so it reuses the vanilla
 * random chance type.
 */
public class ConfigChanceLootCondition implements LootCondition {
    private final BooleanSupplier enabled;
    private final DoubleSupplier chance;

    public ConfigChanceLootCondition(BooleanSupplier enabled, DoubleSupplier chance) {
        this.enabled = enabled;
        this.chance = chance;
    }

    @Override
    public LootConditionType getType() {
        return LootConditionTypes.RANDOM_CHANCE;
    }

    @Override
    public boolean test(LootContext context) {
        double value = chance.getAsDouble();
        return enabled.getAsBoolean() && value > 0.0 && context.getRandom().nextFloat() < (float) value;
    }
}
