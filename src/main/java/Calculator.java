import java.util.ArrayList;

public class Calculator {
    private static final int Value = 500;

    static int add(String param) throws Exception {
        StringBuffer delim = new StringBuffer(",\n");

        if (param.startsWith("//")) {
            delim = new StringBuffer(param.substring(param.indexOf("//") + 2, param.indexOf("\n")));
            String[] arrayOfNumbers = delim.toString().split("[,]");
            for (String s : arrayOfNumbers) {
                delim.append(s);

            }
            param = param.substring(param.indexOf("\n"));
        }
        delim = new StringBuffer("[" + delim + "]");
        return add(param, delim.toString());
    }
    public static int add(final String numbers, String delim) throws Exception {
        int Total = 0;
        String[] arrayOfNumbers = numbers.split("[" + delim + "]");
        ArrayList<Integer> negInt = new ArrayList<>();
        try {
            for (String result : arrayOfNumbers) {
                if (!result.trim().isEmpty()) {
                    int i = Integer.parseInt(result.trim());
                    if (i < 0) {
                        negInt.add(i);
                    } else if (i < Value) {
                        Total += i;
                    }
                }
            }
        }catch (Exception e){
            System.err.println("Wrong Digit");
            throw new Exception("");
        }

        if(negInt.size()>1){
            StringBuilder neg = new StringBuilder();

            for (int i = 0; i < negInt.size()-1; i++) {
                neg.append(negInt.get(i)).append(", ");
            }
            neg.append(negInt.get(negInt.size() - 1));
            System.err.println( "Error : no negative values " + neg);
            throw new Exception("");
        }
        return Total;
    }
}
