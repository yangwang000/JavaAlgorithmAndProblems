package com.java.adawang;

public class LeetCode {
	// "2-3*4"
	public static int md(String s, int index){
		int n1 = 0;
		int n2 = 0;
		int idx1 = index -1;
		// -1-123*456
		while (idx1 >= 0){
			int temp = s.charAt(idx1) - '0';
			if(temp >= 0 && temp <= 9){
				if(n1 == 0){
					n1 = 3;
				}else{
					n1 = temp*10 + n1;
				}
			}else{
				break;
			}
			idx1--;
		}

		while (idx1 >= 0){
			int temp = s.charAt(idx1) - '0';
			if(temp >= 0 && temp <= 9){
				if(n1 == 0){
					n1 = 3;
				}else{
					n1 = temp*10 + n1;
				}
			}else{
				break;
			}
			idx1--;
		}

		// -1*2
		return n1*n2;
 	}

	public static int countNumbers(int[] sortedArray, int lessThan) {
		int start = 0;
		int end = sortedArray.length - 1;
		while(start < end){
			if(sortedArray[start] > lessThan){
				return start;
			}else{
				int mid = start + (end - start)/2;
				if(sortedArray[mid] < lessThan){
					start = mid + 1;
				}else if(sortedArray[mid] >= lessThan){
					end = mid;
				}
			}

		}
		return start;
	}

	public static class MyRunnable implements Runnable {

		private boolean doStop = false;

		public synchronized void doStop() {
			this.doStop = true;
		}

		private synchronized boolean keepRunning() {
			return this.doStop == false;
		}

		@Override
		public void run() {
			while(keepRunning()) {
				// keep doing what this thread should do.
				System.out.println("Running");

				try {
					Thread.sleep(1L * 1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}


	static class Money {
		int amount;
		String currencyCode;

		public Money(int i, String usd) {
			this.amount = i;
			this.currencyCode = usd;
		}

		@Override
		public boolean equals(Object o) {
			if (o == this)
				return true;
			if (!(o instanceof Money))
				return false;
			Money other = (Money)o;
			boolean currencyCodeEquals = (this.currencyCode == null && other.currencyCode == null)
					|| (this.currencyCode != null && this.currencyCode.equals(other.currencyCode));
			return this.amount == other.amount && currencyCodeEquals;
		}

		@Override
		public final int hashCode() {
			int result = 17;
			if (currencyCode != null) {
				result = 31 * result + currencyCode.hashCode();
			}
			return result;
		}
	}

	public static void main(String[] args) throws InterruptedException {
	}
}
