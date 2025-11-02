package org.emp.gl.core.launcher;

import org.emp.gl.clients.Horloge;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;

public class App {
    public static void main(String[] args) throws InterruptedException {
        // إنشاء الخدمة الزمنية
        DummyTimeServiceImpl timer = new DummyTimeServiceImpl();

        // إنشاء ساعة وربطها بالمؤقت
        Horloge h1 = new Horloge("Num 1");
        h1.setTimerService(timer);

        // تشغيل التطبيق لمدة 10 ثوانٍ
        Thread.sleep(10000);
    }
}
