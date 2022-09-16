package com.ysamy.remotecommands.dbus;

import org.freedesktop.dbus.interfaces.DBusInterface;
import org.freedesktop.dbus.annotations.DBusInterfaceName;

@DBusInterfaceName("com.ysamy.remotecommands")
public interface ModDbusInterface extends DBusInterface {
    public void runcommand(String command);
}
