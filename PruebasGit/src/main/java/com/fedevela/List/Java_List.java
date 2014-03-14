package com.fedevela.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fvelazquez
 */
public class Java_List {
    
    public static void main(String[] args) {
         
        //List with type specified
        List<String> list1 = new ArrayList<String>();
        list1.add("ABC");
        //list1.add(123);
        //list1.add(12345.678);
        //list1.add(new Date());
        /* compile time error:
         * - no suitable method found for add(int)
         * - no suitable method found for add(double)
         * - no suitable method found for add(Date)
         */
         
        //List without type specified
        List list2 = new ArrayList();
        list2.add("ABC");
        list2.add(123);
        list2.add(12345.678);
        list2.add(new Date());
        for(int i = 0; i < list2.size(); i++){
            System.out.println(
                    list2.get(i).getClass().getName() + " : " +
                    list2.get(i));
        }
         
        //List without type specified
        //Returns a dynamically typesafe view with Collections.checkedList()
        List list3 = new ArrayList();
        list3 = Collections.checkedList(list3, String.class);
        list3.add("ABC");
        //list3.add(123);
        //list3.add(12345.678);
        //list3.add(new Date());
        /* runtime error:
         * java.lang.ClassCastException: Attempt to insert class
         * java.lang.Integer/Double/Date element into collection with element
         * type class java.lang.String
         */
         
    }
    
}
