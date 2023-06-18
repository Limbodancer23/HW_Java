import java.util.ArrayList;
import java.util.Random;
// Пусть дан произвольный список целых чисел.
// 1) Нужно удалить из него чётные числа
// 2) Найти минимальное значение
// 3) Найти максимальное значение
// 4) Найти среднее ариф. значение
public class Task1{
    public static void main(String[] args) {
        ArrayList<Integer> MyList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int num = rand.nextInt(100);
            MyList.add(num);
        }
        System.out.println(MyList);
        for (int i = 0; i < MyList.size(); i++) {
            if (MyList.get(i) % 2 == 0) {
                MyList.remove(i);
                i--;
            }
        }
        int max = MyList.get(0); int min = MyList.get(0);
        int mean = 0;;
        for (int j = 0; j < MyList.size(); j++) {
            if (MyList.get(j) > max) max = MyList.get(j);
            if (MyList.get(j) < min) min = MyList.get(j);
            mean += MyList.get(j);
        }
        System.out.println(MyList);
        mean/=MyList.size();
        System.out.printf("max = %d\nmin = %d\naverage = %d", max, min, mean);
    }
}