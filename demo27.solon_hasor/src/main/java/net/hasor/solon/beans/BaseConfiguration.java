package net.hasor.solon.beans;

import org.noear.solon.XApp;

public class BaseConfiguration {
    private BuildConfig buildConfig = BuildConfig.instance;

    public BaseConfiguration(){
        buildConfig.envProperties = XApp.cfg();
    }

    public BuildConfig getBuildConfig() {
        return buildConfig;
    }
}
