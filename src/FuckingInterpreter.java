public class FuckingInterpreter {
    private String content;
    FuckingInterpreter(String content) {
        this.content = content;
        System.out.println("[*] Brainfuck program size: "+(content.length()));
    }
    void execute() {
        System.out.println("[*] Executing brainfuck. Here is your program output: ");
        // Global state
        int pointer = 0;
        int[] table = new int[30000];

        // Execution state
        int curr_char = 0;
        int rec_count = 0;
        l: while (curr_char < content.length()) {
            char current = content.charAt(curr_char);
            switch (current) {
                case '>' -> {
                    pointer++;
                }
                case '<' -> {
                    if (pointer == 0) {
                        System.out.println("Out of bonds at index "  +curr_char);
                        break l;
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
                    table[pointer] = 4;
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
                    break l;
                }
            }
            curr_char ++;
        }
        System.out.println();
        System.out.println("[*] Execution ended.");
    }
 }