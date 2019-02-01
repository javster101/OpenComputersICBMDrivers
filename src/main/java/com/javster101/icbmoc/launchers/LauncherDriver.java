package com.javster101.icbmoc.launchers;

import com.javster101.icbmoc.ICBMEnvironment;
import icbm.classic.content.machines.launcher.screen.TileLauncherScreen;
import li.cil.oc.api.driver.DriverBlock;
import li.cil.oc.api.network.ManagedEnvironment;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LauncherDriver implements DriverBlock {
    @Override
    public boolean worksWith(World world, BlockPos blockPos, EnumFacing enumFacing) {
        TileEntity tile = world.getTileEntity(blockPos);
        return tile != null && tile instanceof TileLauncherScreen;
    }

    @Override
    public ManagedEnvironment createEnvironment(World world, BlockPos blockPos, EnumFacing enumFacing) {
        TileLauncherScreen screen = (TileLauncherScreen)world.getTileEntity(blockPos);
        return new LauncherEnvironment(screen);
    }
}
