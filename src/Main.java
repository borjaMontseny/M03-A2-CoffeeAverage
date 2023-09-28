import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String nombreFichero = "entrada.txt";
		double arrayNums[] = crearArrayDeFichero(nombreFichero);

		double promedio = calcularPromedioArray(arrayNums);
		int indexNumDistanteBuscado = encontrarIndexNumeroDistante(arrayNums);
		double promedioArrayCorregido = calcularPromedioArrayCorregido(arrayNums, indexNumDistanteBuscado);

		// OUTPUT
		System.out.println("Average: " + promedio);
		System.out.println("Most distant value: " + arrayNums[indexNumDistanteBuscado]);
		System.out.println("New average " + promedioArrayCorregido);

	}

	public static double[] crearArrayDeFichero(String nombreFichero) throws FileNotFoundException {
		Scanner ficheroEntrada = new Scanner(new File(nombreFichero));
		int cantidadNums = ficheroEntrada.nextInt();
		double[] arrayNums = new double[cantidadNums];

		for (int i = 0; i < arrayNums.length; i++) {
			arrayNums[i] = ficheroEntrada.nextDouble();
		}

		ficheroEntrada.close();

		return arrayNums;

	}

	public static double calcularPromedioArray(double[] array) {
		double sumaTotal = 0;
		for (int i = 0; i < array.length; i++) {
			sumaTotal += array[i];
		}
		double promedio = sumaTotal / array.length;
		return promedio;
	}

	public static int encontrarIndexNumeroDistante(double[] array) {
		double promedio = calcularPromedioArray(array);
		double numMax = encontrarMaxNumArray(array);
		double numMin = encontrarMinNumArray(array);
		double numDistante;
		int indexNumDistante = 0;

		/*
		 * Math.abs para dar igual negativos y fijarse solo en la diferencia y así
		 * saber: num con diferencia más grande = distante
		 */
		if (Math.abs(numMax - promedio) > Math.abs(numMin - promedio)) {
			numDistante = numMax;
		} else {
			numDistante = numMin;
		}

		/*
		 * Ahora que tenemos el numDistante, este while nos dirá en que posición está,
		 * ese mismo número en el array, usando Double.compare mejor que ==
		 */
		int i = 0;
		while (i < array.length && Double.compare(numDistante, array[i]) != 0) {
			i++;
		}

		if (i < array.length) {
			indexNumDistante = i;
		}

		return indexNumDistante;
	}

	public static double encontrarMaxNumArray(double[] array) {

		double max = Double.NEGATIVE_INFINITY;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;

	}

	public static double encontrarMinNumArray(double[] array) {

		double min = Double.POSITIVE_INFINITY;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;

	}

	/*
	 * Sabiendo la posición de numDistante, lo ponemos a 0 y hacemos el promedio sin
	 * contar esa posición que ahora es 0, osea (array.length -1)
	 */
	public static double calcularPromedioArrayCorregido(double[] array, int indexNumeroDistante) {
		/*
		 * Para no manipular valores del array original, creamos uno igual y usaremos
		 * ese. Utilizamos Arrays.copyOf() para que no simplemente rediriga array2 a la
		 * dirección de memoria de array1 y haga una copia literal.
		 */
		double[] copiaArray = Arrays.copyOf(array, array.length);
		copiaArray[indexNumeroDistante] = 0;
		double sumaTotal = 0;

		for (int i = 0; i < copiaArray.length; i++) {
			sumaTotal += copiaArray[i];
		}

		double promedio = sumaTotal / (copiaArray.length - 1);

		return promedio;
	}

}
