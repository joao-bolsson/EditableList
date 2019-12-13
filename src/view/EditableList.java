package view;

import controller.ListController;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import model.CustomTableModel;

/**
 *
 * @version 2019, Dec 12.
 */
public class EditableList extends JTable {

    private final ListController controller;

    public EditableList(final CustomTableModel model, final ListController controller) {
        super(model);
        this.controller = controller;
    }

    public void init() {
        setTableHeader(null);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // TODO: make the height automatically setted by the context
        setRowHeight(80);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        setDefaultRenderer(String.class, centerRenderer);

        // getting the single column on this JTable to make a fake JList
        TableColumn column = getColumnModel().getColumn(0);
        column.setCellRenderer(new ItemListRenderer(controller));
        column.setCellEditor(new ItemListEditor(controller));
    }

}
