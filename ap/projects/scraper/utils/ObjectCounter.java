package ap.projects.scraper.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ObjectCounter <E> {

//    private Map<E,Integer> counterMap;
//
//    public ObjectCounter() {
//        this.counterMap=new HashMap<>();
//    }
//
//    public void add(E item){
//        if (this.counterMap.containsKey(item)){
//            this.counterMap.put(item, this.counterMap.get(item)+1);
//        }
//        else{
//            this.counterMap.put(item,1);
//        }
//    }
//
//    public List<Map.Entry<E, Integer>> getTop(int k){
//        return this.counterMap.entrySet().stream()
//                .sorted((a,b) -> -a.getValue().compareTo(b.getValue()))
//                .limit(k)
//                .collect(Collectors.toList());
//    }

    private ArrayList<String> keys;
    private ArrayList<Integer> values;

    public ObjectCounter() {
        this.values = new ArrayList<>();
        this.keys = new ArrayList<>();
    }

    public void add(String item){
        if (this.keys.contains(item)){
            int index = this.keys.indexOf(item);
            this.values.set(index, this.values.get(index)+1);
        }
        else{
            this.keys.add(item);
            this.values.add(1);
        }
    }


    public List<Map.Entry<String, Integer>> getTop(int k){

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < this.values.size(); i++) {
            map.put(this.keys.get(i), this.values.get(i));
        }

        return map.entrySet().stream()
                .sorted((a,b) -> -a.getValue().compareTo(b.getValue()))
                .limit(k)
                .collect(Collectors.toList());
    }

}
