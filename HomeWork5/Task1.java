
// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами.
// Вывод должен быть отсортирован по убыванию числа телефонов.
// Пример меню:
// 1) Добавить контакт
// 2) Вывести всех
// 3) Выход
// Иванов 123432
// Иванов 546457
// Иванов 788354
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("------PHONEBOOK------");
        Map<String, ArrayList<String>> PhoneB = new HashMap<String, ArrayList<String>>();
        MainMenu(PhoneB);
    }

    static int MainMenu(Map<String, ArrayList<String>> pb) {
        System.out.print("---Main menu---\nSelect option\n1) Add contact\n2) Show contact list\n3) Exit\n");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        switch (input) {
            case "1":
                AddContact(scan, pb);
                break;
            case "2":
                SortByNumbers(pb);
                break;
            default:
                break;
        }
        return 0;
    }

    static void AddContact(Scanner sc, Map<String, ArrayList<String>> pb) {
        System.out.println("Enter contact name");
        String name = sc.nextLine();
        if (pb.containsKey(name)) {
            System.out.printf("Contact with name '%s' already in phonebook!\nContinue?\n1)Yes!\n2)No\n", name);
            String MyChoice = sc.nextLine();
            if (MyChoice.equals("1")) {
                System.out.println("Enter new number: ");
                String num = sc.nextLine();
                ArrayList<String> numbers = pb.get(name);
                numbers.add(num);
                pb.put(name, numbers);
                MainMenu(pb);
            }
            if (MyChoice.equals("2")) {
                MainMenu(pb);
            }
        } else {
            System.out.println("Enter number: ");
            String num = sc.nextLine();
            ArrayList<String> list = new ArrayList<>();
            list.add(num);
            pb.put(name, list);
            System.out.println(pb);
            System.out.println("Succeed!");
            MainMenu(pb);
        }
    }

    static void SortByNumbers(Map<String, ArrayList<String>> pb) {
        ArrayList<Map.Entry<String, ArrayList<String>>> list = new ArrayList<>(pb.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, ArrayList<String>>>() {
            @Override
            public int compare(Map.Entry<String, ArrayList<String>> el1, Map.Entry<String, ArrayList<String>> el2) {
                return el2.getValue().size() - el1.getValue().size();
            }
        });
        for (Map.Entry<String, ArrayList<String>> i : list) {
            System.out.println(i.getKey() + ":" + i.getValue());
        }
        MainMenu(pb);
    }
}