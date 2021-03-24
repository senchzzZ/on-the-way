import com.exp.zsq.defaultMethod.TestDefaultMethod;
import com.exp.zsq.defaultMethod.TestDefaultMethodImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.IntUnaryOperator;

import static java.text.Collator.SECONDARY;

/**
 * Created by zhaoshengqi on 2017/7/25.
 */
public class Tem {

    String str = new String("init");
    //static transient volatile Node head;

    //private static transient volatile int transferIndex;

    private static final Set<Integer>  integerSet = new HashSet<>();

    public static void changePrim(Integer a,GeneralBean bean,String s,int b,String global) {
        a = Integer.valueOf(299);
        s = "abc";
        b = 10000;
        bean.setB("C");
        global = "cccc";
        System.out.println(a);
        bean = new GeneralBean("c","d");
        System.out.println(s);
        System.out.println(b);
        System.out.println(global);
        System.out.println();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class GeneralBean{
        String a;
        String b;
    }

    public static void testParams(List list) {
        System.out.println(list);
    }

    public static void main(String[] args)  {
        /*String str1 = "what";
        String str2 = str1 + " a nice day";
        System.out.println("what a nice day".equals(str2));
        System.out.println("what a nice day" == str2);*/
//        String str1 = "what a nice day";
//        String str2 = new String("what a nice day");
//        System.out.println(str1.equals(str2));
//        System.out.println(str1 == str2);
        String str1 = "what";
        String str2 = str1.concat(" a nice day");
        System.out.println("what a nice day".equals(str2));
        System.out.println("what a nice day" == str2);
        System.out.println("what a nice day"==str2.intern());

       /* List<String> list = null;
        testParams(list);

        Tem tem = new Tem();
        Integer i = 200;
        String z = "zzz";
        int b = 2000;
        GeneralBean bean = new GeneralBean("a","b");
        changePrim(i, bean,z,b,tem.str);

        System.out.println(i);
        System.out.println(z);
        System.out.println(b);
        System.out.println(tem.str);
        System.out.println(bean);*/

        /*Long a = Long.MAX_VALUE;
        Long a1 = 1l;
        System.out.println(a);
        System.out.println(a/100000/3600/24/365);
        System.out.println(Integer.MAX_VALUE/100000/3600/24/365);*/
        /*Integer a = 128;
        Integer b = 128;
        int c = 128;
        Integer d = 127;
        Integer e = 127;
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(d == e);*/

        /*Integer a = 12321;
        System.out.println(a);*/
        //System.out.println(Integer.valueOf(" ",36));

        /*Long h = 30000094l;
        String s = "30000094";
        System.out.println(h == Long.valueOf(s));
        System.out.println(h == Long.valueOf(s).longValue());
        System.out.println(h.equals(Long.valueOf(s)));
        System.out.println(h == Long.parseLong(s));
        System.out.println();
        System.out.println(s == h.toString());
        System.out.println(s.equals(h.toString()));
        System.out.println();

        Integer i = 54321;
        String si = "54321";
        System.out.println(i == Integer.valueOf(si));
        System.out.println(i == Integer.parseInt(si));*/

        /*Set<Long> set = new HashSet<>();
        List<Long> list1 = new ArrayList<>(Arrays.asList(12345l,11111l,222222l,33333l,44444l));
        List<Long> list2 = new ArrayList<>(Arrays.asList(12345l,11111l,222222l,33333l,44444l,55555l));
        set.addAll(list1);
        set.addAll(list2);
        System.out.println(set);*/

        /*List<Map<String, String>> body = new ArrayList<>();
        Map<String, String> pair = new HashMap<>();
        Map<String, String> tpair = new HashMap<>();
        pair.put("name", "content");
        pair.put("value", "content");
        pair.put("type", "1");//（"1"：普通文本；"2": 数字[和数字有关的都是改类型] ；"3": 时间类型；）
        body.add(pair);

        tpair.put("name", "title");
        tpair.put("value", "title");
        tpair.put("type", "1");//（"1"：普通文本；"2": 数字[和数字有关的都是改类型] ；"3": 时间类型；）
        body.add(tpair);
        System.out.println(body);*/

        //System.out.println(String.format("%.2f", new BigDecimal(0.04906205).doubleValue()*100));

        /*if(false && isExcute()){

        }*/
       /* int i=0;
        int j=0;
        System.out.println(i++ == 0);
        System.out.println(++i == 2);
        System.out.println(++j == 1);
        System.out.println(++j == 2);*/
      /*  int n = 15;
       for (int i = 0;i<100;i++){
           System.out.println((i & n));
           System.out.println((i)%15);

       }*/
      /*String s = null;
      String p = "1";
      //p = s;
        System.out.println((p=s) ==null);*/
      /*for (;;){
          int i=0;
          int j=100;
          ++i;
          System.out.println("i = "+i);
          for (;;--j){
              System.out.println("j = "+j + " i = "+i);
          }
      }*/
        //System.out.println(nextSecondarySeed());

        //System.out.println(Integer.toBinaryString(0x8000001));
        /*int i = 0;
        for(;;){
            System.out.println("start");
            i++;
            if (i>10){
                System.out.println("break");
                break;
            }
            if(i>=3){
                System.out.println(i);
                System.out.println("continue");
                continue;
            }
            TimeUnit.SECONDS.sleep(3);
        }*/

        /*BigDecimal a = new BigDecimal(2);
        BigDecimal b = new BigDecimal(3);
        int c=0;
        c = (int) (a.divide(b,2,BigDecimal.ROUND_HALF_DOWN).doubleValue()*100);
        System.out.println(c);*/
        /*class ValueComparator implements Comparator<String> {

            Map<String, Double> base;
            public ValueComparator(Map<String, Double> base) {
                this.base = base;
            }

            // Note: this comparator imposes orderings that are inconsistent with equals.
            public int compare(String a, String b) {
                if (base.get(a) >= base.get(b)) {
                    return -1;
                } else {
                    return 1;
                } // returning 0 would merge keys
            }
        }
        HashMap<String,Double> map = new HashMap<String,Double>();
        ValueComparator bvc =  new ValueComparator(map);
        TreeMap<String,Double> sorted_map = new TreeMap<String,Double>(bvc);

        Map<String,Double> localEntry = new HashMap<>();


        map.put("A",99.5);
        map.put("B",67.4);
        map.put("C",66.4);
        map.put("D",67.3);

        System.out.println("unsorted map: "+map);

        sorted_map.putAll(map);

        System.out.println("results: "+sorted_map);*/

        /*HashMap<String,Double> map = new HashMap<String,Double>();

        Map<String,Double> localEntry = new HashMap<>();
        localEntry.put("B",67.4);

        map.put("A",99.5);
        map.put("B",67.4);
        map.put("C",66.4);
        map.put("D",67.3);
        map.put("E",63.3);

        System.out.println("unsorted map: "+map);

        //排序
        List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String,Double>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1,
                               Map.Entry<String, Double> o2) {
                if (o1.getValue() >= o2.getValue()){
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        System.out.println("results: "+list);
        System.out.println(list.indexOf(localEntry.entrySet().iterator().next()));*/

        /*for (int i=0,j=1;;){

            System.out.println("i="+i+" , j="+j);
            TimeUnit.SECONDS.sleep(3);
            j=3;
        }*/


        /*Integer i = 0;
        Integer t = i;
        i=1;
        Integer p = 1;

        *//*System.out.println(t);
        System.out.println(t==(t=i));
        System.out.println(t);*//*
        System.out.println(p = t!=(t=i)?t:2);*/
        //结论：先判断再赋值



/* 00000001 << 1 = 00000010 *//*
        1 << 1 == 2

*//* 00000001 << 3 = 00001000 *//*
        1 << 3 == 8

*//* 11111111 11111111 11111111 11110000 >> 4 = 11111111 11111111 11111111 11111111 *//*
        0xFFFFFFF0 >> 4 == 0xFFFFFFFF

*//* 00001111 11111111 11111111 11111111 >> 4 = 00000000 11111111 11111111 11111111 *//*
        0x0FFFFFFF >> 4 == 0x00FFFFFF

*//* 10000000 00000000 00000000 00000000 >>> 1 = 01000000 00000000 00000000 00000000 *//*
        0x80000000 >>> 1 == 0x40000000

*//* 10000000 00000000 00000000 00000000 >> 1 = 11000000 00000000 00000000 00000000 *//*
        0x80000000 >> 1  == 0xC0000000*/

        //System.out.println(~10);

        /*int tab = 5;
        for(int a = tab;;){
            System.out.println(a);
        }*/


        /*Node tail = new Node("node","next");
        Node t = tail,p = t;

        t.setNext("null");

        System.out.println(p==t);
        System.out.println(tail.toString());
        System.out.println(t.toString());
        System.out.println(p.toString());*/
        //结论：引用传递


        /*for(int i = 0 ;;){
            if (i>3){
                System.out.println(i);
                if(false){
                    System.out.println(i);
                }
                return;
            }
            System.out.println(i++);
            TimeUnit.SECONDS.sleep(1);
        }*/

        /*Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1498121334000l);
        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.println(days);*/
        /*int size=5;
        int i = size;
        size = i+1;
        System.out.println(i);
        System.out.println(size);*/

       /* int i = 2;
        int j = 2;
        System.out.println(--i);
        int k = --i;
        int l = j--;
        System.out.println(k);
        System.out.println(l);
        System.out.println(i);
        System.out.println(j);*/
        //结论：符号在前先执行算法操作再赋值

        /*List<String> list = new ArrayList<>();
        list.add("诶");
        list.add("bi");
        list.add("算法");
        list.add("执行");
        System.out.println(list);

        Iterator<String> it = list.iterator();

        while (it.hasNext()){
            String s = it.next();
            if (s!="算法" && s!="执行"){
                it.remove();
            }
        }
        System.out.println(list);*/

        //System.out.println(2|1);



        /*Node head = new Node("item","next");

        Node h = head,p = h;

        System.out.println("old head: "+head.toString());

        if (p.casItem("item","new item")){
        //if (unsafe.compareAndSwapObject(Node.class, unsafe.objectFieldOffset
                //(Node.class.getDeclaredField("node")), "item","new item")){
            for (Node q = p; q!=h;){
                System.out.println("q!=h");
            }
            Node q = p;
            System.out.println(q!=h);
            System.out.println("h: "+h.toString());
            System.out.println("p: "+p.toString());
            System.out.println("q: "+q.toString());
            System.out.println("after cas,head: "+head);
        }*/
//----------------------------Unsafe---------------------------------------
        /*Unsafe u = getUnsafeInstance();

        Node[] narr = new Node[500];
        int b = u.arrayBaseOffset(Node[].class);
        int s = u.arrayIndexScale(Node[].class);
        System.out.println(b);
        System.out.println(s);

        int ASHIFT = 31 - Integer.numberOfLeadingZeros(s);

        Node n = new Node("item","next");
        int i = (((narr.length-1) & 1) << ASHIFT)+b;

        System.out.println(i);
        u.putOrderedObject(narr,i ,n);
        System.out.println(Arrays.toString(narr));*/

        /*int oldSum = 0, checkSum = 0;
        do {
            if (checkSum != 100)
                checkSum += 10;
            System.out.println("checkSum = "+checkSum+",oldSum = "+oldSum);
        }while (oldSum != (oldSum = checkSum));

        checkSum += 10;
        System.out.println(oldSum != (oldSum = checkSum));*/


        /*Unsafe u = getUnsafeInstance();
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11};

        int b = u.arrayBaseOffset(char[].class);//数组第一个元素的偏移地址
        int s = u.arrayIndexScale(boolean[].class);//数组中元素的增量地址，也就是说每个元素的占位数

        System.out.println(b);
        System.out.println(s);

        u.putInt(arr, (long)b+s*9, 1);

        System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++){
            int v = u.getInt(arr, (long)b+s*i);
            System.out.print(v+",");
        }*/

//------------------------------------------------------------------------

       /*BigDecimal b = BigDecimal.ZERO;
       b = b.add(new BigDecimal(0.0));
        System.out.println(b==BigDecimal.ZERO);*/

        //System.out.println(Integer.toBinaryString(((-10 << 48))));


        //System.out.println("2.24.1".compareTo("2.24.0"));
        /*int r = 12;
        r ^= r << 6; r ^= r >>> 21; r ^= r << 7;

        System.out.println(100 & 0xffff);*/

        /*String str1 = new StringBuilder("i'm").append(" T").toString();
        System.out.println(str1.intern()==str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern()==str2);

        String str3 = "i'm T";
        System.out.println(str3.intern()==str1.intern());*/

//-----------------------IntUnaryOperator---------------------------
       /* IntUnaryOperator iu = x -> x*10;
        System.out.println(iu.applyAsInt(100));*/

        /*String str = "我我我\uD83D\uDE02\uD83D\uDE02\uD83D\uDE02\uD83D\uDE02\uD83D\uDE02\uD83D\uDE02";
        System.out.println(str);
        String encStr = Base64.getEncoder().encodeToString(str.getBytes());
        System.out.println(encStr);
        String decStr = new String(Base64.getDecoder().decode(encStr));
        System.out.println(decStr);
        System.out.println(decStr.length());*/

        /*String manageTopic = "123,oij,2178d";
        String[] manageTopics = manageTopic.split(",");
        List<String> questionTags = Arrays.asList(manageTopics);

        questionTags.forEach(System.out::println);*/


        //int sizeCtl = -2;
        //System.out.println(Integer.toBinaryString(sizeCtl >>> 16));
        //System.out.println(Integer.numberOfLeadingZeros(16) );

        /*System.out.println(Integer.toBinaryString(0x7fffffff));
        int hashCode = new Node("node","next").hashCode();
        int hash = (hashCode ^ (hashCode >>> 16)) & 0x7fffffff;
        System.out.println("h = "+hashCode);
        System.out.println("h = "+Integer.toBinaryString(hashCode));
        System.out.println("h >>> 16 = "+Integer.toBinaryString(hashCode>>>16));
        System.out.println("h ^ (h >>> 16) = "+Integer.toBinaryString(hashCode ^ (hashCode >>> 16)));
        System.out.println("h ^ (h >>> 16) & HASH_BITS = "+Integer.toBinaryString(hashCode ^ (hashCode >>> 16) & 0x7fffffff));
        for (int n = 1;n <=512*32;n <<= 1){
            System.out.println("n = "+Integer.toBinaryString(n));
            System.out.println(Integer.toBinaryString(Integer.numberOfLeadingZeros(n) ));
            System.out.println("resizeStamp = "+Integer.toBinaryString(Integer.numberOfLeadingZeros(n) | (1 << 15)));
            //System.out.println(Integer.numberOfLeadingZeros(i) | (1 << 15));
            //System.out.println("sizeCtl = " + (Integer.numberOfLeadingZeros(i) | (1 << 15)<<16));
            System.out.println("sizeCtl = " + Integer.toBinaryString((Integer.numberOfLeadingZeros(n) | (1 << 15)<<16)));
            //int stride =  (i >>> 3) / 4;
            //System.out.println(stride);
            System.out.println("hash = "+Integer.toBinaryString(hash));
            System.out.println("i = "+(hash & (n-1)));
            System.out.println("runBit = "+ (hash & n));
            System.out.println("after resize,runBit = "+ (hash & ((n << 1)-1)));
            System.out.println();
        }*/


        /*transferIndex = 25;
        int nextIndex;
        nextIndex = transferIndex;
        if (true){
            transferIndex = 20;

            int i = nextIndex-1;
            System.out.println(i);
        }*/

        //System.out.println(Integer.toBinaryString(Integer.numberOfLeadingZeros(512) | (1 << (16 - 1))));
        //System.out.println(Integer.numberOfLeadingZeros(64) | (1 << (16 - 1)));

        /*CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        list.add(3,"six");

        list.forEach(System.out::println);*/

        /*System.out.println(0x80000001);

        ConcurrentSkipListSet set = new ConcurrentSkipListSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        for (Iterator i = set.iterator();i.hasNext();){
            System.out.println(i.next());
        }*/
        /*SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long statTime = sdf.parse("2017-05"+"-01 00:00:00").getTime();
        System.out.println(statTime);*/

/*
        try {
            System.out.println(Long.toBinaryString(-2));
            System.out.println(Long.toBinaryString(-2<<48));
            System.out.println(Long.toBinaryString(0xffffL<<48));
            System.out.println(Long.toBinaryString(-2<<32));
            System.out.println(Long.toBinaryString(0xffffL<<32));
            System.out.println(Integer.parseInt("1110",2));
            System.out.println(Long.toBinaryString(~(0xffffffffL)));
        }finally {
            System.out.println(-1 << 29);
       }

       int n = 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        n = (n + 1) << 1;
        System.out.println(n);*/

        /*int r = -1640531527;
        System.out.println(Integer.toBinaryString(r));
        int m = 63;
        int origin = r & m, k = origin;
        System.out.println(k);

        long SP_MASK = 0xffffffffL;
        long UC_MASK = ~SP_MASK;
        System.out.println(Long.toBinaryString(UC_MASK));*/

        /*for (int origin = r & m, k = origin, oldSum = 0, checkSum = 0; ; ){
            System.out.println("k= "+k);
            if ((k = (k + 1) & m) == origin) {
                System.out.println("k= "+k);
                System.out.println("origin= "+origin);
                //TimeUnit.SECONDS.sleep(3);
                break;
            }

        }*/


        /*Integer[] a = new Integer[1 << 14];
        for (int i = 0; i < 1 << 14; i++)
            a[i] = new Random().nextInt();

        Arrays.parallelSort(a);

        //List<Integer> list = Arrays.asList(a);
        Arrays.asList(a).forEach(j -> System.out.println(j));*/
        /*int i = 2;
        System.out.println("-------"+BigDecimal.valueOf(i).compareTo(BigDecimal.ZERO));*/
       /* System.out.println();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf = new SimpleDateFormat("yyyy-MM");
        Date date = sdf.parse("2018-03");
        System.out.println(date);*/

        //System.out.println(1<<16);

        /*Long h = 30000094l;
        String s = "30000094";
        System.out.println(h == Long.valueOf(s));
        System.out.println(h == Long.valueOf(s).longValue());
        System.out.println(h.equals(Long.valueOf(s)));
        System.out.println(h == Long.parseLong(s));
        System.out.println();
        System.out.println(s == h.toString());
        System.out.println(s.equals(h.toString()));
        System.out.println();

        Integer i = 54321;
        String si = "54321";
        System.out.println(i == Integer.valueOf(si));
        System.out.println(i == Integer.parseInt(si));*/

       /* int[] nums2 = //{};
                {1,2,5,9,10,20};
        int[] nums1 = //{1};
                {5,15,16,21};

        for (int i = 0; i < nums1.length; i++)
            System.out.printf("%d ", nums1[i]);

        int[] nums = Arrays.copyOf(nums1,nums1.length + nums2.length);
        Arrays.asList(nums).forEach(System.out::print);
        //System.arraycopy(nums,0,nums2,nums1.length,nums2.length);
        System.arraycopy(nums2,0,nums,nums1.length,nums2.length);
        System.out.println(nums);*/
        /*ArrayList list = new ArrayList<>(Arrays.asList( 1267766,1257745,1259019,1267696,1197048,1263612,1258732));
        System.out.println(JSON.toJSONString(list));*/

    }

    public static void a(){
        throw new NullPointerException();
    }

    /*private static boolean isExcute() {
        System.out.println("excute!");
        return false;
    }

    private static class Node {
        private String node;

        private String next;

        @Override
        public String toString() {
            return "Node{" +
                    "node='" + node + '\'' +
                    ", next='" + next + '\'' +
                    '}';
        }

        final boolean casItem(Object cmp, Object val) {
            // assert cmp == null || cmp.getClass() != Node.class;
            return UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val);
        }

        final int arrayBaseOffset(Class<?> k) {
            return UNSAFE.arrayBaseOffset(k);
        }

        final int arrayIndexScale(Class<?> k) {
            return UNSAFE.arrayBaseOffset(k);
        }


        private static final sun.misc.Unsafe UNSAFE;
        private static final long itemOffset;
        private static final long nextOffset;

        //private static final long waiterOffset;
        static {
            try {
                // Unsafe mechanics
                Field field = Unsafe.class.getDeclaredField("theUnsafe");
                field.setAccessible(true);

                UNSAFE = (Unsafe) field.get(null);
                Class<?> k = Node.class;
                itemOffset = UNSAFE.objectFieldOffset
                        (k.getDeclaredField("node"));
                nextOffset = UNSAFE.objectFieldOffset
                        (k.getDeclaredField("next"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        public Node(String node, String next) throws NoSuchFieldException, IllegalAccessException {
            this.node = node;
            this.next = next;
        }

        public String getNode() {
            return node;
        }

        public void setNode(String node) {
            this.node = node;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }
    }

    public static Unsafe getUnsafeInstance() throws Exception {
        Field unsafeStaticField =
                Unsafe.class.getDeclaredField("theUnsafe");
        unsafeStaticField.setAccessible(true);
        return (Unsafe) unsafeStaticField.get(Unsafe.class);
    }
*/


}
