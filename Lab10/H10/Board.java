package org.example;

public class Board {
    private int size=15;
    private int[][] cells;

    public Board(int size) {
        this.size = size;
        this.cells = new int[size][size];
    }

    public int getSize() {
        return size;
    }

    public void makeMove(int row, int col, int id) {
        cells[row][col] = id;
    }

    public boolean isValidMove(int row, int col) {
        return (row >= 0 && row < size && col >= 0 && col < size && cells[row][col] == 0);
    }

    public int getCell(int row, int col) {
        return cells[row][col];
    }

    public boolean isFull() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (cells[row][col] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWinner(int player) {
        // orizontala
        for (int row = 0; row < size; row++) {
            int count = 0;
            for (int col = 0; col < size; col++) {
                if (cells[row][col] == player) {
                    count++;
                    if (count == 5) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // verticala
        for (int col = 0; col < size; col++) {
            int count = 0;
            for (int row = 0; row < size; row++) {
                if (cells[row][col] == player) {
                    count++;
                    if (count == 5) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // diagonala
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row + 4 < size && col + 4 < size) {
                    if (cells[row][col] == player && cells[row+1][col+1] == player && cells[row+2][col+2] == player &&
                            cells[row+3][col+3] == player && cells[row+4][col+4] == player) {
                        return true;
                    }
                }
                if (row + 4 < size && col - 4 >= 0) {
                    if (cells[row][col] == player && cells[row+1][col-1] == player && cells[row+2][col-2] == player &&
                            cells[row+3][col-3] == player && cells[row+4][col-4] == player) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

