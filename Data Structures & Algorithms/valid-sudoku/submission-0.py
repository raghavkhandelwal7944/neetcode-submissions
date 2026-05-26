class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows=defaultdict(set)
        columns=defaultdict(set)
        squares=defaultdict(set)
        
        for i in range(9):
            for j in range(9):
                current_val = board[i][j]
                
                if current_val == ".":
                    continue
            
                if current_val in rows[i] or current_val in columns[j] or current_val in squares[(i//3,j//3)]:
                    return False
                
                
                rows[i].add(current_val)
                columns[j].add(current_val)
                squares[(i//3,j//3)].add(current_val)
        return True

        
        
        

