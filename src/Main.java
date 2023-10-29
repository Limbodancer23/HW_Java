import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] array = {5, 2,7,1,9,0,32,64,-32, -2};
        System.out.print(array.toString());
        sort(array);
        System.out.print(Arrays.toString(array));
    }

    public static void sort(int[] array){
        for (int i = array.length / 2 - 1;i >= 0 ;i-- )
            heapyfy(array, array.length, i);

            //один за другим извлекаем элементы из кучи
            for (int i = array.length - 1; i >= 0 ; i-- ) {
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;
                //вызываем процедуру heapyfy на уменьшенной куче
                heapyfy(array, i, 0);
            }
    }

    public static void heapyfy(int[] array, int heapSize, int rootIndex){
        int largest = rootIndex; // инициализируем наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1; // левый = 2 * rootIndex + 1
        int rightChild = 2 * rootIndex + 2; // правый = 2 * rootIndex + 2

        // если левый дочерний элемент больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest]) largest = leftChild;

        // если  правый дочерний элемент больше, чем самый большой элемет на данный момент
        if(rightChild < heapSize && array[rightChild] > array[largest]) largest = rightChild;

        // если самый большой элемет не корень
        if(largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            // Рекурсивно преобразум в двоичную кучу затронутое поддерево
            heapyfy(array, heapSize, largest);
        }
    }
}