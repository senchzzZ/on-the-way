import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static java.text.Collator.SECONDARY;

/**
 * Created by zhaoshengqi on 2017/7/25.
 */
public class Tem {

    static transient volatile Node head;

    public static void main(String[] args) throws Exception {
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

        int oldSum = 0, checkSum = 0;
        do {
            if (checkSum != 100)
                checkSum += 10;
            System.out.println("checkSum = "+checkSum+",oldSum = "+oldSum);
        }while (oldSum != (oldSum = checkSum));

        checkSum += 10;
        System.out.println(oldSum != (oldSum = checkSum));



        /*int[] arr = {1,2,3,4,5,6,7,8,9,10,11};

        int b = u.arrayBaseOffset(int[].class);
        int s = u.arrayIndexScale(int[].class);

        System.out.println(b);
        System.out.println(s);

        u.putInt(arr, (long)b+s*9, 1);

        System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++){
            int v = u.getInt(arr, (long)b+s*i);
            System.out.print(v+",");
        }*/


       /* SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String dstr="2017-4-24 14:20:00";
        java.util.Date date=sdf.parse(null);
        System.out.println(date);*/

       /*BigDecimal b = BigDecimal.ZERO;
       b = b.add(new BigDecimal(0.0));
        System.out.println(b==BigDecimal.ZERO);*/

        //System.out.println(Integer.toBinaryString(((-10 << 48))));


        //System.out.println("2.24.1".compareTo("2.24.0"));
        /*int r = 12;
        r ^= r << 6; r ^= r >>> 21; r ^= r << 7;

        System.out.println(100 & 0xffff);*/
    }



    private static boolean isExcute() {
        System.out.println("excute!");
        return false;
    }

    private static class Node{
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

        final int arrayBaseOffset(Class<?> k){
            return UNSAFE.arrayBaseOffset(k);
        }
        final int arrayIndexScale(Class<?> k){
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

    public static Unsafe getUnsafeInstance() throws Exception{
        Field unsafeStaticField =
                Unsafe.class.getDeclaredField("theUnsafe");
        unsafeStaticField.setAccessible(true);
        return (Unsafe) unsafeStaticField.get(Unsafe.class);
    }


}
