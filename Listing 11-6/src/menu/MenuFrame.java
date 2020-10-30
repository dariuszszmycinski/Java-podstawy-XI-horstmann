package menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//ramka z paskiem menu
public class MenuFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private Action saveAction;
    private Action saveAsAction;
    private JCheckBoxMenuItem readOnlyItem;
    private JPopupMenu popup;

    //przykładowa akcja, która drukuje nazwę akcji do wyjścia System.out
    class TestAction extends AbstractAction {
        public TestAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Wybrano " + getValue(Action.NAME));
        }
    }

    public MenuFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        var fileMenu = new JMenu("Plik");
        fileMenu.add(new TestAction("Nowy"));

        //akceleratory
        var openItem = fileMenu.add(new TestAction("Otwórz"));
        openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));

        fileMenu.addSeparator();

        saveAction = new TestAction("Zapisz");
        JMenuItem saveItem = fileMenu.add(saveAction);
        saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));

        saveAsAction = new TestAction("Zapisz jako");
        fileMenu.add(saveAsAction);
        fileMenu.addSeparator();

        fileMenu.add(new AbstractAction("Zakończ") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //menu z polem wyboru i przełącznikami
        readOnlyItem = new JCheckBoxMenuItem("Tylko do odczytu");
        readOnlyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean saveOk = !readOnlyItem.isSelected();
                saveAction.setEnabled(saveOk);
                saveAsAction.setEnabled(saveOk);
            }
        });

        var group = new ButtonGroup();
        var insertItem = new JRadioButtonMenuItem("Wstawianie");
        insertItem.setSelected(true);
        var overtypeItem = new JRadioButtonMenuItem("Nadpisywanie");
        group.add(insertItem);
        group.add(overtypeItem);

        //ikony
        var cutAction = new TestAction("Wytnij");
        cutAction.putValue(Action.SMALL_ICON, new ImageIcon("cut.gif"));
        var copyAction = new TestAction("Kopiuj");
        copyAction.putValue(Action.SMALL_ICON, new ImageIcon("copy.gif"));
        var pasteAction = new TestAction("Wklej");
        pasteAction.putValue(Action.SMALL_ICON, new ImageIcon("paste.gif"));

        var editMenu = new JMenu("Edycja");
        editMenu.add(copyAction);
        editMenu.add(cutAction);
        editMenu.add(pasteAction);

        //zagnieżdżone menu
        var optionMenu = new JMenu("Opcje");
        optionMenu.add(readOnlyItem);
        optionMenu.addSeparator();
        optionMenu.add(insertItem);
        optionMenu.add(overtypeItem);
        editMenu.addSeparator();
        editMenu.add(optionMenu);

        //mnemoniki
        var helpMenu = new JMenu("Pomoc");
        helpMenu.setMnemonic('P');
        var indexItem = new JMenuItem("Index");
        indexItem.setMnemonic('I');
        helpMenu.add(indexItem);

        //mnemoniki można także dodawać do akcji
        var aboutAction = new TestAction("O Programie");
        aboutAction.putValue(Action.MNEMONIC_KEY, Integer.valueOf('O'));
        helpMenu.add(aboutAction);

        //Dodanie wszystkich menu bajwyższego rzędu do paska menu
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        //menu kontekstowe
        popup = new JPopupMenu();
        popup.add(cutAction);
        popup.add(copyAction);
        popup.add(pasteAction);

        var panel = new JPanel();
        panel.setComponentPopupMenu(popup);
        add(panel);
    }
}
