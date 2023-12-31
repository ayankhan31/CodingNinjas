/*

    Following is the Node class already written for the Linked List

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

*/


public class EvenafterOdd {

    public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
        //Your code goes here
        LinkedListNode<Integer> eh = null, et = null, oh = null, ot = null;
        while (head != null) {
            if (head.data % 2 == 0) {
                if (eh == null && et == null)
                {
                    eh = head;
                    et = head;
                }
                else
                {
                    et.next = head;
                    et = head;
                }
                head = head.next;
            }
            else
            {
                if (oh == null && ot == null)
                {
                    oh = head;
                    ot = head;
                }
                else
                {
                    ot.next = head;
                    ot = head;
                }
                head = head.next;
            }
        }
        if (oh != null)
        {
            ot.next = eh;
        }
        else
        {
            return eh;
        }
        if (eh != null)
        {
            et.next = null;
        }
        return oh;
    }
}
