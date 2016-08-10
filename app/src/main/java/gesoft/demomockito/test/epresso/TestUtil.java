package gesoft.demomockito.test.epresso;

/**
 * Created by yhr on 2016/8/10.
 * 测试时会用到的通用方法
 */

public class TestUtil {

    /**
     * 暂停
     * @param time 暂停时间 单位毫秒
     */
    public static void sleep( long time ){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
