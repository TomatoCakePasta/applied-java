public class Main {
    public static void main(String[] args) {
        Func1 func1 = (int x) -> { return (x % 2 == 1); };
        Func2 func2 = (int point, String name) -> { return name + "さんは" + (point > 65 ? "合格" : "不合格"); };
        
        IO.println("isOdd(2): " + func1.isOdd(2));
        IO.println("isOdd(1): " + func1.isOdd(1));
        IO.println(func2.passCheck(65, "Sato"));
        IO.println(func2.passCheck(66, "Kimura"));

        // 標準関数インタフェースに代入
        IntFunction<Boolean> func3 = (int x) -> { return (x % 2 == 1); };
        IO.println(func3.apply(2));
        IO.println(func3.apply(1));

        // intを受け取ってbooleanを返す
        // こっちの方がさらに良い
        IntPredicate func4 = (int x) -> { return (x % 2 == 1); };
        IO.println(func4.test(2));
        IO.println(func4.test(1));

        // StreamAPI
        IO.println("===== StreamAPI =====");
        List<String> peoples = new ArrayList<>();
        peoples.add("佐々木姫華");
        peoples.add("田中太郎");
        peoples.add("山健吾");
        
        IO.println("\nBefore:");
        printArrays(peoples);
        
        // streamに変換 -> 色々処理をする -> 再度リストに変換
        List<String> convert_peoples = peoples.stream()
                                        .filter(p -> p.length() <= 4)
                                        .map(p -> p + "さん")
                                        .collect(Collectors.toList());
               
        IO.println("\nAfter: 4文字以下の人に"さん"をつける);                         
        printArrays(convert_peoples);
    }

    public static void printArrays(List<String> arr) {
        for (String elem : arr) {
            IO.println(elem);
        }
    }
}