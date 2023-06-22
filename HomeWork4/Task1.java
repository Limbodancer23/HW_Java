// Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
// 1) Умножьте два числа и верните произведение в виде связанного списка.
// 2) Сложите два числа и верните сумму в виде связанного списка.
// Одно или два числа могут быть отрицательными.
// Даны два Deque, цифры в обратном порядке.
// [3,2,1] - пример Deque
// [5,4,3]- пример второго Deque
// 1) 123 * 345 = 42 435
// Ответ всегда - связный список, в обычном порядке
// [4,2,4,3,5] - пример ответа
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
public class Task1{
    public static void main(String[] args) {
        Deque<String>dq1 = new ArrayDeque<>(); Deque<String>dq2 = new ArrayDeque<>();
        dq1.addLast("3"); dq1.addLast("2"); dq1.addLast("1"); dq1.addLast("-");
        dq2.addLast("5"); dq2.addLast("4"); dq2.addLast("3"); dq2.addLast("4"); dq2.addLast("1");

        System.out.printf("%s\n%s\n", dq1, dq2); 
        
        int num1 = GetDigit(dq1); int num2 = GetDigit(dq2);
        System.out.printf("%d\n%d\n", num1, num2); 

        ProductOf(num1, num2); SumOf(num1, num2);
    }

    public static int  GetDigit(Deque<String> dq){
        int n = 0;
        if(dq.peekLast().equals("-")){
            dq.removeLast();
            while(!dq.isEmpty()){
                n -= Integer.parseInt(dq.removeLast()) * Math.pow(10, dq.size());
            }
        }else{
            while(!dq.isEmpty()){
            n += Integer.parseInt(dq.removeLast()) * Math.pow(10, dq.size());
            }
        }
        return n;
    }
    static void  ProductOf(int a, int b){
        int res = a * b;
        LinkedList<String> ll = new LinkedList<String>();
        String str = Integer.toString(res);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            ll.add(Character.toString(c));
        }
        System.out.println(ll);
    }
    static void  SumOf(int a, int b){
        int res = a + b;
        LinkedList<String> ll = new LinkedList<String>();
        String str = Integer.toString(res);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            ll.add(Character.toString(c));
        }
        System.out.println(ll);
    }
}