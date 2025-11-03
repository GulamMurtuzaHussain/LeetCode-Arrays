class BrowserHistory {

    List<String> stack = new ArrayList<>();
    List<String> history = new ArrayList<>();

    public BrowserHistory(String homepage) {
        stack.add(homepage);
    }
    
    public void visit(String url) {
        stack.add(url);
        history.clear();
    }
    
    public String back(int steps) {
        while(stack.size()>1 && steps>0){
            String tab = stack.remove(stack.size()-1);
            history.add(tab);
            steps--;
        }
        if(stack.size()==1) return stack.get(stack.size()-1);
        return stack.get(stack.size()-1);
    }
    
    public String forward(int steps) {
        while(history.size()>0 && steps>0){
            String tab = history.remove(history.size()-1);
            stack.add(tab);
            steps--;
        }
        return stack.get(stack.size()-1);
    }
}

/* GPT GPT GPT
import java.util.ArrayDeque;
import java.util.Deque;

class BrowserHistory {
    private Deque<String> back = new ArrayDeque<>();
    private Deque<String> forward = new ArrayDeque<>();
    private String current;

    public BrowserHistory(String homepage) {
        current = homepage;
    }

    public void visit(String url) {
        back.push(current);            // move current to back stack
        current = url;                 // new current page
        forward = new ArrayDeque<>();  // drop forward history (O(1) by reassigning)
    }

    public String back(int steps) {
        while (steps > 0 && !back.isEmpty()) {
            forward.push(current);
            current = back.pop();
            steps--;
        }
        return current;
    }

    public String forward(int steps) {
        while (steps > 0 && !forward.isEmpty()) {
            back.push(current);
            current = forward.pop();
            steps--;
        }
        return current;
    }
}


*/



/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
