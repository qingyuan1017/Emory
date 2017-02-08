 /*
      THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
      CODE WRITTEN BY OTHER STUDENTS. 
      Qingyuan Zhang
      */
/**
 * Starter code for the Maze path finder problem.
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayDeque;


/*
 * Recursive class to represent a position in a path
 */
class Position{
public int i;     //row
public int j;     //column
public char val;  //1, 0, or 'X'
// reference to the previous position (parent) that leads to this position on a path
Position parent;
    Position(int x, int y, char v){
i=x; j = y; val=v;
}
    Position(int x, int y, char v, Position p){
i=x; j = y; val=v;
parent=p;
}
}


public class PathFinder {
public static void main(String[] args) throws IOException {
if(args.length<1){
System.err.println("***Usage: java PathFinder maze_file");
System.exit(-1);
}
char [][] maze;
maze = readMaze(args[0]);
printMaze(maze);
Position [] path = stackSearch(maze);
System.out.println("stackSearch Solution:");
printPath(path);
printMaze(maze);
char [][] maze2 = readMaze(args[0]);
path = queueSearch(maze2);
System.out.println("queueSearch Solution:");
printPath(path);
printMaze(maze2);
}
public static Position [] stackSearch(char [] [] maze){
int n = maze.length;
char[][] symbol = new char[n][n];
ArrayDeque<Position> path = new ArrayDeque<Position>();
Position current;
Position [] link = new Position[n*n*n*n];
         Position[] noway = new Position[0];
for(int i=0;i<n;i++){
for (int j=0;j<n; j++){
symbol[i][j]=maze[i][j];
}
}
 int i=0;
 link[0]=new Position(0,0,'0',null);
 path.push(link[0]);
 
 while(!path.isEmpty()){
 current = path.pop();
 if(current.parent !=null)
 link[i] = new Position(current.i,current.j,current.val,current.parent);
 i++;
 symbol[current.i][current.j]='V';
 
 if(current.i==n-1 && current.j== n -1){
 int m= 0;
 Position s;
 for(s=current;s!=null;s=s.parent){
 m++;
 }
 Position[] result = new Position[m];
 int length =m--;
 for (s=current; s!=null;s=s.parent){
 result[m--] = new Position(s.i,s.j,'X');
 }
 for(m=0;m< length; m++)
 maze[result[m].i] [result[m].j]='X';
 
 return result;
 }
 else{
 Position next;
 if(current.i-1 >=0 && symbol[current.i-1][current.j]=='0'){
 next = new Position(current.i-1,current.j,'X',link[i-1]);
 path.push(next);
 }
 if(current.i+1 <n && symbol[current.i+1][current.j]=='0'){
 next = new Position(current.i+1,current.j,'X',link[i-1]);
 path.push(next);
 }
 if(current.j-1 >=0 && symbol[current.i][current.j-1]=='0'){
 next = new Position(current.i,current.j-1,'X',link[i-1]);
 path.push(next);
 }
 if(current.j+1 <n && symbol[current.i][current.j+1]=='0'){
 next = new Position(current.i,current.j+1,'X',link[i-1]);
 path.push(next);
 }
 }
 
 
 }
// todo: your path finding algorithm here using the stack to manage search list
// your algorithm should mark the path in the maze, and return array of Position 
// objects coressponding to path, or null if no path found
return noway;
}


public static Position [] queueSearch(char [] [] maze){
int n = maze.length;
char[][] symbol = new char[n][n];
ArrayDeque<Position> path = new ArrayDeque<Position>();
Position current;
Position [] link = new Position[n*n*n];
        Position[] noway = new Position[0];
for(int i=0;i<n;i++){
for (int j=0;j<n; j++){
symbol[i][j]=maze[i][j];
}
}
 int i=0;
 link[0]=new Position(0,0,'0',null);
 path.add(link[0]);
 
 while(!path.isEmpty()){
 current = path.remove();
 if(current.parent !=null)
 link[i] = new Position(current.i,current.j,current.val,current.parent);
 i++;
 symbol[current.i][current.j]='V';
 
 if(current.i==n-1 && current.j== n -1){
 int m= 0;
 Position s;
 for(s=current;s!=null;s=s.parent){
 m++;
 }
 Position[] result = new Position[m];
 int length =m--;
 for (s=current; s!=null;s=s.parent){
 result[m--] = new Position(s.i,s.j,'X');
 }
 for(m=0;m< length; m++)
 maze[result[m].i] [result[m].j]='X';
 
 return result;
 }
 else{
 Position next;
 if(current.i-1 >=0 && symbol[current.i-1][current.j]=='0'){
 next = new Position(current.i-1,current.j,'X',link[i-1]);
 path.add(next);
 }
 if(current.i+1 <n && symbol[current.i+1][current.j]=='0'){
 next = new Position(current.i+1,current.j,'X',link[i-1]);
 path.add(next);
 }
 if(current.j-1 >=0 && symbol[current.i][current.j-1]=='0'){
 next = new Position(current.i,current.j-1,'X',link[i-1]);
 path.add(next);
 }
 
 if(current.j+1 <n && symbol[current.i][current.j+1]=='0'){
 next = new Position(current.i,current.j+1,'X',link[i-1]);
 path.add(next);
 }
 }
 
 
 }
// todo: your path finding algorithm here using the stack to manage search list
// your algorithm should mark the path in the maze, and return array of Position 
// objects coressponding to path, or null if no path found
return noway;
}
public static void printPath(Position [] path){
System.out.print("Path:");
for(int i=0; i< path.length; i++){
Position print = path[i];
System.out.print("["+print.i+","+print.j+"]");
}
System.out.println();
// todo: print the path to the stdout
}
/**
* Reads maze file in format:
* N  -- size of maze
* 0 1 0 1 0 1 -- space-separated 
* @param filename
* @return
* @throws IOException
*/
public static char [][] readMaze(String filename) throws IOException{
char [][] maze;
Scanner scanner;
try{
scanner = new Scanner(new FileInputStream(filename));
}
catch(IOException ex){
System.err.println("*** Invalid filename: " + filename);
return null;
}
int N = scanner.nextInt();
scanner.nextLine();
maze = new char[N][N];
int i=0;
while(i < N && scanner.hasNext()){
String line =  scanner.nextLine();
String [] tokens = line.split("\\s+");
int j = 0;
for (; j< tokens.length; j++){
maze[i][j] = tokens[j].charAt(0);
}
if(j!=N){
System.err.println("*** Invalid line: " + i + " has wrong # columns: " + j);
return null;
}
i++;
}
if(i!=N){
System.err.println("*** Invalid file: has wrong number of rows: " + i);
return null;
}
return maze;
}
public static void printMaze(char[][] maze){
if(maze==null || maze[0] == null){
System.err.println("*** Invalid maze array");
return;
}
for(int i=0; i< maze.length; i++){
for(int j = 0; j< maze[0].length; j++){
System.out.print(maze[i][j] + " ");	
}
System.out.println();
}
System.out.println();
}

}
