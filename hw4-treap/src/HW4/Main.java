package hw4;

public class Main {
    public static void main(String[] args) {
        Treap<Character> test1 = new Treap<Character>(1);
        test1.add('A');
        test1.add('B');
        test1.add('C');
        Treap<Character> test2 = new Treap<Character>(1);
        test2.add('A');
        test2.add('B');
        test2.add('C');
        System.out.println(test1);
        System.out.println(test2);

    }
}
