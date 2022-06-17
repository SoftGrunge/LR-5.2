public class Main {


    public static void main(String[] args) {

        Func1_1 func1 = new Func();
        System.out.println("Inner class: "+math(func1, 2, 5));

        Func1_1 func2 = new Func1_1() {
            public double f(double x) {
                return x*x+x;
            }
        };
        System.out.println("Anon class: "+math(func2, 3, 4));

        Func1_1 func3 = Func1_1::staticMeth;
        System.out.println("Static method: "+math(func3, 0.01, 2));

        Func1 func4 = new Func1();
        Func1_1 f4 = func4::sqr;
        System.out.println("Method reference: "+math(f4, 1, 3));



    }



    private static final int p = 100;


    public static double math(Func1_1 func11, double l, double r){
        double s = 0;
        double step = (r - l) / p;
        double x = l;
        double xn = l + step;
        for (int i = 0; i < p; i++ ){
            s = s + step * func11.f((x+xn)/2);
            x = xn;
            xn = xn + step;
        }
        return s;
    }

    private static class Func implements Func1_1 {
        @Override
        public double f(double x) {
            return Math.log(x);
        }
    }
}