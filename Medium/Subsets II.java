class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        nums = mergeSort(nums, 0, nums.length-1);
        
        List<List<Integer>> list = new ArrayList();
        int start = 0;
        int end = (int) Math.pow(2, nums.length);
        while(start<end) {
            String s = getBinary(start, nums.length);
            List<Integer> temp = new ArrayList();
            for(int i = 0; i<s.length(); i++) {
                if(s.charAt(i) == '1') {
                    temp.add(nums[i]);
                }
            }
            
            if(!list.contains(temp)) {
                list.add(temp);    
            }            
            start++;
        }
        return list;
    }
    
    private String getBinary(int n, int k) {
        String toReturn = "";
        while(n!=0) {
            int rem = n%2;
            toReturn = rem + toReturn;
            n = n/2;
        }
        
        while(toReturn.length() < k) {
            toReturn = "0"+toReturn;
        }
        System.out.println(toReturn);
        return toReturn;
    }
    
    private int[] mergeTwoSortedArrays(int[] one, int[] two) {
		int[] mergedArray = new int[one.length + two.length];
		int i = 0, j = 0, k = 0;

		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				mergedArray[k] = one[i];
				i++;
				k++;
			} else {
				mergedArray[k] = two[j];
				j++;
				k++;
			}
		}

		if (i == one.length) {
			while (j < two.length) {
				mergedArray[k] = two[j];
				j++;
				k++;
			}
		}

		if (j == two.length) {
			while (i < one.length) {
				mergedArray[k] = one[i];
				i++;
				k++;
			}
		}
		return mergedArray;
	}
	
	private int[] mergeSort(int[] arr, int lo, int hi) {
		if(lo==hi)
		{
			int[] recRes= new int[1];
			recRes[0]= arr[lo];
			return recRes;
		}
		int mid= (lo+hi)/2;
		
		int[] fh= mergeSort(arr, lo, mid);
		int[] sh= mergeSort(arr, mid+1, hi);
		
		int[] finalRes= mergeTwoSortedArrays(fh, sh);
		
		return finalRes;
	}
}