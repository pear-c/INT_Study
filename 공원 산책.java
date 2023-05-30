public class park {
    public static boolean checkNorth(int startX, int startY, String[] park, int n){
        if((startY - n) < 0)
            return false;

        for(int i=startY; i>=(startY-n); i--)
            if(park[i].charAt(startX) == 'X')
                return false;

        return true;
    }
    public static boolean checkSouth(int startX, int startY, int h, String[] park, int n){
        if((startY + n) > h-1)
            return false;

        for(int i=startY; i<=(startY+n); i++)
            if(park[i].charAt(startX) == 'X')
                return false;

        return true;
    }
    public static boolean checkWest(int start, String s, int n){
        if((start - n) < 0)
            return false;

        for(int i=start; i>=(start-n); i--){
            if(s.charAt(i) == 'X')
                return false;
        }
        return true;
    }
    public static boolean checkEast(int start, int w, String s, int n){
        if((start + n) > w-1)
            return false;

        for(int i=start; i<=(start+n); i++)
            if(s.charAt(i) == 'X')
                return false;

        return true;
    }

    public int[] solution(String[] park, String[] routes) {
        int w = park[0].length();
        int h = park.length;

        int startX = 0, startY = 0;

        for(int i=0; i<h; i++){
            if(park[i].contains("S")){
                startY = i;
                break;
            }
        }
        for(int i=0; i<w; i++){
            if(park[startY].charAt(i) == 'S'){
                startX = i;
                break;
            }
        }

        for(int i=0; i<routes.length; i++){
            char c = routes[i].charAt(0);
            int n = routes[i].charAt(2)-48;
            switch(c){
                case 'N':
                    if(checkNorth(startX, startY, park, n))
                        startY -= n;
                    break;

                case 'S':
                    if(checkSouth(startX, startY, h, park, n))
                        startY += n;
                    break;

                case 'W':
                    if(checkWest(startX, park[startY], n))
                        startX -= n;
                    break;

                case 'E':
                    if(checkEast(startX, w, park[startY], n))
                        startX += n;
                    break;
            }
        }

        int[] result = new int[2];
        result[0] = startY;
        result[1] = startX;

        return result;
    }
}
