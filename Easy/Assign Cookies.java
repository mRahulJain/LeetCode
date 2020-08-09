class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(g.length == 0 || s.length == 0) {
            return 0;
        }
        g = mergeSort(g, 0, g.length - 1);
        s = mergeSort(s, 0, s.length - 1);
        
        int answer = 0;
        int i = 0;
        int j = 0;
        while(i<g.length && j<s.length) {
            if(g[i] > s[j]) {
                j++;
            } else {
                j++;
                answer++;
                i++;
            }
        }
        return answer;
    }

    public static int[] mergeTwoSortedArrays(int[] one, int[] two) {
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
	
	public static int[] mergeSort(int[] arr, int lo, int hi)
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