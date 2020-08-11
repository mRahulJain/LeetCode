class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums.length == 0) {
            return 0;
        }
        int answer = 0;
        nums = mergeSort(nums, 0, nums.length - 1);
        for(int i = 0; i<nums.length; i++) {
            if(i != 0) {
                if(nums[i-1] == nums[i]) {
                    continue;
                }
            }
            for(int j = i+1; j<nums.length; j++) {
                if(j != i+1) {
                    if(nums[j-1] == nums[j]) {
                        continue;
                    }
                }
                if(nums[j]-nums[i] > k) {
                    break;
                } else if(nums[j] - nums[i] == k) {
                    answer++;
                }
            }
        }
        return answer;
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
	
	private int[] mergeSort(int[] arr, int lo, int hi)
	{
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