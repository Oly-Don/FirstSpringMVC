package com.set.practice.math.pragram;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class SortTest {
    private long timeCount;
    /*
        随机数组
         */
    private int[] radomIntArr;
    /*
    断言是否为正序的依据，必须测试类中初始化
     */
    private boolean isFloor;

    public static int[] radomArraysGenarator(int length, int min, int max) {
        if (min > max || length <= 0) {
            return null;
        }
        int[] intArr = new int[length];
        int destinct = max - min;
        for (int i = 0; i < length; i++) {
            double randomdoub = Math.random();
            intArr[i] = min + (int) ((randomdoub * 100 * destinct) / 100);
        }
        return intArr;
    }

    public static String wellPrint(Object arrays) {
//        Arrays.sort();
        if (arrays instanceof int[]) {
            return loop((int[]) arrays);
        }
        return "未实现";//Todo
    }

    public static String loop(int[] strArrays) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strArrays.length; i++) {
            sb.append(strArrays[i]).append(",");
        }
        return sb.toString();
    }

    @BeforeClass
    public void beforeClass() {
        timeCount = System.nanoTime();
    }

    @AfterClass
    public void AfterClass() {
        //Fixme
        System.out.printf("消耗时间%d", TimeUnit.NANOSECONDS.convert((System.nanoTime() - timeCount), TimeUnit.NANOSECONDS));
    }

    @BeforeMethod
    public void setUp() {
        radomIntArr = radomArraysGenarator(10, 100, 9999);
//        radomIntArr =new int []{2,1,3,4,5,6};
        System.out.printf("排序前:%s", wellPrint(radomIntArr));
    }

    @Test(testName = "选择排序：小到大", invocationCount = 10)
    public void test_Select_sort() {
        isFloor = true;
        int temp = -1;
        for (int outerIndex = 0; outerIndex < radomIntArr.length; outerIndex++) {
            for (int innerindex = outerIndex + 1; innerindex < radomIntArr.length; innerindex++) {
                /*
                前大于后
                 */
                if (radomIntArr[outerIndex] > radomIntArr[innerindex]) {
                    //存小，换大
                    temp = radomIntArr[innerindex];//小
                    radomIntArr[innerindex] = radomIntArr[outerIndex];//大=》小
                    radomIntArr[outerIndex] = temp;//小=》大
                }
            }
        }
    }

    @Test(testName = "选择排序：大到小", invocationCount = 10)
    public void test_Select_Sort() {
        isFloor = false;
        int temp = -1;
        for (int outerIndex = 0; outerIndex < radomIntArr.length; outerIndex++) {
            for (int innerindex = outerIndex + 1; innerindex < radomIntArr.length; innerindex++) {
                 /*
                前小于后
                 */
                if (radomIntArr[outerIndex] < radomIntArr[innerindex]) {
                    //
                    temp = radomIntArr[innerindex];//存大
                    radomIntArr[innerindex] = radomIntArr[outerIndex];//小=》大
                    radomIntArr[outerIndex] = temp;//大》小
                }
            }
//            System.out.printf("\n排序第%d:%s\n" ,outerIndex+1, wellPrint(radomIntArr));
        }
    }

    @Test(testName = "冒泡排序：大到小", invocationCount = 10)
    public void test_Bubble_Sort() {
        isFloor = false;
        int temp = -1;
        for (int outerIndex = 0; outerIndex < radomIntArr.length; outerIndex++) {
            for (int innerindex = 0; innerindex < radomIntArr.length - 1; innerindex++) {
                 /*
                前小于后
                 */
                if (radomIntArr[innerindex] < radomIntArr[innerindex + 1]) {
                    temp = radomIntArr[innerindex + 1];//存大
                    radomIntArr[innerindex + 1] = radomIntArr[innerindex];//小=》大
                    radomIntArr[innerindex] = temp;//大》小
                }
            }
            System.out.printf("\n排序第%d:%s\n", outerIndex, wellPrint(radomIntArr));
        }
    }

    @Test(testName = "冒泡排序：大到小", invocationCount = 10)
    public void test_Bubble_sort() {
        isFloor = true;
        int temp = -1;
        for (int outerIndex = 1; outerIndex < radomIntArr.length; outerIndex++) {
            int canBreakloop = 0;
            for (int innerindex = 0; innerindex < radomIntArr.length - 1; innerindex++) {
                 /*
                前大于后
                 */
                if (radomIntArr[innerindex] > radomIntArr[innerindex + 1]) {
                    temp = radomIntArr[innerindex + 1];//存大
                    radomIntArr[innerindex + 1] = radomIntArr[innerindex];//小=》大
                    radomIntArr[innerindex] = temp;//大》小
                    canBreakloop++;
                }
//                System.out.printf("\n排序第%d 子%d:%s\n", outerIndex, innerindex, wellPrint(radomIntArr));
            }
            if (canBreakloop == 0) {
                break;
            }
//            System.out.printf("\n排序第%d:%s\n" ,outerIndex, wellPrint(radomIntArr));
        }
    }

    @Test(testName = "插入排序：小到大", invocationCount = 10000)
    public void test_Insertion_sort() {
        isFloor = true;
        for (int outerIndex = 1; outerIndex < radomIntArr.length; outerIndex++) {     //挑选数据遍历
            int currValue = radomIntArr[outerIndex];
            int fore = outerIndex - 1;
            int temp = -1;
            while (fore > 0 && currValue < radomIntArr[fore]) {
                radomIntArr[fore + 1] = radomIntArr[fore];
                fore--;
            }
            radomIntArr[fore] = currValue;
        }
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("排序后：" + wellPrint(radomIntArr));
        Assert.assertTrue(isSortByFloor(radomIntArr, isFloor));
    }

    private boolean isSortByFloor(int[] arrays, boolean isFloorMode) {
        for (int i = 0; i < arrays.length - 1; i++) {
            int minuteResult = arrays[i] - arrays[i + 1];
            //正序
            if (isFloorMode) {
                if (minuteResult > 0) {
//                    System.out.printf("排序模式：%s:前：%s,后：%s", isFloorMode, arrays[i], arrays[i + 1]);
                    return false;
                }
            } else {
                //倒序
                if (minuteResult < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
