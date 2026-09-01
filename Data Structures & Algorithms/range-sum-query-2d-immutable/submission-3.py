class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        row, col= len(matrix), len(matrix[0])
        self.prefixsum= [[0]*col for i in range(row)]
        
        for i in range(row):
            for j in range(col):
                top= self.prefixsum[i-1][j] if i>0 else 0
                left= self.prefixsum[i][j-1] if j>0 else 0
                topleft= self.prefixsum[i-1][j-1] if i>0 and j>0 else 0
                self.prefixsum[i][j]= matrix[i][j]+top+left-topleft        

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        
        total = self.prefixsum[row2][col2]
        left = self.prefixsum[row2][col1-1] if col1>0 else 0
        top = self.prefixsum[row1-1][col2] if row1>0 else 0
        topleft = self.prefixsum[row1-1][col1-1] if row1>0 and col1 > 0 else 0 
      
        return total-left-top+topleft
        

# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)