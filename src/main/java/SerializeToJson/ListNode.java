package SerializeToJson;

public class ListNode {
    private ListNode Prev;
    private ListNode Next;
    private String Data;
    private ListNode Rand; // произвольный элемент внутри списка

    public ListNode(ListNode prev, ListNode next, String data, ListNode rand) {
        Prev = prev;
        Next = next;
        Data = data;
        Rand = rand;
    }

    public ListNode getPrev() {
        return Prev;
    }

    public void setPrev(ListNode prev) {
        Prev = prev;
    }

    public ListNode getNext() {
        return Next;
    }

    public void setNext(ListNode next) {
        Next = next;
    }

    public ListNode getRand() {
        return Rand;
    }

    public void setRand(ListNode rand) {
        Rand = rand;
    }

    public String getData() {
        return Data;
    }
}

