package ap.exercises.ex5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringCounter {
    private ArrayList<String> keys;
    private ArrayList<Integer> values;

    public StringCounter() {
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

    public List<Entry> getEntries(ArrayList<String> keys, ArrayList<Integer> values) {
        List<Entry> entries = new ArrayList<>();

        for (int i = 0; i < keys.size(); i++) {
            entries.add(new Entry(keys.get(i), values.get(i)));
        }

        return entries;
    }

    public List<Entry> getTop(int k){
        return getEntries(keys, values).stream()
                .sorted((a,b) -> Integer.compare(b.getValue(), a.getValue()))
                .limit(k)
                .collect(Collectors.toList());
    }
}

class Entry {
    private String key;
    private int value;

    public Entry(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}