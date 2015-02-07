/**
 * Created by davidwang on 2/6/15.
 */
public class Trial implements newLookup {

    private String[] test;
    private Object[] learn;

    public Object add(String name) {

        String[] entry = new String[test.length + 1];
        entry[entry.length-1] = name;

        test = entry;

        return test;

    }
}
