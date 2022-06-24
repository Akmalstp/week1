package com.sudukoSol;

class SolveSuduko
{
    //This method checks whether it is safe to put a number in a desire cell
    //By checking its presents in row column and finally in 3by3 board of that cell.
    public static boolean isSafe(int[][] board, int row, int col, int num){
        // checking presence of element in that row.
        for (int d = 0; d < board.length; d++){
            if (board[row][d] == num){
                return false;
            }
        }

        //checking presence of element in that column only.
        for (int r = 0; r < board.length; r++){
            if (board[r][col] == num){
                return false;
            }
        }


        //here we are calculating index of the first cell of that box.
        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        //Finally here we are checking where that element is present in 3*3 box of that index or not.
        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart; d < boxColStart + sqrt; d++){
                if (board[r][d] == num)
                {
                    return false;
                }
            }
        }

        //After checking in row, column and box thoroughly, here we are saying, "It is safe to put that
        // element in this location.
        return true;
    }

    public static boolean solveSudoku(
            int[][] board, int n)
    {
        int row = -1;
        int col = -1;
        //Assuming that we have empty space to fill.
        boolean isEmpty = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (board[i][j] == 0){
                    row = i;
                    col = j;

                    isEmpty = false;
                    break;
                }
            }
            if(!isEmpty) {
                break;
            }
        }
        //Checking whether suduko is already solved or not.
        if(isEmpty){
            return true;
        }

        //Main code in which we are putting values and doing backtrack.
        for (int num = 1; num <= n; num++){
            if (isSafe(board, row, col, num)){
                board[row][col] = num;
                //Here we are checking if after putting this value here is it possible solve the full suduko.
                if (solveSudoku(board, n)){
                    //Finally we will say yes its possible to solve whole suduko by putting this value.
                    return true;
                }
                else{
                    //if not then we will backtrack and try by putting next value.
                    board[row][col] = 0;
                }
            }
        }
        //false means this suduko can not be solved.
        return false;
    }

    public static void print(int[][] board, int N){

        System.out.println("Yeah. Your suduko is solved!");
        for (int r = 0; r < N; r++){
            for (int d = 0; d < N; d++){
                //Here we are printing the solved suduko.
                System.out.print(board[r][d]);
                System.out.print(" ");
            }

            System.out.print("\n");
            if ((r + 1) % (int)Math.sqrt(N) == 0)
            {
                System.out.print("");
            }
        }
    }

    // Driver Code
    public static void main(String args[])
    {
        //This is our edge case board where all cells are empty.
        int[][] edgeBoard = new int[][] {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        //Normal suduko board.
        int[][] board = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };

        int N = board.length;
        //if solveSudoku returns true means there exit one solution so we will print the solved sudoku.
        if (solveSudoku(board, N)){
            print(board, N);
        }
        else{
            System.out.println("Sorry, No solution exist!");
        }
    }
}

