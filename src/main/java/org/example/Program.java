package org.example;

import java.util.Scanner;

public class Program {
    public Program(){
        int x,y,count,cost=0,tcost=0;
        Scanner scan = new Scanner(System.in);
        x = scan.nextInt();
        y = scan.nextInt();
        count = scan.nextInt();
        if (count==1 || (x==1 && y==1)){
            System.out.print(1);
        }
        else{
            int[][] map = new int[x][y];
            int xmin=x,ymin=y,xmax=0,ymax=0;
            int tx,ty;
            for (int i=0;i<count;i++){
                tx = scan.nextInt()-1;
                ty = scan.nextInt()-1;
                map[tx][ty] = 1;
                if (tx<xmin) xmin=tx;
                if (tx>xmax) xmax=tx;
                if (ty<ymin) ymin=ty;
                if (ty>ymax) ymax=ty;
            }
            if (xmax==0 && (map[0][1]!=1 || map[0][y-2]!=1)){
                tcost = calculate(xmin,xmax,ymin+1,ymax);
                if (tcost>cost) cost = tcost;
                tcost = calculate(xmin,xmax,ymin,ymax-1);
                if (tcost>cost) cost = tcost;
            }
            if (ymax==0 && (map[1][0]!=1 || map[x-2][0]!=1)){
                tcost = calculate(xmin+1,xmax,ymin,ymax);
                if (tcost>cost) cost = tcost;
                tcost = calculate(xmin,xmax-1,ymin,ymax);
                if (tcost>cost) cost = tcost;
            }
            if (cost == 0) {
                cost = calculate(xmin,xmax,ymin,ymax);
                if (xmin>0){
                    tcost = calculate(xmin-1,xmax,ymin,ymax);
                    if (tcost>cost) cost = tcost;
                }
                if (xmax<x-1){
                    tcost = calculate(xmin,xmax+1,ymin,ymax);
                    if (tcost>cost) cost = tcost;
                }
                if (ymin>0){
                    tcost = calculate(xmin,xmax,ymin-1,ymax);
                    if (tcost>cost) cost = tcost;
                }
                if (ymax<y-1){
                    tcost = calculate(xmin,xmax,ymin,ymax+1);
                    if (tcost>cost) cost = tcost;
                }
            }
            System.out.print(cost);
        }
    }
    private int calculate(int x1,int x2,int y1,int y2){
        return (x2 - x1 + 1) * (y2 - y1 + 1);
    }
}
