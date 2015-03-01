package Discussion361B;

/**
 * Created by davidwang on 3/1/15.
 */
public class SentinelList {

    private SNode front;
    private SNode back;
    public SentinelList(){

        this.back = new SNode(0, null);
        this.front = new SNode(0, back);
    }

    public void insert (double val, int position){

        SNode pos = front;
        while (pos.next != back && position > 0){ //points forward until we reach position


            pos = pos.next;
            position --;

        }

        SNode trail = pos;    //store list after the insert position.
        pos = new SNode(val, trail); //insert value at position, and next pointing to teh stored list afterwards.




    }


}
