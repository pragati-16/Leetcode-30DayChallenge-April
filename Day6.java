class Solution {
    public int threeSumMulti(int[] ar, int t ) {
        
        int m = 1000000000+7;        
        Arrays.sort(ar);;
        
        int ans = 0;
        
        for(int i = 0; i<ar.length; i++) {
            
            int j = i+1, k = ar.length-1;
            
            while( j < k) {
                int cur = ar[i] + ar[j] + ar[k];
                if( cur == t ) {
                    int count1 = 0, count2 = 0;
                                         
                    if( ar[j] == ar[k] ) {
                         
                        count1 = k-j+1;
                        
                        count1 = (count1*(count1-1))%m;
                        
                        ans = ((count1/2) + ans)%m;
                        
                    }
                    else {
                        
                        for(int x = j ;x <= k; x++)
                            if( ar[x] == ar[j])
                                count1++;  
                            else
                                break;
                        
                        for(int x = k ;x >= j; x--)
                            if( ar[x] == ar[k])
                                count2++;  
                            else
                                break;     
                        
                            count1 = ( count1 * count2  ) % m;
                            ans = (ans + count1) % m;
                                                
                    }
                    
                    k--;
                    j++;
                    
                    while( j < k && ar[j] == ar[j-1] )
                        j++;
                    while( j < k && ar[k] == ar[k+1] )
                        k--;                    
                    
                     
                }
                else if( cur > t)
                    k--;
                else
                    j++;
            }
            
        }
        return ans;
    }
}

