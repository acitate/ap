import java.util.ArrayList;
import java.util.Scanner;


public class DataSet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Float> values = new ArrayList<>();
        float temp_in = in.nextFloat();

        while(temp_in != -9999) {
            values.add(temp_in);
            temp_in = in.nextFloat();
        }

        System.out.println(getAverage(values));
        System.out.println(getSmallest(values));
        System.out.println(getLargest(values));
        System.out.println(getRange(values));
    }


    static float getAverage(ArrayList<Float> values) {
        float sum = 0;
        for (float value : values) {
            sum += value;
        }

        return (sum / values.size());
    }


    static float getSmallest(ArrayList<Float> values) {
        float min = values.get(0);

        for (float value : values) {
            min = Math.min(value, min);
        }

        return min;
    }


    static float getLargest(ArrayList<Float> values) {
        float max = values.get(0);

        for (float value : values) {
            max = Math.max(value, max);
        }

        return max;
    }


    static float getRange(ArrayList<Float> values) {
        float min = getSmallest(values);
        float max = getLargest(values);

        return max - min;
    }
}
