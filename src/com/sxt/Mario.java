package com.sxt;

import java.awt.image.BufferedImage;

public class Mario implements Runnable{
    //用于表示横纵坐标
    private int x;
    private int y;
    //用于表示当前的状态
    private String status;
    //用于显示当前状态对应的图像
    private BufferedImage show = null;

    //定义一个BackGround对象，用来获取障碍物的信息
    private BackGround backGround = new BackGround();
    //用来实现马里奥的动作
    private Thread thread = null;
    //马里奥的移动速度
    private int xSpeed;
    //马里奥的跳跃速度
    private int ySpeed;
    //定义一个索引
    private int index;
    //表示马里奥上升的时间
    private int upTime = 0;

    public Mario(){

    }
    public Mario(int x,int y){
        this.x = x;
        this.y =y;
        show = StaticValue.stand_R;
        this.status = "stand--right";
        thread = new Thread(this);
        thread.start();
    }


    //马里奥向左移动
    public void leftMove(){
        //改变速度
        xSpeed = -5;
        //判断马里奥是否处于空中
        if(status.indexOf("jump")!= -1){
            status = "jump--left";
        }else{
            status = "move--left";
        }
    }

    //马里奥向右移动
    public void rightMove(){
        xSpeed = 5;
        if(status.indexOf("jump")!= -1){
            status = "jump--right";
        }else{
            status = "move--right";
        }
    }

    //马里奥向左停止
    public void  leftStop(){
        xSpeed = 0;
        if(status.indexOf("jump")!= -1){
            status = "jump--left";
        }else{
            status = "stop--left";
        }
    }

    //马里奥向右停止
    public void rightStop(){
        xSpeed = 0;
        if(status.indexOf("jump")!= -1){
            status = "jump--right";
        }else{
            status = "stop--right";
        }
    }

    //马里奥跳跃
    public void jump(){
        if(status.indexOf("jump")==-1){
            if(status.indexOf("left")!=-1){
                status = "jump--left";
            }else{
                status = "jump--right";
            }
            ySpeed=-10;
            upTime = 7;
        }
    }
    //马里奥下落
    public void fall(){
        if(status.indexOf("left")!=-1){
            status = "jump--left";
        }else{
            status = "jump--right";
        }
        ySpeed = 10;
    }



    @Override
    public void run() {
        while(true){
            if(xSpeed<0||xSpeed>0){
                x += xSpeed;
                //判断马里奥是否运动到了屏幕的最左边
                if(x<0){
                    x=0;
                }
            }
            //判断当前是否是移动状态
            if(status.contains("move")){
                index = index==0?1:0;
            }
            //判断马里奥是否向左移动
            if("move--left".equals(status)){
                show = StaticValue.run_L.get(index);
            }
            //判断马里奥是否向右移动
            if("move--right".equals(status)){
                show = StaticValue.run_R.get(index);
            }
            //判断马里奥是否向左停止
            if("stop--left".equals(status)){
                show = StaticValue.stand_L;
            }
            //判断马里奥是否向右停止
            if("stop--right".equals(status)){
                show = StaticValue.stand_R;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BufferedImage getShow() {
        return show;
    }

    public void setShow(BufferedImage show) {
        this.show = show;
    }


    public void setBackGround(BackGround backGround) {
        this.backGround = backGround;
    }

}
