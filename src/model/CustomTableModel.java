package model;

import controller.ListController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author João Bolsson (joaobolsson@animati.com.br)
 * @version 2019, Nov 11.
 * @param <E> Object to manage on the model.
 */
public abstract class CustomTableModel<E> extends AbstractTableModel implements ListDataListener {

    private final String[] columns;

    protected final List<E> list = new ArrayList<>();

    /**
     * Creates an empty model.
     *
     * @param columns Model's columns.
     */
    public CustomTableModel(final String[] columns) {
        this.columns = Arrays.copyOf(columns, columns.length);
    }

    /**
     * Creates a table model with the given objects on the list.
     *
     * @param columns Model's columns.
     * @param list Objects to add.
     */
    public CustomTableModel(final String[] columns, final List<E> list) {
        this(columns);

        this.list.addAll(list);
    }

    /**
     * @return A list with all objects stored on the model.
     */
    public List<E> getList() {
        return new ArrayList<>(list);
    }

    /**
     * Clear this model and import all the objects given by the list.
     *
     * @param list Objects to import.
     */
    public void addAll(final List<E> list) {
        this.list.clear();

        this.list.addAll(list);
        fireTableDataChanged();
    }

    /**
     * Adds a new item on the model. Repeated items aren't allowed.
     *
     * @param item Item to add.
     */
    public void add(final E item) {
        if (!list.contains(item)) {
            list.add(item);

            fireTableRowsInserted(list.size() - 1, list.size() - 1);
        }
    }

    /**
     * Removes the given element from the model.
     *
     * @param item The element to remove.
     */
    public void remove(final E item) {
        if (list.contains(item)) {
            int index = list.indexOf(item);
            list.remove(index);

            fireTableRowsDeleted(index, index);
        }
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        if (column >= 0 && column < columns.length) {
            return columns[column];
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Object value = getValueAt(0, columnIndex);
        if (value != null) {
            return value.getClass();
        }
        return null;
    }

    @Override
    public abstract boolean isCellEditable(int rowIndex, int columnIndex);

    @Override
    public abstract Object getValueAt(int rowIndex, int columnIndex);

    @Override
    public void intervalAdded(final ListDataEvent evt) {
        // empty
    }

    @Override
    public void intervalRemoved(final ListDataEvent evt) {
        // empty
    }

    @Override
    public void contentsChanged(final ListDataEvent evt) {
        if (evt != null && evt.getSource() instanceof ListController) {
            ListController controller = (ListController) evt.getSource();
            addAll(controller.getAll());
        }
    }

}
