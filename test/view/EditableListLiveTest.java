package view;

import controller.ListController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Arrays;
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
        MonitorsConfig config1 = new MonitorsConfig("Layout 1", "Layout 1");
        MonitorsConfig config2 = new MonitorsConfig("Outro", "Layout 2");

        controller.addAll(Arrays.asList(config1, config2));

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
