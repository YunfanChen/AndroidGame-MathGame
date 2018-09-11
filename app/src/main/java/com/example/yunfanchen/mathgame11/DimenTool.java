package com.example.yunfanchen.mathgame11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by YunfanChen on 3/23/2018.
 */

public class DimenTool {
    public static void gen() {

        File file = new File("./app/src/main/res/values/dimens.xml");
        BufferedReader reader = null;
        StringBuilder sw300 = new StringBuilder();
        StringBuilder sw330 = new StringBuilder();
        StringBuilder sw370 = new StringBuilder();
        StringBuilder sw480 = new StringBuilder();
        StringBuilder sw600 = new StringBuilder();
        StringBuilder sw720 = new StringBuilder();
        StringBuilder sw800 = new StringBuilder();
        StringBuilder w820 = new StringBuilder();


        try {
            System.out.println("生成不同分辨率：");
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束

            while ((tempString = reader.readLine()) != null) {

                if (tempString.contains("</dimen>")) {
                    //tempString = tempString.replaceAll(" ", "");
                    String start = tempString.substring(0, tempString.indexOf(">") + 1);
                    String end = tempString.substring(tempString.lastIndexOf("<") - 2);
                    int num = Integer.valueOf(tempString.substring(tempString.indexOf(">") + 1, tempString.indexOf("</dimen>") - 2));
                    sw300.append(start).append((int) Math.round(num * 0.71)).append(end).append("\n");
                    sw330.append(start).append((int) Math.round(num * 0.786)).append(end).append("\n");
                    sw370.append(start).append((int) Math.round(num * 0.88)).append(end).append("\n");
                    sw480.append(start).append((int) Math.round(num * 1.143)).append(end).append("\n");
                    sw600.append(start).append((int) Math.round(num * 1.43)).append(end).append("\n");
                    sw720.append(start).append((int) Math.round(num * 1.71)).append(end).append("\n");
                    sw800.append(start).append((int) Math.round(num * 1.9)).append(end).append("\n");
                    w820.append(start).append((int) Math.round(num * 1.95)).append(end).append("\n");

                } else {
                    sw300.append(tempString).append("\n");
                    sw330.append(tempString).append("\n");
                    sw370.append(tempString).append("\n");
                    sw480.append(tempString).append("\n");
                    sw600.append(tempString).append("\n");
                    sw720.append(tempString).append("\n");
                    sw800.append(tempString).append("\n");
                    w820.append(tempString).append("\n");
                }
                line++;
            }
            reader.close();
            System.out.println("<!--  sw300 -->");
            System.out.println(sw300);
            System.out.println("<!--  sw330 -->");
            System.out.println(sw330);
            System.out.println("<!--  sw370 -->");
            System.out.println(sw370);
            System.out.println("<!--  sw480 -->");
            System.out.println(sw480);
            System.out.println("<!--  sw600 -->");
            System.out.println(sw600);
            System.out.println("<!--  sw720 -->");
            System.out.println(sw720);
            System.out.println("<!--  sw800 -->");
            System.out.println(sw800);

            String sw300file = "./app/src/main/res/values-sw300dp-land/dimens.xml";
            String sw330file = "./app/src/main/res/values-sw330dp-land/dimens.xml";
            String sw370file = "./app/src/main/res/values-sw370dp-land/dimens.xml";
            String sw480file = "./app/src/main/res/values-sw480dp-land/dimens.xml";
            String sw600file = "./app/src/main/res/values-sw600dp-land/dimens.xml";
            String sw720file = "./app/src/main/res/values-sw720dp-land/dimens.xml";
            String sw800file = "./app/src/main/res/values-sw800dp-land/dimens.xml";
            String w820file = "./app/src/main/res/values-w820dp/dimens.xml";
            writeFile(sw300file, sw300.toString());
            writeFile(sw330file, sw330.toString());
            writeFile(sw370file, sw370.toString());
            writeFile(sw480file, sw480.toString());
            writeFile(sw600file, sw600.toString());
            writeFile(sw720file, sw720.toString());
            writeFile(sw800file, sw800.toString());
            writeFile(w820file, w820.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public static void writeFile(String file, String text) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.close();
    }

    public static void main(String[] args) {
        gen();
    }
}
