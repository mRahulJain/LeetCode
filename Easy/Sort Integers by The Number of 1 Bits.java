class Solution {
    public int[] sortByBits(int[] arr) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap();
        int[] answer = new int[arr.length];
        int index = 0;
        for(int i = 0; i<arr.length; i++) {
            int getCount1s = count1s(arr[i]);
            if(map.containsKey(getCount1s)) {
                ArrayList<Integer> list = map.get(getCount1s);
                list.add(arr[i]);
                map.put(getCount1s, list);
            } else {
                ArrayList<Integer> list = new ArrayList();
                list.add(arr[i]);
                map.put(getCount1s, list);
            }
        }
        
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry element = (Map.Entry) iterator.next();
            int key = (int) element.getKey();
            ArrayList<Integer> list = (ArrayList<Integer>) element.getValue();
            int[] temp = new int[list.size()];
            for(int i = 0; i<temp.length; i++) {
                temp[i] = list.get(i);
            }
            temp = mergeSort(temp, 0, temp.length-1);
            
            for(int i = 0; i<temp.length; i++) {
                answer[index] = temp[i];
                index++;
            }
        }
        
        return answer;
    }
    
    private int count1s(int n) {
        int count = 0;
        while(n>0) {
            if(n%2==1) {
                count++;
            }
            n=n/2;
        }
        return count;
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