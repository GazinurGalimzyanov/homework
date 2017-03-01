import java.util.Scanner;

/**
 * Created by User on 01.03.2017.
 */
public class Skobki {
    public static void main(String[] args) {
        String s;
        char c;
        Stack stack=new Stack();
        Scanner in=new Scanner(System.in);
        s=in.next();
        for (int i=0;i<s.length();i++){
            c=s.charAt(i);
            if(c=='('||c=='['||c=='{'||c=='<'){
                stack.push(c);
            }
            else {try {
                switch (c){
                    case '"':
                        if(c==stack.look()){
                            stack.pop();
                        }
                        else stack.push(c);
                        break;
                    case ')':
                        if(stack.pop()!='(') {
                            throw new Exception();
                        }
                        break;
                    case '>':
                        if(stack.pop()!='<') {
                            throw new Exception();
                        }
                        break;
                    case '}':
                        if(stack.pop()!='{') {
                            throw new Exception();
                        }
                        break;
                    case ']':
                        if(stack.pop()!='[') {
                            throw new Exception();
                        }
                        break;
                }} catch (Exception e) {
                e.printStackTrace();
            }
            }
        }
    }
}
