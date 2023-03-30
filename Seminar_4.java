import java.util.*;

public class Seminar_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String[]> data = new ArrayList<>();
        int index = 0;
        System.out.println("Введите фамилию, имя, отчество, пол и возраст, или q для выхода: ");
        String[] data2;
        String input = sc.nextLine();
        if (!input.equals("q")) {
            input = index++ + " " + input;
            data2 = input.split(" ");
            data.add(data2);
        }

        while (!input.equals("q")) {
            System.out.println("Введите фамилию, имя, отчество, пол и возраст, или q для выхода: ");
            input = sc.nextLine();
            if (!input.equals("q")) {
                input = index++ + " " + input;
                data2 = input.split(" ");
                data.add(data2);
            }
        }

        int[] dataIndexes = new int[data.size()];

        for (int i = 0; i < dataIndexes.length; i++) {
            dataIndexes[i] = i;

        }

        printArrayList(data, dataIndexes);

        System.out.println("Для вывода списка,сортированного по возрасту и полу, нажмите '1'" + "\n" + "Для выхода нажмите '2'");
        input = sc.nextLine();
        if (input.equals("1")) {
            bubbleIndexesSort(dataIndexes, data, 4);
            bubbleIndexesSort(dataIndexes, data, 5);
            printArrayList(data, dataIndexes);
        }
    }

    static void printArrayList(ArrayList<String[]> data, int[] dataIndexes) {
        for (int i : dataIndexes) {
            for (int j = 1; j < data.get(i).length; j++) {
                if (j != 2 && j != 3) {
                    System.out.print(data.get(i)[j] + " ");
                } else System.out.print(data.get(i)[j].charAt(0) + ". ");
            }
            System.out.println();
        }
    }

    static void bubbleIndexesSort(int[] orderIndexes, ArrayList<String[]> data, int column) {
        for (int count = 0; count < orderIndexes.length; count++) {
            boolean sorted = true;
            for (int i = 0; i < orderIndexes.length - 1; i++) {
                if (column == 4) {
                    if (Integer.parseInt(data.get(orderIndexes[i])[column]) > Integer.parseInt(data.get(orderIndexes[i + 1])[column])) {
                        int temp = orderIndexes[i + 1];
                        orderIndexes[i + 1] = orderIndexes[i];
                        orderIndexes[i] = temp;
                        sorted = false;
                    }
                } else if (data.get(orderIndexes[i])[column].charAt(0) > data.get(orderIndexes[i + 1])[column].charAt(0)) {
                    int temp = orderIndexes[i + 1];
                    orderIndexes[i + 1] = orderIndexes[i];
                    orderIndexes[i] = temp;
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }

}