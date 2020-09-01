/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    List<Integer> list;
    TreeNode one;
    TreeNode two;
    public void recoverTree(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            return;
        }
        
        list = new ArrayList();
        getInorder(root);
        
        int[] myArray = new int[list.size()];
        for(int i = 0; i<list.size(); i++) {
            myArray[i] = list.get(i);
        }
        int[] sortedArray = mergeSort(myArray, 0, myArray.length - 1);
        int[] getSwapElements = getElements(myArray, sortedArray);
        System.out.println(getSwapElements[0]+" "+getSwapElements[1]);
        if(getSwapElements[0] != Integer.MIN_VALUE && getSwapElements[1] != Integer.MIN_VALUE) {
            getNodeOne(root, getSwapElements[0]);
            getNodeTwo(root, getSwapElements[1]);

            int temp = one.val;
            one.val = two.val;
            two.val = temp;
        }
    }
    
    private void getNodeOne(TreeNode root, int a) {
        if(root == null) {
            return;
        }
        if(root.val == a) {
            one = root;
        } else {
            getNodeOne(root.left, a);
            getNodeOne(root.right, a);
        }
    }
    
    private void getNodeTwo(TreeNode root, int a) {
        if(root == null) {
            return;
        }
        if(root.val == a) {
            two = root;
        } else {
            getNodeTwo(root.left, a);
            getNodeTwo(root.right, a);
        }
    }
    
    private int[] getElements(int[] a, int[] b) {
        int[] toReturn = new int[2];
        toReturn[0] = Integer.MIN_VALUE;
        toReturn[1] = Integer.MIN_VALUE;
        
        for(int i = 0; i<a.length; i++) {
            if(a[i]!=b[i]) {
                toReturn[0] = a[i];
                toReturn[1] = b[i];
            }
        }
        return toReturn;
    }
    
    private void getInorder(TreeNode root) {
        if(root == null) {
            return;
        }
        getInorder(root.left);
        list.add(root.val);
        getInorder(root.right);
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