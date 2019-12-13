package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @version 2019, Nov 12.
 * @param <E> Object type to manage on this controller.
 */
public class ListController<E> extends AbstractListModel<E> {

    private final Collection<E> list = new ArrayList<>();
    private final Collection<ListDataListener> listDtListener = new ArrayList<>();

    /**
     * Creates an empty controller.
     */
    public ListController() {
        // empty
    }

    /**
     * Adds all the elements on the given list.
     *
     * @param all Elements to add.
     */
    public void addAll(final Collection<E> all) {
        if (all == null) {
            return;
        }
        int first = list.size();
        list.addAll(all);
        int last = list.size() - 1;

        fireIntervalAdded(first, last);
    }

    /**
     * Adds an element.
     *
     * @param item Element to add.
     */
    public void add(final E item) {
        if (item == null) {
            return;
        }
        int first = list.size();
        list.add(item);
        int last = list.size() - 1;

        fireIntervalAdded(first, last);
    }

    /**
     * Removes an element.
     *
     * @param item Item to remove.
     */
    public void remove(final E item) {
        list.remove(item);
        fireContentsChanged();
    }

    /**
     * @return A list with all the items on this controller.
     */
    public List<E> getAll() {
        return new ArrayList<>(list);
    }

    /**
     * Clear the items from this controller.
     */
    public void clear() {
        list.clear();
        fireContentsChanged();
    }

    /**
     * @return If the controller is without items - true, otherwise - false.
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * @return Number of listed objects.
     */
    public int size() {
        return list.size();
    }

    /**
     * Adds a list data listener.
     *
     * @param listener Listener to add.
     */
    @Override
    public void addListDataListener(final ListDataListener listener) {
        if (!listDtListener.contains(listener) && listener != null) {
            listDtListener.add(listener);
        }
    }

    /**
     * Removes a listener from the controller.
     *
     * @param listener Listener to remove.
     */
    @Override
    public void removeListDataListener(final ListDataListener listener) {
        listDtListener.remove(listener);
    }

    /**
     * @return A list with the data listeners.
     */
    public Collection<ListDataListener> getListDtListener() {
        return new ArrayList<>(listDtListener);
    }

    private void fireIntervalAdded(int first, int last) {
        if (last >= first) {
            for (ListDataListener listDataListener : listDtListener) {
                listDataListener.intervalAdded(new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, first, last));
                listDataListener.contentsChanged(new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, first, last));
            }
        }
    }

    /**
     * Fires contents changed event to all the registered listeners.
     */
    public void fireContentsChanged() {
        for (ListDataListener listDataListener : listDtListener) {
            listDataListener.contentsChanged(new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, 0));
        }
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public E getElementAt(int index) {
        if (index >= 0 && index < list.size()) {
            return new ArrayList<>(list).get(index);
        }
        return null;
    }
}
