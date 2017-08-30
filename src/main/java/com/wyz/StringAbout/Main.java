package com.wyz.StringAbout;

/**
 * Created by yzwang on 2017/8/25.
 */
import java.util.Scanner;

public class Main {
    /** ÇëÍê³ÉÏÂÃæÕâ¸öprocessº¯Êý£¬ÊµÏÖÌâÄ¿ÒªÇóµÄ¹¦ÄÜ **/
    /** µ±È»£¬ÄãÒ²¿ÉÒÔ²»°´ÕÕÕâ¸öÄ£°åÀ´×÷´ð£¬ÍêÈ«°´ÕÕ×Ô¼ºµÄÏë·¨À´ ^-^ **/
    private static int process() {

        for(int i=0;i<items.length;i++){
            if(items[i].length>boxTemplate.length||items[i].width>boxTemplate.width||items[i].height>boxTemplate.height)
                return -1;
            if(items[i].price>CUSTOMS_LIMIT_MONEY_PER_BOX)
                return -1;
        }
        int cou=items.length;
        for(int i=0;i<items.length-1;i++){
            for(int j=i+1;j<items.length;j++){
                if(items[i].status==0&&items[j].status==0){
                    Model item=hehe(items[i],items[j]);
                    if(item!=null){
                        items[i].status=-1;
                        items[j].status=-1;
                        cou--;
                    }
                }
            }
        }

        return cou;
    }

    private static Model hehe(Model m1, Model m2) {
        Model hehe=new Model();
        hehe.price=m1.price+m2.price;
        if(m1.length==m2.length&&m1.width==m2.width&&m1.height==m2.height){
            hehe.length=m1.length*2;
            hehe.width=m1.width;
            hehe.height=m1.height;
        }
        else if(m1.length==m2.length&&m1.width==m2.width)
        {
            hehe.length=m1.length;
            hehe.width=m1.width;
            hehe.height=m1.height+m2.height;
        }
        else if(m1.length==m2.length&&m1.height==m2.height)
        {
            hehe.length=m1.length;
            hehe.width=m1.width+m2.width;
            hehe.height=m1.height;
        }
        else if(m1.height==m2.height&&m1.height==m2.height){
            hehe.length=m1.length+m2.length;
            hehe.width=m1.width;
            hehe.height=m1.height;
        }
        else{
            hehe.length=m1.length+m2.length;
            hehe.width=Math.max(m1.width,m2.width);
            hehe.height=Math.max(m1.height,m2.height);
        }
        if(hehe.length<=boxTemplate.length&&hehe.width<=boxTemplate.width&&hehe.height<=boxTemplate.height&&hehe.price<=CUSTOMS_LIMIT_MONEY_PER_BOX)
            return hehe;
        return null;
    }

    public static int CUSTOMS_LIMIT_MONEY_PER_BOX = 2000;
    public static Model boxTemplate = new Model();
    public static Model[] items;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        boxTemplate.price = CUSTOMS_LIMIT_MONEY_PER_BOX;

        while (scanner.hasNext()) {
            boxTemplate.length = scanner.nextInt();
            boxTemplate.width = scanner.nextInt();
            boxTemplate.height = scanner.nextInt();
            boxTemplate.prepro();
            int itemNum = scanner.nextInt();
            items = new Model[itemNum];
            for (int i = 0; i < itemNum; i++) {
                Model item = new Model();
                item.price = scanner.nextInt();
                item.length = scanner.nextInt();
                item.width = scanner.nextInt();
                item.height = scanner.nextInt();
                item.prepro();
                items[i] = item;
            }
            // long startTime = System.currentTimeMillis();
            int boxMinNum = Integer.MAX_VALUE;
            System.out.println(process());

        }
    }

}

class Model {
    int status;
    int price;
    int length;
    int width;
    int height;
    public void prepro(){
        int max=Math.max(Math.max(length, width),height);
        int min=Math.min(Math.min(length, width),height);
        length=min;
        width=(length+width+height)-max-min;
        height=max;
    }
}

