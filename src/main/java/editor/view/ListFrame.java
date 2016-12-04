package editor.view;

import editor.Editor;
import editor.Main;
import editor.primitives.Group;
import editor.primitives.Primitive;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by svuatoslav on 12/4/16.
 */
public class ListFrame extends JFrame {
    private JPanel actions;
    private JButton delete;
    private JButton group;
    private JButton select;
    private JButton up;
    private JButton down;
    private JButton rename;
    private JScrollBar scrollBar;

    public ListFrame()
    {
        actions=new JPanel();
        actions.setLayout(new GridLayout(2,4));

        select=new JButton("Select");
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Primitive primitive:Editor.selectPanel.getSelectedValuesList())
                {
                    primitive.select(true);
                }
                Main.update();
            }
        });

        rename=new JButton("Rename");
        rename.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Primitive primitive:Editor.selectPanel.getSelectedValuesList())
                {
                    if(primitive.isGroup())
                        primitive.setName(JOptionPane.showInputDialog(null,"Name", "Group"));
                }
                Main.update();
            }
        });

        up=new JButton();
        try {
            up.setIcon(new ImageIcon(ImageIO.read(new File("src/main/resources/circle.bmp"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        up.setBackground(Color.WHITE);
        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Primitive primitive = Editor.selectPanel.getSelectedValue();
                if(primitive==null)
                    return;
                int i = Editor.primitives.indexOf(primitive);
                if(i!=0)
                {
                    Editor.primitives.remove(primitive);
                    Editor.primitives.add(i-1,primitive);
                }
                Main.update();
            }
        });

        down=new JButton();
        try {
            down.setIcon(new ImageIcon(ImageIO.read(new File("src/main/resources/circle.bmp"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        down.setBackground(Color.WHITE);
        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Primitive primitive = Editor.selectPanel.getSelectedValue();
                if(primitive==null)
                    return;
                int i = Editor.primitives.indexOf(primitive);
                if(i<Editor.primitives.size()-1)
                {
                    Editor.primitives.remove(primitive);
                    Editor.primitives.add(i+1,primitive);
                }
                Main.update();
            }
        });

        delete=new JButton("Delete");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Primitive primitive:Editor.selectPanel.getSelectedValuesList())
                {
                    Editor.primitives.remove(primitive);
                    List<Primitive> insert = primitive.collapse();
                    if(insert!=null)
                        for(Primitive primitive1:insert)
                            Editor.primitives.add(primitive1);
                }
                Main.update();
            }
        });

        group=new JButton("Group");
        group.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=null;
                for (Primitive primitive: Editor.selectPanel.getSelectedValuesList())
                {
                    if(primitive.getName()!=null)
                        if(name==null)
                            name=primitive.getName();
                        else
                        {
                            name=null;
                            break;
                        }
                }
                if(name==null)
                    name = JOptionPane.showInputDialog(null,"Name", "Group");
                if(name!=null) {
                    Group group = new Group(name);
                    for (Primitive primitive : Editor.selectPanel.getSelectedValuesList()) {
                        Editor.primitives.remove(primitive);
                        primitive.select(false);
                        List<Primitive> contained = primitive.collapse();
                        if(contained==null)
                            group.add(primitive);
                        else
                            for(Primitive primitive1:contained)
                                group.add(primitive1);
                    }
                    Editor.primitives.add(group);
                    Main.update();
                }
            }
        });

        actions.add(group);
        actions.add(select);
        actions.add(delete);
        actions.add(up);
        actions.add(rename);
        actions.add(down);
        add(actions, BorderLayout.SOUTH);
        add(new JScrollPane(Editor.selectPanel));
        setMinimumSize(new Dimension(100,500));
        setMaximumSize(new Dimension(100,500));
        setResizable(false);
        setLocation(100,100);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setTitle("Object list");
        pack();
        setVisible(true);
    }

    public void update()
    {
        Editor.selectPanel.update();
    }
}
