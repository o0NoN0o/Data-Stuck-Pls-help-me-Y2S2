
public class StackUtility {
	static String alphabets = "abcdefghijklmnopqrstuvwxyz";
	
	public static String operate(MyStack s1, MyStack s2) throws Exception {
		int size = s1.size();
		String ans = "";
		MyStack s3 = new StackArray();
		for(int i = 0; i < size/2; i++) {
			if(s2.top() >= 0) {
				s2.pop();
				int fst = s1.top();
				s1.pop();
				int snd = s1.top();
				s1.pop();
				int index = fst + snd;
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
		for(int i = 0; i < ansSize; i++) {
			ans += alphabets.charAt(s3.top());
			s3.pop();
		}
		
		return ans;

		
		
	}
}
