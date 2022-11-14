package com.animals.animalsdemo.practice;

import org.aspectj.weaver.ast.Var;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.internal.progress.SequenceNumber.next;

public class Test {

    public static void main(String[] args) {
//        BigDecimal yingfagognzi =  new BigDecimal("11000");
//        BigDecimal gongjijin =  new BigDecimal("990");
//        BigDecimal yanglaobaoxian =  new BigDecimal("660");
//        BigDecimal yiliaobaoxian =  new BigDecimal("165");
//        BigDecimal shiyebaoxian =  new BigDecimal("41.25");
//        System.out.println(yingfagognzi.subtract(gongjijin).subtract(yanglaobaoxian).subtract(yiliaobaoxian).subtract(shiyebaoxian));
//        BigDecimal all = yingfagognzi.subtract(gongjijin).subtract(yanglaobaoxian).subtract(yiliaobaoxian).subtract(shiyebaoxian).subtract(new BigDecimal("5000"));
//        BigDecimal shengyu = all.multiply(new BigDecimal("0.1"));
//        System.out.println(all);
//
//        System.out.println(gongjijin.add(yanglaobaoxian).add(yiliaobaoxian).add(shiyebaoxian));

        List  list = new ArrayList();
        List list2 = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add(2,"潘柯伟");
        list2.add(list);
        System.out.println(list2);


    }

    public void canEat(int  allEmpty) {
        int canReplace = 0;//可以喝到的饮料
        //0和1是换不了饮料了 结束循环
        while (!(allEmpty == 0 || allEmpty == 1)) {
            //如果是2 可以换一瓶 +1
            if (allEmpty == 2) {
                canReplace = canReplace + 1;
                break;
            } else {
                int a = allEmpty / 3;//喝剩下的空瓶 以及可以喝的汽水
                canReplace += a;
                allEmpty = a + (allEmpty - a * 3);//喝剩下的瓶子
            }
        }
        System.out.println(canReplace);
    }


    public int[] twoSum(int[] nums, int target) {
        int x = -1,y=-1;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    x=i;
                    y=j;
                }
            }
        }
       if(x==-1 && y==-1){
           return null;
       }
        int[] a = {x,y};
        System.out.println(x+"::::"+y);
        return a;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String a="",b="";
        while(l1 !=null){
            a= a+l1.val;
        } while(l2 !=null){
            b= b+l2.val;
            ListNode next = l2.next;
        }
        int i = Integer.parseInt(a) + Integer.parseInt(b);

        return null;
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
