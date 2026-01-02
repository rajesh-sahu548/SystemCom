package hcl_training_assignment_3;



import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public class HashMapDemo {

    public static void main(String[] args) {

        // ===============================
        // Constructors of HashMap
        // ===============================

        HashMap<Integer, String> map1 = new HashMap<>();
        // Default constructor

        HashMap<Integer, String> map2 = new HashMap<>(5);
        // Initial capacity constructor

        HashMap<Integer, String> map3 = new HashMap<>(map1);
        // Map constructor (copy)

        // ===============================
        // 15 Methods of HashMap
        // ===============================

        map1.put(1, "Java");              // 1. put()
        map1.put(2, "Python");
        map1.put(3, "C++");
        // map1 = {1=Java, 2=Python, 3=C++}

        map1.putIfAbsent(3, "PHP");       // 2. putIfAbsent()
        // map1 = {1=Java, 2=Python, 3=C++}

        System.out.println(map1.get(1));  // 3. get()
        // Output: Java

        map1.remove(2);                   // 4. remove(key)
        // map1 = {1=Java, 3=C++}

        System.out.println(map1.containsKey(1));   // 5. containsKey()
        // Output: true

        System.out.println(map1.containsValue("C++")); // 6. containsValue()
        // Output: true

        Set<Integer> keys = map1.keySet(); // 7. keySet()
        System.out.println(keys);
        // Output: [1, 3]

        Collection<String> values = map1.values(); // 8. values()
        System.out.println(values);
        // Output: [Java, C++]

        Set<Map.Entry<Integer, String>> entries = map1.entrySet(); // 9. entrySet()
        System.out.println(entries);
        // Output: [1=Java, 3=C++]

        System.out.println(map1.size());  // 10. size()
        // Output: 2

        System.out.println(map1.isEmpty()); // 11. isEmpty()
        // Output: false

        map1.replace(1, "Spring");        // 12. replace()
        // map1 = {1=Spring, 3=C++}

        map1.forEach((k, v) ->
                System.out.println(k + " : " + v)); // 13. forEach()
        /*
        Output:
        1 : Spring
        3 : C++
        */

        map1.clone();                     // 14. clone()
        // Creates shallow copy of map

        map1.clear();                     // 15. clear()
        System.out.println(map1);
        // Output: {}
    }
}
