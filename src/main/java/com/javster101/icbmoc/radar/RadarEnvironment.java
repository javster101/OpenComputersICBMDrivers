package com.javster101.icbmoc.radar;

import com.javster101.icbmoc.ICBMEnvironment;
import icbm.classic.content.machines.launcher.screen.TileLauncherScreen;
import icbm.classic.content.machines.radarstation.TileRadarStation;
import icbm.classic.content.missile.EntityMissile;
import li.cil.oc.api.machine.Arguments;
import li.cil.oc.api.machine.Callback;
import li.cil.oc.api.machine.Context;
import net.minecraft.util.math.Vec3d;

public class RadarEnvironment extends ICBMEnvironment<TileRadarStation> {
    public RadarEnvironment(TileRadarStation tile) {
        super("icbmbase", tile);
    }

    @Callback(doc = "function():int - Gets the alarm range of the radar")
    public Object[] getAlarmRange(final Context context, Arguments arguments)
    {
        return new Object[] { tile.alarmRange };
    }

    @Callback(doc = "function():int - Gets the amount of detected entities")
    public Object[] getDetectedEntityCount(final Context context, Arguments arguments)
    {
        return new Object[] { tile.detectedEntities.size() };
    }

    @Callback(doc = "function(int):double - Returns the distance from the radar to the given missile")
    public Object[] getDistanceToRadar(final Context context, Arguments arguments)
    {
        if(arguments.checkInteger(0) >= tile.detectedEntities.size()) return new Object[] {-1};
        return new Object[] {tile.detectedEntities.get(arguments.checkInteger(0)).getPositionVector().distanceTo(
                new Vec3d(tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ()))};
    }

    @Callback(doc = "function():boolean - Returns if there is a missile detected by this radar that is going to impact within the safety range")
    public Object[] isMissileGoingToHit(final Context context, Arguments arguments)
    {
        return new Object[] {tile.detectedEntities.stream()
                                    .filter(e -> e instanceof EntityMissile)
                                    .anyMatch(e -> tile.isMissileGoingToHit((EntityMissile) e))};
    }


}
