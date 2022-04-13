package com.animals.animalsdemo.unit;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Test {
    public static void main(String[] args) {
      int i =0;
      if(i==0){
          System.out.println("1");
          return;
      }
        System.out.println("2");
    }

    private static void placeComponents(JPanel panel) {

        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel.setLayout(null);

        // 创建 JLabel
        JLabel userLabel = new JLabel("发送语言：");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        /*
         * 创建文本域用于用户输入
         */
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        // 输入密码的文本域
//        JLabel passwordLabel = new JLabel("Password:");
//        passwordLabel.setBounds(10,50,80,25);
//        panel.add(passwordLabel);

        /*
         *这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */
//        JPasswordField passwordText = new JPasswordField(20);
//        passwordText.setBounds(100,50,165,25);
//        panel.add(passwordText);

        // 创建登录按钮
        JButton sendButton = new JButton("发送");
        sendButton.setBounds(10, 80, 80, 25);
        addActionListener(sendButton);
        panel.add(sendButton);
    }

    private static void addActionListener(JButton saveButton) {
        // 为按钮绑定监听器
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 对话框
                JOptionPane.showMessageDialog(null, "发送成功！");
            }
        });
    }

}

