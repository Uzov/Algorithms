package Task01;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HeapSort {
    public void sort(int[] array) {
        // Построение кучи (перегруппируем массив)
        for (int i = array.length /2-1; i >= 0; i--)
            heapify(array, array.length, i) ;
        // Один за другим извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array[0] ; array[0] = array[i];
            array[i] = temp;
            // Вызываем процедуру heapify на уменьшенной куче
            heapify (array, i, 0);
        }
    }
    private static void heapify(int[] array, int heapSize, int rootindex) {
        int largest = rootindex; // нициализируем наибольший элемент как корень
        int leftchild = 2 * rootindex +1; // левый = 2*rootlndex + 1
        int rightchild = 2 * rootindex +2; // правый = 2*rootlndex + 2

        // Если левый дочерний элемент больше корня
        if (leftchild < heapSize && array[leftchild] > array[largest]) largest = leftchild;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (rightchild < heapSize && array[rightchild] > array[largest]) largest = rightchild;

        // Если самый большой элемент не корень
        if (largest != rootindex) {
            int temp = array[rootindex];
            array[rootindex] = array[largest];
            array[largest] = temp;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(array, heapSize, largest);
        }
    }

    // Печать массива
    static void printArray(int[] arr)
    {
       for (int j : arr) System.out.print(j + " ");
       System.out.println();
    }

    // Выполнение программы
    public static void main(String[] args)
    {
        int N = 100000000;
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = (int)-100 + (int) (Math.random() * ((100 - (-100)) + 1));
        }

        //System.out.println("Not sorted array is ");
        //printArray(arr);

        HeapSort ob = new HeapSort();
        Date t1 = new Date();
        ob.sort(arr);
        Date t2 = new Date();
        long elapsedms = t2.getTime() - t1.getTime();
        long diff = TimeUnit.SECONDS.convert(elapsedms, TimeUnit.MILLISECONDS);
        System.out.println("Время выполнения, сек: ");
        System.out.printf("%d%n",diff);

        //System.out.println("Sorted array is ");
        //printArray(arr);
    }
}
