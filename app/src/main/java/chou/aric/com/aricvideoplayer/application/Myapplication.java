package chou.aric.com.aricvideoplayer.application;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.baidu.crabsdk.CrabSDK;
import com.tencent.bugly.crashreport.CrashReport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by aric on 2017/3/10.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
      initCrab();

        Context context = getApplicationContext();
// 获取当前包名
        String packageName = context.getPackageName();
// 获取当前进程名
        String processName = getProcessName(android.os.Process.myPid());
// 设置是否为上报进程
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
// 初始化Bugly
        CrashReport.initCrashReport(context, "be4fba3d63", false, strategy);
    }



    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    private static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    private void initCrab() {
        CrabSDK.init(this,"89b7ae101dfe9e04");
        CrabSDK.setBehaviorRecordLimit(20);
        CrabSDK.setCollectScreenshot(true);
        CrabSDK.setSendPrivacyInformation(true);
        CrabSDK.setUserName("AricVideo");
        CrabSDK.setUid("12345678967");
        CrabSDK.setUploadLimitOfSameCrashInOneday(200);
        CrabSDK.setUploadLimitOfCrashInOneday(-1);
        CrabSDK.setUploadLimitOfAnrInOneday(-1);
        CrabSDK.setDebugMode(true);
    }
}
