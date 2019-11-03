package SerializeToJson;

public class ListNode {
    private ListNode Prev;
    private ListNode Next;
    private String Data;
    private ListNode Rand; // произвольный элемент внутри списка

    public void setPrev(ListNode prev) {
        Prev = prev;
    }

    public void setNext(ListNode next) {
        Next = next;
    }

    public ListNode(ListNode prev, ListNode next, String data, ListNode rand) {
        Prev = prev;
        Next = next;
        Data = data;
        Rand = rand;
    }

    public ListNode getPrev() {
        return Prev;
    }

    public ListNode getNext() {
        return Next;
    }

    public ListNode getRand() {
        return Rand;
    }

    public String getData() {
        return Data;
    }

    public void setRand(ListNode rand) {
        Rand = rand;
    }
}

