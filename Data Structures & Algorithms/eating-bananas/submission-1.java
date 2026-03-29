class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = getmax(piles);

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(caneatit(piles,h, mid)){
                right = mid - 1;

            }else{
                left = mid + 1;

            }
        }
        return left;
    }

            private boolean caneatit(int[] piles, int h, int k){
                int time = 0;
                for(int pile: piles){
                    time += (pile + k - 1) / k;
                }
                return time <= h;
            
            
        }

        private int getmax(int[] piles){
            int max = 0;
            for(int pile : piles){
                max = Math.max(pile, max);
            }
            return max;
        }
        
    }

