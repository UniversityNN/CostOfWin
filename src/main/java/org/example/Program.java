package org.example;

import java.util.Scanner;

public class Program {
    int x,y,count,cost;
    Monster[] mons;
    int[][] map;
    public Program(){
        Scanner scan = new Scanner(System.in);
        x = scan.nextInt();
        y = scan.nextInt();
        cost = x*y;
        map = new int[x][];
        for (int i=0;i<x;i++){
            map[i] = new int[y];
        }
        count = scan.nextInt();
        mons = new Monster[count];
        for (int i=0;i<count;i++){
            mons[i] = new Monster();
            mons[i].x = scan.nextInt();
            mons[i].y = scan.nextInt();
            map[mons[i].x][mons[i].y] = 1;
        }
        print();
        int xl,xr,yb,yt;
        for (Monster m : mons) {
            xl=0;xr=0;yb=0;yt=0;
            if (m.x==0) {
                map[m.x+1][m.y] = 2;
                xr = x+1;
            }
            else {
                map[m.x-1][m.y] = 2;
                xl = m.x-1;
            }
            if (m.x==x-1) map[m.x-1][m.y] = 2;
            else map[m.x+1][m.y] = 2;
            if (m.y==0) map[m.x][m.y+1] = 2;
            else map[m.x][m.y-1] = 2;
            if (m.y==y-1) map[m.x][m.y-1] = 2;
            else map[m.x][m.y+1] = 2;
            print();

            map_setup();
        }
    }
    private void print(){
        for (int i=0;i<x;i++){
            for (int j=0;j<y;j++){
                System.out.printf("%d",map[i][j]);
            }
            System.out.printf("\n");
        }
        System.out.printf("----");
    }
    private boolean check(int x,int y){
        for (var m:mons){
            if (x==m.x && y==m.y) return true;
        }
        return false;
    }
    private int check_map(){

    }
    private void map_setup(){
        for (int i=0;i<x;i++){
            for (int j=0;j<y;j++){
                if (check(i,j)){
                    map[mons[i].x][mons[i].y] = 1;
                }
                else{
                    map[mons[i].x][mons[i].y] = 0;
                }
            }
        }
    }
}
