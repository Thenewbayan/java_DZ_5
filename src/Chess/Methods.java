package Chess;

public class Methods {
    //чат жпт это вещь
    
public static int[][] fillChessboard(int size) {
    int[][] chessboard = new int[size][size];
    int row = size / 2;
    int col = size / 2;
    int count = 1;
    chessboard[row][col] = count;

    while (count < size * size) {
        int minMoves = Integer.MAX_VALUE;
        int nextRow = -1;
        int nextCol = -1;

        // Проверяем все возможные ходы коня из текущей позиции
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                if (Math.abs(i * j) == 2) {
                    int r = row + i;
                    int c = col + j;
                    if (r >= 0 && r < size && c >= 0 && c < size && chessboard[r][c] == 0) {
                        int moves = countMoves(chessboard, r, c, size);
                        if (moves < minMoves) {
                            minMoves = moves;
                            nextRow = r;
                            nextCol = c;
                        }
                    }
                }
            }
        }

        // Если есть следующая позиция, заполняем ее числом в последовательности
        if (nextRow != -1 && nextCol != -1) {
            count++;
            chessboard[nextRow][nextCol] = count;
            row = nextRow;
            col = nextCol;
        } else {
            // Иначе выбираем случайную незаполненную позицию
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (chessboard[i][j] == 0) {
                        count++;
                        chessboard[i][j] = count;
                        row = i;
                        col = j;
                        break;
                    }
                }
            }
        }
    }

    return chessboard;
}

// Метод для подсчета числа возможных ходов коня из заданной позиции
private static int countMoves(int[][] chessboard, int row, int col, int size) {
    int moves = 0;
    for (int i = -2; i <= 2; i++) {
        for (int j = -2; j <= 2; j++) {
            if (Math.abs(i * j) == 2) {
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < size && c >= 0 && c < size && chessboard[r][c] == 0) {
                    moves++;
                }
            }
        }
    }
    return moves;
}
public static void printArray(int[][] array) {
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
            System.out.print(array[i][j] + " ");
        }
        System.out.println();
    }
}

    
}
