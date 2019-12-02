package Day1;

import java.util.Arrays;

public class secondHalf {
    private final static String input = "89822\n149236\n106135\n147663\n91417\n59765\n66470\n121156\n148632\n116660\n90316\n111666\n142111\n72595\n139673\n145157\n77572\n83741\n79815\n74693\n139077\n106066\n125817\n127827\n103884\n147289\n81588\n142651\n69916\n147214\n71501\n130067\n60182\n139195\n115502\n127751\n95013\n73411\n125294\n79809\n118110\n122547\n145141\n72231\n138853\n108119\n139960\n128665\n107228\n73416\n54608\n63811\n72363\n130546\n61055\n56786\n127718\n144953\n149284\n137318\n109566\n112866\n148063\n130570\n67536\n84011\n123795\n128098\n51687\n83758\n59867\n103122\n77339\n72126\n71446\n67162\n112342\n120248\n137629\n135736\n139781\n92512\n105922\n85458\n148571\n51173\n135047\n110175\n93722\n82611\n128288\n125225\n104177\n115081\n78470\n96167\n138445\n117778\n100133\n140047";

    private static int getFuel(int fuel) {
        int i = ((int) (fuel / 3.0f)) - 2;
        if (i <= 0) {
            return 0;
        }
        return i + getFuel(i);
    }

    public static void main(String[] args) {
        int sum = Arrays.stream(input.split("\n"))
                .mapToInt(Integer::parseInt)
                .map(secondHalf::getFuel)
                .sum();

        System.out.println(sum);
    }
}
