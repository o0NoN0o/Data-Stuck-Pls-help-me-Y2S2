
public class StackUtility {
	static String alphabets = "abcdefghijklmnopqrstuvwxyz";
	
	public static String operate(MyStack s1, MyStack s2) throws Exception {
		int size = s1.size();
		String ans = "";
		MyStack s3 = new StackArray();                          //create new stack s3 to store the decrypt message
		for(int i = 0; i < size/2; i++) {                       //since it use 2 element of a stack for 1 letter we run it only half of the size
			if(s2.top() >= 0) {                                 //check if s2 operation is positive or negative
				s2.pop();
				int fst = s1.top();
				s1.pop();
				int snd = s1.top();
				s1.pop();
				int index = fst + snd;                           //decrypt the message then add to s3
				s3.push(index); 
			} else {
				s2.pop();
				int fst = s1.top();
				s1.pop();
				int snd = s1.top();
				s1.pop();
				int index = fst - snd;
				s3.push(index);
			}
		}
		int ansSize = s3.size();                   
		for(int i = 0; i < ansSize; i++) {                       //run the code for the number of letter in answer stack then compare it to alphabets
			ans += alphabets.charAt(s3.top());                
			s3.pop();
		}
		
		return ans;

		
		
	}
}
