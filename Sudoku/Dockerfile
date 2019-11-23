FROM maven:3.6.2-jdk-14
COPY . .
RUN mvn package 
CMD ["java" ,"-cp", "target/Sudoku-1.0-SNAPSHOT.jar" ,"SudokuGame"] 
