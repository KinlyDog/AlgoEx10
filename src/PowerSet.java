public class PowerSet {
    public int size;
    public int step;
    public String[] slots;

    public PowerSet() {
        this.size = 20000;
        this.step = 3;
        this.slots = new String[this.size];
    }

    // my
    public int hashFun(String value) {
        int len = value.getBytes().length;
        return len % size;
    }

    // my
    public int seekSlot(String value) {
        int ind = hashFun(value);

        if (find(value) != -1) {
            return -1;
        }

        for (int i = 0; i < size; i++, ind += step) {
            if (ind >= size) {
                ind -= size;
            }

            if (slots[ind] == null) {
                return ind;
            }
        }

        return -1;
    }

    // my
    public int find(String value) {
        int ind = hashFun(value);

        for (int i = 0; i < size; i++, ind += step) {
            if (ind >= size) {
                ind -= size;
            }

            if (slots[ind] == null) {
                continue;
            }

            if (slots[ind].equals(value)) {
                return ind;
            }
        }

        return -1;
    }

    public int size() {
        return this.size;
    }

    // my
    public void put(String value) {
        int ind = seekSlot(value);

        if (ind != -1) {
            slots[ind] = value;
        }
    }

    public boolean get(String value) {
        return find(value) != -1;
    }

    public boolean remove(String value) {
        int ind = find(value);

        if (ind != -1) {
            slots[ind] = null;
            return true;
        }

        return false;
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet inter = new PowerSet();

        for (int i = 0; i < size(); i++) {
            if (slots[i] == null) continue;

            for (int j = 0; j < set2.size(); j++) {
                if (set2.slots[j] != null && slots[i].equals(set2.slots[j])) {
                    inter.put(slots[i]);
                    break;
                }
            }
        }

        return inter;
    }

    public PowerSet union(PowerSet set2) {
        PowerSet uni = new PowerSet();

        for (int i = 0; i < size(); i++) {
            if (slots[i] != null) {
                uni.put(slots[i]);
            }
        }

        for (int i = 0; i < set2.size(); i++) {
            if (set2.slots[i] != null) {
                uni.put(set2.slots[i]);
            }
        }

        return uni;
    }

    public PowerSet difference(PowerSet set2) {
        PowerSet dif = new PowerSet();
        boolean flag;

        for (int i = 0; i < size(); i++) {
            if (slots[i] == null) continue;
            flag = false;

            for (int j = 0; j < set2.size(); j++) {
                if (set2.slots[j] != null && slots[i].equals(set2.slots[j])) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                dif.put(slots[i]);
            }
        }

        return dif;
    }

    public boolean isSubset(PowerSet set2) {
        boolean flag;

        for (int i = 0; i < set2.size(); i++) {
            if (set2.slots[i] == null) continue;
            flag = false;

            for (int j = 0; j < size(); j++) {
                if (slots[j] != null && set2.slots[i].equals(slots[j])) {
                    flag = true;
                    break;
                }
            }

            if (!flag) return false;
        }

        return true;
    }
}
