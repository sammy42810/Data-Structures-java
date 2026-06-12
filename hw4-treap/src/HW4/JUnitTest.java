package HW4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitTest {
    @Test
    void testTreap() {
        Treap<Character> test1 = new Treap<Character>();
        assertEquals("null\n", test1.toString());
    }

    @Test
    void testTreapLongB() {
        Treap<Character> test1 = new Treap<Character>(1);
        test1.add('2');
        test1.add('3');
        test1.add('4');
        Treap<Character> test2 = new Treap<Character>(1);
        test2.add('2');
        test2.add('3');
        test2.add('4');
        assertEquals(test1.toString(), test2.toString());
    }

    @Test
    void testTreapLong() {
        Treap<Character> test1 = new Treap<Character>(1);
        test1.add('s');
        test1.add('a');
        test1.add('m');
        Treap<Character> test2 = new Treap<Character>(1);
        test2.add('s');
        test2.add('a');
        test2.add('m');
        assertEquals(test1.toString(), test2.toString());
    }

    @Test
    void testAddE() {
        Treap<Integer> test1 = new Treap<Integer>(2);
        test1.add(12);
        test1.add(16);
        test1.add(3);
        test1.add(5);
        test1.add(7);
        test1.add(6);
        test1.add(14);
        assertEquals(false, test1.add(12)); //false as treap already has this key in a node
    }

    @Test
    void testAddEInt() {
        Treap<Integer> test1 = new Treap<Integer>();
        test1.add(1, 2);
        test1.add(6, 4);
        test1.add(0, 12);
        test1.add(3, 18);
        test1.add(5, 20);
        test1.add(2, 22);
        test1.add(7, 58);
        assertEquals(false, test1.add(2, 26)); //false as treap already has this key
    }

    @Test
    void testDelete() {
        Treap<Character> test2 = new Treap<Character>(2);
        test2.add('s', 98);
        test2.add('a', 80);
        test2.add('m', 60);
        test2.add('n', 65);
        test2.add('t', 75);
        test2.add('h', 40);
        test2.add('l', 32);
        test2.add('b', 21);
        test2.add('r', 25);
        test2.add('y', 47);
        assertEquals(true, test2.delete('m')); //test with root for most possible problems
        Treap<Character> test3 = new Treap<Character>(2);
        test3.add('a', 80);
        test3.add('m', 60);
        test3.add('n', 65);
        test3.add('t', 75);
        test3.add('h', 40);
        test3.add('l', 32);
        test3.add('b', 21);
        test3.add('r', 25);
        test3.add('y', 47); //Create same treap without root
        assertEquals(test2.toString(), test3.toString());

        Treap<Character> test4 = new Treap<Character>(2);
        test4.add('j', 99);
        test4.add('a', 80);
        test4.add('c', 60);
        test4.add('k', 65);
        test4.add('w', 75);
        test4.add('i', 40);
        test4.add('t', 32);
        test4.add('z', 21);
        test4.add('k', 25);
        test4.add('e', 47);
        assertEquals(true, test4.delete('z')); //test with root for most possible problems
        Treap<Character> test5 = new Treap<Character>(2);
        test5.add('j', 99);
        test5.add('a', 80);
        test5.add('c', 60);
        test5.add('k', 65);
        test5.add('w', 75);
        test5.add('i', 40);
        test5.add('t', 32);
        test5.add('z', 21);
        test5.add('k', 25);//Create same treap without root
        assertEquals(test2.toString(), test3.toString());

    }

    @Test
    void testFind() {
        Treap<Integer> test1 = new Treap<Integer>();
        test1.add(2, 19);
        test1.add(4, 31);
        test1.add(12, 70);
        test1.add(18, 84);
        test1.add(6, 12);
        test1.add(3, 83);
        test1.add(5, 26);
        assertEquals(true, test1.find(6));
    }

    @Test
    void testToString() {
        Treap<Integer> test1 = new Treap<Integer>();
        test1.add(2, 19);
        test1.add(4, 31);
        test1.add(12, 70);
        test1.add(18, 84);
        test1.add(6, 12);
        test1.add(3, 83);
        test1.add(5, 26);
        System.out.println(test1.toString()); //same toString as example test
    }

}
