package net.hasor.solon.boot;

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
