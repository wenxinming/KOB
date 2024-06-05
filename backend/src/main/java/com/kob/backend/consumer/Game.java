package com.kob.backend.consumer;

import java.util.Random;

/**
 * @Author:Smart7 Description:
 */
public class Game {
    final private Integer rows;
    final private Integer clos;
    final private Integer inner_walls_count;
    final private int[][] g;
    final private static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public Game(Integer rows, Integer clos, Integer inner_walls_count) {
        this.rows = rows;
        this.clos = clos;
        this.inner_walls_count = inner_walls_count;
        this.g = new int[rows][clos];
    }

    public int[][] getG() {
        return g;
    }

    private boolean check_connectivity(int sx, int sy, int tx, int ty) {
        if(sx == tx && sy == ty) return true;
        g[sx][sy] = 1;

        for(int i = 0; i < 4; i++) {
            int x = sx + dx[i], y = sy + dy[i];
            if(x >= 0 && x < this.rows && y >= 0 && y < this.clos && g[x][y] == 0) {
                if(check_connectivity(x,y,tx,ty)) {
                    g[sx][sy] = 0;
                    return true;
                }
            }
        }

        g[sx][sy] = 0;
        return false;
    }

    private boolean draw() {   //画地图
        for(int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.clos; j++) {
                g[i][j] = 0;
            }
        }

        for(int r = 0; r < this.rows; r++) {
            g[r][0] = g[r][this.clos - 1] = 1;
        }
        for(int c = 0; c < this.clos; c++) {
            g[0][c] = g[this.rows - 1][c] = 1;
        }

        Random random = new Random();
        for(int i = 0; i < this.inner_walls_count / 2; i++) {
            for(int j = 0; j < 1000; j++) {
                int r = random.nextInt(this.rows);
                int c = random.nextInt(this.clos);

                if (g[r][c] == 1 || g[this.rows - 1 - r][this.clos - 1 - c] == 1)
                    continue;
                if (r == this.rows - 2 && c == 1 || r == 1 && c == this.clos - 2)
                    continue;

                g[r][c] = g[this.rows - 1 - r][this.clos - 1 - c] = 1;
                break;
            }
        }

        return check_connectivity(this.rows - 2, 1, 1, this.clos - 2);
    }

    public void createMap() {
        for(int i = 0; i < 1000; i++) {
            if(draw()) {
                break;
            }
        }
    }
}
