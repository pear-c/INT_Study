import java.util.*;
public class number {
    public String solution(String X, String Y) {

        boolean[] checkX = new boolean[X.length()];
        boolean[] checkY = new boolean[Y.length()];
        ArrayList<Character> result = new ArrayList<>();

        Arrays.fill(checkX, false);
        Arrays.fill(checkY, false);

        for(int i=0; i<X.length(); i++){
            for(int j=0; j<Y.length(); j++){
                if(X.charAt(i) == Y.charAt(j)){
                    if(!checkX[i] && !checkY[j]){
                        checkX[i] = true;
                        checkY[j] = true;
                        break;
                    }
                }
            }
        }

        for(int i=0; i<X.length(); i++)
            if(checkX[i])
                result.add(X.charAt(i));

        Collections.sort(result, Collections.reverseOrder());

        if(result.isEmpty())
            return "-1";
        else if(result.get(0) == '0'){
            return "0";
        }
        else{
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<result.size(); i++)
                sb.append(result.get(i));

            return sb.toString();
        }
    }
}
