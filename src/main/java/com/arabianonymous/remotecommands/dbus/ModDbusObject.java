package com.arabianonymous.remotecommands.dbus;

import org.freedesktop.dbus.connections.impl.DBusConnection;
import org.freedesktop.dbus.exceptions.DBusException;
import net.minecraft.client.Minecraft;


public class ModDbusObject implements ModDbusInterface {

    private DBusConnection m_conn;

    public ModDbusObject() throws DBusException {
        /* Get a connection to the session bus so we can request a bus name */
        m_conn = DBusConnection.getConnection(DBusConnection.DBusBusType.SESSION);
        /* Request a unique bus name */
        m_conn.requestBusName( "com.arabianonymous.remotecommands" );
        /* Export this object onto the bus using the path '/' */
        m_conn.exportObject( getObjectPath(), this );
    }

    @Override
    public void runcommand(String command) {
        Minecraft.getMinecraft().thePlayer.sendChatMessage(command);
    }

    @Override
    public boolean isRemote() {
        /* Whenever you are implementing an object, always return false */
        return false;
    }

    @Override
    public String getObjectPath() {
        /* This is not strictly needed; it is a convenience method for housekeeping
         * on your application side if you will be exporting and unexporting
         * many times
         */
        return "/";
    }


    public static void main(String[] args) throws DBusException {
        new ModDbusObject();
    }
}