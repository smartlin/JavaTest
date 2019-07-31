package cn.lxh.java.DataStructure.TwoPointsToFind;

/**
 * Created by starlin
 * on 2016/09/28 9:08.
 * 二分查找法是对一组有序的数组中进行查找
 * 二分查找法非递归和递归实现
 * * 要使用二分查找法需满足以下特征
 * 1.存储在数组中，在链表中是不可以的
 * 2.有序排列
 *
 * 确认一下几点：
 *   1.是否排好序
 *   2.递增还是递减
 *   3.当数字有重复时，是否返回任意一个数的下标即可
 *   4.查找需要注意边界条件
 */

public class HalfSearch {
    //二分查找法非递归实现
    public static int binraySearch(int[] srcArray , int des){
        //最低位
        int low = 0;
        //最高位
        int high = srcArray.length - 1;
        //当low"指针"和high不重复的时候.
        while(low<=high){
            //中间位置计算
            int middle = (high + low)/2;
            //与最中间位置比较是否相等，相等返回对应的数组下标
            if(des == srcArray[middle]){
                return middle;
                //如果小于的话则移动最高层的"指针"
            }else if(des < srcArray[middle]){
                high = middle - 1;
            }else{
                low = middle + 1;
            }
        }
        return -1;
    }

    //二分查找法递归实现
    public static int BinSearch(int Array[],int low,int high,int key){
        if(low <= high){
            int mid = (low + high)/2;
            if(key == Array[mid]){
                return mid;
            }else if(key < Array[mid]){
                //移动low和high
                return BinSearch(Array,low,mid-1,key);
            }else if(key > Array[mid]){
                return BinSearch(Array,mid+1,high,key);
            }
        }
        return -1;
    }

    public static int test(int[] array,int des){
        int low = 0;
        int high = array.length - 1;
        while(low <= high ){
            int middle = (low + high)/2;
            if(des == array[middle]){
                return middle;
            }else if(des < array[middle]){
                high = middle -1;
            }else{
                low = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int data[] = new int[]{2, 3, 4, 5, 6, 7, 8};
        System.out.println(HalfSearch.binraySearch(data,8));
        System.out.println(HalfSearch.BinSearch(data,0,6,8));
        System.out.println("test-------->" + HalfSearch.test(data,5));
    }

}

