package com.wpliang.xiaomi.algorithm.easy;

/**
 * 描述
 * 给定一个排序的整数数组（升序）和一个要查找的整数target，用O(logn)的时间查找到target第一次出现的下标（从0开始），
 * 如果target不存在于数组中，返回-1。
 * 样例
	样例  1:
		输入:[1,4,4,5,7,7,8,9,9,10]，1
		输出: 0
		
		样例解释: 
		第一次出现在第0个位置。
	
	样例 2:
		输入: [1, 2, 3, 3, 4, 5, 10]，3
		输出: 2
		
		样例解释: 
		第一次出现在第2个位置
		
	样例 3:
		输入: [1, 2, 3, 3, 4, 5, 10]，6
		输出: -1
		
		样例解释: 
		没有出现过6， 返回-1

 * @author wpliang
 *
 */
public class BinarySearchTest {

	public static void main(String[] args) {
		int[] nums = {3,4,5,8,8,8,8,10,13,14};
		int ret = binarySearch(nums, 8);
		System.out.println(ret==3);
		
		int[] nums2 = {1,4,4,5,7,7,8,9,9,10};
		ret = binarySearch(nums2, 1);
		System.out.println(ret==0);
		
		int[] nums3 = {1, 2, 3, 3, 4, 5, 10};
		ret = binarySearch(nums3, 3);
		System.out.println(ret==2);
		
		int[] nums4 = {1, 2, 3, 3, 4, 5, 10};
		ret = binarySearch(nums4, 6);
		System.out.println(ret==-1);

	}

	public static int binarySearch(int[] nums, int target) {
	 
		int low =0;
		int high = nums.length - 1;
		
		while(low <= high) {
			int middle = (low + high) / 2;
			if (nums[middle] < target) {
				low = middle + 1;
			} else if (nums[middle] > target) {
				high = middle -1;
			} else {
				// check if exist the same value number
				int ret = middle;
				while (ret > 0) {
					if(nums[--ret] != target) {
						ret += 1;
						break;
					}
				}
				return ret;
			}
		}
		
		return -1;
		
    }
	
}
