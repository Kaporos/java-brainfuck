import java.util.Scanner;

public class FuckingInterpreter {
    void execute(String content) {
        System.out.println("[*] Brainfuck program size: "+(content.length()));
        System.out.println("[*] Executing brainfuck. Here is your program output: ");
        // Global state
        int pointer = 0;
        int[] table = new int[30000];

        // Execution state
        int curr_char = 0;
        int rec_count = 0;
        loop: while (curr_char < content.length()) {
            char current = content.charAt(curr_char);
            switch (current) {
                case '>' -> {
                    if (pointer >= 30000) {
                        System.out.println("ERROR: Out of bounds at index "  +curr_char);
                        break loop;
                    }
                    pointer++;
                }
                case '<' -> {
                    if (pointer == 0) {
                        System.out.println("ERROR: Out of bounds at index "  +curr_char);
                        break loop;
                    }
                    pointer--;
                }
                case '+' -> {
                    table[pointer] ++;
                }
                case '-' -> {
                    table[pointer] --;

                }
                case '.' -> {
                    System.out.print((char) table[pointer]);

                }
                case ',' -> {
                    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                    String letter = "too long :D";
                    while (letter.length() > 1) {
                        System.out.print("Your program is asking for a char at index "+curr_char+" (max 1 char): ");
                        letter = myObj.nextLine();  // Read user input

                    }
                    table[pointer] = (int) letter.charAt(0);
                }
                case '[' -> {
                    rec_count ++;
                    if (table[pointer] == 0) {
                        while (rec_count != 0) {
                            curr_char++;
                            if (content.charAt(curr_char) == ']') {
                                rec_count--;
                            }
                        }
                    }
                    rec_count = 0;
                }
                case ']' -> {
                    rec_count++;
                    if (table[pointer] != 0) {
                        while (rec_count != 0) {
                            curr_char--;
                            if (content.charAt(curr_char) == '[') {
                                rec_count--;
                            }
                        }
                    }
                    rec_count = 0;
                }
                default -> {
                    System.out.println("Error at pointer: "+curr_char+" because "+content.charAt(curr_char)+" is not valid brainfuck.");
                    break loop;
                }
            }
            curr_char ++;
        }
        System.out.println();
        System.out.println("[*] Execution ended.");
    }
 }
