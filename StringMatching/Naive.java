package StringMatching;

public class Naive {
    static void naiveAlgo(String txt,String pattern){
        int m=txt.length();
        int n=pattern.length();
        for(int i=0;i<=m-n;i++){
                int j;
                for (j = 0; j < n; j++)
                    if (txt.charAt(i + j) != pattern.charAt(j))
                        break;

                if (j == n)
                    System.out.println("Pattern occurs with shift " + i);

        }
    }

    public static void main(String[] args) {
        String txt="ABABCDABABDE" ;
        String pattern="ABAB";
        naiveAlgo(txt,pattern);
    }
}
