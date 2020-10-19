class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] array = preorder.split(",");
        Stack<String> stack = new Stack();
        
        if(array[0] == "#") {
            return false;
        } else {
            stack.push(array[0]);
        }
        for(int i = 1; i<array.length; i++) {
            if(array[i].equals("#")) {
                if(stack.peek().equals("#")) {
                    if(stack.size() < 2) {
                        return false;
                    }
                    while(stack.peek().equals("#")) {
                        stack.pop();
                        stack.pop();
                        if(stack.isEmpty() || stack.size() == 1) {
                            break;
                        }
                    }
                    stack.push(array[i]);
                } else {
                    stack.push(array[i]);
                }
            } else {
                stack.push(array[i]);
            }
        }
        
        if(stack.size() == 1 && stack.peek().equals("#")) {
            return true;
        }
        return false;
    }
}