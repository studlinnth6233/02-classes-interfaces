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
        public Object  item;
        public Element next;
    }

    private class SimpleIteratorImpl implements Iterator<Object>
    {
        Element current = head;

        @Override
        public boolean hasNext()
        {
            return current.next != null;
        }

        @Override
        public Object next()
        {
            current = current.next;

            return current;
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

    }

    @Override
    public int size()
    {
        return 0;
    }

    @Override
    public SimpleList filter(SimpleFilter filter)
    {
        return null;
    }
}