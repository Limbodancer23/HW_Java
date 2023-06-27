// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. 
//Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.
// NoteBook notebook1 = new NoteBook
// NoteBook notebook2 = new NoteBook
// NoteBook notebook3 = new NoteBook
// NoteBook notebook4 = new NoteBook
// NoteBook notebook5 = new NoteBook
// Например: “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет
// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
// Класс сделать в отдельном файле
// приветствие
// Выбор параметра
// выбор конкретнее
// вывод подходящих
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {
        NoteBooks Note1 = new NoteBooks("note1", 4, 500, "Red", "macOS", false);
        NoteBooks Note2 = new NoteBooks("note2", 8, 2000, "Red", "macOS", true);
        NoteBooks Note3 = new NoteBooks("note3", 4, 1000, "Green", "Linux", false);
        NoteBooks Note4 = new NoteBooks("note4", 2, 500, "Blue", "Windows", true);
        NoteBooks Note5 = new NoteBooks("note5", 16, 4000, "Blue", "Windows", false);

        Set<NoteBooks> Storage = new HashSet<>();
        Storage.add(Note1);
        Storage.add(Note2);
        Storage.add(Note3);
        Storage.add(Note4);
        Storage.add(Note5);

        Map<String, Object> Filter = new HashMap<>();

        System.out.println("Welcome to My Filter!\n");
        Menu(Filter, Storage);
    }

    static void Menu(Map<String, Object> Filter, Set<NoteBooks> Storage) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Select from below: ");
        System.out.println("1)RAM\n2)Hard disc capacy\n3)Color\n4)OS\n5)Status\n6)Find!");
        int Pick = scan.nextInt();
        switch (Pick) {
            case 1:
                int[] ramSize = { 2, 4, 8, 16 };
                System.out.println("1)2\n2)4\n3)8\n4)16");
                Filter.put("RAM", ramSize[scan.nextInt() - 1]);
                System.out.println(Filter);
                Menu(Filter, Storage);
                break;
            case 2:
                int[] HDSize = { 500, 1000, 2000, 4000 };
                System.out.println("1)500 GB\n2)1 TB\n3)2 TB\n4)4 TB");
                Filter.put("HDCapacy", HDSize[scan.nextInt() - 1]);
                Menu(Filter, Storage);
                break;
            case 3:
                String[] Colors = { "Red", "Green", "Blue" };
                System.out.println("1)Red\n2)Green\n3)Blue\n");
                Filter.put("Color", Colors[scan.nextInt() - 1]);
                Menu(Filter, Storage);
                break;
            case 4:
                String[] Systems = { "Windows", "macOS", "Linux" };
                System.out.println("1)Windows\n2)macOS\n3)Linux\n");
                Filter.put("Color", Systems[scan.nextInt() - 1]);
                Menu(Filter, Storage);
                break;
            case 5:
                System.out.println("1)New\n2)Used");
                int val = scan.nextInt();
                if (val == 1)
                    Filter.put("Status", false);
                else
                    Filter.put("Status", true);
                Menu(Filter, Storage);
                break;
            case 6:
                FindNoteBook(Filter, Storage);
                break;
            default:
        }
    }

    static void FindNoteBook(Map<String, Object> Filter, Set<NoteBooks> Storage) {
        for (NoteBooks noteBook : Storage) {
            if (Filter.values().contains(noteBook.getRAM()) | Filter.values().contains(noteBook.getHDSize())
                    | Filter.values().contains(noteBook.getColor()) | Filter.values().contains(noteBook.getOS())
                    | Filter.values().contains(noteBook.getSecondHand())) {
                System.out.println(noteBook.getName());
            }
        }
    }
}