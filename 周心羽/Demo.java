package com.example.testnotes;

        import android.os.RemoteException;
        import android.util.Log;

        import androidx.test.platform.app.InstrumentationRegistry;
        import androidx.test.uiautomator.By;
        import androidx.test.uiautomator.UiCollection;
        import androidx.test.uiautomator.UiDevice;
        import androidx.test.uiautomator.UiObject2;
        import androidx.test.uiautomator.UiObjectNotFoundException;
        import androidx.test.uiautomator.UiSelector;

        import org.junit.Before;
        import org.junit.FixMethodOrder;
        import org.junit.Test;
        import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)//按字符字典顺序执行
public class Demo {
    UiDevice mDevice;
    UiCollection collection;

    @Before
    //创建连接
    public void initDevice() throws RemoteException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        if (mDevice.isScreenOn()) {//判断当前屏幕是否是亮的
            mDevice.wakeUp();//唤醒屏幕
        }
        int width = mDevice.getDisplayWidth();
        int height = mDevice.getDisplayHeight();
        Log.i("Width:", String.valueOf(width));
        Log.i("Height:", String.valueOf(height));
    }

    //11注册成功
    @Test
    public void signUpSuccess() throws InterruptedException {
        //点击注册
        mDevice.findObject(By.res("net.onest.timestoryprj:id/btn_register")).click();
        mDevice.findObject(By.res("net.onest.timestoryprj:id/et_res_phone")).setText("15371906891");
        mDevice.findObject(By.res("net.onest.timestoryprj:id/et_res_pwd")).setText("zxy721025");
        mDevice.findObject(By.res("net.onest.timestoryprj:id/btn_res")).click();
    }

    //2登录成功
    @Test
    public void loginSuccess() throws InterruptedException {
        //找到账号并点击
        UiObject2 phone = mDevice.findObject(By.res("net.onest.timestoryprj:id/et_phone"));
        UiObject2 pwd = mDevice.findObject(By.res("net.onest.timestoryprj:id/et_pwd"));
        UiObject2 btn_login = mDevice.findObject(By.res("net.onest.timestoryprj:id/btn_login"));
        phone.setText("15371906891");
        pwd.setText("zxy721025");
        btn_login.click();
    }

    //    3注册并登录
    @Test
    public void signupAndlogin() throws InterruptedException {
        signUpSuccess();
        Thread.sleep(1000);
        loginSuccess();
    }

    //    4退出登录
    @Test
    public void QuitSuccess() throws InterruptedException {
        loginSuccess();
        Thread.sleep(1000);
        //找到退出并点击
        mDevice.findObject(By.res("net.onest.timestoryprj:id/btn_settings")).setText("15371906891");
        mDevice.findObject(By.res("net.onest.timestoryprj:id/btn_exit_login")).setText("zxy721025");
        mDevice.findObject(By.res("net.onest.timestoryprj:id/rightlinear")).click();
    }

    //    5调节音量
    @Test
    public void voiceSet() throws InterruptedException {
        loginSuccess();
        Thread.sleep(1000);
        //找到退出并点击
        mDevice.findObject(By.res("net.onest.timestoryprj:id/btn_settings")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("net.onest.timestoryprj:id/mainlayout")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("net.onest.timestoryprj:id/btn_voice_set")).click();
        Thread.sleep(2000);
        mDevice.swipe(460, 257, 700, 257, 100);
    }

    //    6点击个人资料-修改昵称
    @Test
    public void clickPerson() throws InterruptedException {
        loginSuccess();
        Thread.sleep(1000);
        mDevice.findObject(By.res("net.onest.timestoryprj:id/btn_person")).click();
        mDevice.findObject(By.res("net.onest.timestoryprj:id/iv_jiantou2")).click();
        mDevice.findObject(By.res("net.onest.timestoryprj:id/et_signature")).setText("zzzz");
        mDevice.findObject(By.res("net.onest.timestoryprj:id/btn_signature_save")).click();
        mDevice.findObject(By.res("  net.onest.timestoryprj:id / btn_save")).click();
    }

    //    7点击个人资料-修改个性签名
    @Test
    public void clickPerson1() throws InterruptedException {
        loginSuccess();
        Thread.sleep(1000);
        mDevice.findObject(By.res("net.onest.timestoryprj:id/btn_person")).click();
        mDevice.findObject(By.res("net.onest.timestoryprj:id/tv_niname")).click();
        mDevice.findObject(By.res("net.onest.timestoryprj:id/et_nickname")).setText("天外来客");
        mDevice.findObject(By.res("net.onest.timestoryprj:id/btn_nickname_save")).click();
        mDevice.findObject(By.res("  net.onest.timestoryprj:id / btn_save")).click();
    }

    //    8点击个人资料-更改性别
    @Test
    public void clickPerson2() throws InterruptedException {
        loginSuccess();
        Thread.sleep(1000);
        mDevice.findObject(By.res("net.onest.timestoryprj:id/btn_person")).click();
        mDevice.findObject(By.res("net.onest.timestoryprj:id/woman")).click();
        mDevice.findObject(By.res("  net.onest.timestoryprj:id / btn_save")).click();
    }

    //    9点击查看规则
    @Test
    public void clickRule() throws InterruptedException {
        loginSuccess();
        Thread.sleep(1000);
        mDevice.findObject(By.res("net.onest.timestoryprj:id/btn_rule")).click();
    }

    //    10点击反馈问题
    @Test
    public void clickRightliner() throws InterruptedException {
        loginSuccess();
        Thread.sleep(1000);
        mDevice.findObject(By.res("net.onest.timestoryprj:id/rightlinear")).click();
    }
}





