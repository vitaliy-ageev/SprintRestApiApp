package com.company;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MyPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private String items[] = new String[] { "item1", "item2",
            "item3", "item4", "item5" };

    public MyPanel() {
        setLayout(new BorderLayout()); // выбираем компоновщик

        // сеточная растановка в два столбца
        // много строк
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(0, 2));
        JButton jb;
        JComboBox cb = new JComboBox(items);
        jp.add(cb);
        jb = new JButton("bt1");
        jp.add(jb);
        jb = new JButton("bt2");
        jp.add(jb);
        jb = new JButton("bt3");
        jp.add(jb);
        jb = new JButton("bt4");
        jp.add(jb);

        // укладываем элементы в ящик
        Box bv = new Box(BoxLayout.Y_AXIS);
        // минимальная ширина текстовых полей
        bv.add(Box.createHorizontalStrut(60));

        JTextArea jta = new JTextArea();
        // рамка вокруг текстового поля
        jta.setBorder(BorderFactory.createLineBorder(Color.green));
        bv.add(jta);
        // пустое место в 15 пикселей
        bv.add(Box.createVerticalStrut(15));
        // для эксперемента с размерами
        // jta.setPreferredSize(new Dimension(60,100));
        // jta.setMaximumSize(new Dimension(60,100));
        // jta.setAlignmentX(LEFT_ALIGNMENT); // явно задаем выравнивание

        jta = new JTextArea();
        jta.setBorder(BorderFactory.createLineBorder(Color.green));
        bv.add(jta);
        bv.add(Box.createVerticalStrut(15));

        jta = new JTextArea();
        jta.setBorder(BorderFactory.createLineBorder(Color.green));
        bv.add(jta);
        bv.add(Box.createVerticalStrut(15));

        add(jp); // добавляем панель в центр
        add(bv, BorderLayout.WEST); // добавляем ящик влево
    }
}