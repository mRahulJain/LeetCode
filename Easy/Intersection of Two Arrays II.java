class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
        nums1 = mergeSort(nums1, 0, nums1.length - 1);
        nums2 = mergeSort(nums2, 0, nums2.length - 1);
        
        return getIntersection(nums1, nums2);
        
    }
    
    private int[] getIntersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList();
        int i = 0;
        int j = 0;
        while(i<nums1.length && j< nums2.length) {
            if(nums1[i] < nums2[j]) {
                i++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] toReturn = new int[list.size()];
        for(int iterator = 0; iterator<toReturn.length; iterator++) {
            toReturn[iterator] = list.get(iterator);
        }
        return toReturn;
    }
    
    private int[] removeDuplicate(int[] nums) {
        ArrayList<Integer> list = new ArrayList();
        for(int i = 0; i<nums.length - 1; i++) {
            if(nums[i] == nums[i+1]) {
                continue;
            } else {
                list.add(nums[i]);
            }
        }
        list.add(nums[nums.length - 1]);
        int[] toReturn = new int[list.size()];
        for(int i = 0; i<toReturn.length; i++) {
            toReturn[i] = list.get(i);
        }
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