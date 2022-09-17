package com.arabianonymous.remotecommands;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.arabianonymous.remotecommands.dbus.ModDbusObject;
import org.freedesktop.dbus.exceptions.DBusException;


@Mod(modid = "Remote Commands", version = "1.0.0")
public class RemoteCommands {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) throws DBusException {
        System.out.println("Dirt: " + Blocks.dirt.getUnlocalizedName());
        new ModDbusObject();
    }
}


