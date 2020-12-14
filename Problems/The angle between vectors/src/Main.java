import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int u1 = scanner.nextInt();
        int u2 = scanner.nextInt();
        int v1 = scanner.nextInt();
        int v2 = scanner.nextInt();

        double lengthU = Math.sqrt(Math.pow(u1, 2) + Math.pow(u2, 2));
        double lengthV = Math.sqrt(Math.pow(v1, 2) + Math.pow(v2, 2));
        double dotProduct = u1 * v1 + u2 * v2;

        double angle = Math.acos(dotProduct / (lengthU * lengthV)) * (180 / Math.PI);

        System.out.print(angle);
    }
}