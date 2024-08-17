import java.util.Scanner;

public class Ass1_Q2{
    //Class to create and manage character stacks
    public class stackOfParentheses{ 
        char[] stackP; //Array to store stack elements
        int top; //Index of the top element in the stack
        int size; //Max size of the stack

        //Method to create and initialize stack
        public void stackCreation(int size) { 
            stackP = new char[size]; //Initialize the array with given size
            top = -1; //Initialize top of array to -1 to show if empty
            this.size = size; //Set max size
        }

        public boolean isFull(){ return (top == size-1); } //Checks if stack is full
        public boolean isEmpty(){ return (top == -1); } //Checks if stack is empty

        //Method to push an element onto a stack
        public void push(char item){
            if(isFull()){ //Checks if stack is full before running
                System.out.println("Stack full.");
                return;
            }

            top++; //Increment top index
            stackP[top] = item; //Adds item to the top of the stack
        }

        //Method to pop an element from the stack
        public char pop() {
            if(isEmpty()){ //Check if the stack is empty before popping
                System.out.println("Stack empty.");
                return ' ';
            }

            char item = stackP[top]; //retrieve top element
            top--; //Decrement top index
            return item; //Return the popped element
        }

    }

    //Method to check if the parentheses are balanced
    public boolean balanceChecker(char[] arr, stackOfParentheses S){
        for (char x : arr){

            //If the character is a bracket, push onto the stack
            if (x == '(' || x == '[' || x == '{'){
                S.push(x);
            } else if(x == ')' || x == ']' || x == '}' ){ //If the character is a closing bracket, pop from the stack
                if (S.isEmpty()){ //If stack is empty, return false
                    return false;
                }
                char popped = S.pop(); //Pop the top element from the stack
                //Check if popped element matches the closing bracket
                if ((x == ')' && popped != '(') || (x == ']' && popped != '[') || (x == '}' && popped != '{')){
                    return false;
                }
            }
        }
        return S.isEmpty(); //Once done, returns empty if everything was popped and compared properly
    }

    public static void main(String[] args) {
        Ass1_Q2 balance = new Ass1_Q2(); //Instance of balance class
        stackOfParentheses stack = balance.new stackOfParentheses(); //Instance of stackOfParentheses
        Scanner scanner = new Scanner(System.in); //Scanner class for user input
        
        System.out.println("Enter a string of parentheses: ");
        
        String input = scanner.nextLine();
        char[] arr = input.toCharArray(); //Converts string to character array

        stack.stackCreation(arr.length); //Initialize the stack with the size of the array
        boolean result = balance.balanceChecker(arr, stack); //Check if parentheses are balanced

        //Output the result
        if (result == true){
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
        scanner.close();
    }
}