package net.petemc.apocalypsedrops;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.petemc.apocalypsedrops.config.ApocalypseDropsConfig;
import net.petemc.apocalypsedrops.loot.ApocalypseDropsLootModifier;
import org.slf4j.Logger;

@Mod(ApocalypseDrops.MOD_ID)
public class ApocalypseDrops {
    public static final String MOD_ID = "apocalypsedrops";
    public static final Logger LOGGER = LogUtils.getLogger();

    private static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, MOD_ID);

    @SuppressWarnings("unused")
    private static final RegistryObject<Codec<? extends IGlobalLootModifier>> APOCALYPSE_DROPS =
            LOOT_MODIFIERS.register("apocalypse_drops", ApocalypseDropsLootModifier.CODEC);

    public ApocalypseDrops() {
        LOGGER.info("Initializing Apocalypse Drops Mod");
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        LOOT_MODIFIERS.register(modEventBus);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ApocalypseDropsConfig.SPEC);
    }
}
