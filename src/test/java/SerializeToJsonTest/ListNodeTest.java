package SerializeToJsonTest;

import SerializeToJson.ListNode;
import SerializeToJson.ListRand;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListNodeTest {
    @Test
    void nodeSerialTest() throws ParseException, IOException {
        ListNode first = new ListNode(null, null, "s1", null);
        ListNode second = new ListNode(first, null, "s2", first);
        ListNode third = new ListNode(second, null, "s3", second);
        second.setNext(third);
        first.setNext(second);
        first.setRand(second);
        ListRand listRand = new ListRand(first, third, 3);
        listRand.Serialize("dd.json");
        ListRand listRand1 = ListRand.desereliaze("dd.json");
        assertEquals(listRand, listRand1);
    }
}
