class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            int select = 0;
            switch(s.charAt(i)) {
                case 'z':
                    select = 0;
                    i+=3;
                    break;
                case 'o':
                    select = 1;
                    i+=2;
                    break;    
                case 't':
                    switch(s.charAt(i+1)) {
                        case 'w':
                            select = 2;
                            i+=2;
                            break;
                        case 'h':
                            select = 3;
                            i+=4;
                            break;
                    }
                    break;
                case 'f':
                    switch(s.charAt(i+1)) {
                        case 'o':
                            select = 4;
                            i+=3;
                            break;
                        case 'i':
                            select = 5;
                            i+=3;
                            break;
                    }
                    break;
                case 's':
                    switch(s.charAt(i+1)) {
                        case 'i':
                            select = 6;
                            i+=2;
                            break;
                        case 'e':
                            select = 7;
                            i+=4;
                            break;
                    }
                    break;
                case 'e':
                    select = 8;
                    i+=4;
                    break;
                case 'n':
                    select =9;
                    i+=3;
                    break;
                default:
                    select = s.charAt(i) - '0';
            }
            answer *= 10;
            answer += select;
        }
        return answer;
    }
}