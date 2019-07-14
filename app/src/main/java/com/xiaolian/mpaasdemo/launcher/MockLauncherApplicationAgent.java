package com.xiaolian.mpaasdemo.launcher;

import android.app.Application;
import android.util.Log;

import com.alipay.mobile.framework.LauncherApplicationAgent;
import com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider;
import com.alipay.mobile.nebula.util.H5Utils;

/**
 * Created by seker on 16/2/18.
 */
public class MockLauncherApplicationAgent extends LauncherApplicationAgent {

    public MockLauncherApplicationAgent(Application context, Object bundleContext) {
        super(context, bundleContext);
    }

    @Override
    public void preInit() {
        super.preInit();
        // 内置小程序资源包

    }


    @Override
    public void postInit() {
        super.postInit();
        Log.e("tag","MockLauncherApplicationAgent");

        // 内置小程序资源包
        H5Utils.setProvider(H5AppCenterPresetProvider.class.getName(), new H5AppCenterPresetProviderImpl());
//        // 这里事先关闭下H5离线包验签功能
        H5Utils.setProvider(H5ExtConfigProvider.class.getName(), new H5ExtConfigProvider() {
            @Override
            public String getConfig(String s) {
                if ("h5_shouldverifyapp".equalsIgnoreCase(s)) {
                    return "NO";
                }
                return null;
            }
        });

    }
}
