import static org.junit.jupiter.api.Assertions.*;

class PowerSetTest {
    PowerSet pw1 = new PowerSet();
    PowerSet pw2 = new PowerSet();

    @org.junit.jupiter.api.Test
    void size() {
    }

    @org.junit.jupiter.api.Test
    void put() {
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void intersection() {
    }

    @org.junit.jupiter.api.Test
    void union() {
    }

    @org.junit.jupiter.api.Test
    void difference() {
    }

    @org.junit.jupiter.api.Test
    void isSubset() {
        pw1.put("123");
        pw1.put("2");
        pw1.put("444");
        pw2.put("2");
        pw2.put("444");
        pw2.put("123");

        assertTrue(pw1.isSubset(pw2));

        pw2.remove("123");

        assertTrue(pw1.isSubset(pw2));

        pw2.put("123");
        pw2.put("666");
        assertFalse(pw1.isSubset(pw2));

        for (int i = 0; i < pw1.size; i++) {
            pw1.put(String.valueOf(i));
        }

        for (int i = 0; i < pw2.size; i++) {
            pw2.put(String.valueOf(i));
        }

        pw1.difference(pw2);

        assertTrue(pw1.get("19000"));
        assertFalse(pw1.get("20000"));

        int c = pw1.size();
    }
}