public class Test {
    public static void main(String[] args) { 
	mystery(5, 3);
    }

    public static int[] array = {-2, -500, 60, 32, 50};
    
    private static void mystery(int a, int b) {
        int i = 1;
	i += (i++);
        System.out.println(i);
    }
}
