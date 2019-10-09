package de.thro.inf.prg3.a02;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable<Object>
{
    private static class Element
    {
        Object  item;
        Element next;

        Element(Object item)
        {
            this.item = item;
        }
    }

    private class SimpleIteratorImpl implements Iterator<Object>
    {
        Element current = head;

        @Override
        public boolean hasNext()
        {
            return current != null;
        }

        @Override
        public Object next()
        {
            Object value = current.item;

            current = current.next;

            return value;
        }
    }

    private Element head;

    @Override
    public Iterator<Object> iterator()
    {
        return new SimpleIteratorImpl();
    }

    @Override
    public void add(Object o)
    {
        Element tail = head;

        while (tail != null && tail.next != null)
            tail = tail.next;

        if (head == null) head      = new Element(o);
        else              tail.next = new Element(0);
    }

    @Override
    public int size()
    {
        int count = 0;

        for (Object element : this)
            count ++;

        return count;
    }

    @Override
    public SimpleList filter(SimpleFilter filter)
    {
        SimpleList filtered = new SimpleListImpl();

        for (Object element : this)
        {
            if (filter.include(element))
                filtered.add(element);
        }

        return filtered;
    }
}