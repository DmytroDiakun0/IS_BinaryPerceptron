import java.util.Random;

public class BinaryPerceptron {
	double[] w;
	double learningSpeed;
	double threshold;
	
	BinaryPerceptron(int enterCount, double learningSpeed) {
		w = new double[enterCount];
		setRandomW();
		this.learningSpeed = learningSpeed;
		threshold = 0;
	}
	
	private void setRandomW() {
		Random random = new Random();
		double[] startW = {0.2, 0.4, 0.6};
		
		for(int i = 0; i < this.w.length; i++) {
			int randomIndex = random.nextInt(startW.length);
			w[i] = startW[randomIndex];
		}
	}
	
	public void teach(int[][] data, int[] result) {
		System.out.println("w1      w2      w3      O-      x1   x2   x3   a       Y    T    d    dw1     dw2     dw3     dO-");
		for(int i = 0; i < data.length; i++) {
			////////
			int[] x = data[i];
			double[] oldW = w.clone();
			double oldThreshold = threshold;
			double a = 0;
			int y;
			int delta = 0;
			
			double[] deltaI = new double[w.length];
			for(int j = 0; j < deltaI.length; j++) deltaI[j] = 0;
			////////
			
			for(int j = 0; j < w.length; j++) {
				a += x[j] * w[j];
			}
			
			if(a > threshold) {
				y = 1;
			} else {
				y = 0;
			}
			
			if(y != result[i]) {
				delta = result[i] - y;
				threshold -= learningSpeed * delta;
				
				for(int j = 0; j < w.length; j++) {
					deltaI[j] = learningSpeed * delta * x[j];
					w[j] = oldW[j] + deltaI[j];
				}
				
			}
			
			////////
			for(int j = 0; j < oldW.length; j++) {
				System.out.printf("%.2f    ", oldW[j]);
			}
			
			System.out.printf("%.2f    ", oldThreshold);
			
			for(int j = 0; j < x.length; j++) {
				System.out.print(x[j] + "    ");
			}
			
			System.out.printf("%.2f    ", a);
			System.out.print(y + "    ");
			System.out.print(result[i] + "    ");
			System.out.print(delta + "    ");
			
			for(int j = 0; j < w.length; j++) {
				System.out.printf("%.2f    ", w[j]);
			}
			
			System.out.printf("%.2f    ", threshold);
			System.out.println();
			////////
		}
		System.out.println();
	}
	
	public int culcFuncResult(int[] x) {
		double a = 0;
		for(int j = 0; j < w.length; j++) {
			a += x[j] * w[j];
		}

		if(a > threshold) {
			return 1;
		} else {
			return 0;
		}
	}
}
