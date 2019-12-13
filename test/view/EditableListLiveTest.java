package view;

import controller.ListController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JPanel;
import model.ItemConfigTableModel;
import model.MonitorsConfig;

/**
 *
 * @version 2019, Dec 13.
 */
public class EditableListLiveTest {

    public EditableListLiveTest() {
    }

    public static void main(final String[] args) {
        ListController<MonitorsConfig> controller = new ListController<>();

        List<MonitorsConfig> items = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            items.add(new MonitorsConfig("Layout " + i, "Layout " + (i + 10)));
        }

        controller.addAll(items);

        ItemConfigTableModel model = new ItemConfigTableModel(controller.getAll());
        controller.addListDataListener(model);

        EditableList list = new EditableList(model, controller);
        list.init();

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(list, BorderLayout.CENTER);
        panel.setPreferredSize(new Dimension(350, 400));

        JDialog dialog = new JDialog();
        dialog.setTitle("EditableList Live Test");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);

        dialog.setContentPane(panel);

        dialog.pack();
        dialog.setVisible(true);
    }

}
