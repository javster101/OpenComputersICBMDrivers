package com.javster101.icbmoc;

import com.javster101.icbmoc.launchers.LauncherDriver;
import com.javster101.icbmoc.radar.RadarDriver;
import li.cil.oc.api.Driver;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = OpenComputersICBM.MODID, name = OpenComputersICBM.NAME, version = OpenComputersICBM.VERSION)
public class OpenComputersICBM
{
    public static final String MODID = "examplemod";
    public static final String NAME = "Example Mod";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        Driver.add(new LauncherDriver());
        Driver.add(new RadarDriver());
        logger.info("Loaded OpenComputers ICBM Integration by Javier Coindreau");
    }
}
