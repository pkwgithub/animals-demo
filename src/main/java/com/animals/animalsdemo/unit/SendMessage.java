package com.animals.animalsdemo.unit;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class SendMessage {
    public static void main(String[] args){
        int  a = 3;
        switch (a) {
            case 1:
                System.out.println("第一个");
                break;
            case 2:
                System.out.println("第二个");
                break;
             default:
                System.out.println("第三个");
        }

    }
}

