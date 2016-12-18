package editor.view;

import com.sun.javafx.geom.Vec2f;
import editor.Editor;
import editor.Main;
import editor.primitives.Primitive;
import editor.view.dialogues.MoveDialog;
import editor.view.dialogues.ScaleDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by svuatoslav on 12/4/16.
 */
public class EditorToolBar extends JMenuBar {
    private JMenu viewMenu;
    private JMenu fileMenu;
    private JMenu commandMenu;
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

        commandMenu=new JMenu("Commands");
        add(commandMenu);

        menuItem=new JMenuItem("Move");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MoveDialog.show();
                if(MoveDialog.success())
                    for (Primitive primitive:Editor.selected)
                        primitive.move(new Vec2f(MoveDialog.getDX(),MoveDialog.getDY()));
                Main.update();
            }
        });
        commandMenu.add(menuItem);

        menuItem=new JMenuItem("Change");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Editor.selected.size()>1)
                    JOptionPane.showMessageDialog(null,"Can't change multiple objects at once","Select command error",JOptionPane.WARNING_MESSAGE);
                if(Editor.selected.size()==0)
                    JOptionPane.showMessageDialog(null,"Select an object first","Select command error",JOptionPane.WARNING_MESSAGE);
                if(Editor.selected.size()==1){
                    for(Primitive primitive:Editor.selected)
                    {
                        if(primitive.isGroup())
                            JOptionPane.showMessageDialog(null,"Can't change groups","Select command error",JOptionPane.WARNING_MESSAGE);
                        else
                            primitive.change();
                    }
                }
                Main.update();
            }
        });
        commandMenu.add(menuItem);

        menuItem=new JMenuItem("Scale");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScaleDialog.show();
                if(ScaleDialog.success())
                    for (Primitive primitive:Editor.selected)
                        primitive.enlarge(ScaleDialog.getScale());
                Main.update();
            }
        });
        commandMenu.add(menuItem);

        menuItem=new JMenuItem("Recolor");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Primitive primitive:Editor.selected)
                    primitive.setColor(Editor.chooser.getColor());
                Main.update();
            }
        });
        commandMenu.add(menuItem);

        menuItem=new JMenuItem("Clear clip");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Editor.clip=null;
                Main.update();
            }
        });
        commandMenu.add(menuItem);

        menuItem=new JMenuItem("Set background");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.setCanvasBackground(Editor.chooser.getColor());
                Main.update();
            }
        });
        commandMenu.add(menuItem);

    }
}
