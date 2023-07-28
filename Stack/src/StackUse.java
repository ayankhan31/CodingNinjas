public class StackUse {
    public static void main(String[] args) throws StackFullException{
        StackUsingArray stack = new StackUsingArray();
//        stack.data[1] = 100;
        stack.push(10);
        stack.top();
        stack.pop();
        stack.size();
        stack.isEmpty();
    }
}
