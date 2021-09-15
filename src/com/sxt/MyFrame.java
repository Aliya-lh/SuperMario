package com.sxt;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements KeyListener {
    public MyFrame(){
        //设置窗口的大小为800*600
        this.setSize(800,600);
       //设置窗口居中显示
        this.setLocationRelativeTo(null);
       //设置窗口的可见性
        this.setVisible(true);
       //设置点击窗口上的关闭键，结束程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口大小不可变
        this.setResizable(false);
        //向窗口对象添加键盘监听器
        this.addKeyListener(this);
        //设置窗口名称
        this.setTitle("我的超级玛丽");
        //初始化图片
        StaticValue.init();
    }

    public static void main(String[] args) {
       MyFrame myFrame = new MyFrame();

    }








    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

