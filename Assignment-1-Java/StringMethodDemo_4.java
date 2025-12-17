public class StringMethodDemo_4 {

    public static void main(String[] args) {

        String str = "  Hello Java World  ";
        String str2 = "Hello Java World";

        // length()
        System.out.println("Length: " + str.length());

        // isEmpty()
        System.out.println("Is Empty: " + str.isEmpty());

        // charAt()
        System.out.println("CharAt(1): " + str.charAt(3));

        // toString()
        StringBuffer sb = new StringBuffer("Java");
        System.out.println("toString(): " + sb.toString());

        // equals()
        System.out.println("Equals: " + str.trim().equals(str2));

        // compareTo()
        System.out.println("CompareTo: " + str2.compareTo("Hello"));

        // contains()
        System.out.println("Contains 'Java': " + str.contains("Java"));

        // indexOf()
        System.out.println("IndexOf 'Java': " + str.indexOf("Java"));

        // lastIndexOf()
        System.out.println("LastIndexOf 'o': " + str.lastIndexOf('o'));

        // startsWith()
        System.out.println("StartsWith 'Hello': " + str.trim().startsWith("Hello"));

        // endsWith()
        System.out.println("EndsWith 'World': " + str.trim().endsWith("World"));

        // matches()
        System.out.println("Matches alphabets: " + str2.matches("[A-Za-z ]+"));

        // substring()
        System.out.println("Substring: " + str2.substring(6, 10));

        // toLowerCase()
        System.out.println("LowerCase: " + str2.toLowerCase());

        // trim()
        System.out.println("Trim: '" + str.trim() + "'");

        // replace()
        System.out.println("Replace: " + str2.replace("Java", "Python"));

        // split()
        String[] words = str2.split(" ");
        System.out.println("Split:");
        for (String w : words) {
            System.out.println(w);
        }

        // join()
        String joined = String.join("-", words);
        System.out.println("Join: " + joined);

        // valueOf()
        int num = 123;
        String numStr = String.valueOf(num);
        System.out.println("ValueOf: " + numStr);
    }
}
