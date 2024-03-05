
public class UseStack {
	
	//implement this method.
	public static Stack sort(Stack s) throws Exception {
		ArrayListStack st = new ArrayListStack();  //create temp stack
		
		while(!s.isEmpty()) {                                //run when s is not empty
			int value = s.top();                             //create temp value that store the top value of s
			s.pop();                                         //remove top of s
			
			while(!st.isEmpty() && st.top() > value ) {     //if temp stack is not empty and the temp value is less than top of s
				s.push(st.top());                           //transfer the top of st to top of s
				st.pop();
			}
			
			
			st.push(value);                                 //if temp value is greater than top of s then add temp value to temp stack     
			
		}
		while(!st.isEmpty()) {                             //if st is not empty
			s.push(st.top());                              //transfer the top of st to top of s
			st.pop();
		}
		
		return s;
	}

}

