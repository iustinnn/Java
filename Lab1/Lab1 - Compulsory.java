class FirstApp {
    public static void main( String args[]) {
    System.out.println("Hello world!");
    String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
    int n = (int) (Math.random() * 1_000_000);
    n=n*3;
    System.out.println("N-ul initial: " + n);
    int decimal=Integer.parseInt("10101",2);
    int decimal1=Integer.parseInt("FF",16);
    n=(n+decimal+decimal1)*3;
    System.out.println("The integer is: " + n);
    int contor=0,s;

    while (n>9)
    {
        s=0;
        while (n>0)
        {
            s+=n%10;
            n/=10;
        }
        n=s;
    }
    System.out.println("cifra de control este:" + n);
    int result=n;
    System.out.println("Willy-nilly, this semester I will learn " + languages[result]);

}
    }
