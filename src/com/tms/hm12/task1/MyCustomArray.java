package com.tms.hm12.task1;
/**
 * Программа имитируем работу ArrayList
 */

import java.util.Arrays;

public class MyCustomArray<E> implements IMyCustomArray{

    public static void main(String[] args) {

        MyCustomArray<String> myArray1 = new MyCustomArray<String>();
        myArray1.createList();
        myArray1.addElementToList("56");
        myArray1.addElementToList("13");
        myArray1.addElementToList("9");
        myArray1.addElementToList("Minsk");
        myArray1.addElementToList("Pinsk");
        System.out.println("Исходный массив: " + myArray1.toString());
        myArray1.addElementToList("qwerty");
        myArray1.addElementToList("123pkkj");
        System.out.println("Массив при добавлении элемента больше размера массива: " + myArray1.toString());

        myArray1.isElementToList("13");
        myArray1.searchElement(8);

        myArray1.delElement(2);
        System.out.println("Массив после удаления элемента: " + myArray1.toString());

        myArray1.delAllElement();
        System.out.println("Массив после удаления всех элементов: " + myArray1.toString());

        System.out.println("Новый массив");
        System.out.println("");

        MyCustomArray<Integer> myArray2 = new MyCustomArray<Integer>();
        myArray2.createListWithSize(9);
        myArray2.addElementToList(8);
        myArray2.addElementToList(23);
        myArray2.addElementToList(56);
        myArray2.addElementToList(7);
        myArray2.addElementToList(36);
        myArray2.addElementToList(5625);
        System.out.println("Исходный массив: " + myArray2.toString());

        myArray2.isElementToList(7);
        myArray2.searchElement(8);

        myArray2.delElement(4);
        System.out.println("Массив после удаления элемента: " + myArray2.toString());

        myArray2.delAllElement();
        System.out.println("Массив после удаления всех элементов: " + myArray2.toString());
    }

    private Object[] initArray;//массив для хранения элементов
    private int size;//размер коллекции
    private int currentIndex = -1; //текущий индекс

    @Override
    public void createList() {//создание массива с длиной по default
        initArray = new Object[5];
        size = 5;
        currentIndex = 0;
    }

    @Override
    public void createListWithSize(int n) {//создание массива заданной длины
        initArray = new Object[n];
        size = n;
        currentIndex = 0;
    }

    @Override
    public Object[] addElementToList(Object element) {//добавление элемента
        Object[] initArrayNew;
        initArrayNew = new Object[size];
        if (currentIndex == size){
            for (int i = 0; i < size; i++){
                initArrayNew[i] = initArray[i];
            }
            initArray = new Object[size+1];
            initArray = Arrays.copyOf(initArrayNew, size + 1);
            initArray[currentIndex] = element;
            size = initArrayNew.length + 1;
            currentIndex++;
            return  initArray;
        }else{
            initArray[currentIndex] = element;
            currentIndex ++;
            return initArray;
        }
    }

    @Override
    public void isElementToList(Object element) {//проверка:содержится ли элемент в массиве
        int k = 0;
        for (int i = 0; i < size; i++){
            if (initArray[i] == element){
                k++;
            }
        }

        if (k != 0){
            System.out.println("Элемент " + element + " содержится в массиве.");
        } else {
            System.out.println("Элемент " + element + " не содержится в массиве.");
        }
    }

    @Override
    public void searchElement(int index) {//вывод элемента по индексу
        if (index <= size){
           Object elem =  initArray[index];
            System.out.println("Под индексом "  + index + " находится элемент" + elem);
        } else{
            System.out.println("Индекс " + index + " выходит за пределы массива.");
        }
    }

    @Override
    public void delElement(int index) {//удаляет элемент по индексу
        if (index <= size){
            initArray[index] = null;
        } else{
            System.out.println("Индекс выходит за пределы массива.");
        }
    }

    @Override
    public void delAllElement() {//удаляет все элементы массива
        for (int i = 0; i < size; i++){
            initArray[i] = null;
        }
        currentIndex = 0;
    }

    @Override
    public String toString() {
        return "MyCustomArray{" +
                "initArray=" + Arrays.toString(initArray) +
                ", size=" + size +
                ", currentIndex=" + currentIndex +
                '}';
    }
}
