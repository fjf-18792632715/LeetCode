import javax.security.auth.callback.CallbackHandler;
import java.util.ArrayList;
import java.util.List;

public class L_925 {
    public boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length()) return false;
        int i = 0;
        int j = 0;
        while (j < typed.length()) {
            if (i < name.length() && typed.charAt(j) == name.charAt(i)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }

        return i == name.length();
    }

    class entry{
        char ch;
        int number;

        public entry(char ch, int number) {
            this.ch = ch;
            this.number = number;
        }

        @Override
        public String toString() {
            return "entry{" +
                    "ch=" + ch +
                    ", number=" + number +
                    '}';
        }
    }
    public boolean isLongPressedName1(String name, String typed) {
        if (name.length() > typed.length()) return false;

        List<entry> nameList = new ArrayList<>();
        List<entry> typeList = new ArrayList<>();

        addList(name, nameList);
        addList(typed, typeList);

        System.out.println(nameList.toString());

        if (nameList.size() != typeList.size()) {
            return false;
        } else {
            while (!nameList.isEmpty()) {
                entry nameEntry = nameList.remove(0);
                entry typeEntry = typeList.remove(0);
                if (nameEntry.ch != typeEntry.ch) {
                    return false;
                } else {
                    if (nameEntry.number < typeEntry.number) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    public void addList(String name, List<entry> list) {
        int i = 0;
        while (i < name.length()) {
            int count = 1;
            char temp = name.charAt(i++);
            while (i < name.length() && name.charAt(i) == temp) {
                count++;
                i++;
            }
            list.add(new entry(temp, count));
        }
    }
}
