package view;

import controller.ListController;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import model.CustomTableModel;
import model.ItemConfiguration;

/**
 *
 * @version 2019, Dec 10.
 */
public class ItemListRenderer extends ItemPanel implements TableCellRenderer {

    public ItemListRenderer(final ListController controller) {
        super(controller);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object val, boolean isSelected, boolean hasFocus, int row, int column) {
        Object value = null;
        int index = table.convertRowIndexToModel(row);
        TableModel model = table.getModel();

        if (model instanceof CustomTableModel) {
            value = ((CustomTableModel) model).getList().get(index);
        }

        if (value instanceof ItemConfiguration) {
            ItemPanel panel = new ItemPanel((ItemConfiguration) value, controller);
            panel.init();
            Color background = table.getBackground();
            if (isSelected) {
                background = table.getSelectionBackground();
            }
            panel.setBackground(background);

            return panel;
        }

        return this;
    }

}
