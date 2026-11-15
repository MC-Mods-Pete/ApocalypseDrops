package net.petemc.apocalypsedrops;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.petemc.apocalypsedrops.config.ApocalypseDropsConfig;
import net.petemc.apocalypsedrops.loot.ApocalypseDropsLootModifier;
import org.slf4j.Logger;

@Mod(ApocalypseDrops.MOD_ID)
public class ApocalypseDrops {
    public static final String MOD_ID = "apocalypsedrops";
    public static final Logger LOGGER = LogUtils.getLogger();

    private static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS =
            DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, MOD_ID);

    static {
        LOOT_MODIFIERS.register("apocalypse_drops", () -> ApocalypseDropsLootModifier.CODEC);
    }

    public ApocalypseDrops(IEventBus modEventBus, ModContainer modContainer) {
        LOGGER.info("Initializing Apocalypse Drops Mod");
        LOOT_MODIFIERS.register(modEventBus);
        modContainer.registerConfig(configType(), ApocalypseDropsConfig.SPEC, MOD_ID + "-common.toml");
    }

    /**
     * FML renamed ModConfig.Type.COMMON to LOCAL during 26.3. Looked up by name so that one jar works with both.
     */
    private static ModConfig.Type configType() {
        try {
            return ModConfig.Type.valueOf("COMMON");
        } catch (IllegalArgumentException e) {
            return ModConfig.Type.valueOf("LOCAL");
        }
    }
}
