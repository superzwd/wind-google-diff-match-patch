import java.util.List;

/**
 * Created by zhangwd4 on 2018/1/12.
 */
public class Test {
    public static void main(String args[]){
        diff_match_patch dmp = new diff_match_patch();
        List<diff_match_patch.Diff> list = dmp.diff_main("123456789", "012356889");
        System.out.println(list);
    }
}
