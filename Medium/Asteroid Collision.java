class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for(int i = 0; i<asteroids.length; i++) {
            if(stack.isEmpty()) {
                stack.push(asteroids[i]);
                continue;
            }
            if(asteroids[i]>0) {
                stack.push(asteroids[i]);
            } else {
                if(stack.peek()<0) {
                    stack.push(asteroids[i]);
                } else {
                    if(Math.abs(stack.peek()) == Math.abs(asteroids[i])) {
                        stack.pop();
                    } else if(Math.abs(stack.peek()) > Math.abs(asteroids[i])) {
                        // do nothing
                    } else {
                        boolean flag = false;
                        while(!stack.isEmpty() && stack.peek() > 0 && Math.abs(stack.peek()) <= Math.abs(asteroids[i])) {
                            if(stack.peek() == Math.abs(asteroids[i])) {
                                stack.pop();
                                flag = true;
                                break;
                            }
                            stack.pop();
                        }
                        if(flag) {
                            continue;
                        }
                        if(!stack.isEmpty() && stack.peek() < 0) {
                            stack.push(asteroids[i]);
                            continue;
                        } else if(!stack.isEmpty() && Math.abs(stack.peek()) > Math.abs(asteroids[i])) {
                            //do nothing
                        } else {
                            stack.push(asteroids[i]);   
                        }
                    }
                }
            }
        }
        
        int[] result = new int[stack.size()];
        for(int i = result.length-1; i>=0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}