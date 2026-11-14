package net.petemc.apocalypsedrops;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

/** Registers the built-in NeoForge config screen (Mods list, Config button) on the client. */
@Mod(value = ApocalypseDrops.MOD_ID, dist = Dist.CLIENT)
public class ApocalypseDropsClient {
    public ApocalypseDropsClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
