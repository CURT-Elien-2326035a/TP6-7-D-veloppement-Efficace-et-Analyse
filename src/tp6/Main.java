    package tp6;

    import java.io.FileWriter;
    import java.io.IOException;
    import static tp6.Quicksort.quicksort;
    import static tp6.Quicksort.randomInit;

    public class Main {
        public static void main(String[] args) {
            TriBulles list = new TriBulles();

            list.push(5);
            list.push(3);
            list.push(8);
            list.push(1);
            list.push(7);
            list.push(2);
            list.push(9);
            list.push(4);
            list.push(20);
            list.push(15);
            list.push(6);
            list.push(11);
            list.push(13);
            list.push(10);
            list.push(12);
            list.push(14);
            list.push(16);
            list.push(17);
            list.push(18);
            list.push(19);
            list.push(21);
            list.push(22);
            list.push(23);
            list.push(24);
            list.push(25);
            list.push(26);
            list.push(27);
            list.push(28);
            list.push(29);

            System.out.println("Liste avant Tri:");
            list.MontrerListe();

            list.bubbleSort();

            System.out.println("Liste après Tri: (bubbleSort)");
            list.MontrerListe();
        
            int[] array = {3, 6, 8, 10, 1, 2, 1};
            System.out.println("Array avant Tri:");
            for (int i : array) {
                System.out.print(i + " ");
            }
            quicksort(array, 0, array.length - 1);
            System.out.println("\nArray après Tri: (quicksort)");   
            for (int i : array) {
                System.out.print(i + " ");
            }

            int[] sizes = {1000, 5000, 10000, 50000, 100000}; 
            try (FileWriter writer = new FileWriter("quicksort_performance.csv")) {
                writer.write("Size,Time (ms)\n");
                for (int size : sizes) {
                    int[] tempArray = new int[size]; // Renamed to tempArray
                    randomInit(tempArray, size);

                    long startTime = System.nanoTime();
                    quicksort(tempArray, 0, tempArray.length - 1);
                    long endTime = System.nanoTime();

                    long duration = (endTime - startTime) / 1000000; // on met en ms
                    writer.write(size + "," + duration + "\n");
                    System.out.println("Size: " + size + ", Time: " + duration + " ms");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
