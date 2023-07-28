public class PairUse {
    public static void main(String[] args) {
//        Pair p = new Pair(10,20);
//        System.out.println(p.getFirst()+" "+p.getSecond());
//
//        PairString pS = new PairString("aa","bb");
//        PairDouble pD = new PairDouble(3.5,7.2);

//        Pair<String> pS = new Pair<String>("aa", "bb");
//        System.out.println(pS.getFirst()+" "+ pS.getSecond());
        Pair<String, Integer> pInner = new Pair<>();
        pInner.setFirst("Hello");
        pInner.setSecond(100);
        Pair<Pair<String, Integer>, String> p = new Pair<>();
        p.setFirst(pInner);
        System.out.println(p.getFirst().getFirst());
        System.out.println(p.getFirst().getSecond());

        p.setSecond("abcd");
        System.out.println(p.getSecond());
    }
}
