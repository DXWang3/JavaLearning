package Discussion361B;

/**
 * Created by davidwang on 3/1/15.
 */
public class SList {

    private SNode head;
    public void insert(double val, int position){

        if(head == null || position == 0){ //when we either want to insert it into the first position,
                                           //or if the List is empty, insert it as the only term.
            head = new SNode(val, head);
        }

        SNode pos = head;
        while (pos.next != null && position > 0){ //points forward until we reach position


            pos = pos.next;
            position --;

        }

        SNode trail = pos;    //store list after the insert position.
        pos = new SNode(val, trail); //insert value at position, and next pointing to teh stored list afterwards.


    }
}
