import java.lang.reflect.Field;

/**
 * Created by zhaoshengqi on 2018/9/19.
 */
public class RefrenceTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a = 1;
        Integer b = 2;
        swap(a, b);
        System.out.println(a);
        System.out.println(b);

    }

    static void swap(Integer a, Integer b) throws NoSuchFieldException, IllegalAccessException {
        Integer tmp = new Integer(b);
        Field f = Integer.class.getDeclaredField("value");
        f.setAccessible(true);
        f.set(b,a);
        f.set(a,tmp);
    }
}
