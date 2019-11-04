package SerializeToJson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

public class ListRand implements Iterable<ListNode> {
    private ListNode Head;
    private ListNode Tail;
    private int Count;

    public ListRand(ListNode head, ListNode tail, int count) {
        this.Head = head;
        this.Tail = tail;
        this.Count = count;
    }

    /*
           Method to produce Json  from List.
     */
    public static ListRand desereliaze(String path) {
        JSONObject fullJson = null;
        try {
            fullJson = (JSONObject) new JSONParser().parse(Files.readString(Path.of(path)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        JSONArray listJson = (JSONArray) fullJson.get("Nodes");
        Iterator iterator = listJson.iterator();
        ListNode[] arrayofNodes = new ListNode[listJson.size()];
        int[] arrayofRand = new int[listJson.size()];
        int i = 0;
        while (iterator.hasNext()) {
            JSONObject first = (JSONObject) iterator.next();
            JSONObject second = (JSONObject) first.get(" node" + i);
            arrayofNodes[i] = new ListNode(null, null, second.get("data").toString(), null);
            arrayofRand[i++] = Integer.parseInt(second.get("randId").toString());
        }
        /*
          Make objects from array of nodes.
         */
        {
            for (int j = 0; j < arrayofNodes.length; j++) {
                arrayofNodes[j].setRand(arrayofNodes[arrayofRand[j]]);
            }
            for (int j = 0; j < arrayofNodes.length - 1; j++) {
                arrayofNodes[j].setNext(arrayofNodes[j + 1]);
            }
            for (int j = 1; j < arrayofNodes.length; j++) {
                arrayofNodes[j].setPrev(arrayofNodes[j - 1]);
            }
        }
        return new ListRand(arrayofNodes[0], arrayofNodes[arrayofNodes.length - 1], arrayofNodes.length);
    }

    public ListNode getHead() {
        return this.Head;
    }

    public ListNode getTail() {
        return this.Tail;
    }

    public int getCount() {
        return this.Count;
    }

    /*
        Method to produce json object from List.
     */
    public void Serialize(String path) {
        JsonObj cl = new JsonObj(this);
        try (FileWriter sWriter = new FileWriter(new File(path))) {
            sWriter.write(cl.makeObject());
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    public Iterator<ListNode> iterator() {
        return new Iterator<ListNode>() {
            ListNode currentNode = Head;

            public boolean hasNext() {
                return currentNode != null;
            }

            public ListNode next() {
                ListNode ss = currentNode;
                currentNode = currentNode.getNext();
                return ss;

            }

            public void remove() {
                //requirements of jdk 11
            }

            public void startAgain() {
                this.currentNode = Head;
            }
        };
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ListRand guest = (ListRand) obj;
        if (getCount() != guest.getCount()) {
            return false;
        }
        Iterator<ListNode> listNodeIterator = iterator();
        Iterator<ListNode> guestNodeIterator = guest.iterator();
        while (!listNodeIterator.hasNext()) {
            ListNode thatNode = listNodeIterator.next();
            ListNode guestNode = guestNodeIterator.next();
            if (!thatNode.getData().equals(guestNode.getData())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTail() == null) ? 0 : getTail().hashCode());
        result = prime * result + getCount();
        result = prime * result + ((getHead() == null) ? 0 : getHead().hashCode());
        return result;
    }
}
