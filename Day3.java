class Solution {
    public void swap(int nums[],int in1,int in2) {
        int temp=nums[in1];
        nums[in1]=nums[in2];
        nums[in2]=temp;
    }
    public void reverse(int nums[],int a,int b) {
        int start=a,end=b-1;
        while(start<end) {
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
       int n=nums.length;
        int i=n-1;
        for(i=n-1;i>0;i--) {
            if(nums[i]>nums[i-1]) {
                break;
        } }
        if(i==0) {
          reverse(nums,0,n);
             for(int k=n-1;k>=0;k--) {
                System.out.print(nums[k]+" ");
            } 
        }
        else {
            int x=nums[i-1];
            int min=i;
            for(int j=i;j<n;j++) {
                if(nums[j]>x) {
                    min=j;
                }
            }
            swap(nums,i-1,min);
            reverse(nums,i,n);
            for(int k=0;k<n;k++) {
                System.out.print(nums[k]+" ");
            }
        }
        
    }
}