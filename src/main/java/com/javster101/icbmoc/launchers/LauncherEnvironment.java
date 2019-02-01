package com.javster101.icbmoc.launchers;

import com.javster101.icbmoc.ICBMEnvironment;
import icbm.classic.content.machines.launcher.screen.TileLauncherScreen;
import li.cil.oc.api.machine.Arguments;
import li.cil.oc.api.machine.Callback;
import li.cil.oc.api.machine.Context;
import net.minecraft.util.math.Vec3d;

public class LauncherEnvironment extends ICBMEnvironment<TileLauncherScreen> {
    public LauncherEnvironment(TileLauncherScreen tile) {
        super("icbmbase", tile);
    }

    @Callback(doc = "function():boolean - Checks if the launcher can launch a missile")
    public Object[] canLaunch(final Context context, Arguments arguments)
    {
        return new Object[] { tile.canLaunch() };
    }

    @Callback(doc = "function() - Fires the missile")
    public Object[] launch(final Context context, Arguments arguments)
    {
        tile.launch();
        return new Object[] {  };
    }

    @Callback(doc = "function():int - Gets the lock height of the missile")
    public Object[] getLockHeight(final Context context, Arguments arguments)
    {
        return new Object[] { tile.lockHeight };
    }
/*
    @Callback(doc = "function():int - Gets the X coordinate of the target")
    public Object[] getTargetX(final Context context, Arguments arguments)
    {
        return new Object[] { tile.getTarget().getX() };
    }

    @Callback(doc = "function():int - Gets the Y coordinate of the target")
    public Object[] getTargetY(final Context context, Arguments arguments)
    {
        return new Object[] { tile.getTarget().getY() };
    }

    @Callback(doc = "function():int - Gets the Z coordinate of the target")
    public Object[] getTargetZ(final Context context, Arguments arguments)
    {
        return new Object[] { tile.getTarget().getZ() };
    }*/

    @Callback(doc = "function(int) - Sets the X coordinate of the target")
    public Object[] setTargetX(final Context context, Arguments arguments)
    {
        tile.setTarget(tile.getTarget().add(new Vec3d(arguments.checkDouble(0), 0, 0)));
        return new Object[] {  };
    }

    @Callback(doc = "function(int) - Sets the Y coordinate of the target")
    public Object[] setTargetY(final Context context, Arguments arguments)
    {
        tile.setTarget(tile.getTarget().add(new Vec3d(0, arguments.checkDouble(0), 0)));
        return new Object[] { };
    }

    @Callback(doc = "function(int) - Sets the XZ coordinate of the target")
    public Object[] setTargetZ(final Context context, Arguments arguments)
    {
        tile.setTarget(tile.getTarget().add(new Vec3d(0, 0, arguments.checkDouble(0))));
        return new Object[] {  };
    }
}
