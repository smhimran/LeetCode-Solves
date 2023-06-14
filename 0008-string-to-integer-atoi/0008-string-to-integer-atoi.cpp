class Solution {
public:
    int myAtoi(string s) {
        long long ret = 0;
        
        bool positive = true;
        bool started = false;
        
        for (int i=0; i<s.length(); i++) {
            if (!started and s[i] == '+') {
                positive = true;
                started = true;
            } else if (!started and s[i] == '-') {
                positive = false;
                started = true;
            } else if (s[i] >= '0' and s[i] <= '9') {
                started = true;
                ret = (ret * 10L) + (long long)(s[i] - '0');
                
                if (ret >= 2147483648L) {
                    break;
                }
            } else if (!started and s[i] == ' ') {
                continue;
            } else {
                break;
            }
        }

        cout<<ret<<endl;
        
        if (!positive) {
            ret *= -1L;
        }

        ret = clamp(ret);
        
        return ret;
    }

private:
    long long clamp(long long number) {
        if (number < -2147483648) {
            number = -2147483648;
        } else if (number > 2147483647) {
            number = 2147483647;
        }

        return number;
    }
};