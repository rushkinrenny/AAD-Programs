package StringMatching;

public class KMP {
    static void lps(String str,int [] lpsArr){
        int i=1,len=0;
        while(i<str.length()){
            if(str.charAt(i)==str.charAt(len)){
                len++;
                lpsArr[i]=len;
                i++;
            }else{
                if(len>0){
                    len=lpsArr[len-1];
                }else{
                    lpsArr[i]=0;
                    i++;
                }
            }
        }
    }
    static void kmpAlgo(String txt, String pat){
        String newStr=pat+"#"+txt;
        int [] lpsArr=new int[newStr.length()];
        lps(newStr,lpsArr);
        int m=pat.length();
        System.out.print("Patten Match at : ");
        for(int i=0;i<lpsArr.length;i++){
            if(lpsArr[i]==m){
                int foundAtIndex=i-2*m;
                System.out.print(foundAtIndex+" ");
            }
        }
    }
    public static void main(String[] args) {
        String txt="ABABCDABABDE" ;
        String pattern="ABAB";
        kmpAlgo(txt,pattern);
    }

}
