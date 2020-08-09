class Solution {
    public int islandPerimeter(int[][] grid) {
        int answer = 0;
        if(grid.length > 1 && grid[0].length > 1) {
            for(int i = 0; i<grid.length; i++) {
                for(int j = 0; j<grid[0].length; j++) {
                    if(i == 0) {
                        if(j == 0) {
                            if(grid[i][j] == 1) {
                                if(grid[i][j+1] == 1 && grid[i+1][j] == 1) {
                                    answer = answer + 2;
                                } else if((grid[i][j+1] == 0 && grid[i+1][j] == 1) || (grid[i][j+1] == 1 && grid[i+1][j] == 0)) {
                                    answer = answer + 3;
                                } else {
                                    answer = answer + 4;
                                }
                            }
                        } else if(j == grid[0].length - 1) {
                            if(grid[i][j] == 1) {
                                if(grid[i][j-1] == 1 && grid[i+1][j] == 1) {
                                    answer = answer + 2;
                                } else if((grid[i][j-1] == 0 && grid[i+1][j] == 1) || (grid[i][j-1] == 1 && grid[i+1][j] == 0)) {
                                    answer = answer + 3;
                                } else {
                                    answer = answer + 4;
                                }
                            }
                        } else {
                            if(grid[i][j] == 1) {
                                int left = grid[i][j-1];
                                int right = grid[i][j+1];
                                int bottom = grid[i+1][j];
                                if(left == 1 && right == 1 && bottom == 1) {
                                    answer += 1;
                                } else if((left == 1 && right == 1 && bottom == 0) || (left == 1 && right == 0 && bottom == 1) || (left == 0 && right == 1 && bottom == 1)) {
                                    answer += 2;
                                } else if((left == 1 && right == 0 && bottom == 0) || (left == 0 && right == 0 && bottom == 1) || (left == 0 && right == 1 && bottom == 0)) {
                                    answer += 3;
                                } else {
                                    answer += 4;
                                }
                            }
                        }
                    } else if(i == grid.length - 1) {
                        if(j == 0) {
                            if(grid[i][j] == 1) {
                                if(grid[i][j+1] == 1 && grid[i-1][j] == 1) {
                                    answer = answer + 2;
                                } else if((grid[i][j+1] == 0 && grid[i-1][j] == 1) || (grid[i][j+1] == 1 && grid[i-1][j] == 0)) {
                                    answer = answer + 3;
                                } else {
                                    answer = answer + 4;
                                }
                            }
                        } else if(j == grid[0].length - 1) {
                            if(grid[i][j] == 1) {
                                if(grid[i][j-1] == 1 && grid[i-1][j] == 1) {
                                    answer = answer + 2;
                                } else if((grid[i][j-1] == 0 && grid[i-1][j] == 1) || (grid[i][j-1] == 1 && grid[i-1][j] == 0)) {
                                    answer = answer + 3;
                                } else {
                                    answer = answer + 4;
                                }
                            }
                        } else {
                            if(grid[i][j] == 1) {
                                int left = grid[i][j-1];
                                int right = grid[i][j+1];
                                int bottom = grid[i-1][j];
                                if(left == 1 && right == 1 && bottom == 1) {
                                    answer += 1;
                                } else if((left == 1 && right == 1 && bottom == 0) || (left == 1 && right == 0 && bottom == 1) || (left == 0 && right == 1 && bottom == 1)) {
                                    answer += 2;
                                } else if((left == 1 && right == 0 && bottom == 0) || (left == 0 && right == 0 && bottom == 1) || (left == 0 && right == 1 && bottom == 0)) {
                                    answer += 3;
                                } else {
                                    answer += 4;
                                }
                            }
                        }
                    } else {
                        if(j == 0) {
                            if(grid[i][j] == 1) {
                                if(grid[i][j+1] == 1 && grid[i-1][j] == 1 && grid[i+1][j] == 1) {
                                    answer += 1;
                                } else if((grid[i][j+1] == 0 && grid[i-1][j] == 1 && grid[i+1][j] == 1) || (grid[i][j+1] == 1 && grid[i-1][j] == 0 && grid[i+1][j] == 1) || (grid[i][j+1] == 1 && grid[i-1][j] == 1 && grid[i+1][j] == 0)) {
                                    answer += 2;
                                } else if((grid[i][j+1] == 0 && grid[i-1][j] == 1 && grid[i+1][j] == 0) || (grid[i][j+1] == 1 && grid[i-1][j] == 0 && grid[i+1][j] == 0) || (grid[i][j+1] == 0 && grid[i-1][j] == 0 && grid[i+1][j] == 1)){
                                    answer += 3;
                                } else {
                                    answer = answer + 4;
                                }
                            }
                        } else if(j == grid[0].length - 1) {
                            if(grid[i][j] == 1) {
                                if(grid[i][j-1] == 1 && grid[i-1][j] == 1 && grid[i+1][j] == 1) {
                                    answer += 1;
                                } else if((grid[i][j-1] == 0 && grid[i-1][j] == 1 && grid[i+1][j] == 1) || (grid[i][j-1] == 1 && grid[i-1][j] == 0 && grid[i+1][j] == 1) || (grid[i][j-1] == 1 && grid[i-1][j] == 1 && grid[i+1][j] == 0)) {
                                    answer += 2;
                                } else if((grid[i][j-1] == 0 && grid[i-1][j] == 1 && grid[i+1][j] == 0) || (grid[i][j-1] == 1 && grid[i-1][j] == 0 && grid[i+1][j] == 0) || (grid[i][j-1] == 0 && grid[i-1][j] == 0 && grid[i+1][j] == 1)){
                                    answer += 3;
                                } else {
                                    answer = answer + 4;
                                }
                            }
                        } else {
                            if(grid[i][j] == 1) {
                                int left = grid[i][j-1];
                                int right = grid[i][j+1];
                                int bottom = grid[i+1][j];
                                int top = grid[i-1][j];
                                int sum = left + right + bottom + top;
                                if(sum == 0) {
                                    answer += 4;
                                } else if(sum == 1) {
                                    answer += 3;
                                } else if(sum == 2) {
                                    answer += 2;
                                } else if(sum == 3) {
                                    answer += 1;
                                }
                            }
                        }
                    }
                }
            }   
        } else if(grid.length > 1 && grid[0].length == 1) {
            for(int i = 0;i<grid.length; i++) {
                if(grid[i][0] == 1) {
                    if(i == 0) {
                        if(grid[i+1][0] == 1) {
                            answer += 3;
                        } else {
                            answer += 4;
                        }
                    } else if(i == grid.length - 1) {
                        if(grid[i-1][0] == 1) {
                            answer += 3;
                        } else {
                            answer += 4;
                        }
                    } else {
                        if(grid[i+1][0] == 1 && grid[i-1][0] == 1) {
                            answer += 2;
                        } else if((grid[i+1][0] == 0 && grid[i-1][0] == 1) || (grid[i+1][0] == 1 && grid[i-1][0] == 0)) {
                            answer += 3;
                        } else {
                            answer += 4;
                        }
                    }   
                }
            }
        } else if(grid.length == 1 && grid[0].length > 1) {
            for(int i = 0;i<grid[0].length; i++) {
                if(grid[0][i] == 1) {
                    if(i == 0) {
                        if(grid[0][i+1] == 1) {
                            answer += 3;
                        } else {
                            answer += 4;
                        }
                    } else if(i == grid[0].length - 1) {
                        if(grid[0][i-1] == 1) {
                            answer += 3;
                        } else {
                            answer += 4;
                        }
                    } else {
                        if(grid[0][i+1] == 1 && grid[0][i-1] == 1) {
                            answer += 2;
                        } else if((grid[0][i+1] == 0 && grid[0][i-1] == 1) || (grid[0][i+1] == 1 && grid[0][i-1] == 0)) {
                            answer += 3;
                        } else {
                            answer += 4;
                        }
                    }   
                }
            }
        } else if(grid.length == 1 && grid[0].length == 1){
            if(grid[0][0] == 1) {
                answer += 4;
            }
        }
        return answer;
    }
}