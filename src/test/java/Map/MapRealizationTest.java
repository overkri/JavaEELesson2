package Map;

import org.junit.Assert;
import org.junit.Test;

public class MapRealizationTest {
    MapRealization hash = new MapRealization();

    @Test
    public void put() {
        hash.put('A', 2);
    }

    @Test
    public void size() {
        hash.put('A', 2);
        hash.put('C', 2);
        hash.put('B', 2);
        Assert.assertTrue(hash.size() == 3);

    }

    @Test
    public void isEmpty() {
        hash.put('D', 2);
        hash.isEmpty();
        Assert.assertFalse(hash.isEmpty());

    }


    @Test
    public void get() {
        hash.put('J', 10);
        Assert.assertTrue(hash.get('J').equals(10));
    }


    @Test
    public void contains() {
        hash.put('A', 2);
        Assert.assertTrue(hash.contains('A'));

    }

    @Test
    public void delete() {
        hash.put('A', 2);
        hash.put('A', 3);
        //hash.put('B', 2);
        hash.delete('A');
        Assert.assertTrue(hash.isEmpty());

    }
}