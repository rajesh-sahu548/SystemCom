import java.util.Scanner;

class ArrayOperations_2 {

    // method to insert an element
    static int insert(int arr[], int n, int pos, int value) {
        for (int i = n; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = value;
        return n + 1;
    }

    // method to delete an element
    static int delete(int arr[], int n, int pos) {
        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        return n - 1;
    }

    // linear search
    static int linearSearch(int arr[], int n, int key) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    // binary search (array must be sorted)
    static int binarySearch(int arr[], int n, int key) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    // find maximum value
    static int findMax(int arr[], int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    // count even and odd
    static void countEvenOdd(int arr[], int n) {
        int even = 0, odd = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0)
                even++;
            else
                odd++;
        }
        System.out.println("Even numbers = " + even);
        System.out.println("Odd numbers = " + odd);
    }

    // insertion sort
    static void insertionSort(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // display array
    static void display(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // main method
    public static void main(String args[]) {

         Scanner sc = new Scanner(System.in);

    int arr[] = new int[50];
    int n, choice;

    // input array size
    System.out.print("Enter number of elements: ");
    n = sc.nextInt();

    // input array elements
    System.out.println("Enter elements:");
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }

    // show menu only once
    System.out.println("\n1 Insert");
    System.out.println("2 Delete");
    System.out.println("3 Linear Search");
    System.out.println("4 Binary Search");
    System.out.println("5 Maximum");
    System.out.println("6 Even/Odd Count");
    System.out.println("7 Insertion Sort");
    System.out.println("8 Display");

    System.out.print("Enter choice: ");
    choice = sc.nextInt();

    // perform selected operation only once
    if (choice == 1) {
        System.out.print("Position: ");
        int pos = sc.nextInt();
        System.out.print("Value: ");
        int val = sc.nextInt();
        n = insert(arr, n, pos, val);
        display(arr, n);
    }

    else if (choice == 2) {
        System.out.print("Position: ");
        int pos = sc.nextInt();
        n = delete(arr, n, pos);
        display(arr, n);
    }

    else if (choice == 3) {
        System.out.print("Search element: ");
        int key = sc.nextInt();
        int index = linearSearch(arr, n, key);
        System.out.println(index == -1 ? "Not Found" : "Found at index " + index);
    }

    else if (choice == 4) {
        System.out.print("Search element: ");
        int key = sc.nextInt();
        int index = binarySearch(arr, n, key);
        System.out.println(index == -1 ? "Not Found" : "Found at index " + index);
    }

    else if (choice == 5) {
        System.out.println("Maximum = " + findMax(arr, n));
    }

    else if (choice == 6) {
        countEvenOdd(arr, n);
    }

    else if (choice == 7) {
        insertionSort(arr, n);
        System.out.println("Sorted Array:");
        display(arr, n);
    }

    else if (choice == 8) {
        display(arr, n);
    }

    else {
        System.out.println("Invalid choice");
    }

    sc.close();
    


}
}