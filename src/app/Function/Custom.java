package app.Function;

import app.CurvePanel;

import java.util.ArrayList;

public class Custom extends Function {
    /**
     * 字符：
     * ()sct+-*^/l!0123456789.exp
     * 特殊
     * ( 嵌套
     * ) 嵌套
     * ! 变换
     * x 变量
     * [0-9.]! 数字
     * e e
     * p pi
     * 双目:
     * *
     * +
     * -
     * /
     * ^
     * l
     * 单目：
     * s !sin-1
     * c !cos-1
     * t !tan-1
     * 例如：(*(s(*(123!)(x)))(^!(e)(*(x)(c(+(x)(1!))))))
     * *s*123!x^!e*xc+x1!
     * (*(s(*(123!(x(^!(e(*(x(c(+(x(1
     */
    @Override
    public Function init(){
        ct=new numT(0);
        return super.init();
    }
    @Override
    public Function init(String inCode){
        ct=deCode(inCode);
        return super.init();
    }
    static class X extends countTree {
        static double x;

        static void setX(double x) {
            X.x = x;
        }

        @Override
        public double count() {
            return x;
        }
    }

    static ArrayList<String> code;
    static countTree ct;
    public Custom() {
        ct=new numT(0);
    }
    public static countTree deCode(String inCode){
        code = new ArrayList<String>();
        char[] car = inCode.toCharArray();
        for (int i = 0; i < inCode.length(); ) {
            char c = car[i++];
            if (c == '(' || c == ')'||c == '（' || c == '）') {
                continue;
            }
            if ("+-*/l^exp".contains(c + "")) {
                code.add(c + "");
                continue;
            }
            if ("sct".contains(c + "")) {
                if (i<inCode.length()&&car[i] == '!'||car[i] == '！') {
                    code.add(c + "!");
                    i++;
                    continue;
                }
                code.add(c + "");
                continue;
            }
            if ("0123456789".contains(c + "")) {
                StringBuffer num = new StringBuffer(c + "");
                boolean temp = true;
                try {
                    while (true) {
                        c = car[i++];
                        if ("0123456789".contains(c + "")) {
                            num.append(c);
                            continue;
                        }
                        if (c == '.' && temp) {
                            temp = false;
                            num.append(c);
                            continue;
                        }
                        if (c == '!'||car[i] == '！') {
                            break;
                        }
                        System.out.println("NumError");
                        break;
                    }
                    code.add(num.toString());
                    continue;
                } catch (Exception e) {
                    System.out.println("NumError");
                }
            }
            System.out.println("Error");
            return null;
        }
        //System.out.println(code.toString());
        return getTree();
    }
    static countTree getTree() {
        String c;
        try {
            c = code.remove(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("CodeError");
            return null;
        }

        switch (c) {
            case "+":
                return new addT(getTree(), getTree());
            case "-":
                return new subT(getTree(), getTree());
            case "*":
                return new mulT(getTree(), getTree());
            case "/":
                return new divT(getTree(), getTree());
            case "^":
                return new powT(getTree(), getTree());
            case "l":
                return new logT(getTree(), getTree());
            case "s":
                return new sinT(getTree());
            case "c":
                return new cosT(getTree());
            case "t":
                return new tanT(getTree());
            case "s!":
                return new arc_sinT(getTree());
            case "c!":
                return new arc_cosT(getTree());
            case "t!":
                return new arc_tanT(getTree());
            case "e":
                return new eT();
            case "p":
                return new piT();
            case "x":
                return new X();
            default:
                double num = 0.0;
                try {
                    num = Double.parseDouble(c);
                } catch (Exception e) {
                    System.out.println("NumError");
                }
                return new numT(num);
        }

    }

    @Override
    protected double function(double x) {
        X.setX(x);
        if (("" + ct.count()).equals("NaN")) {
            System.out.println("NumError");
            return 0.0;
        }
        return ct.count();
    }
//    public static void main(String[] args) {
//        Custom c = new Custom("(*(s(*(123!)(x)))(l(e)(*(x)-(0!)(1!)");
//        System.out.println(c.function(1));
//    }
}
