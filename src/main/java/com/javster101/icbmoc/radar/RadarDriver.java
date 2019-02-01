package com.javster101.icbmoc.radar;

import icbm.classic.content.machines.launcher.screen.TileLauncherScreen;
import icbm.classic.content.machines.radarstation.TileRadarStation;
import li.cil.oc.api.driver.DriverBlock;
import li.cil.oc.api.network.ManagedEnvironment;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RadarDriver implements DriverBlock {
    @Override
    public boolean worksWith(World world, BlockPos blockPos, EnumFacing enumFacing) {
        TileEntity tile = world.getTileEntity(blockPos);
        return tile != null && tile instanceof TileRadarStation;
    }

    @Override
    public ManagedEnvironment createEnvironment(World world, BlockPos blockPos, EnumFacing enumFacing) {
        TileRadarStation screen = (TileRadarStation)world.getTileEntity(blockPos);
        return new RadarEnvironment(screen);
    }
}
