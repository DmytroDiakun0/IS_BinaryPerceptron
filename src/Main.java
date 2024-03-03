public class Main {
	public static void main(String[] args) {
		int[][] arg = {
				{0, 0, 0},
				{0, 0, 1},
				{0, 1, 0},
				{0, 1, 1},
				{1, 0, 0},
				{1, 0, 1},
				{1, 1, 0},
				{1, 1, 1}
		};
		int[] result = {0, 0, 0, 1, 1, 1, 1, 1};
		
		BinaryPerceptron p = new BinaryPerceptron(3, 0.1);
		for(int i = 0; i < 8; i++) {
			p.teach(arg, result);
		}
		
		System.out.println("Результат 0 | 0 & 0 : " + p.culcFuncResult(arg[0]));
		System.out.println("Результат 0 | 1 & 1 : " + p.culcFuncResult(arg[3]));
		System.out.println("Результат 1 | 0 & 1 : " + p.culcFuncResult(arg[5]));
	}
}
