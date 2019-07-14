package com.xiaolian.mpaasdemo.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.alipay.mobile.framework.LauncherApplicationAgent;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider;
import com.alipay.mobile.nebula.util.H5Utils;


/**
 * Created by mPaaS on 16/9/28.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.xiaolian.mpaasdemo.launcher.R.layout.main);


        findViewById(R.id.jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String appId = "1111111111111111";
                Bundle bundle = new Bundle();
//                bundle.putString(H5Param.PAGE, "/index.html#pages/todos/todos");
                LauncherApplicationAgent.getInstance().getMicroApplicationContext().startApp(null, appId, bundle);

            }
        });
    }
}
