package com.tms.hm12.task1;

public interface IMyCustomArray<E> {

    public Object[] addElementToList(E element);
    public void createList();
    public void createListWithSize(int n);
    public void isElementToList(E element);
    public void delElement(int index);
    public void searchElement(int index);
    public void delAllElement();

}
