package com.company;

import java.util.Iterator;

public  class SimpleLinkedList<T> implements Iterable<T>{
    private class ListNode<T> {
        public T value;
        public ListNode<T> nextElement;
        public ListNode <T> prevElement;

        public ListNode(T value, ListNode<T> next,ListNode<T> prev) {
            this.value = value;
            this.nextElement = next;

            if(nextElement!=null) {
                nextElement.prevElement = this;
            }
            this.prevElement=prev;

            if(prevElement!=null){
                prevElement.nextElement=this;
            }

        }
        public ListNode(T value) {

            this(value, null,null);
        }
        public ListNode() {

            this(null);
        }
    }

    private ListNode<T> head = null;
    private ListNode<T> tail = null;

    private int count = 0;

    public ListNode<T> FromHead(int k){
        ListNode<T> curr = head;
        for (int i = 0; i < k; i++) {
            curr = curr.nextElement;
        }
        return curr;
    }

    public ListNode<T> FromTail(int k){
        ListNode<T> curr = tail;

        for (int i = 0; i <k; i++) {
            curr = curr.prevElement;
        }
        return curr;
    }
    public T solution(int k) throws Exception {
        return getNode2(k).value;
    }
    private ListNode<T> getNode2(int index)throws Exception{
        if (index < 0 || index >= count) {
            throw new Exception("Wrong index");
        }
        ListNode<T> curr=null;
        if(index<=(count-1)/2){

            curr=FromHead(index);
        }else{
            int k=count-index-1;
            curr=FromTail(k);
        }
        return curr;
    }
    public void addFirst(T value) {
        head = new ListNode<>(value, head,null);
        if (count==0) {
            tail = head;
        }
        count++;

    }
    public void addLast(T value) {
        tail= new ListNode<>(value, null,tail);
        if(head==null){
            head=tail;
        }
        count++;
    }

    @Override
    public Iterator<T> iterator() {
        class LinkedListIterator1 implements Iterator<T> {
            ListNode<T> curr;

            public LinkedListIterator1(ListNode<T> head) {
                curr = head;
            }

            @Override
            public boolean hasNext() {

                return curr != null;
            }

            @Override
            public T next() {
                T result = curr.value;
                curr = curr.nextElement;
                return result;
            }
        }

        return new LinkedListIterator1(head);
    }
}
