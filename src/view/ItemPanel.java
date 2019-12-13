package view;

import controller.ListController;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.ItemConfiguration;

/**
 *
 * @version 2019, Dec 06.
 */
public class ItemPanel extends JPanel {

    private final JButton btnEdit = new JButton("Edit");
    private final JButton btnDelete = new JButton("Delete");
    private final JLabel lblDescription, lblTitle;

    protected final ListController controller;
    private final ItemConfiguration item;

    private ActionListener listener;

    /**
     * Default construct. Empty title and description, used for list cell renderer.
     *
     * @param controller
     */
    public ItemPanel(final ListController controller) {
        this.lblDescription = new JLabel();
        this.lblTitle = new JLabel();
        this.controller = controller;
        this.item = null;
    }

    /**
     * Creates new form ItemPanel
     *
     * @param item Item to show information on the panel.
     * @param controller Referenced list controller.
     */
    public ItemPanel(final ItemConfiguration item, final ListController controller) {
        super(new GridBagLayout());
        this.item = item;

        this.controller = controller;

        lblTitle = new JLabel(item.getTitle());
        lblDescription = new JLabel(item.getDescription());
    }

    private JPanel getLabelsPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEtchedBorder());

        GridBagConstraints cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.weightx = 1;
        cons.gridwidth = GridBagConstraints.RELATIVE;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.anchor = GridBagConstraints.PAGE_START;
        cons.insets = new Insets(5, 5, 5, 5);
        panel.add(lblTitle, cons);

        cons.gridy++;
        panel.add(lblDescription, cons);

        return panel;
    }

    public void setListener(ActionListener listener) {
        this.listener = listener;
    }

    private void addListeners() {
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (controller != null) {
                    controller.remove(item);
                }

                if (listener != null) {
                    listener.actionPerformed(e);
                }
            }
        });
    }

    /**
     * Initialize this component.
     */
    public void init() {
        setOpaque(true);

        btnEdit.setFocusable(false);
        btnEdit.setRolloverEnabled(false);
        btnDelete.setFocusable(false);
        btnDelete.setRolloverEnabled(false);

        addListeners();
        setBorder(BorderFactory.createEtchedBorder());

        GridBagConstraints cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.weightx = 1;
        cons.gridheight = 2;
        cons.gridwidth = GridBagConstraints.RELATIVE;
        cons.anchor = GridBagConstraints.PAGE_START;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.insets = new Insets(10, 15, 0, 0);
        add(getLabelsPanel(), cons);

        cons.gridx++;
        cons.gridy = 0;
        cons.gridheight = 1;
        cons.ipadx = 5;
        cons.insets = new Insets(10, 15, 0, 10);
        add(btnEdit, cons);

        cons.gridy++;
        cons.insets = new Insets(10, 15, 10, 10);
        add(btnDelete, cons);
    }

}
