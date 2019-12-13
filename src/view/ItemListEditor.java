package view;

import controller.ListController;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;
import model.CustomTableModel;
import model.ItemConfiguration;

/**
 *
 * @version 2019, Dec 10.
 */
public class ItemListEditor extends AbstractCellEditor implements TableCellEditor {

    private final ListController controller;

    public ItemListEditor(final ListController controller) {
        super();
        this.controller = controller;
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object val, boolean isSelected, int row, int column) {
        int index = table.convertRowIndexToModel(row);
        TableModel model = table.getModel();

        Object value = null;
        if (model instanceof CustomTableModel) {
            value = ((CustomTableModel) model).getList().get(index);
        }

        if (value instanceof ItemConfiguration) {
            ActionListener listener = new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    // nothing
                }
            };
            ItemPanel panel = new ItemPanel((ItemConfiguration) value, controller);
            panel.setListener(listener);
            panel.init();
            panel.setBackground(table.getSelectionBackground());
            return panel;
        }
        return null;
    }

}
