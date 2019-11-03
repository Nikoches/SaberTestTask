package SerializeToJson;

import java.util.HashMap;
import java.util.Iterator;

public class JsonObj {

        private ListRand list;
        private ListNode[] addArray;
        private HashMap<ListNode,Integer> randhashMap=new HashMap<>();
        private int[] addRandArray;
        private String text = "{";
        public JsonObj(ListRand list){
            this.list = list;
            addArray = new ListNode[list.getCount()];
            addRandArray = new int[list.getCount()];
        }
        public String toString() {
            return text.substring(0, text.length() - 2)+"\n}";
        }
        private void compileList() {
            //2параметра 1=номер ноды 2=дата ноды
            String nodeIn1=" \"%s\" :  %s ,\n";
            String nodeIn="{ \" node%s\" : {\"data\" : \"%s\" ,\"randId\":%s}}"+",";
            this.text+=String.format(nodeIn1,"ListCounter",list.getCount());
            this.text+=String.format(nodeIn1,"HeadNodeid",0);
            this.text+=String.format(nodeIn1,"TailNodeid",1);
            //Заполнение массива из листа итераторов
            {
                Iterator<ListNode> iterator = list.iterator();
                int i=0;
                while (iterator.hasNext()){
                    addArray[i++]=iterator.next();
                }
            }
            for(int i=0;i<addArray.length;i++) {
                randhashMap.put(addArray[i],i);
            }
            for(int i=0;i<addArray.length;i++) {
                addRandArray[i]=randhashMap.get(addArray[i].getRand());
            }
            this.text += String.format(" \"Nodes\" :[");
            for(int i=0;i<addArray.length;i++) {
                this.text+=String.format(nodeIn,i,addArray[i].getData(),addRandArray[i]);
            }
            text = text.substring(0, text.length() - 1)+"\n";
            this.text+="]  ";
        }
        public String makeObject() {
            this.compileList();
            return this.toString();
        }
}
