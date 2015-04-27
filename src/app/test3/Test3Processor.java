package app.test3;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;

public class Test3Processor {
	public Test3Processor() {
		// TODO Auto-generated constructor stub
	}

	public static synchronized void doSomething(String image_addr) {
		/*
		 * can't read image from image address ???
		 */
		Mat A = Highgui.imread(image_addr, Highgui.CV_LOAD_IMAGE_ANYDEPTH);
		
		Mat C = A.clone();
		Size sizeA = A.size();
		/*
		 * CASE 1: Using get() function
		 */
		for (int i = 0; i < sizeA.height; i++) {
			for (int j = 0; j < sizeA.width; j++) {
				double[] data = A.get(i, j);
				data[0] = data[0] / 2;
				data[1] = data[1] / 2;
				data[2] = data[2] / 2;
				C.put(i, j, data);
			}
		}
		/*
		 * CASE 2: Using Array
		 */
		/*
		 * Mat A = Highgui.imread(image_addr); \\"image_addr" is the address of
		 * the image Mat C = A.clone(); int size = (int) (A.total() *
		 * A.channels()); byte[] temp = new byte[size]; A.get(0, 0, temp); for
		 * (int i = 0; i < size; i++) temp[i] = (byte) (temp[i] / 2); C.put(0,
		 * 0, temp);
		 */
	}
}
