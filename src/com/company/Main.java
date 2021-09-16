package com.company;
import java.util.Locale;
import java.util.Iterator;

public class Main {

    public static void main(String[] args)throws Exception {
        SimpleLinkedList<String> list=new SimpleLinkedList<>() ;
        list.addFirst("a");
        list.addFirst("c");
        list.addLast("b");
        list.addFirst("d");
        list.addLast("e");
        list.addLast("f");
        list.addLast("g");
        list.addFirst("h");
        list.addFirst("i");
        Iterator<String> iterator= list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.println(list.solution(7));
        Locale.setDefault(Locale.ROOT);
    }
}
