class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0) {
            return 0;
        }
        if(citations.length == 1 && citations[0] == 0) {
            return 0;
        }
        if(citations.length == 1) {
            return 1;
        }
        
        citations = mergeSort(citations, 0, citations.length - 1);
        
        int h = 0;
        for(int i = 0; i<citations.length; i++) {
            if((citations.length - i) <= citations[i]) {
                if((citations.length - i) > h) {
                    h = citations.length - i;
                }
            }  
        }
        
        return h;
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