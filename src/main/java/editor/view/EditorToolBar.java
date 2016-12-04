package editor.view;

import editor.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


/**
 * Created by svuatoslav on 12/4/16.
 */
public class EditorToolBar extends JMenuBar {
    private JMenu viewMenu;
    private JMenu fileMenu;
    public EditorToolBar()
    {
        fileMenu=new JMenu("File");
        add(fileMenu);

        JMenuItem menuItem=new JMenuItem("Exit");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.kill();
            }
        });
        fileMenu.add(menuItem);

        viewMenu=new JMenu("View");
        add(viewMenu);

        menuItem=new JMenuItem("Tools");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.optionsFrame.setVisible(!Main.optionsFrame.isVisible());
            }
        });
        viewMenu.add(menuItem);

        menuItem=new JMenuItem("Palette");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.colorFrame.setVisible(!Main.colorFrame.isVisible());
            }
        });
        viewMenu.add(menuItem);

        menuItem=new JMenuItem("Object list");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.listFrame.setVisible(!Main.listFrame.isVisible());
            }
        });
        viewMenu.add(menuItem);
    }
}
