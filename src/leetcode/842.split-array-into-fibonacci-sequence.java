class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
		List<Integer> res = new ArrayList<>();
		int first;
		int second;
		for (int i = 0; i < S.length/2; i++) {
			first = Integer.valueOf(S.substring(0, i+1));
			for (int j = i+1; j < S.length/2; j++) {
				second = Integer.valueOf(S.substring(i+1, j+1));
				int f1 = first;
				int f2 = second;
				int f3 = first + scond;
				int startIndex = j+1;
				res.add(f1);
				res.add(f2);
				while (startIndex + (f3/10)+1<S.length && f3 == Integer.valueOf(S.substring(startIndex, startIndex+(f3/10)+1) {
					startIndex += (f3/10)+1
					res.add(f3);
					int t = f2;
					f2 = f1 + f2;
					f3 = t + f3;
					f1 = t;
				}
				if (startIndex == S.length) {
					break
				} else {
					res.clear();
				}
			}
		}        
    }
}
