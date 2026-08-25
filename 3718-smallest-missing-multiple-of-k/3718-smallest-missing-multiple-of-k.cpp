class Solution {
public:
    int missingMultiple(vector<int>& nums, int k) {
        unordered_set<int>st;
        for(int i : nums){
            st.insert(i);
        }
        int val=k;
        while(val){
            if(st.find(val)!=st.end())
                val=val+k;
            else
                return val;
        }
        return 0;
    }
};