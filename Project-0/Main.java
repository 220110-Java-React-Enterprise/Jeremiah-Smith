public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> myList = new CustomArrayList<>();
        myList.print();

        myList.add(1);
        myList.print();
        myList.add(2);
        myList.print();
        myList.add(3);
        myList.print();
        myList.add(4);
        myList.print();
        myList.add(5);
        myList.print();

        myList.add(6, 2);
        myList.print();

        myList.remove(2);
        myList.print();

        myList.add(6);
        myList.print();

        System.out.println("Object 1 located in list at index: " + myList.contains(1));
        System.out.println("Object 6 located in list at index: " + myList.contains(6));
        System.out.println("Object 17 located in list at index: " + myList.contains(17));

        myList.clear();
        myList.print();
    }
}
