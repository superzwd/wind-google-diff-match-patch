import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

/**
 * Created by zhangwd4 on 2018/1/12.
 */
public class Test {
    public static void main(String args[]) throws Exception {

        String sanguozhi =
                FileUtils.readFileToString(new File("api/src/main/resources/三国志.txt"), Charset.defaultCharset());
        String shiji = FileUtils.readFileToString(new File("api/src/main/resources/史记.txt"), Charset.defaultCharset());

        diff_match_patch dmp = new diff_match_patch();
        dmp.Diff_Timeout = -1.0f;

        new Thread(() -> {
            int count = 0;
            for (; ; ) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(count);
                count++;
                if (count >= 100) {
                    Runtime.getRuntime().halt(1);
                }
            }

        }).start();

        List<diff_match_patch.Diff> list = dmp.diff_main(sanguozhi, shiji);
        System.out.println(list);
    }
}
