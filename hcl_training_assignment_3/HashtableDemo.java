package hcl_training_assignment_3;


import java.util.Hashtable;
import java.util.Set;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;

public class HashtableDemo {

    public static void main(String[] args) {

        // ===============================
        // Constructors of Hashtable
        // ===============================

        Hashtable<Integer, String> ht1 = new Hashtable<>();
        // Default constructor

        Hashtable<Integer, String> ht2 = new Hashtable<>(5);
        // Initial capacity constructor

        Hashtable<Integer, String> ht3 = new Hashtable<>(ht1);
        // Map constructor (copy)

        // ===============================
        // 15 Methods of Hashtable
        // ===============================

        ht1.put(1, "Java");                // 1. put()
        ht1.put(2, "Python");
        ht1.put(3, "C++");
        // ht1 = {3=C++, 2=Python, 1=Java} (order not fixed)

        System.out.println(ht1.get(1));    // 2. get()
        // Output: Java

        ht1.remove(2);                     // 3. remove(key)
        // ht1 = {1=Java, 3=C++}

        System.out.println(ht1.containsKey(1)); // 4. containsKey()
        // Output: true

        System.out.println(ht1.containsValue("C++")); // 5. containsValue()
        // Output: true

        Enumeration<Integer> keys = ht1.keys(); // 6. keys()
        System.out.println("Keys:");
        while (keys.hasMoreElements()) {
            System.out.println(keys.nextElement());
        }
        /*
        Output:
        1
        3
        */

        Enumeration<String> elements = ht1.elements(); // 7. elements()
        System.out.println("Values:");
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }
        /*
        Output:
        Java
        C++
        */

        Set<Integer> keySet = ht1.keySet(); // 8. keySet()
        System.out.println(keySet);
        // Output: [1, 3]

        Collection<String> values = ht1.values(); // 9. values()
        System.out.println(values);
        // Output: [Java, C++]

        Set<Map.Entry<Integer, String>> entries = ht1.entrySet(); // 10. entrySet()
        System.out.println(entries);
        // Output: [1=Java, 3=C++]

        System.out.println(ht1.size());    // 11. size()
        // Output: 2

        System.out.println(ht1.isEmpty()); // 12. isEmpty()
        // Output: false

        ht1.replace(1, "Spring");          // 13. replace()
        // ht1 = {1=Spring, 3=C++}

        ht1.clone();                       // 14. clone()
        // Creates shallow copy

        ht1.clear();                       // 15. clear()
        System.out.println(ht1);
        // Output: {}
    }
}
