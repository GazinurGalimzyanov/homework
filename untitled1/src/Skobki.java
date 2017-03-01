import java.util.Scanner;

/**
 * Created by User on 01.03.2017.
 */
public class Skobki {
    public static void main(String[] args) throws MyException {
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
            else {
                if(c==')'){
                    if(c!=(char)stack.look()+1){
                        throw new MyException();
                    }
                    stack.pop();
                }
                else {
                    if(c!=(char)stack.look()+2){
                        throw new MyException();
                    }
                    stack.pop();
                }
            }
        }
    }
}
