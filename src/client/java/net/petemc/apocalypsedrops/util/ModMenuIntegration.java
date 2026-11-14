package net.petemc.apocalypsedrops.util;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfigClient;
import net.petemc.apocalypsedrops.config.ApocalypseDropsConfig;

public class ModMenuIntegration implements ModMenuApi
{
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory()
    {
        return parent -> AutoConfigClient.getConfigScreen(ApocalypseDropsConfig.class, parent).get();
    }
}
