package model;

import java.util.List;

/**
 *
 * @version 2019, Dec 12.
 * @param <E> Item to manage on this model.
 */
public class ItemConfigTableModel<E> extends CustomTableModel<E> {

    public ItemConfigTableModel() {
        super(new String[]{""});
    }

    public ItemConfigTableModel(final List<E> list) {
        super(new String[]{""}, list);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex >= 0 && rowIndex < list.size()) {
            return list.get(rowIndex);
        }
        return "";
    }

}
