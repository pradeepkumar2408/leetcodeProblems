class Solution {
public:
    vector<int> findMissingElements(vector<int>& nums) {
        vector<int>res;
        sort(nums.begin(),nums.end());
        unordered_map<int,int>mp;
        for(int i : nums){
            mp[i]++;
        }
        for(int i=nums[0];i<nums[nums.size()-1];i++){
            if(mp[i]==0)
            res.push_back(i);
        }
        return res;
    }
};